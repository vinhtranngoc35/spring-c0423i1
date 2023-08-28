package com.example.springc0423i1.service.task;

import com.example.springc0423i1.domain.Task;
import com.example.springc0423i1.domain.TaskHistory;
import com.example.springc0423i1.domain.enumration.TaskStatus;
import com.example.springc0423i1.domain.enumration.TaskType;
import com.example.springc0423i1.exception.ResourceNotFoundException;
import com.example.springc0423i1.repository.TaskHistoryRepository;
import com.example.springc0423i1.repository.TaskRepository;
import com.example.springc0423i1.service.task.request.TaskEditRequest;
import com.example.springc0423i1.service.task.request.TaskSaveRequest;
import com.example.springc0423i1.service.task.response.TaskDetailResponse;
import com.example.springc0423i1.service.task.response.TaskListResponse;
import com.example.springc0423i1.util.AppMessage;
import com.example.springc0423i1.util.AppUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    private final TaskHistoryRepository taskHistoryRepository;

    public List<TaskListResponse> getTasks() {

        return taskHistoryRepository.findAllTaskToDay(LocalDate.now(ZoneId.of("GMT+0")))
                .stream()
                .map(e -> AppUtil.mapper.map(e, TaskListResponse.class))
                .collect(Collectors.toList());
    }

    public void create(TaskSaveRequest request) {
        var taskHistory = AppUtil.mapper.map(request, TaskHistory.class);
        if (Objects.equals(request.getType(), TaskType.DAILY.toString())) {
            var task = AppUtil.mapper.map(request, Task.class);
            task = taskRepository.save(task);
            //create new task history for display in home screen
            LocalDate now = LocalDate.now();
            taskHistory.setTask(task);
            taskHistory.setStart(LocalDateTime.of(now, task.getStart()));
            taskHistory.setEnd(LocalDateTime.of(now, task.getEnd()));
        }

        taskHistoryRepository.save(taskHistory);
    }

    public void changeStatus(Long id, TaskStatus status){
        var task = findById(id);
        task.setStatus(status);
        taskHistoryRepository.save(task);
    }

    public TaskHistory findById(Long id){
        return taskHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(AppMessage.ID_NOT_FOUND, "Task", id)));
    }
    public Task findByTaskId(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(AppMessage.ID_NOT_FOUND, "Task", id)));
    }
    public TaskDetailResponse findTaskDetail(Long id){
        TaskHistory taskHistory = findById(id);
        return AppUtil.mapper.map(taskHistory, TaskDetailResponse.class);
    }

    @Transactional
    public void generateTaskHistory(){
        var tasks = taskRepository.findAll();
        var taskHistories = new ArrayList<TaskHistory>();
        for (var task : tasks) {
            var taskHistory = AppUtil.mapper.map(task, TaskHistory.class);
            //create new task history for display in home screen
            LocalDate now = LocalDate.now();
            taskHistory.setType(TaskType.DAILY);
            taskHistory.setTask(task);
            taskHistory.setStart(LocalDateTime.of(now, task.getStart()));
            taskHistory.setEnd(LocalDateTime.of(now, task.getEnd()));
            taskHistories.add(taskHistory);
        }
        taskHistoryRepository.saveAll(taskHistories);
    }
    @Transactional
    public void edit(TaskEditRequest request, Long id) {
        //lấy task history bằng id.
        // nếu task có value và isEditAll = true.
        // cập nhập task cũ và taskhistory cho hôm nay
        // còn không chỉ cập nhập task history cho Hôm nay

        var taskHistoryExistDb = findById(id);

        AppUtil.mapper.map(request, taskHistoryExistDb);
        boolean isEditAll = Boolean.parseBoolean(request.getIsEditAll());

        var taskExistDb = taskHistoryExistDb.getTask();
        if(isEditAll && taskExistDb != null){
            AppUtil.mapper.map(request, taskExistDb);
            taskRepository.save(taskExistDb);
        }
        if(taskExistDb != null){
            LocalDate now = LocalDate.now();
            taskHistoryExistDb.setTask(taskExistDb);
            taskHistoryExistDb.setStart(LocalDateTime.of(now,LocalTime.parse(request.getStart(), DateTimeFormatter.ofPattern("HH:mm"))));
            taskHistoryExistDb.setEnd(LocalDateTime.of(now, LocalTime.parse(request.getEnd(), DateTimeFormatter.ofPattern("HH:mm"))));
        }
        taskHistoryRepository.save(taskHistoryExistDb);
    }
}
