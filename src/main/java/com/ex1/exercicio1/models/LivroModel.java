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

    public LivroModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
