package weg.senai.atv1.mapper;

import org.springframework.stereotype.Component;
import weg.senai.atv1.dto.funcionario.FuncionarioRequest;
import weg.senai.atv1.dto.funcionario.FuncionarioResponse;
import weg.senai.atv1.model.Funcionario;

@Component

public class FuncionarioMapper {


    public Funcionario toEntity(FuncionarioRequest funcionarioRequest) {
        return new Funcionario(funcionarioRequest.nome(), funcionarioRequest.idade(), funcionarioRequest.cpf());
    }

    public FuncionarioResponse toDTO(Funcionario funcionario) {
        return new FuncionarioResponse(funcionario.getId(), funcionario.getNome(), funcionario.getIdade(), funcionario.getCpf(), funcionario.getDepartamento().getId());
    }


}
