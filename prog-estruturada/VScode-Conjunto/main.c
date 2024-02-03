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
    if (a < b) return LT;
    if (a == b) return EQUAL;
    return GT;
}


//typedef void (*funcaoDeForaQueImprime)(Tipo);// ponteiro para função
//typedef Result (*funcaoDeForaQueCompara)(Tipo, Tipo);// ponteiro para função

Logic setsPrint(char conj);
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



//------------------------------------------//



typedef struct node {
    Tipo e;
    struct node *prox;
} Node;

#define MAX_CONJUNTOS ('Z'-'A'+1)

Node *vetListas[MAX_CONJUNTOS];
int count;

int mapearConjunto(char c){
    if (c >= 'A' && c <= 'Z')
        return (int) (c - 'A');
    return -1;
}



Logic setsPrint(char conj){
    int indexConj = mapearConjunto(conj);
    if (indexConj < 0) return FALSE;
    Node *p1;
    p1 = vetListas[indexConj];

    printf("set(%c)->", conj);
    while (p1 != NULL){
        printf("[");
        Tipo aux = p1->e;
        //impri(aux);// o mundo exterior vai imprimir
        setsPrint(aux);
        printf("]->");
        p1 = p1->prox;
    }
    printf("NULL\n");
    return TRUE;
}

Logic setsCreate(){
    for(int i=0;i<MAX_CONJUNTOS;i++){
        vetListas[i] = NULL;
    }
    return TRUE;
}

Logic setsNumberOfElements(char c1, int *total){
    int indexConj = mapearConjunto(c1);
    count = 0;
    Node *pAux = vetListas[indexConj];

    while (pAux != NULL){
        count++;
        pAux = pAux->prox;
    }
    return TRUE;
}

Logic setsBelongsTo(char c1, Tipo e){
    int indexConj = mapearConjunto(c1);
    Node *pInicio = vetListas[indexConj];
    if (pInicio == NULL) return FALSE;

    while (pInicio->e != e){
        pInicio = pInicio->prox;
        if (pInicio == NULL) return FALSE;
    }
    if (pInicio->e == e) return TRUE;
}

Logic setsAddElement(char c1, Tipo e){
    int indexConj = mapearConjunto(c1);
    if (indexConj <= 0) return FALSE;
    //if (setsBelongsTo(c1, e)) return FALSE;

    Node *primeiroElemConj = vetListas[indexConj];
    if (primeiroElemConj == NULL){
        Node *aux = (Node *) malloc(sizeof(Node));
        aux->prox = NULL;
        aux->e = e;
        vetListas[indexConj] = aux;
        return TRUE;
    }
    while(primeiroElemConj != NULL){
        if (comparar(e, primeiroElemConj->e) == LT){ //é menor que primeiroElemento??
            Node *aux = (Node*) malloc(sizeof(Node));
            aux = primeiroElemConj;
            primeiroElemConj->e = e;
            primeiroElemConj->prox = aux;
            return TRUE;
        }
        primeiroElemConj = primeiroElemConj->prox;
    }
    Node *novo = (Node*) malloc(sizeof(Node));
    novo->e = e;
    novo->prox = NULL;
    primeiroElemConj->prox = novo;
    return TRUE;
}


//---------------------------------------//



char conjuntoAtual = 'A';
char conjuntosExibidos[]= {'A', 'B', 'C', 'D'};

void menu(){
    system("clear");//linux

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
    for (int i=0;i<tamanho;i++){
        setsPrint(conjuntosExibidos[i]); // imprimir o conjunto
    }
    printf("\n\n");
}

void inputUsuario(){
    char teclaDigitada;
    char strDoNumero[100];
    int algarismo;//não tenho certeza do que seja isso

    setsCreate();
    menu();

    while(TRUE){
        char cA=conjuntosExibidos[0], cB=conjuntosExibidos[1], cC=conjuntosExibidos[2];
        char teclaDigitada = getchar();

        
        
        if (teclaDigitada == 'e'){
            break;
        } else if (((teclaDigitada >= '0') && (teclaDigitada <= '9')) || (teclaDigitada == '.')){
            strDoNumero[algarismo] = teclaDigitada;
            printf("%c foi digitado\n", teclaDigitada);
        } else if (teclaDigitada  == 'm'){
            menu();
        } else if (teclaDigitada == 13){ // enter
            strDoNumero[algarismo] = '\0';// terminador de string
            //Tipo num = strDoNumero - '0';
            Tipo num = atoi(strDoNumero);
            if (num != 0)
                setsAddElement(conjuntoAtual, num);
            algarismo = 0;
            menu();
        } else if (teclaDigitada == 'u'){
            //setsUnion(cA, cB, cC);
            menu();
        } else if (teclaDigitada >= 'A' && teclaDigitada <= 'Z'){
            conjuntoAtual = teclaDigitada;
            menu();
        }
    }

}

int main(){
    inputUsuario();
    return 0;
}



