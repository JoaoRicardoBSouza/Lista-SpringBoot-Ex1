package com.ex1.exercicio1.services;

import com.ex1.exercicio1.models.LivroModel;
import com.ex1.exercicio1.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroModel criarLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }

    public Optional<LivroModel> findById(Long id){
        return livroRepository.findById(id);
    }

    public void deletarLivroPorId(Long id){
        livroRepository.deleteById(id);
    }

    public LivroModel atualizarLivro(Long id, LivroModel livroModel){
        LivroModel model = livroRepository.findById(id).get();
        model.setId(livroModel.getId());
        model.setTitulo(livroModel.getTitulo());
        model.setAutor(livroModel.getAutor());
        model.setAnoPublicacao(livroModel.getAnoPublicacao());

        return livroRepository.save(model);
    }
}
