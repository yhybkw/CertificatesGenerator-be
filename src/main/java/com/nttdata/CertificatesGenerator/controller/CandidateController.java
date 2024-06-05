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
@CrossOrigin("*")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository; // we are passing service layer
// get candidates list
@GetMapping("/list")
public List<Candidate> candidatesList(){
    return candidateRepository.findAll();
}
// find candidate by id
@GetMapping ("/find/{candidateId}")
public ResponseEntity<Candidate> getCandidateByID(@PathVariable Long candidateId) {
    Candidate candidate = candidateRepository.findById(candidateId)
            .orElseThrow(() -> new ResourceNotFoundException("Candidate with id -" + candidateId + "- not exist"));
    return ResponseEntity.ok(candidate);
}
    // add candidate
    @PostMapping ("/add")
    public Candidate addCandidate (@RequestBody Candidate candidate){
        return candidateRepository.save(candidate);
    }
    // update candidate
    @PutMapping("update/{candidateId}")
    public ResponseEntity<Candidate>
        updateCandidate(@PathVariable Long candidateId, @RequestBody Candidate candidateData){
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate with id -" + candidateId + "- not exist"));
        candidate.setFirstName(candidateData.getFirstName());
        candidate.setLastName(candidateData.getLastName());
        candidate.setEmail(candidateData.getEmail());
        candidate.setCity(candidateData.getCity());
        candidate.setUniversity(candidateData.getUniversity());
        candidate.setDiploma(candidateData.getDiploma());
        candidate.setGender(candidateData.getGender());
        candidate.setType(candidateData.getType());
        candidate.setDate(candidateData.getDate());
        candidate.setPhoneNumber(candidateData.getPhoneNumber());
        Candidate updatedCandidate = candidateRepository.save(candidate);
        return ResponseEntity.ok(updatedCandidate);
    }
    // delete candidate
    @DeleteMapping("/delete/{candidateId}")
    public void deleteCandidate(@PathVariable Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
}
