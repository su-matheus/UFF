#include "listaQueRoda.h"

/*
typedef struct node {
    Tipo element;
    node *next;
    node *prev;
} Node;
*/

Node *current;
int count;
Logic recordedFile;

char fileName[] = {"minhaLista.bin"};

void saveFile(char *fileName){
    FILE *file;
    file = fopen(fileName, "wb"); //escrever em binário
    Node *writeThisInFile = current;
    writeThisInFile

    do {

    } while ()

    if (count <= 0){
        remove(fileName);
        return;
    }

    fclose(file)
}


Logic clCreate(){
    current = NULL;
    count = 0;
    recordedFile = FALSE;
    return TRUE;
}


Logic clPrint(){
    Node *currentPrint;
    currentPrint = current;

    if (fileName == NULL) {
        printf("Error opening file.\n");
        return;
    }

    printf("(%i)current->", count);
    if (current == NULL){
        printf("NULL");
        return;
    }

    while (currentPrint != NULL){
        printf("[ ");
        fscanf(fileName, "%c");
        printf(" ]->");
        currentPrint = currentPrint->next;
    }
    fclose(fileName);
    return TRUE;
}


Logic clInsert(Tipo e){
    if (count == 0 && current == NULL) {
        current = (Node*)malloc(sizeof(Node));
        current->element = e;
        current->next = current->prev = current;
        count = 1;
        return TRUE;
    }
    Node *newNode = (Node*)malloc(sizeof(Node));
    Node *prevAux = current;
    Node *nextAux= current->next;
    newNode->element = e;
    newNode->next = nextAux;
    newNode->prev = prevAux;
    nextAux->prev = newNode;
    prevAux->next = newNode;
    current = newNode;
    count++;
    return TRUE;
}







