#include <stdio.h>

void troca(int *a, int *b);

int main (void) {
    int a = 5, b = 3;
    printf("a=%d b=%d\n", a, b);
    troca(&a, &b);
    printf("a=%d b=%d\n", a, b);
}

void troca(int *a, int *b) {
    int temp = *b;
    *b = *a;
    *a = temp;
}

/*
Não foi possível criar uma função para a troca de valores sem usar ponteiros.
É preciso usar ponteiro nas funções que eu criar porque os valores alterados dentro da minha função não são exportados para fora da função. Ele só é exportado quando eu utilizo o ponteiro para o endereço de memória da variável que vem de fora da minha função e depois jogo os resultados obtidos da minha função para o endereço de memória da variável que vem de fora da minha função.
*/