package com.example.springc0423i1.controller.rest;

import com.example.springc0423i1.service.dailyTask.DailyTaskService;
import com.example.springc0423i1.service.task.TaskService;
import com.example.springc0423i1.service.task.request.TaskSaveApiRequest;
import com.example.springc0423i1.service.task.response.TaskListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/daily-tasks")
@CrossOrigin(origins = {"http://localhost:5173"})
public class DailyTaskRestController {
    private final DailyTaskService dailyTaskService;
    private final TaskService taskService;


    public DailyTaskRestController(DailyTaskService dailyTaskService, TaskService taskService) {
        this.dailyTaskService = dailyTaskService;
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Page<TaskListResponse>> findAll(@RequestParam(defaultValue = "") String search,
                                                          @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        return new ResponseEntity<>(dailyTaskService.findAll(search, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskSaveApiRequest request){
        return new ResponseEntity<>(taskService.create(request), HttpStatus.OK);
    }
}