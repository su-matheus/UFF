package com.matheus.controller;

import com.matheus.model.Professor;
import com.matheus.model.ProfessorDTO;
import com.matheus.service.ProfessorService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> recuperarProfessores() {
        return professorService.recuperarProfessores();
    }

    @PostMapping
    public Professor cadastrarProfessor(@RequestBody Professor professor) {
        return professorService.cadastrarProfessor(professor);
    }

    @PutMapping
    public Professor alterarProfessor(@RequestBody Professor professor) {
        return professorService.alterarProfessor(professor);
    }

    @GetMapping("{idProfessor}")
    public ResponseEntity<?> recuperarProfessorPorId(
            @PathVariable("idProfessor") Long id,
            @RequestParam(name = "incluirTurma", defaultValue = "true") boolean incluirTurma) {
        if (incluirTurma) {
            Professor professor = professorService.recuperarProfessorPorId(id);
            return ResponseEntity.ok(professor);
        }
        else {
            Professor professor = professorService.recuperarProfessorPorIdSemTurma(id);
            ProfessorDTO professorDTO = new ProfessorDTO(professor.getId(), professor.getNome());
            System.out.println(professorDTO.id());
            return ResponseEntity.ok(professorDTO);
        }
    }

    @DeleteMapping("{idProfessor}")
    public ResponseEntity<Void> removerProfessorPorId(@PathVariable("idProfessor") Long id) {
        professorService.removerProfessorPorId(id);
        return ResponseEntity.ok().build();
    }
}
