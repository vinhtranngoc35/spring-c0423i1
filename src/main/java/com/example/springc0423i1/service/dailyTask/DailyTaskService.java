package com.example.springc0423i1.service.dailyTask;

import com.example.springc0423i1.repository.TaskRepository;
import com.example.springc0423i1.service.task.TaskService;
import com.example.springc0423i1.service.task.request.TaskSaveApiRequest;
import com.example.springc0423i1.service.task.request.TaskSaveRequest;
import com.example.springc0423i1.service.task.response.TaskListResponse;
import com.example.springc0423i1.util.AppUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyTaskService {
    private final TaskService taskService;

    private final TaskRepository taskRepository;


    public DailyTaskService(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    public Page<TaskListResponse> findAll(String search, Pageable pageable){
        return taskRepository.findTasksByDescriptionContainingOrTitleContaining(search, search, pageable)
                .map(e -> AppUtil.mapper.map(e, TaskListResponse.class));
    }



    public void create(TaskSaveRequest request){
        taskService.create(request);
    }
}