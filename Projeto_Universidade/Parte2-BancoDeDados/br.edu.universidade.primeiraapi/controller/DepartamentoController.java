package br.edu.universidade.primeiraapi.controller;

import br.edu.universidade.primeiraapi.model.Aluno;
import br.edu.universidade.primeiraapi.model.Departamento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.universidade.primeiraapi.repository.DepartamentoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/departamentos") //Define a rota base (Padrão REST)
public class DepartamentoController {
    // Injeção de dependencias do repositorio
    private final DepartamentoRepository repository;

    public DepartamentoController(DepartamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Departamento> listarTodos() {
        return repository.findAll(); // Vai ao banco e faz: SELECT * FROM aluno
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable long id) {
        //Substituimos o stream pelo metodo do JPA
        Optional<Departamento> departamentoEncontrado = repository.findById(id);

        // Se encontrado, retorna 200(OK). Se não retorna 404(Not Found)
        if(departamentoEncontrado.isPresent()) {
            return new ResponseEntity<>(departamentoEncontrado.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Departamento> criarDepartamento(@RequestBody Departamento novoDepartamento) {
        Departamento departamentoSalvo = repository.save(novoDepartamento); // INSERT INTO aluno
        // Retorna status 201 (Created) e o objeto criado com o novo Id
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizarDepartamento(
            @PathVariable Long id, @RequestBody Departamento departamentoAtualizado){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        // Garante que o Id não será alterado e atualiza o banco
        departamentoAtualizado.setId(id);
        // save() também faz update
        Departamento departamentoSalvo = repository.save(departamentoAtualizado);
        return ResponseEntity.ok(departamentoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        //
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Departamento> atualizarParcial(
            @PathVariable Long id, @RequestBody Departamento departamentoAtualizado){
        Optional<Departamento> departamentoEncontrado = repository.findById(id);

        if(departamentoEncontrado.isPresent()) {
            Departamento departamento = departamentoEncontrado.get();

            if(departamentoAtualizado.getNomeDepartamento() != null) {
                departamento.setNomeDepartamento(departamentoAtualizado.getNomeDepartamento());
            }
            if(departamentoAtualizado.getSigla() != null) {
                departamento.setSigla(departamentoAtualizado.getSigla());
            }

            Departamento departamentoSalvo = repository.save(departamento);
            return ResponseEntity.ok(departamentoSalvo);
        }
        // Retorna 404 Not Found se não encontrar o Id
        return ResponseEntity.notFound().build();
    }
}
/*
{
    "nomeDepartamento":"Faculdade de Tecnologia",
    "sigla":"FATECS"
}
 */
