package weg.senai.atv1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weg.senai.atv1.dto.departamento.DepartamentoRequest;
import weg.senai.atv1.dto.departamento.DepartamentoResponse;
import weg.senai.atv1.dto.funcionario.FuncionarioRequest;
import weg.senai.atv1.dto.funcionario.FuncionarioResponse;
import weg.senai.atv1.mapper.DepartamentoMapper;
import weg.senai.atv1.mapper.FuncionarioMapper;
import weg.senai.atv1.model.Departamento;
import weg.senai.atv1.model.Funcionario;
import weg.senai.atv1.repository.DepartamentoRepository;
import weg.senai.atv1.repository.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;


    private final FuncionarioMapper funcionarioMapper;
    private final DepartamentoRepository departamentoRepository;


    public FuncionarioResponse create(FuncionarioRequest funcionarioRequest) {

        Departamento departamento = departamentoRepository.findById(funcionarioRequest.departamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioRequest);
        funcionario.setDepartamento(departamento);

        Funcionario funcionario2 = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDTO(funcionario2);
    }

    public List<FuncionarioResponse> listAll() {

        if (funcionarioRepository.findAll().isEmpty()) {
            throw new RuntimeException("Nao existe nenhum funcionario cadastrado");
        } else {
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            List<FuncionarioResponse> dtos = new ArrayList<>();


            for (Funcionario funcionario : funcionarios) {
                dtos.add(funcionarioMapper.toDTO(funcionario));
            }
            return dtos;

        }

    }

    public FuncionarioResponse findById(Long id) {
        if (funcionarioRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhum funcionario com esse id");
        } else {
            Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
            FuncionarioResponse funcionarioResponse = funcionarioMapper.toDTO(funcionario);

            return funcionarioResponse;
        }

    }

    public FuncionarioResponse update(Long id, FuncionarioRequest funcionarioRequest) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não existe nenhum funcionario com este id"));

        Departamento departamento = departamentoRepository.findById(funcionarioRequest.departamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));


        funcionario.setNome(funcionarioRequest.nome());
        funcionario.setCpf(funcionarioRequest.cpf());
        funcionario.setIdade(funcionarioRequest.idade());
        funcionario.setDepartamento(departamento);

        Funcionario funcionario1 = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDTO(funcionario1);


    }

    public void delete(Long id) {

        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);

        } else {
            throw new RuntimeException("Este funcionario não existe");
        }

    }


    public List<FuncionarioResponse> findByDepartamento(long departamentoId) {
        return funcionarioRepository.findByDepartamentoId(departamentoId)
                .stream()
                .map(funcionarioMapper::toDTO).toList();
    }

    public List<FuncionarioResponse> findbyNome(String nome) {
        return funcionarioRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(funcionarioMapper::toDTO).toList();
    }


    public List<FuncionarioResponse> findByIdAndNome(long id, String nome) {
        return funcionarioRepository.findByIdAndNomeContainingIgnoreCase(id, nome)
                .stream()
                .map(funcionarioMapper::toDTO).toList();


    }


}
