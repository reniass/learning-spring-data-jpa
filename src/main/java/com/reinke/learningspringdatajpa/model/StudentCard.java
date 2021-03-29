package com.reinke.learningspringdatajpa.model;

import javax.persistence.*;

@Entity(name = "StudentCard")
@Table(
        name = "student_card",
        uniqueConstraints = {@UniqueConstraint(
                name = "card_number_constraint",
                columnNames = {"card_number"}
        )}
)
public class StudentCard {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_card_sequence"
    )
    @SequenceGenerator(
            name = "student_card_sequence",
            sequenceName = "student_card_sequence",
            allocationSize = 1
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;
    @Column(
            name = "card_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String card_number;

    public StudentCard() {
    }

    public StudentCard(Long id, Student student, String card_number) {
        this.id = id;
        this.student = student;
        this.card_number = card_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
}
