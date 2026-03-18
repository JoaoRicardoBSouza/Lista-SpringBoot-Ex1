package com.ex1.exercicio1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livro")
public class LivroModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nomeLivro")
    private String titulo;
    @Column(name = "nomeAutor")
    private String autor;
    private Integer anoPublicacao;

}
