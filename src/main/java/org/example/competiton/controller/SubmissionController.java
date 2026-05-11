package org.example.competiton.controller;


import org.example.competiton.entity.Submission;
import org.example.competiton.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//このreqestMappingのルーティングって変えた方が良さそう
@RequestMapping("/api/problems/")
public class SubmissionController {
    private final SubmissionService submissionService;
    @Autowired
    public SubmissionController(SubmissionService submissionService){
        this.submissionService =submissionService;
    }
    @GetMapping
    public List<Submission> getSubmissions(){
        return submissionService.getAllSubmission();
    }
    @PostMapping
    public void submitCode(){
        sumbissionService.submitt();
    }
    @PutMapping
    public void updateCode(){
        submissionservice.update();
    }
    @DeleteMapping
    public void deleteCode(){
        submissionservice.deleteCode()
    }
}
