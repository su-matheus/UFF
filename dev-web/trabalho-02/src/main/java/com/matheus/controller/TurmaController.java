package com.matheus.controller;

import com.matheus.model.Professor;
import com.matheus.model.Turma;
import com.matheus.model.TurmaDTO;
import com.matheus.service.TurmaService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("turmas")
public class TurmaController {
    @Autowired
    private final TurmaService turmaService;

    @GetMapping
    public List<Turma> recuperarTurmas() {
        return turmaService.recuperarTurmas();
    }

    @PostMapping
    public Turma cadastrarTurma(@RequestBody TurmaDTO turmaDTO) {
        return turmaService.cadastrarTurma(turmaDTO);
    }

    @DeleteMapping("{idTurma}")
    public ResponseEntity<Void> removerTurmaPorId(@PathVariable("idTurma") Long id) {
        turmaService.removerTurmaPorId(id);
        return ResponseEntity.ok().build();
    }

}
