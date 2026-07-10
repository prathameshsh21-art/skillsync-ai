package com.skillsync.backend.controller;

import com.skillsync.backend.entity.Candidate;
import com.skillsync.backend.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin(origins = "*")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public Candidate saveCandidate(@RequestBody Candidate candidate) {
        System.out.println("===== Candidate API Called =====");
        return candidateService.saveCandidate(candidate);
    }

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable Long id) {
        System.out.println("===== Get Candidate API Called =====");
        return candidateService.getCandidateById(id);
    }
}