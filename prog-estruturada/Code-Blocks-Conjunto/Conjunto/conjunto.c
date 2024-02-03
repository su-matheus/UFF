#include "conjunto.h"

typedef struct node {
    Tipo e;
    struct node *next;
} Node;

#define MAX_SETS ('Z'-'A'+1)
Node * vetListas[MAX_SETS]; // as listas correspondem às 26 letras do alfabeto
// cada lista manterá os elementos em ordem (alfabética, numérica etc) para
// facilitar a pesquisa

Result comparador(Tipo e1, Tipo e2){
    if(e1 > e2) return GT;
    if(e1 < e2) return LT;
    return EQUAL;
}


int mapa(char c){
    if (c >= 'A' && c <= 'Z')
        return (int) (c - 'A');
    return -1; // indice invalido
}


Logic setsCreate(){
    for(int i=0;i<MAX_SETS;i++){
        vetListas[i] = NULL;
    }
    return TRUE;
}


Logic setsPrint(char letra, funcaoDeForaQueImprime imprime){
    int ix = mapa(letra);
    if (ix < 0) return FALSE;
    Node *p1;
    p1 = vetListas[ix];

    printf("set(%c)->", letra);
    while (p1 != NULL){
        printf("[");
        Tipo aux = p1->e;
        imprime(aux);// o mundo exterior vai imprimir
        printf("]->");
        p1 = p1->next;
    }
    printf("NULL");
    //imprime(setsNumberOfElements(p1));
    printf("\n");
    return TRUE;
}


Logic setsAddElement(char c1, Tipo e){
    int ix = mapa(c1);
    Node *pInicio = vetListas[ix];

    if (pInicio == NULL){
        Node *aux = (Node *) malloc(sizeof(Node));
        aux->next = NULL;
        aux->e = e;
        vetListas[ix] = aux;
        return TRUE;
    }

    if(setsBelongsTo(c1,e)) return FALSE;

    Node *pAnterior = NULL;

    while (pInicio != NULL){
        Result r = comparador(e, pInicio->e);
        if ( r == LT){
            Node *aux = (Node *) malloc(sizeof(Node));
            //aux->next = NULL;
            aux->e = e;
            if (pAnterior == NULL){
                // primeiro da lista
                //aux->next = vetListas[ix];//proximo recebe NULL, pois era o primeiro do conjunto
                aux->next = pInicio;
                vetListas[ix] = aux;
                return TRUE;
            }
            pAnterior->next = aux;
            aux->next = pInicio;
            return TRUE;
        }
        pAnterior = pInicio;
        pInicio = pInicio->next;
    }
    // se chegou aqui, a lista não era vazia e o elemento é maior que todos que existiam
    Node *aux = (Node *) malloc(sizeof(Node));
    aux->next = NULL;
    aux->e = e;
    pAnterior->next = aux;
    return TRUE;
}


Logic setsNumberOfElements(char conj, int *total){
    int indexConj = mapa(conj);
    //if(indexConj < 0) return FALSE;

    Node *pAux = vetListas[indexConj];
    *total = 0;

    if(pAux == NULL) return FALSE;

    while(pAux != NULL){
        *total ++;
        pAux = pAux->next;
    }
    return TRUE;
}


Logic setsBelongsTo(char conj, Tipo e){
    int indexConj = mapa(conj);
    Node *pAux = vetListas[indexConj];

    if (pAux == NULL) return FALSE;

    /*
    while(pAux->e != e){
        pAux = pAux->next;
        if(pAux == NULL) return FALSE;
    }
    return TRUE;
    */
    while(pAux != NULL){
        if (pAux->e == e) return TRUE;
        pAux = pAux->next;
    }
    return FALSE;
}


//NÃO SEI SE FUNCIONA
Logic setsRemoveElement(char conj, Tipo *e){
    int indexConj = mapa(conj);
    Node *pInicio = vetListas[indexConj];
    Tipo *elem = *e;

    if(pInicio == NULL) return FALSE;

    if(setsBelongsTo(conj, elem)){
        Node *elemRemovido = elem;
        pInicio = elemRemovido->next;
        free(elemRemovido);
        return TRUE;
    }
    return FALSE;
}


Logic setsFreeSet(char conj){
    int indexConj = mapa(conj);
    if (indexConj < 0) return FALSE;

    Node *pAux = vetListas[indexConj];
    if (pAux == NULL) return FALSE;

    while(pAux != NULL){
        Node *nohRemovido = pAux;
        pAux = nohRemovido->next;
        free(nohRemovido);
    }
    vetListas[indexConj] = NULL;
    return TRUE;
}


Logic setsUnion(char conj1, char conj2, char conj3){
    int indexConj1 = mapa(conj1);
    int indexConj2 = mapa(conj2);
    int indexConj3 = mapa(conj3);

    if (indexConj1 < 0 || indexConj2 < 0 || indexConj3 < 0) return FALSE;

    Node *pConj1 = vetListas[indexConj1];
    Node *pConj2 = vetListas[indexConj2];

    while(pConj1 != NULL && pConj2 != NULL){
        Tipo elem1 = pConj1->e;
        Tipo elem2 = pConj2->e;
        //Result resultadoElem = compareTo(elem1, elem2);
        Result resultadoElem = comparador(elem1, elem2);

        if(resultadoElem == GT){
            setsAddElement(conj3, elem2);
            pConj2 = pConj2->next;
        } else if(resultadoElem == LT){
            setsAddElement(conj3, elem1);
            pConj1 = pConj1->next;
        } else {
            setsAddElement(conj3, elem1);
            pConj1 = pConj1->next;
            pConj2 = pConj2->next;
        }
    }
    while(pConj1 != NULL){
        Tipo elem1 = pConj1->e;
        setsAddElement(conj3, elem1);
        pConj1 = pConj1->next;
    }
    while(pConj2 != NULL){
        Tipo elem2 = pConj2->e;
        setsAddElement(conj3, elem2);
        pConj2 = pConj2->next;
    }
    return TRUE;
}


Logic setsIntersection(char conj1, char conj2, char conj3){
    int indexConj1 = mapa(conj1);
    int indexConj2 = mapa(conj2);
    int indexConj3 = mapa(conj3);

    if (indexConj1 < 0 || indexConj2 < 0 || indexConj3 < 0) return FALSE;

    Node *pConj1 = vetListas[indexConj1];
    Node *pConj2 = vetListas[indexConj2];

    setsFreeSet(conj3);
    while(pConj1 != NULL && pConj2 != NULL){
        Tipo elem1 = pConj1->e;
        Tipo elem2 = pConj2->e;
        Result resultadoElem = comparador(elem1, elem2);

        if (resultadoElem == EQUAL){
            setsAddElement(conj3, elem1);
            pConj1 = pConj1->next;
            pConj2 = pConj2->next;
        }
        if (resultadoElem == LT){
            pConj2 = pConj2->next;
            if (pConj2==NULL){
                pConj2 = vetListas[indexConj2];
                pConj1 = pConj1->next;
            }
        }
        if (resultadoElem == GT){
            pConj2 = pConj2->next;
        }
    }
    return TRUE;
}


Logic setsDestroy(){
    char ch = 'A';
    while(ch<='Z'){
        setsFreeSet(ch);
        ch++;
    }
}
<<<<<<< HEAD
=======


>>>>>>> af8d6f978f4892d297fa826ba95bf93b09dd9694

