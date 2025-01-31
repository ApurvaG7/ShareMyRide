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
@Table(name = "Trips")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private User driver;

    @Column(nullable = false, length = 255)
    private String departureLocation;

    @Column(nullable = false, length = 255)
    private String destinationLocation;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private int availableSeats;

    @Column(nullable = false)
    private double price;
}
