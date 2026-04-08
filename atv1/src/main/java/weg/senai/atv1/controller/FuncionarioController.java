package weg.senai.atv1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FuncionarioResponse> create(@RequestBody FuncionarioRequest funcionarioRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.create(funcionarioRequest));

    }

    @GetMapping("/list")
    public ResponseEntity<List<FuncionarioResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.listAll());

    }


    @GetMapping("/list/{id}")
    public ResponseEntity<FuncionarioResponse> listId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findById(id));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FuncionarioResponse> update(@PathVariable("id") long id, @RequestBody FuncionarioRequest funcionarioRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.update(id, funcionarioRequest));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/filter/departamento/{departamentoId}")
    public ResponseEntity<List<FuncionarioResponse>> filterByDepartamento(@PathVariable Long departamentoId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findByDepartamento(departamentoId));
    }

    @GetMapping("/filter/nome/{nome}")
    public ResponseEntity<List<FuncionarioResponse>> filterByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findbyNome(nome));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<FuncionarioResponse>> filterByIdAndNome(@RequestParam long id, @RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findByIdAndNome(id, nome));
    }

}
