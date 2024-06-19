#include <stdlib.h>
#include <stdio.h>

typedef struct noh{
  char nome;
  struct noh *esq;
  struct noh *dir;
}TNoh;

void imprimir(TNoh *noh, int indentacao){
  for (int i=0; i<indentacao; i++){
    printf("-");
  }

  if (noh != NULL){
    printf("%s\n", noh->nome);
    imprimir(noh->esq, indentacao+2);
    printf("\n");
    imprimir(noh->dir, indentacao+2);
  } else {
    printf("vazio");
  }
}


TNoh *adicionarNoh(char nome){
  TNoh *novo = (TNoh*) malloc(sizeof(TNoh));
  novo->nome = nome;
  novo->dir, novo->esq = NULL;
  
  return novo;
}

