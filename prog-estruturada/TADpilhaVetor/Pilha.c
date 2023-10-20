#include "Pilha.h"

#define MAX 4
Tipo vetorPilha[MAX];
int posicao;


Logico stCreate(){
    posicao = -1;
    return TRUE;
}// criação ou construção

Logico stDestroy(){
    posicao = -1;
    return TRUE;
}// destruição

Logico stIsFull(){
    if (posicao >= (MAX-1))
        return TRUE;
    return FALSE;
}// para saber se a pilha esta ou nao cheia

Logico stIsEmpty(){
    if (posicao < 0)
        return TRUE;
    return FALSE;
}// para saber se a pilha está ou nao vazia

Logico stPush(Tipo e){
    if (stIsFull() == TRUE)
        return FALSE;
    posicao++;
    vetorPilha[posicao] = e;
    return TRUE;
} // operação para colocar coisas na pilha

Logico stPop(Tipo *e){
    if (stIsEmpty() == TRUE)
        return FALSE;
    *e = vetorPilha[posicao];
    posicao--;
    return TRUE;
} // operação para retirar coisas da pilha
