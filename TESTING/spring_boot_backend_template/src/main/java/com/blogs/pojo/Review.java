package com.blogs.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "Reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(nullable = false)
    private int rating;

    @Column(columnDefinition = "TEXT")
    private String reviewText;

    @Column(updatable = false)
    private LocalDateTime reviewDate = LocalDateTime.now();
}
