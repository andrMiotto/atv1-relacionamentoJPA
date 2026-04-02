package weg.senai.atv1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weg.senai.atv1.dto.departamento.DepartamentoRequest;
import weg.senai.atv1.dto.departamento.DepartamentoResponse;
import weg.senai.atv1.dto.funcionario.FuncionarioRequest;
import weg.senai.atv1.dto.funcionario.FuncionarioResponse;
import weg.senai.atv1.service.DepartamentoService;
import weg.senai.atv1.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;


    @PostMapping("/register")
    public FuncionarioResponse create(@RequestBody FuncionarioRequest funcionarioRequest) {
        return funcionarioService.create(funcionarioRequest);

    }

    @GetMapping("/list")
    public List<FuncionarioResponse> listAll() {
        return funcionarioService.listAll();

    }


    @GetMapping("/list/{id}")
    public FuncionarioResponse listId(@PathVariable("id") Long id) {
        return funcionarioService.findById(id);

    }

    @PutMapping("/update/{id}")
    public FuncionarioResponse update(@PathVariable("id") long id, @RequestBody FuncionarioRequest funcionarioRequest) {
        return funcionarioService.update(id, funcionarioRequest);

    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        funcionarioService.delete(id);
    }

    @GetMapping("/filter/departamento/{departamentoId}")
    public List<FuncionarioResponse> filterByDepartamento(@PathVariable Long departamentoId) {
        return   funcionarioService.findByDepartamento(departamentoId);
    }

    @GetMapping("/filter/nome/{nome}")
    public List<FuncionarioResponse> filterByNome(@PathVariable String nome) {
        return   funcionarioService.findbyNome(nome);
    }

    @GetMapping("/filter")
    public List<FuncionarioResponse> filterByIdAndNome(@RequestParam long id, @RequestParam String nome) {
        return   funcionarioService.findByIdAndNome(id, nome);
    }

}
