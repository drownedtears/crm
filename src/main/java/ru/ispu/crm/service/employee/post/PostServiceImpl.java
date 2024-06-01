package ru.ispu.crm.service.employee.post;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ispu.crm.common.employee.post.AddEditEmployeePost;
import ru.ispu.crm.common.employee.post.EmployeePostResponseText;
import ru.ispu.crm.common.employee.post.EmployeePost;
import ru.ispu.crm.common.employee.post.PostSchedule;
import ru.ispu.crm.dao.employee.EmployeeRepository;
import ru.ispu.crm.dao.employee.post.PostRepository;
import ru.ispu.crm.model.employee.PostDb;
import ru.ispu.crm.model.employee.PostScheduleDb;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, EmployeeRepository employeeRepository) {
        this.postRepository = postRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public EmployeePostResponseText addEditEmployeePost(AddEditEmployeePost addEditEmployeePost) {
        PostDb post;
        if (addEditEmployeePost.getId() != null) {
            post = postRepository.findById(addEditEmployeePost.getId()).orElseThrow();
        } else {
            post = new PostDb();
        }
        var employee = employeeRepository.findById(addEditEmployeePost.getEmployeeId()).orElseThrow();
        post.setEmployee(employee);
        post.setName(addEditEmployeePost.getName());
        post.setFirstWorkDay(Date.from(Instant.ofEpochMilli(addEditEmployeePost.getFirstWorkDay())));
        post.setSchedule(PostScheduleDb.valueOf(addEditEmployeePost.getSchedule().toString()));

        return updateMainPostAndSave(post, addEditEmployeePost.getMain());
    }

    @Override
    public List<EmployeePost> getEmployeePosts(UUID employeeId) {
        return postRepository.findAllByEmployee_Id(employeeId).stream().map(this::toEmployeePost).toList();
    }

    @Override
    public EmployeePostResponseText deleteEmployeePost(UUID postId) {
        var postDb = postRepository.findById(postId).orElseThrow();
        if (postDb.getMain()) {
            return EmployeePostResponseText.EMPLOYEE_CANT_HAVE_NO_MAIN_POST;
        }
        postRepository.deleteById(postId);
        return EmployeePostResponseText.SUCCESS;
    }

    private EmployeePost toEmployeePost(PostDb postDb) {
        return new EmployeePost(postDb.getId(), postDb.getEmployee().getId(), postDb.getName(),
                postDb.getMain(), PostSchedule.valueOf(postDb.getSchedule().toString()), postDb.getFirstWorkDay().getTime());
    }

    private EmployeePostResponseText updateMainPostAndSave(PostDb postDb, Boolean main) {
        var mainPostDb = postRepository.findByEmployee_IdAndMainIsTrue(postDb.getEmployee().getId());
        //todo refactor
        if (mainPostDb != null && postDb.getId() != mainPostDb.getId()) {
            if (main) {
                mainPostDb.setMain(false);
                postRepository.save(mainPostDb);
            } else {
                if (mainPostDb.getId() == postDb.getId()) {
                    return EmployeePostResponseText.EMPLOYEE_CANT_HAVE_NO_MAIN_POST;
                }
            }
        } else {
            if (!main) {
                return EmployeePostResponseText.EMPLOYEE_CANT_HAVE_NO_MAIN_POST;
            }
        }
        postDb.setMain(main);
        postRepository.save(postDb);
        return EmployeePostResponseText.SUCCESS;
    }
}
