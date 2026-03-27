package weg.senai.atv1.mapper;

import org.springframework.stereotype.Component;
import weg.senai.atv1.dto.departamento.DepartamentoRequest;
import weg.senai.atv1.dto.departamento.DepartamentoResponse;
import weg.senai.atv1.model.Departamento;

@Component
public class DepartamentoMapper {


    public Departamento toEntity(DepartamentoRequest departamentoRequest){
        return new Departamento(departamentoRequest.nome());
    }

    public DepartamentoResponse toDTO(Departamento departamento){
        return new DepartamentoResponse(departamento.getId(), departamento.getNome());
    }


}
