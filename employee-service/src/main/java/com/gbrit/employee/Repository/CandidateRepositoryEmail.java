package com.gbrit.employee.Repository;

import com.gbrit.employee.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CandidateRepositoryEmail extends JpaRepository<Candidate, String> {

    Candidate findByEmailId(String emailId);
   /* @Query(nativeQuery=true, value="SELECT * FROM Candidate where emailId=narmatha@gmail.com")
    Collection<Candidate> findQuestion(Collection collection);*/
    @Query(value = "SELECT * FROM candidate  WHERE email_id = ?1 and contact_number = ?2",nativeQuery = true)
    List<Candidate> findbyEmail(String email, String contactNumber);

}
