#include "arvore-busca.c"

int main(void){
  TNoh *raiz = criarNoh('A');
  raiz->dir = criarNoh('B');
  imprimir(raiz,0);

  return 0;
}