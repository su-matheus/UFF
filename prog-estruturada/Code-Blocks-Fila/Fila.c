
#include "Fila.h"

#define MAX 4
Tipo vetorFila[MAX];
int posicao;
int front;
int count;


Logico queueCreate(){
    posicao = -1;
    front = 0;
    count = 0;
    return TRUE;
}// criação ou construção

Logico queueDestroy(){
    posicao = -1;
    front = 0;
    count = 0;
    return TRUE;
}// destruição

Logico queueIsFull(){
    if (count == MAX)
        return TRUE;
    return FALSE;
}// para saber se a pilha esta ou nao cheia

Logico queueIsEmpty(){
    if (count == 0)
        return TRUE;
    return FALSE;
}// para saber se a pilha está ou nao vazia

Logico queueIn(Tipo e){
    if (queueIsFull()) {
        printf("Fila está cheia\n");
        return FALSE;
    } else {
        if (posicao == -1) {
            front = 0;
            count = 1;
            posicao++;
            vetorFila[posicao] = e;
            return TRUE;
        }
        count++;
        posicao++;
        //posicao = (posicao+1) % MAX; isso é o método wrap around para achar a última posição possível
        vetorFila[posicao] = e;
        return TRUE;
    }
} // operação para colocar coisas na pilha

Logico queueOut(Tipo *e){
    if (queueIsEmpty())
        return FALSE;
    *e = vetorFila[front];
    front++;
    //front = (front+1)%MAX; wrap around para achar a primeira posição possível
    count--;
    return TRUE;
} // operação para retirar coisas da pilha

Logico queueSize(int *total) {
    //int tamanho = posicao - front;
    *total = count;
    return TRUE;
}
