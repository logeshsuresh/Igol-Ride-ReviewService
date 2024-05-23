package com.example.IgolReviewService.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
public class Review {

    @Id // this annotation makes the id property a primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    Long id;

    @Column(nullable = false)
    String content;

    Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Format of date object to be stored
    @CreatedDate // This annotation tells spring only handle it object creation
    Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Format of date object to be stored
    @LastModifiedDate // This annotation tells spring only handle it for object update
    Date updatedAt;

}
