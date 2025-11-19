package com.matheus.controller;

import com.matheus.model.*;
import com.matheus.service.DisciplinaService;
import com.matheus.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {
    @Autowired
    private final DisciplinaService disciplinaService;
    private final TurmaService turmaService;

    @GetMapping
    public List<DisciplinaDTO> recuperarDisciplinas() {
        return disciplinaService.recuperarDisciplinas();
    }

    @GetMapping("/{id}/turmas")
    public List<DisciplinaTurmaDTO> recuperarPorTurma(@PathVariable Long id) {
//        return turmaService.recuperaPorDisciplina();
        return disciplinaService.recuperarPorTurma(id);
    }

    @PostMapping
    public Disciplina cadastrarDisciplina(@RequestBody Disciplina Disciplina) {
        return disciplinaService.cadastrarDisciplina(Disciplina);
    }


    @DeleteMapping("{idDisciplina}")
    public ResponseEntity<Void> removerDisciplinaPorId(@PathVariable("idTurma") Long id) {
        disciplinaService.removerDisciplinaPorId(id);
        return ResponseEntity.ok().build();
    }

}
