package br.edu.universidade.primeiraapi.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

@Entity // Avisa ao JPA para criar a tabela aluno baseada na classe
public class Aluno {
    @Id // Indica PK (chave primária)
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Ativa o auto incremento
    private Long id;
    private String nome;
    private String matricula;
    private String curso;
    // Inicio do relacionamento
    // Many to One e JoinColumn cria a coluna FK (chave estrangeira)
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Aluno(){
    }

    public Aluno(Long id, String nome, String matricula, String curso, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.departamento = departamento;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}

    public String getCurso() {return curso;}
    public void setCurso(String curso) {this.curso = curso;}

    public Departamento getDepartamento() {return departamento;}
    public void setDepartamento(Departamento departamento) {this.departamento = departamento;}
}

/*
SELECT
a.id AS aluno_id,
a.nome AS aluno_nome,
a.curso,
d.nome_departamento AS departamento_nome,
d.sigla
FROM aluno a
INNER JOIN departamento d ON a.departamento_id = d.ids
*/
