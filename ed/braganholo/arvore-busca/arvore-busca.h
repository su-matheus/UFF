#include <stdio.h>
#include <stdlib.h>

#ifndef ARVORE_BUSCA_H
#define ARVORE_BUSCA_H

typedef struct noh{
  char info;
  struct noh *esq;
  struct noh *dir;
}TNoh;


void imprimir(TNoh *noh, int indentacao);
TNoh *criarNoh(char info);

#endif /* ARVORE_BUSCA_H */
