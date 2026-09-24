package br.edu.universidade.primeiraapi.controller;

import br.edu.universidade.primeiraapi.model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/alunos") //Define a rota base (Padrão REST)
public class AlunoController {
    // Simulação de tabela (banco)
    private List<Aluno> alunos = new ArrayList<>();
    // Simulação do contador auto-incremental do BD
    private long proximoId = 1;

    // Metodo GET HTTP que retorna a lista
    @GetMapping
    public List<Aluno> listarTodos() {return alunos;}

    // Metodo GET HTTP por ID (aluno específico)
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable long id) {
        //Utilizamos a API de Streams do Java para buscar o aluno na lista
        Optional<Aluno> alunoEncontrado = alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst();
        // Se encontrado, retorna 200(OK). Se não retorna 404(Not Found)
        if(alunoEncontrado.isPresent()) {
            return new ResponseEntity<>(alunoEncontrado.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Metodo POST HTTP que cria um aluno e adiciona na lista
    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno novoAluno) {
        // Atribui o Id simulado e incrementa para o próximo
        novoAluno.setId(proximoId++);
        // Adiciona na lista
        alunos.add(novoAluno);
        // Retorna status 201 (Created) e o objeto criado com o novo Id
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }
}
/*
{
    "nome":"Leon Kennedy",
    "matricula":"2024002",
    "curso":"Ciência da Computação"
}
 */
