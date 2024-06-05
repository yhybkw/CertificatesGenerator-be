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
    @Column(name = "candidateId")
    private Long candidateId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String city;
    private String country;
    private String date;
    private String diploma;
    private String university;
    private String type;
}
