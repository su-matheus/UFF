#include <stdio.h>

void ord_sel_sort_rec(int *vet, int n){
    if(n <= 0) return;
    int menor = 0;//por padrão o primeiro elemento do vetor será sempre o menor
    
    for(int j = 1; j < n; j++){
        if(vet[j] < vet[menor])//caso o próx elemento do vetor seja menor que o primeiro elemento
            menor = j;
        if(menor != 0){//quando houver algum elemento menor que o primeiro elemento, se ñ ocorrer é pq já tá ordenado
            int temp = vet[0];
            vet[0] = vet[menor];
            vet[menor] = temp;
        }
    }
        
    ord_sel_sort_rec(&vet[1], --n);//na próx chamada para a função, irá comparar com o próx valor do vetor, ñ entendi a parte do --n, pois vai deixar de comparar a última posição do vetor
}

int main(void){
    while(1){
        int n;
        scanf("%d", &n);
        if(n <= 0) break;
        int vet[n];

        for(int i = 0; i < n; i++){
            scanf("%d", &vet[i]);
        }
        
        ord_sel_sort_rec(vet, n);
        
        for(int i = 0; i < n; i++){
            printf("%d ", vet[i]);
        }

        printf("\n");
}
return 0;
}