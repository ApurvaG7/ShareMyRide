package com.blogs.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Complaints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(nullable = false)
    private String complaintText;

    @Column(nullable = false)
    private LocalDateTime complaintTime = LocalDateTime.now();
}
