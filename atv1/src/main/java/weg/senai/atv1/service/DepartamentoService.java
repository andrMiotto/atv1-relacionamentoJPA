package weg.senai.atv1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weg.senai.atv1.dto.departamento.DepartamentoRequest;
import weg.senai.atv1.dto.departamento.DepartamentoResponse;
import weg.senai.atv1.mapper.DepartamentoMapper;
import weg.senai.atv1.model.Departamento;
import weg.senai.atv1.repository.DepartamentoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {


    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;


    public DepartamentoResponse create(DepartamentoRequest departamentoRequest) {

        Departamento departamento = departamentoMapper.toEntity(departamentoRequest);

        Departamento departamento2 = departamentoRepository.save(departamento);


        DepartamentoResponse departamentoResponse = departamentoMapper.toDTO(departamento2);

        return departamentoResponse;
    }

    public List<DepartamentoResponse> listAll() {

        if (departamentoRepository.findAll().isEmpty()) {
            throw new RuntimeException("Nao existe nenhum departamento cadastrado");
        } else {
            List<Departamento> departamentos = departamentoRepository.findAll();
            List<DepartamentoResponse> dtos = new ArrayList<>();


            for (Departamento departamento : departamentos) {
                dtos.add(departamentoMapper.toDTO(departamento));
            }
            return dtos;

        }

    }

    public DepartamentoResponse findById(Long id) {
        if (departamentoRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhum departamento com esse id");
        } else {
            Departamento departamento = departamentoRepository.findById(id).orElseThrow();
            DepartamentoResponse departamentoResponse = departamentoMapper.toDTO(departamento);

            return departamentoResponse;
        }

    }

    public DepartamentoResponse update(Long id, DepartamentoRequest departamentoRequest) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não existe nenhum departamento com este id"));
        departamento.setNome(departamentoRequest.nome());
        Departamento departamentoSalvo = departamentoRepository.save(departamento);

        DepartamentoResponse departamentoResponse = departamentoMapper.toDTO(departamentoSalvo);

        return departamentoResponse;

    }

    public void delete(Long id) {

        if (departamentoRepository.existsById(id)) {
            departamentoRepository.deleteById(id);

        } else {
            throw new RuntimeException("Este departamento não existe");
        }

    }


}
