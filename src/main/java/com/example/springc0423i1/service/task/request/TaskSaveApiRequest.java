package com.example.springc0423i1.service.task.request;

import com.example.springc0423i1.domain.enumration.TaskType;
import com.example.springc0423i1.service.dto.SelectOptionRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
public class TaskSaveApiRequest {

    private String title;

    private String description;

    private String start;

    private String time;

    private String repeatPerDays;

    private String repeatDayOfWeek;

    private SelectOptionRequest category;
}