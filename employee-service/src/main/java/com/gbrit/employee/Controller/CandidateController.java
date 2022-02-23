package com.gbrit.employee.Controller;

import java.util.List;
import java.util.Optional;
import com.gbrit.employee.Repository.CandidateRepositoryEmail;
import com.gbrit.employee.Repository.CandidateRepositoryId;
import com.gbrit.employee.entity.Candidate;
import com.gbrit.employee.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepositoryId candidateRepositoryId;
    @Autowired
    private CandidateRepositoryEmail candidateRepositoryEmail;
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/employees")
    List<Candidate> all() {
        return candidateRepositoryId.findAll();
    }

    @GetMapping("/findbyId/{id}")
    private Optional<Candidate> getCandidateByID(@PathVariable("id") long id){
        return candidateRepositoryId.findById(id);
    }

    @GetMapping("/findbyEmail/{emailId}")
    private Optional<Candidate> getCandidateByEmail(@PathVariable("emailId") String email){
        return Optional.ofNullable(candidateRepositoryEmail.findByEmailId(email));
    }

    /**
     *
     * @param email
     * @return
     */
    @GetMapping("/customQuery/{emailId}/{contactnumber}")
    private List<Candidate> getemail(@PathVariable("emailId") String email, @PathVariable("contactnumber") String contactNumber) {
        return  candidateRepositoryEmail.findbyEmail(email, contactNumber);
    }

    /**
     * @RequestMapping(value = "/{lang}/{count}/{term}", method=RequestMethod.GET)
     * public ResponseEntity<?> getSomething(@PathVariable("lang") String lang, @PathVariable("count") String count, @PathVariable("term") String term) {
     *
     *@GetMapping("/customQuery/{emailId}")
     *     private List<Candidate> getemail(@PathVariable("emailId") String email) {
     *         return  candidateRepositoryEmail.findbyEmail(email);
     *     }
     * @param newCandidate
     * @return
     */
    @PostMapping("/registration")
    Candidate newEmployee(@RequestBody Candidate newCandidate) {
        return candidateRepositoryId.save(newCandidate);
    }

    /**
     *
     * @param modelAndView
     * @param candidate
     * @return
     */
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, Candidate candidate){
        modelAndView.addObject("user", candidate);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    /**
     *
     * @param candidate
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String isCandidateExist(@RequestBody Candidate candidate){
        Candidate emailExists = candidateService.findByEmail(candidate.getEmailId());
        if (emailExists != null) {
          return "Already Resgistered";
        } else {
            candidateService.saveUser(candidate);
            return "Registered Sucessfully!";
        }
    }

   // @GetMapping("/maleCandidate")
   // public Collection<Candidate> sortingMaleCandidate(Collection gender){
    //    return candidateRepositoryEmail.findQuestion(gender);
   // }

    /*
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Candidate candidate, BindingResult bindingResult,HttpServletRequest request) {
        // Lookup user in database by e-mail
        Candidate emailExists = candidateService.findByEmail(candidate.getEmailId());
        System.out.println(emailExists);
        if (emailExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            candidateService.saveUser(candidate);
        }
        return modelAndView;
    }
    */
    /* Single item

    @GetMapping("/employees/{id}")
    Candidate one(@PathVariable Long candidateId) {

        return repository.findById(candidateId)
                .orElseThrow(() -> new ClassCastException(candidateId.toString())); //EmployeeNotFoundException(id));
    }

*/

/*
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }*/

    /*
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        candidateRepositoryId.deleteById(id);
    }
     */
}