package com.matheus.controller;

import com.matheus.model.Inscricao;
import com.matheus.service.InscricaoService;
import com.matheus.model.InscricaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("inscricoes")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

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
