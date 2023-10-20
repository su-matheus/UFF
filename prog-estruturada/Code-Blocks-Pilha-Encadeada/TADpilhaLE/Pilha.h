
#include <stdio.h>
#include <stdlib.h>

#ifndef PILHA_H_INCLUDED
#define PILHA_H_INCLUDED


typedef struct {
    char nome[80];
    float nota[4];
    int matricula;
} Aluno;

typedef Aluno Tipo;

typedef struct node{
    Tipo element;
    struct node *next;
} Node;

typedef int Logico;
#define TRUE 1
#define FALSE 0

Logico stCreate();
Logico stDestroy();
Logico stIn(Tipo e);
Logico stOut(Tipo *e);
Logico stIsEmpty();
Logico stSize(int total);


#endif PILHA_H_INCLUDED
