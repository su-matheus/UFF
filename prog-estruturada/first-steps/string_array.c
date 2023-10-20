#include <stdio.h>

int main() {
    char badCharArray[3][15] = {"array", "outro array", "nome"};
    printf("Primeiro é o método ruim do array de string\n");

    for (int i=0; i<3; i++){
        printf("%s\n", badCharArray[i]);
    }

    printf("\nIsso é um bom array de strings\n");
    char *goodCharArray[] = {"Array", "muito", "bom"};
    
    for (int i=0; i<3; i++){
        printf("%s\n", goodCharArray[i]);
    }

    return 0;
}

/*
    Em C, um array de string é um vetor de 2 dimensões e por isso para percorrer cada elemento desse array é necessário dois loops "for". Esse método também é ruim porque não permite alterar esse array.

    Para criar um array de strings de forma mais eficiente é possível criar um ponteiro para esse array de strings, assim é possível criar um array unidimensional.
*/