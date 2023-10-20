#include <stdio.h>

void swap(int *a, int *b) {
    int aux = *a;
    *a = *b;
    *b = aux;
};

void printArray(int array[], int size) {
    for (int i=0; i<=size; i++){
        printf("%d ", array[i]);
    }
    printf("\n");
}


int orderArray(int array[], int size, int half) {
    int i, j, k= 0;
    int aux1, aux2 = 0;

    int firstHalf = half;
    int secondHalf = size - half;

    int leftArray[firstHalf], rightArray[secondHalf];

    for (i=0; i<firstHalf; i++){
        leftArray[i] = array[i];
    }

    for (i=0; i<=secondHalf; i++) {
        rightArray[i] = array[secondHalf+i-1];
    }    

    for (j=0; j<=firstHalf; j++) {
        for (k=0; k<firstHalf-1; k++) {

            if (leftArray[k] >= leftArray[k+1]) {
                swap(&leftArray[k], &leftArray[k+1]);
            }
        }
    }
    printArray(leftArray, firstHalf - 1);

    for (int l=0; l< secondHalf; l++) {
        for (int m=0; m<secondHalf-1; m++) {
            if (rightArray[m] > rightArray[m+1]) {
                swap(&rightArray[m], &rightArray[m+1]);
            }
        }
    }
    printArray(rightArray, secondHalf - 1);

};


int main () {
    
    int array[]= {22,1,56,3,554,787,33,7865,24,45,65578,90,42,2};
    int arraySize = sizeof(array) / sizeof(array[0]);
    int halfArray = arraySize/2;

    orderArray(array, arraySize, halfArray);

    return 0;
}