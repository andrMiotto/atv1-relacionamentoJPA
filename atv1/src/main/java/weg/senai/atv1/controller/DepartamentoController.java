package weg.senai.atv1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import weg.senai.atv1.dto.departamento.DepartamentoRequest;
import weg.senai.atv1.dto.departamento.DepartamentoResponse;
import weg.senai.atv1.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@RequiredArgsConstructor
public class DepartamentoController {


    private final DepartamentoService departamentoService;


    @PostMapping("/register")
    public DepartamentoResponse create(@RequestBody DepartamentoRequest departamentoRequest) {
        return departamentoService.create(departamentoRequest);

    }

    @GetMapping("/list")
    public List<DepartamentoResponse> listAll() {
        return departamentoService.listAll();

    }


    @GetMapping("/list/{id}")
    public DepartamentoResponse listId(@PathVariable("id") Long id) {
        return departamentoService.findById(id);

    }

    @PutMapping("/update/{id}")
    public DepartamentoResponse update(@PathVariable("id") long id, @RequestBody DepartamentoRequest departamentoRequest) {
        return departamentoService.update(id, departamentoRequest);

    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        departamentoService.delete(id);
    }


}
