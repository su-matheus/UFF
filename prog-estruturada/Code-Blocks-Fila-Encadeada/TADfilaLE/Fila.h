#include <stdio.h>
#include <stdlib.h>

#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED


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

Logico qCreate();
Logico qDestroy();
Logico qIn(Tipo e);
Logico qOut(Tipo *e);
//Logico qIsFull(); não há limite para lista encadeada
Logico qIsEmpty();
Logico qSize(int total);


#endif FILA_H_INCLUDED
