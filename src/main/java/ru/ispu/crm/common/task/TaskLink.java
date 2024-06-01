package ru.ispu.crm.common.task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TaskLink {
    private UUID id;

    private String shortName;

    private String description;

    private String url;

    private UUID taskId;
}
