#include <stdio.h>

void printVetor(int *vetor, int n) {
    for(int i =0; i<n; i++){
        printf("%2d ", vetor[i]);
    }
}

void printLinha() {
    printf("\n------------------------------------------------\n");
}

int particiona(int *vetor, int inicio, int final) {
    int esq, dir, pivo, temp;
    esq = inicio;
    dir = final;
    pivo = vetor[inicio];

    while(esq < dir) {
        while(esq <= final && vetor[esq] <= pivo){
            esq++;//a posição da esquerda irá aumentar pq esse é o caso de quando o valor da esq já é menor que o pivô, então não precisa alterar e será analisado o próx valor. Na primeira vez que entra nesse while, a função será sempre verdadeira, pois sempre o index da esquerda será menor que o último index e o vetor[esq] sempre será o pivô
        }
        while(dir >= 0 && vetor[dir] > pivo) {
            dir--;//a posição da direita irá diminuir pq esse é o caso de quando o valor da dir já é maior que o pivô, então não precisa alterar e será a analisado o próx valor
        }

        if(esq < dir) {
            temp = vetor[dir];
            vetor[dir] = vetor[esq];
            vetor[esq] = temp;//quando a posição da esq for maior que a da dir então realizar-se-á a troca. Também serve para não alterar nada quando os valores já estiverem ordenados. Logo tudo será falso e não entrará em nenhum loop.
        }
    }

    vetor[inicio] = vetor[dir];
    vetor[dir] = pivo;
    return dir;
}

void quickSort(int *vetor, int inicio, int fim) {
    int pivo;
    if(fim > inicio) {
        pivo = particiona(vetor, inicio, fim);
        quickSort(vetor, inicio, pivo-1);//usado para ordenar a primeira metade do vetor e é executada varias vezes. Primeiro entra nesse quicksort para dividir o "array principal" e depois é executada recursivamente essa função para dividir a primeira metade da primeira metade do "array principal" e assim sucessivamente até ordenar totalmente a primeira metade do "array principal"
        quickSort(vetor, pivo+1, fim);//Esse quicksort é para ordenar a segunda metade do "array principal" e para ordenar a segunda metade ocorre o mesmo que aconteceu na primeira metade, onde é realizada diversas recursividades para ordenar o "array secundário" e o array desse "array secundário" e assim por diante. Quando terminar todas as funções recursivas desse "array secundário", a "função principal" desse quicksort onde ordena todos os valores do vetor é finalizado já contendo todos os valores ordenados.

        //Quando o "array secundário" terminar, todas as funções recursivas retornarão até "função principal" pois em cada função recursiva chamada, o valor da esquerda será maior que o valor da direita no final daquela função recursiva, e assim, cada função recursiva retorna para a "função principal" pois irá retorna como falsa a condição fim > inicio.
    }
}


int main() {
    int vetor[4] = {-8,90,54,21};
    int n = 4;

    printf("Sem ordenar\n");
    printVetor(vetor,n);
    printLinha();

    quickSort(vetor,0,n-1);
    printf("Ordenado\n");
    printVetor(vetor,n);

}

/*
* No método quicksort é realizado o método dividir para conquistar, onde primeiro divide o vetor e dentro dessa divisão ocorre a ordenação. Essa divisão e ordenação ocorre diversas vezes de forma recursiva.
* Em seu melhor caso, a performance desse código é O(n log n)
* Em seu pior caso, a performance é O(n^2)
*/