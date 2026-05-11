package org.example.competiton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.competiton.entity.Problem;
public interface ProblemRepository extends JpaRepository<Problem,Long> {

}
