package ru.ispu.crm.service.employee.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ispu.crm.common.employee.post.AddEditEmployeePost;
import ru.ispu.crm.dao.employee.EmployeeRepository;
import ru.ispu.crm.dao.employee.post.PostRepository;
import ru.ispu.crm.model.employee.PostDb;
import ru.ispu.crm.model.employee.PostScheduleDb;

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
    public void addEditEmployeePost(AddEditEmployeePost addEditEmployeePost) {
        PostDb post;
        if (addEditEmployeePost.getId() != null) {
            post = postRepository.findById(addEditEmployeePost.getId()).orElseThrow();
        } else {
            post = new PostDb();
        }
        var employee = employeeRepository.findById(addEditEmployeePost.getEmployeeId()).orElseThrow();
        post.setEmployee(employee);
        post.setName(addEditEmployeePost.getName());
        post.setMain(addEditEmployeePost.getMain());
        post.setSchedule(PostScheduleDb.valueOf(addEditEmployeePost.getSchedule().toString()));
        postRepository.save(post);
    }

    @Override
    public List<PostDb> getEmployeePosts(UUID employeeId) {
        return postRepository.findAllByEmployee_Id(employeeId);
    }
}
