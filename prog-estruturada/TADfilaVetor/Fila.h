#include <stdio.h>
#include <stdlib.h>

#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED


typedef    struct {
                char nome[80]; // nome do aluno
                //float notas[4];
                //int matricula;
            }                   Aluno;

//typedef int Tipo;
// vamos mudar o Tipo (de int para Aluno), mas nada precisa ser mudado em Pilha.c
typedef Aluno Tipo;

typedef int Logico;
#define TRUE 1
#define FALSE 0

Logico qCreate(); // inicializacao da eventual estrutura de dados
Logico qDestroy(); // eventual liberacao de memoria etc
Logico qIn(Tipo e); // entrada do elemento um a um na fila
Logico qOut(Tipo *e); // saida do elemento um a um na fila
Logico qIsFull(); // pergunta se está cheia
Logico qIsEmpty(); // pergunta se está vazia
Logico qCount(int *total); // quantos elementos tem na fila

#endif // FILA_H_INCLUDED
