package com.example.springc0423i1.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Long repeatPerDays;

    private String repeatDayOfWeek;

    private LocalDate date;

    private LocalTime start;

    private LocalTime end;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;

    // để xác định được OneToMany hay ManyToOne thì phải câu hỏi Task History thằng 1 nào thằng nhiều
    // chữ đầu tiên đại diện cho class đang đứng
    // chữ thứ 2 đại diện cho field bên dưới
    @OneToMany(mappedBy = "task") // task ở đây được lấy name field task của TaskHistory
    private Set<TaskHistory> taskHistories;


}