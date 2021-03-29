package com.reinke.learningspringdatajpa.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    private Long id;
    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(
            name = "book",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @CreationTimestamp
    @Column(name = "created_on")
    private Timestamp createdAt;


}
