package br.edu.universidade.primeiraapi.controller;

import br.edu.universidade.primeiraapi.model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos") //Define a rota base
public class AlunoController {
    // Simulação de tabela (banco)
    private List<Aluno> alunos = new ArrayList<>();
}
