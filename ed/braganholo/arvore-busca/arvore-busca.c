#include "arvore-busca.h"

void imprimir(TNoh *noh, int indentacao){
  for (int i=0; i<indentacao; i++){
    printf("-");
  }

  if (noh != NULL){
    printf("%c", noh->info);
    imprimir(noh->dir, indentacao+2);
    printf("\n");
    imprimir(noh->esq, indentacao+2);
  } else printf("vazio");
}

TNoh *criarNoh(char info){
  TNoh *novoNoh = (TNoh*) malloc(sizeof(TNoh));
  novoNoh->info = info;
  novoNoh ->dir = novoNoh->esq = NULL;

  return novoNoh;
}