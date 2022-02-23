package com.gbrit.employee.Repository;
import com.gbrit.employee.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepositoryId extends JpaRepository<Candidate, Long> {
}

