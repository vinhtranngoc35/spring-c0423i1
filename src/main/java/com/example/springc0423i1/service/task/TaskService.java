package com.example.springc0423i1.service.task;

import com.example.springc0423i1.model.Task;
import com.example.springc0423i1.model.enumration.TaskStatus;
import com.example.springc0423i1.model.enumration.TaskType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final static List<Task> tasks;

    static {
        tasks = new ArrayList<>();
        var task1 = Task.builder().id(1L).title("Hoc Java")
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusHours(2L))
                .type(TaskType.DAILY)
                .status(TaskStatus.IN_PROGRESS).build();
        var task2 = Task.builder().id(2L).title("Hoc Ky nang viet CV")
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusHours(2L))
                .type(TaskType.DAILY)
                .status(TaskStatus.IN_PROGRESS).build();
        tasks.add(task1);
        tasks.add(task2);
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
