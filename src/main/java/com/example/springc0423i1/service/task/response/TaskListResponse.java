package com.example.springc0423i1.service.task.response;

import com.example.springc0423i1.domain.enumration.TaskStatus;
import com.example.springc0423i1.domain.enumration.TaskType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class TaskListResponse {
    private Long id;

    private String title;

    private String description;

    private LocalDate date;

    private LocalTime start;

    private TaskStatus status;

    private TaskType type;

    private String category;

    private int repeatPerDays;
}