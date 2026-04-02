package weg.senai.atv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weg.senai.atv1.model.Departamento;
import weg.senai.atv1.model.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    List<Funcionario> findByDepartamentoId(long departamentoId);

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    List<Funcionario> findByIdAndNomeContainingIgnoreCase(long id, String nome);


}

