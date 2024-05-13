package com.nttdata.CertificatesGenerator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50)
    private String gender;

    @Column(length = 50)
    private String email;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String country;

    @Column(length = 20)
    private String anapec;

    private String diploma;

    private String university;

    private String type;

    private boolean isDeleted;
}
