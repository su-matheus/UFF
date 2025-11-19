package com.matheus.controller;

import com.matheus.model.Inscricao;
import com.matheus.service.InscricaoService;
import com.matheus.model.InscricaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("inscricoes")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping
    public List<InscricaoDTO> recuperarInscricoes() {return inscricaoService.recuperarInscricoes();}

    @PostMapping
    public Inscricao cadastrarInscricao(@RequestBody InscricaoDTO inscricaoDTO) {
        return inscricaoService.cadastrarInscricao(inscricaoDTO);
    }

    @DeleteMapping("{idInscricao}")
    public ResponseEntity<Void> removerInscricaoPorId(@PathVariable("idInscricao") Long id) {
        inscricaoService.removerInscricaoPorId(id);
        return ResponseEntity.ok().build();
    }
}
