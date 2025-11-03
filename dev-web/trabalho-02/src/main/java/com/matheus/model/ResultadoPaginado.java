package com.matheus.model;

import java.util.List;

public record ResultadoPaginado<t>(
        long totalItens,
        int totalPaginas,
        int paginaAtual,
        List<t> itens) { }
