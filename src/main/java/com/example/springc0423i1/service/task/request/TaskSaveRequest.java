package com.example.springc0423i1.service.task.request;

import com.example.springc0423i1.domain.enumration.TaskStatus;
import com.example.springc0423i1.domain.enumration.TaskType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskSaveRequest {

    private String title;

    private String description;

    private String start;

    private String end;

    private String type;
}
