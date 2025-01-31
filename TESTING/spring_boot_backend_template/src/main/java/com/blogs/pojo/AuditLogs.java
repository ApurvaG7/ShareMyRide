package com.blogs.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "AuditLogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private LocalDateTime logTime = LocalDateTime.now();
}
