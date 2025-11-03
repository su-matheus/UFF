package com.matheus.controller;

import com.matheus.model.*;
import com.matheus.service.TurmaService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<TurmaDTO> recuperarTurmas() {
        return turmaService.recuperarTurmas();
    }

    // http://localhost:8080/produtos/paginacao?pagina=0&tamanho=5
    @GetMapping("paginacao")
    public ResultadoPaginado<Turma> recuperarTurmasComPaginacao(
            @RequestParam(name = "pagina", defaultValue = "0") int pagina,
            @RequestParam(name = "tamanho", defaultValue = "5") int tamanho,
            @RequestParam(name = "nome", defaultValue = "") String nome
    ) {
        Pageable pageable = PageRequest.of(pagina, tamanho);
        Page<Turma> page = turmaService.recuperarTurmasPaginadas(pageable, nome);
        return new ResultadoPaginado<Turma>(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getContent()
        );
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<TurmaAlunoPaginadoDTO> buscarPorIdComAlunosPaginados(
//            @PathVariable Long id,
//            Pageable pageable) {
//        TurmaAlunoPaginadoDTO dto = turmaService.buscarPorIdComAlunosPaginados(id, pageable);
//        return ResponseEntity.ok(dto);
//    }


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
