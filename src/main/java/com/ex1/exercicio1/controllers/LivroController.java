package com.ex1.exercicio1.controllers;

import com.ex1.exercicio1.models.LivroModel;
import com.ex1.exercicio1.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll(){
        List<LivroModel> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        LivroModel novoLivro = livroService.criarLivro(livroModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoLivro.getId()).toUri();

        return ResponseEntity.created(uri).body(novoLivro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroModel>> buscaPorId(@PathVariable Long id){
        Optional<LivroModel> livroModelOptional = livroService.findById(id);

        return ResponseEntity.ok().body(livroModelOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
        livroService.deletarLivroPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livroModel){
        LivroModel livroAtualizado = livroService.atualizarLivro(id, livroModel);

        return ResponseEntity.ok().body(livroAtualizado);
    }

}
