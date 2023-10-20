#include <stdio.h>
#include <stdlib.h>

int main(){
    char letra = 'A';
    int numero = 112;

    int * pnumero;

    pnumero = &numero;
    char pletra = &letra;

    printf("conteúdo de pnumero é: %i\n", *pnumero);
    printf("endereço de pnumero é: %p\n", pnumero);
    printf("endereço de pnumero muda de endereço?? %p\n", pnumero);
    printf("endereço de pnumero com asterístico é: %p\n", *pnumero);
    printf("conteúdo de pletra é: %c\n", pletra);

    printf("----------------------------------\n");

    char nome;
    printf("Qual a primeira letra do seu nome?\n");
    scanf("%c", &nome);
    printf("letra: %c\n", nome);
    printf("endereço de letra é: %p\n", nome);

    return 0;
}

//Quando eu quero o conteúdo de um ponteiro eu uso na porcentagem o tipo que o ponteiro está representando e depois passo na função printf o ponteiro da variável (com o asterístico).
//Quando eu quero o endereço da variável (acho difícil acontecer isso) eu uso %p e não passo para a função printf o ponteiro da variável (com o asterístico), passo somente a variável.
