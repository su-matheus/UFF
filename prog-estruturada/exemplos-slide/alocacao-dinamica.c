#include <stdio.h>

int main(void){
    int n;
    scanf("%d", &n);

    if(n <= 0) return 0;
    
    float vet[n], media = 0.0;
    
    for(int i = 0; i < n; i++)
        scanf("%f", &vet[i]); //&vet[i] = (vet + i)
    
    for(int i = 0; i < n; i++)
        media += vet[i]; //vet[i] = *(vet + i)
    media /= n;
    printf("media = %f\n", media);
    return 0;
}