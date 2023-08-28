package com.example.springc0423i1.service.task.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskEditRequest {
    private String title;

    private String description;

    private String start;

    private String end;

    private String isEditAll;
}
