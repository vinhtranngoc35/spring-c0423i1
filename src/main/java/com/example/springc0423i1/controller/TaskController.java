package com.example.springc0423i1.controller;

import com.example.springc0423i1.domain.enumration.TaskStatus;
import com.example.springc0423i1.domain.enumration.TaskType;
import com.example.springc0423i1.service.task.TaskService;
import com.example.springc0423i1.service.task.request.TaskSaveRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ModelAndView showListTasks() {
        ModelAndView view = new ModelAndView("task/index");
        view.addObject("tasks", taskService.getTasks());
        return view;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView view = new ModelAndView("task/create");
        view.addObject("task", new TaskSaveRequest());
        view.addObject("taskTypes", TaskType.values());
        view.addObject("taskStatuses", TaskStatus.values());
        return view;
    }

    @PostMapping("/create")
    public ModelAndView showCreate(@ModelAttribute TaskSaveRequest task) {
        ModelAndView view = new ModelAndView("task/create");
        taskService.create(task);
        view.addObject("task", task);
        view.addObject("taskTypes", TaskType.values());
        view.addObject("taskStatuses", TaskStatus.values());
        return view;
    }
}
