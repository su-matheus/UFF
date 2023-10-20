#include <stdio.h>
#include <stdlib.h>


#ifndef LISTAQUERODA_H_INCLUDED
#define LISTAQUERODA_H_INCLUDED

typedef struct {
    char nome[80];
    int matricula;
    float nota[4];
} Aluno;

typedef Aluno Tipo;


typedef struct node{
    Tipo element;
    struct node *next;
    struct node *prev;
} Node;

typedef int Logic;
#define TRUE 1
#define FALSE 0

Node *current;
int count;

Logic clCreate();
Logic clPrint();
Logic clInsert(Tipo e);




#endif // LISTAQUERODA_H_INCLUDED


