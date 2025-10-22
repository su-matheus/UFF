package com.matheus.controller;

import com.matheus.model.Aluno;
import com.matheus.model.AlunoDTO;
import com.matheus.service.AlunoService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("alunos")   // htttp://localhost:8080/alunos
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> recuperarAlunos() {
        return alunoService.recuperarAlunos();
    }

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.cadastrarAluno(aluno);
    }

    @PutMapping
    public Aluno alterarAluno(@RequestBody Aluno aluno) {
        return alunoService.alterarAluno(aluno);
    }

//    Implementação retornando um objeto Produto
//    // http://localhost:8080/produtos/1
//    @GetMapping("{idProduto}")
//    public Produto recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
//        return produtoService.recuperarProdutoPorId(id);
//    }

//    Implementação retornando um ResponseEntity<Produto>
//    // http://localhost:8080/produtos/1
//    @GetMapping("{idProduto}")
//    public ResponseEntity<Produto> recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
//        Produto produto = produtoService.recuperarProdutoPorId(id);
//        return new ResponseEntity<>(produto, HttpStatus.OK);
//    }

    // Implementação utilizando o método estático ok() que retorna um ResponseEntity
    // http://localhost:8080/produtos/1?incluirCategoria=false
    @GetMapping("{idAluno}")
    public ResponseEntity<?> recuperarAlunoPorId(
            @PathVariable("idAluno") Long id,
            @RequestParam(name = "incluirInscricao", defaultValue = "true") boolean incluirInscricao) {
        if (incluirInscricao) {
//            Produto produto = produtoService.recuperarProdutoPorIdComCategoria(id);
//            Aluno aluno = alunoService.recuperarAlunoPorId(id);
            Aluno aluno = alunoService.recuperarAlunoPorIdComInscricao(id);
            return ResponseEntity.ok(aluno);
        }
        else {
            Aluno aluno = alunoService.recuperarAlunoPorIdSemInscricao(id);
            AlunoDTO alunoDTO = new AlunoDTO(aluno.getId(), aluno.getNome());
            System.out.println(alunoDTO.id());
            return ResponseEntity.ok(alunoDTO);
//            Produto produto = produtoService.recuperarProdutoPorIdSemCategoria(id);
//            ProdutoDTO produtoDTO = new ProdutoDTO(produto.getId(), produto.getNome());
//            System.out.println(produtoDTO.id());
//            return ResponseEntity.ok(produtoDTO);
        }
    }

//    Implementação que retorna um Produto ou um String (mensagem de errro) sem utilizar
//    um GlobalExceptionHandler
//    // Get para http://localhost:8080/produtos/1
//    @GetMapping("{idProduto}")
//    public ResponseEntity<?> recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
//        try {
//            Produto produto = produtoService.recuperarProdutoPorId(id);
//            return ResponseEntity
//                .ok()
//                .header("Content-Type", "application/json")
//                .body(produto);
//        }
//        catch(EntidadeNaoEncontradaException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

//    // Delete para http://localhost:8080/produtos/1
//    @DeleteMapping("{idProduto}")
//    public void removerProdutoPorId(@PathVariable("idProduto") Long id) {
//        produtoService.removerProdutoPorId(id);
//    }

    // Implementação utilizando um builder
    // Delete para http://localhost:8080/produtos/1
    @DeleteMapping("{idAluno}")
    public ResponseEntity<Void> removerAlunoPorId(@PathVariable("idAluno") Long id) {
        alunoService.removerAlunoPorId(id);
        return ResponseEntity.ok().build();
    }
}

