#include<stdio.h>

int main(){
    int v[10] = {1,2,3,4,5,6,7,8,9,10};
    int *v_pt = v+2; //isso quer dizer v[0+2]
    int a = 10;
    int *b = &a;
    int *c = b;
    int **d = &b; //creio que d tenha ponteiro duplo pois recebe um ponteiro que já recebe outro ponteiro
    int *e = v+9;
    *b = 3;
    *c = *b + **d;
    *e = *(v+7)+v_pt[3]; //v da posição 7 somado com v_pt da posição 3. Ou seja, 8+6


    printf("a = %d\n",a);
    printf("*b = %d\n",*b);
    printf("*c = %d\n",*c);
    printf("**d = %d\n",**d);
    printf("*e = %d\n", *e);


    printf("v = [ ");
    for (int i=0;i<10;i++){
        printf("%d ",v[i]);
    }
    printf("]\n");


    printf("v_pt = [ ");
    for (int i=0;i<7;i++){
        printf("%d ",v_pt[i]); //v_pt[0] é 3 pois *v_pt = v+2. Ou seja, v_pt começa em 3
    }
    printf("]\n");

}

/*
Sem executar o código abaixo no computador, simule a execução manualmente e especifique o resultado das impressões dos valores das variáveis.

Qual a relação entre arrays e ponteiros em C?
*/