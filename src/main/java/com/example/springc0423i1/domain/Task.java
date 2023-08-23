package com.example.springc0423i1.domain;

import com.example.springc0423i1.domain.enumration.TaskStatus;
import com.example.springc0423i1.domain.enumration.TaskType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalTime start;

    private LocalTime end;
// Học Java, Học C#  => Task daily
    // Học Java, Học C# done, Seminar => Task History.


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
