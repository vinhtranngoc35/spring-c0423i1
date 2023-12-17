package com.example.springc0423i1.controller.rest;

import com.example.springc0423i1.domain.enumration.TaskStatus;
import com.example.springc0423i1.service.task.TaskService;
import com.example.springc0423i1.service.task.request.TaskSaveRequest;
import com.example.springc0423i1.service.task.response.TaskDetailResponse;
import com.example.springc0423i1.service.task.response.TaskListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Controller
@RequestMapping("api/tasks")
@CrossOrigin(origins = {"http://localhost:5173"})
public class TaskRestController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskListResponse>> getTasks(){
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDetailResponse> getTask(@PathVariable Long id){
        return new ResponseEntity<>(taskService.findTaskDetail(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody TaskSaveRequest request){
        return new ResponseEntity<>(taskService.create(request), HttpStatus.OK);
    }
    @GetMapping("status/{id}/{status}")
    public String changeStatus(@PathVariable Long id, @PathVariable TaskStatus status){
        taskService.changeStatus(id, status);
        return "redirect:/task?message=Change Success";
    }
    @GetMapping("recovery")
    public void recovery(){
        taskService.generateTaskHistoryRecovery();
    }
}