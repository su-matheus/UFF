
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED

//#define Logico char

typedef int Logico;
#define TRUE 1
#define FALSE 0

typedef struct {
    char nome[10];
} Nome;

typedef Nome Tipo;


Logico queueCreate();
Logico queueDestroy();
Logico queueIsFull();
Logico queueIsEmpty();
Logico queueIn(Tipo e);
Logico queueOut(Tipo *e);
Logico queueSize(int *total);

#endif // FILA_H_INCLUDED
