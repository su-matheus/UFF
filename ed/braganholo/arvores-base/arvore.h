#include <stdlib.h>
#include <stdio.h>

#ifndef ARVORE_H_INCLUDED
#define ARVORE_H_INCLUDED


typedef struct noh{
  char nome;
  struct noh *esq;
  struct noh *dir;
}TNoh;


TNoh criarNoh();
TNoh adicionarNoh(char nome);

char returnChar();

#endif //ARVORE_H_INCLUDED