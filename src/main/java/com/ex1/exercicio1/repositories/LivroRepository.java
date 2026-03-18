package com.ex1.exercicio1.repositories;

import com.ex1.exercicio1.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
