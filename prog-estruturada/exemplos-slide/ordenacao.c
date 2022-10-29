#include <stdio.h>

void ord_sel_sort(int *vet, int n) {
    for (int i = 0; i < n ; i++) {
        int menor = i;//no primeiro momento, o menor valor é i=0, isso é pode ser alterado enquanto percorre o for com j
        for (int j = i+1; j < n; j++) {
            if (vet[j] < vet[menor]) {
                menor = j;
            }
        }
        if (menor != i) {
            int temp = vet[i];
            vet[i] = vet[menor];
            vet[menor] = temp; //com esse loop colocará o valor de i depois do valor de j, pois i > j. Além disso garantirá que i sempre comece menor que j e somente depois de encontrar algum valor i<j que efetuará essa condição if para novamente transformar o index i menor que o index j.
        }
    }
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

        ord_sel_sort(vet, n);

        for(int i = 0; i < n; i++){
            printf("%d ", vet[i]);
        }

        printf("\n");
    }
return 0;
}