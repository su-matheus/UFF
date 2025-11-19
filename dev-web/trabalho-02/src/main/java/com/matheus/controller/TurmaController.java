package com.matheus.controller;

import com.matheus.model.*;
import com.matheus.service.AlunoService;
import com.matheus.service.TurmaService;
import com.matheus.service.InscricaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("turmas")
public class TurmaController {
    @Autowired
    private final TurmaService turmaService;
    private final AlunoService alunoService;
    private final InscricaoService inscricaoService;

    @GetMapping
    public List<TurmaDTO> recuperarTurmas() {
        return turmaService.recuperarTurmas();
    }

    @GetMapping("/{id}/alunos")
    public List<AlunoDTO> listarAlunosDaTurma(@PathVariable Long id) {
        return alunoService.recuperarPorTurma(id);
    }

    @GetMapping("/{id}/inscricoes")
    public List<InscricaoDTO> listarInscritosDaTurma(@PathVariable Long id) {
        return inscricaoService.recuperarPorTurma(id);
    }

    // http://localhost:8080/produtos/paginacao?pagina=0&tamanho=5
    @GetMapping("paginacao")
    public ResultadoPaginado<TurmaAlunoPaginadoDTO> recuperarTurmasComPaginacao(
            @RequestParam(name = "pagina", defaultValue = "0") int pagina,
            @RequestParam(name = "tamanho", defaultValue = "5") int tamanho,
            @RequestParam(name = "nome", defaultValue = "") String nome
    ) {
        Pageable pageable = PageRequest.of(pagina, tamanho);
        var page = turmaService.recuperarTurmaComAlunos(pageable, nome);
        return new ResultadoPaginado<>(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getContent()
        );
    }

    @PostMapping
    public Turma cadastrarTurma(@RequestBody TurmaDTO turmaDTO) {
        return turmaService.cadastrarTurma(turmaDTO);
    }

    @PostMapping("/{idTurma}/inscricoes")
    public ResponseEntity<Inscricao> inscreverAluno(
            @PathVariable Long idTurma,
            @RequestBody Map<String, Long> payload
    ) {
        Long alunoId = payload.get("alunoId");
        Inscricao inscricao = inscricaoService.inscreverAluno(idTurma, alunoId);
        return ResponseEntity.ok(inscricao);
    }

    @DeleteMapping("/{idTurma}/inscricoes/{idInscricao}")
    public ResponseEntity<Void> removerInscricao(
            @PathVariable Long idTurma,
            @PathVariable Long idInscricao
    ) {
        inscricaoService.removerInscricao(idTurma, idInscricao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idTurma}")
    public ResponseEntity<Void> removerTurmaPorId(@PathVariable("idTurma") Long id) {
        turmaService.removerTurmaPorId(id);
        return ResponseEntity.ok().build();
    }
}
