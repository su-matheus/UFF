#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct aluno {
    char nome[80];
    int matricula;
    float notas[2];
} Aluno;

typedef Aluno Tipo;

void swap(Tipo *a, Tipo *b) {
    Tipo aux = *a;
    *a = *b;
    *b = aux;
};

#define LESSTHAN -1
#define GREATERTHAN 1
#define EQUAL 0

int compare(Tipo x, Tipo y){
    if (strcmp(x.nome, y.nome)>0) return GREATERTHAN;
    if (strcmp(x.nome, y.nome)<0) return LESSTHAN;
    return EQUAL;
}

void mergeArray(Tipo *array, int left, int mid, int right){
    int sizeLeft = mid - left + 1;
    int sizeRigth = right - mid;

    Tipo leftArray[sizeLeft];
    Tipo rightArray[sizeRigth];

    for (int i=0;i<sizeLeft;i++){
        leftArray[i] = array[left+i];
    }

    for (int i=0;i<sizeRigth;i++){
        rightArray[i] = array[mid+1+i];
    }

    int l,r = 0;
    int j = left;

    while (l < sizeLeft && r < sizeRigth){
        if (compare(leftArray[l],rightArray[r]) == LESSTHAN){
            //swap(leftArray[l], rightArray[r]);
            array[j] = leftArray[l];
            l++;
        } else {
            array[j] = rightArray[r];
            r++;
        }
        j++;
    }

    //if still values on left
    while (l < sizeLeft) {
        array[j] = leftArray[l];
        l++;
        j++;
    }

    //if still values on right
    while (r < sizeRigth) {
        array[j] = rightArray[r];
        r++;
        j++;
    }
}

void mergeSort(Tipo *array, int left, int right){
    if (left<right){
        int mid = left + (right-left)/2;

        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        mergeArray(array,left, mid, right);

    }
}

int main()
{
    Tipo vet[] = {
        {"Juliana", 100, {8,9}},
        {"Ze", 101, {7,9}},
        {"Ana", 201, {8,10}},
        {"Bia", 202, {10,9}},
        {"Edu", 402, {7,9}},
        {"Joao", 302, {7,9}},
        {"Zulmira", 802, {7,9}},
        {"Pedro", 702, {9,9}}
    } ;
    int sizeArray = sizeof(vet)/sizeof(Tipo);

    mergeSort(vet, 0, sizeArray-1);

    for (int i=0;i<sizeArray;i++){
        printf("%s \n", vet[i].nome);
    }

    /*
    for (int i=0;i<sizeArray-1;i++){
        mergeSort(vet[i], vet[i+1]);
    }

    for (int i=0;i<sizeArray;i++){
        printf("0:%s \n", vet[i].nome);
    }
    */

    return 0;
}
