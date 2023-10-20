
#include "Fila.h"

int count;
Node *first;
Node *last;

Logico qCreate(){
    count = 0;
    first = last = NULL;
    return TRUE;
}

Logico qDestroy(){
    while(first != NULL){
        Node *aux = first;
        first = aux->next;
        free(aux);
    }
    count = 0;
    first = last = NULL;
    return TRUE;
}

Logico qIn(Tipo e){
    if (qIsEmpty()){
        first = last = (Node*)malloc(sizeof(Node));
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

Logico qOut(Tipo *e){
    if (qIsEmpty()){
        return FALSE;
    }
    /*
    Node *aux = first;
    first = aux->next;
    free(aux);
    count--;
    return TRUE;
    */
    *e = first->element;
    Node *removedNode = first;
    first = first->next;
    free(removedNode);
    count--;
    /*if (count == 0){
        first = last = NULL;
    }
    */
    return TRUE;
}

Logico qIsEmpty(){
    if (count == 0){
        return TRUE;
    }
    return FALSE;
}

Logico qSize(int total){
    total = count;
    return TRUE;
}











