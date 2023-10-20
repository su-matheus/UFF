
#include "Pilha.h"

int count;
Node *last;
//Node prev;


Logico stCreate(){
    count = 0;
    last = NULL;
    return TRUE;
}

Logico stDestroy(){
    while(last != NULL){
        /*
        Node *aux = last;
        last = aux->next;
        free(aux);
        */
        stOut(Tipo *e)
    }
    count = 0;
    last = NULL;
    return TRUE;
}

Logico stIn(Tipo e){
    if (pIsEmpty()){
        last = (Node*)malloc(sizeof(Node));
        last->element = e;
        last->next = NULL;
        count = 1;
        return TRUE;
    }
    count++;
    Node *newNode = (Node*) malloc(sizeof(Node));
    newNode->element = e;
    newNode->next = NULL;
    last->next = newNode;
    last = newNode;
    return TRUE;
}

Logico stOut(Tipo *e){
    if (qIsEmpty()){
        return FALSE;
    }

    *e = last->element;
    Node *removedNode = last;
    last = last->next;
    free(removedNode);
    count--;
    if (count == 0){
        last = NULL;
    }
    return TRUE;
}

Logico stIsEmpty(){
    if (count == 0){
        return TRUE;
    }
    return FALSE;
}

Logico stSize(int total){
    total = count;
    return TRUE;
}



