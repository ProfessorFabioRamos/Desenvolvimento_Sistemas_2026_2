package br.edu.universidade.primeiraapi.repository;

import br.edu.universidade.primeiraapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// O JPA Repository recebe 2 tipos gnéricos: <Classe da Entidade, o tipo de Id>
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Vazio.
    // Todos os métodos (save, findById, findAll, deleById etc) estão aqui
}
