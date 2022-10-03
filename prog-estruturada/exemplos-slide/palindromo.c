#include <stdio.h>

void imprimir_vetor(int *vetor, int tam) {
    for (int i = 0; i < tam; i++){
        printf("%d ", vetor[i]);
    }
}

int verificar_palindromo(int *vetor, int tam) {
    /*
    if (tam < 2) {
        return 1;
    }
    else {
        return (vetor[0]==vetor[tam-1] && (verificar_palindromo(vetor+1, tam-2)));
    }
    */
   do{
    return (vetor[0]==vetor[tam-1]) && verificar_palindromo(vetor+1, tam-2);
   }
   while(tam > 1);
   if (tam == 1) {
    char mensagem = "É palindromo";
    return mensagem;
   }
   
}

int main(void) {
    int vetor[9] = {3,4,5,6,7,6,5,4,3};
    int tam = 9;

    imprimir_vetor(vetor, tam);
    verificar_palindromo(vetor, tam);
}