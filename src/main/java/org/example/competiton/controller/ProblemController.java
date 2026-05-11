package org.example.competiton.controller;
//repositoryではGET,POST,,,の管理だけを行い、実際の処理に関してはSeviceに一任する
import org.example.competiton.entity.Problem;
import org.example.competiton.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/problems/")
public class ProblemController {
    private final ProblemService problemService;
    //Listの型について
    //ルーティングをきちんと割り振る
    //serveとcontrollerの命名規則について勉強　
    @Autowired
    public ProblemController(ProblemService problemService){
        this.problemService = problemService;
    }
    @GetMapping
    public List<Problem> getAllProblems(){
        return problemService.getAllProblems();
    }
    //データをどうやって渡すか考える
    @PostMapping
    public void addProblem(){
        return problemService.addSubmit();
    }
    @GetMapping("/{id}")
    public List<Problem> getSpeProblems(){
        return problemService.getSpeProblems();
    }
    @PutMapping("/{id}")
    public void updateSpeProblems(){
        return problemService.putSpeproblems();
    }
    @DeleteMapping("/{id}")
    public void deleteSpeProblems(){
        return problemService.delSpecProblems();
    }
    //タグ絞り込みのルーティングがわからん
    @GetMapping("/")
    public String usetag(){
        return "どうしよう";
    }

}