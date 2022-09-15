#include <stdio.h>

int fat (int numero) {
    int fatorial = 1;

    for (int i = 1; i<=numero; i++){
        fatorial *= i;
    }

    return fatorial;
}

int main(void) {
    int numero, resultado;
    printf("Digite um número não negativo: \n");
    scanf("%d", &numero);
    resultado = fat(numero);
    printf("Fatorial de %d é %d. \n", numero, resultado);

    return 0;
}