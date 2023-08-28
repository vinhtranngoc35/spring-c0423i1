package com.example.springc0423i1.service.task.response;

import com.example.springc0423i1.domain.enumration.TaskType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class TaskDetailResponse {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime start;
    private LocalDateTime end;

    private TaskType type;

    public Object getStartTime(){
        if(type == TaskType.DAILY){
            return start.toLocalTime();
        }
        return start;
    }

    public Object getEndTime(){
        if(type == TaskType.DAILY){
            return end.toLocalTime();
        }
        return end;
    }
}
