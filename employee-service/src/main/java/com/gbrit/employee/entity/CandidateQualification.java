package com.gbrit.employee.entity;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CandidateQualification {
    @Id
    private long id;
    private String name;
    private String SSLC;
    private float SSLCmark;
    private String HSC;
    private float HSCmark;
    private String UGdegree;
    private float UGmark;
    private String PGdegree;
    private float PGMark;
    private String Others;
    private float OthersMark;

//    @ManyToOne
//    @JoinColumn(name="candidate")
//    private Candidate Candidate;
}
