package com.example.springc0423i1.service.task;

import com.example.springc0423i1.domain.Task;
import com.example.springc0423i1.repository.TaskRepository;
import com.example.springc0423i1.service.task.request.TaskSaveRequest;
import com.example.springc0423i1.service.task.response.TaskListResponse;
import com.example.springc0423i1.util.AppUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskListResponse> getTasks() {

        return taskRepository.findAll()
                .stream()
                .map(e -> AppUtil.mapper.map(e, TaskListResponse.class))
                .collect(Collectors.toList());
    }
    public void create(TaskSaveRequest request) {
        var task = AppUtil.mapper.map(request, Task.class);
        taskRepository.save(task);
    }

}
