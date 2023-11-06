#include "conjunto.h"

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



