package org.example.competiton.repository;
import org.example.competiton.entity.Problem;
import org.example.competiton.repository.ProblemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProblemRepositoryTest {
    private final ProblemRepository problemRepository;
    @Autowired
    public ProblemRepositoryTest(ProblemRepository problemRepository){
        this.problemRepository=problemRepository;
    }
    @AfterEach
    void tearDown(){
        problemRepository.deleteAll();
    }
    @Test
    void registProblem(){
        //データベースを確認
        Problem problem=new Problem(null,"ABC422 A","https//example.com","メモ",null);
        problemRepository.save(problem);

        List<Problem> result=problemRepository.findAll();
        assertEquals(1,result.size());
        //ここも確認
        assertEquals("ABC422 A", result.get(0).getTitle());

    }
    @Test
    void confirmProblem(){
        Problem problem=new Problem(null,"ABC422 A","https//example.com","メモ",null);
        Problem saved=problemRepository.save(problem);
        Problem result=problemRepository.findById(saved.getId()).orElseThrow();
        assertEquals("ABC422 A",result.getTitle());
    }
    @Test
    void deleteProblem(){
        Problem problem=new Problem(null,"ABC422 A","https://example.com","メモ",null);
        Problem saved=problemRepository.save(problem);

        problemRepository.deleteById(saved.getId());
        List<Problem> result=problemRepository.findAll();
        assertEquals(0,result.size());
    }
}
