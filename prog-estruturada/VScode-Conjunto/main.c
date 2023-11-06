#include <stdio.h>
#include <stdlib.h>


#ifndef CONJUNTO_H_INCLUDED
#define CONJUNTO_H_INCLUDED

typedef int Tipo;

typedef int Logic;
#define TRUE 1
#define FALSE 0

typedef int Result;
#define GT 1
#define EQUAL 0
#define LT -1

Result comparar(Tipo a, Tipo b){
    if (a > b) return GT;
    if (a == b) return EQUAL;
    return LT;
}


//typedef void (*funcaoDeForaQueImprime)(Tipo);// ponteiro para função
//typedef Result (*funcaoDeForaQueCompara)(Tipo, Tipo);// ponteiro para função

Logic setsCreate();
Logic setsAddElement(char c1, Tipo e);
Logic setsRemoveElement(char c1, Tipo e);
Logic setsBelongsTo(char c1, Tipo e);
Logic setsUnion(char c1, char c2, char c3);
Logic setsIntersection(char c1, char c2, char c3);
Logic setsNumberOfElements(char c1, int *total);
Logic setsIsIn(char c1, char c2, Logic *result);
Logic setsDestroy();

#endif // CONJUNTO_H_INCLUDED

//------------------------------------------

typedef struct node {
    Tipo e;
    struct node * next;
} Node;

#define MAX_CONJUNTOS ('Z'-'A'+1)
Node * vetListas[MAX_CONJUNTOS];

Logic setsCreate(){
    for(int i=0;i<MAX_CONJUNTOS;i++){
        vetListas[i] = NULL;
    }
    return TRUE;
}

//---------------------------------------

char conjuntoAtual = 'A';
char conjuntosExibidos[]= {'A', 'B', 'C', 'D'};

void menu(){
    system("clear");

    //defineOrdemExibicaoConjuntos();
    printf("Menu (m)\n");
    printf("Digite diretamente os números para serem inseridos no conjunto atual.\n");
    printf("Operação: \n");
    printf("f: fim\n");
    printf("u: %c union %c -> %c\n", conjuntosExibidos[0], conjuntosExibidos[1], conjuntosExibidos[2]);
    printf("Defina o primeiro (current) set: A..Z \n");
    printf("cojunto atual: %c\n", conjuntoAtual);
    printf("\nCojuntos:\n");
    int tamanho = sizeof(conjuntosExibidos)/sizeof(char);
    /*
    for (int i=0;i<tamanho;i++){
        setsPrint(conjuntosExibidos[i], imprime); // imprimir o conjunto
    }
    */
    printf("\n\n");
}

void inputUsuario(){
    char ch;
    char strDoNumero[100];
    int algarismo;//não tenho certezo do que seja isso

    setsCreate();

    while(TRUE){
        char cA=conjuntosExibidos[0], cB=conjuntosExibidos[1], cC=conjuntosExibidos[2];
    }

}

int main()
{
    menu();
    inputUsuario();
    return 0;
}



