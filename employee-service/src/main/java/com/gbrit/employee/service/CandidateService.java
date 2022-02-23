package com.gbrit.employee.service;

import com.gbrit.employee.Repository.CandidateRepositoryEmail;
import com.gbrit.employee.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private CandidateRepositoryEmail  candidateRepositoryEmail;

    @Autowired
    public CandidateService(CandidateRepositoryEmail candidateRepositoryEmail) {
        this.candidateRepositoryEmail = candidateRepositoryEmail;
    }

    public Candidate findByEmail(String email) {
        return candidateRepositoryEmail.findByEmailId(email);
    }
    public void saveUser(Candidate candidate) {
        candidateRepositoryEmail.save(candidate);
    }

}
