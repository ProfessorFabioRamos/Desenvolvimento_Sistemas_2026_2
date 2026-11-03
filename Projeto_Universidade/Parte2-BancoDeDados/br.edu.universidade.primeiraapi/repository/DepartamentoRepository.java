package com.edu.universidade.primeiraapi.repository;

import com.edu.universidade.primeiraapi.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// O JPA Repository recebe 2 tipos genericos: <Classe da Entidade, o tipo de Id>
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

}
