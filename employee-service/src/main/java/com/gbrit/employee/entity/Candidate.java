package com.gbrit.employee.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String contactNumber;
    private String emailId;
    private String firstName;
    private String lastName;
    private String date_Of_Birth;
    private String gender;
    private String ScreeningStatus;
    @Lob
    private Blob resume;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "candidateid", referencedColumnName = "id", nullable=false)
    private Set<CandidateQualification> candidateQualification;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "candidateid", referencedColumnName = "id")
    private Set<CandidateEmploymentHistory> candidateEmploymentHistory;

}
