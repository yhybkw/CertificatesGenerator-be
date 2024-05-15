package com.nttdata.CertificatesGenerator.controller;

import com.nttdata.CertificatesGenerator.entity.Candidate;
import com.nttdata.CertificatesGenerator.exception.ResourceNotFoundException;
import com.nttdata.CertificatesGenerator.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository; // we are passing service layer

// get candidates list
@GetMapping("/list")
public List<Candidate> studentsList(){
    return candidateRepository.findAll();
}

// find candidate by id
@GetMapping ("/find/{candidateId}")
public ResponseEntity<Candidate> getStudentByID(@PathVariable Long candidateId) {
    Candidate student = candidateRepository.findById(candidateId)
            .orElseThrow(() -> new ResourceNotFoundException("Candidate with id -" + candidateId + "- not exist"));
    return ResponseEntity.ok(student);
}

    // add candidate
    @PostMapping ("/add")
    public Candidate addStudent (@RequestBody Candidate student){
        return candidateRepository.save(student);
    }

    // update candidate
    @PutMapping("update/{candidateId}")
    public ResponseEntity<Candidate>
        updateStudent(@PathVariable Long candidateId, @RequestBody Candidate candidateData){
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate with id -" + candidateId + "- not exist"));
        candidate.setFirstName(candidateData.getFirstName());
        candidate.setLastName(candidateData.getLastName());
        candidate.setEmail(candidateData.getEmail());
        candidate.setCity(candidateData.getCity());
        candidate.setUniversity(candidateData.getUniversity());
        candidate.setDiploma(candidateData.getDiploma());

        Candidate updatedCandidate = candidateRepository.save(candidate);
        return ResponseEntity.ok(updatedCandidate);
    }

    // delete candidate
    @DeleteMapping("/delete/{candidateId}")
    public void deleteStudent(@PathVariable Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }

}
