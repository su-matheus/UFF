#include <stdio.h>

void ord_sel_sort_rec(int *vet, int n){
    if(n <= 0) return;
    int menor = 0;
    
    for(int j = 1; j < n; j++){
        if(vet[j] < vet[menor])
            menor = j;
        if(menor != 0){
            int temp = vet[0];
            vet[0] = vet[menor];
            vet[menor] = temp;
        }
    }
        
    ord_sel_sort_rec(&vet[1], --n);
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