package com.example.springc0423i1.cronjob;

import com.example.springc0423i1.service.task.TaskService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class CreateTaskCronjob {
    private final TaskService taskService;

    public CreateTaskCronjob(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleFixedRateTask() {
        taskService.generateTaskHistory();
    }
}
