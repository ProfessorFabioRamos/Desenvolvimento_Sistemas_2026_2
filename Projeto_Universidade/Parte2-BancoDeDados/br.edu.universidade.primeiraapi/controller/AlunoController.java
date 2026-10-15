package br.edu.universidade.primeiraapi.controller;

import br.edu.universidade.primeiraapi.model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.universidade.primeiraapi.repository.AlunoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/alunos") //Define a rota base (Padrão REST)
public class AlunoController {
    // Injeção de dependencias do repositorio
    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    // Metodo GET HTTP que retorna a lista
    @GetMapping
    public List<Aluno> listarTodos() {
        return repository.findAll(); // Vai ao banco e faz: SELECT * FROM aluno
    }

    // Metodo GET HTTP por ID (aluno específico)
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable long id) {
        //Substituimos o stream pelo metodo do JPA
        Optional<Aluno> alunoEncontrado = repository.findById(id);

        // Se encontrado, retorna 200(OK). Se não retorna 404(Not Found)
        if(alunoEncontrado.isPresent()) {
            return new ResponseEntity<>(alunoEncontrado.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // ULTIMO ALTERADO POST
    // Metodo POST HTTP que cria um aluno e adiciona na lista
    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno novoAluno) {
        Aluno alunoSalvo = repository.save(novoAluno); // INSERT INTO aluno
        // Retorna status 201 (Created) e o objeto criado com o novo Id
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    // Metodo PUT HTTP atualiza um aluno existente de forma integral por ID
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(
            @PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        for (Aluno aluno : alunos) {
            if(aluno.getId().equals(id)) {
                aluno.setNome(alunoAtualizado.getNome());
                aluno.setMatricula(alunoAtualizado.getMatricula());
                aluno.setCurso(alunoAtualizado.getCurso());

                // Retorna 200(OK) com os dados atualizados
                return ResponseEntity.ok(aluno);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Remove um aluno da lista
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        // removeIf retorna true se encontrou e removeu o item
        boolean removido = alunos.removeIf(aluno -> aluno.getId().equals(id));

        if(removido) {
            // Retorna 204 No Content (sucesso na remoção, não tem corpo de resposta)
            return ResponseEntity.noContent().build();
        }
        // Se não encontrou o ID para deletar, retorna 404 Not Found
        return ResponseEntity.notFound().build();
    }

    // Atualiza parcialmente os dados de um aluno existente
    @PatchMapping("/{id}")
    public ResponseEntity<Aluno> atualizarParcial(
            @PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        Optional<Aluno> alunoEncontrado = alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst();

        if(alunoEncontrado.isPresent()) {
            Aluno aluno = alunoEncontrado.get();

            // Verifica cada campo. Se não for nulo, é atualizado
            if(alunoAtualizado.getNome() != null) {
                aluno.setNome(alunoAtualizado.getNome());
            }
            if(alunoAtualizado.getMatricula() != null) {
                aluno.setMatricula(alunoAtualizado.getMatricula());
            }
            if(alunoAtualizado.getCurso() != null) {
                aluno.setCurso(alunoAtualizado.getCurso());
            }
            // Retorna 200 OK com o aluno atualizado
            return ResponseEntity.ok(aluno);
        }
        // Retorna 404 Not Found se não encontrar o registro
        return ResponseEntity.notFound().build();
    }
}
/*
{
    "nome":"Leon Kennedy",
    "matricula":"2024002",
    "curso":"Ciência da Computação"
}
 */
