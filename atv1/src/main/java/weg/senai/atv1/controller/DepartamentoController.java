package weg.senai.atv1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DepartamentoResponse> create(@RequestBody DepartamentoRequest departamentoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(departamentoService.create(departamentoRequest));

    }

    @GetMapping("/list")
    public ResponseEntity<List<DepartamentoResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(departamentoService.listAll());

    }


    @GetMapping("/list/{id}")
    public ResponseEntity<DepartamentoResponse> listId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(departamentoService.findById(id));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DepartamentoResponse> update(@PathVariable("id") long id, @RequestBody DepartamentoRequest departamentoRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(departamentoService.update(id, departamentoRequest));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        departamentoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
