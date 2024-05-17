package com.example.IgolReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id // this annotation makes the id property a primary key for the table
    Long id;

}
