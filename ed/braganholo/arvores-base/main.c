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
    printf("%c\n", noh->nome);
    imprimir(noh->esq, indentacao+2);
    printf("\n");
    imprimir(noh->dir, indentacao+2);
    printf("\n");
  } else {
    printf("vazio");
  }
}


TNoh *criarNoh(char nome){
  TNoh *novo = (TNoh*) malloc(sizeof(TNoh));
  novo->nome = nome;
  novo->esq = NULL;
  novo->dir = NULL;
  
  return novo;
}


int main (void){
  TNoh *raiz = criarNoh('A');
  raiz->dir = criarNoh('B');
  imprimir(raiz, 0);
  
  return 0;
}