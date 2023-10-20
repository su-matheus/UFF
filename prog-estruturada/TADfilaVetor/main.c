#include "Fila.h"
int main(){
    printf("Teste da Fila!\n");
    Tipo vet[] = {"ana", "bia", "dri", "juli", "edy"};

    /*Aluno vet[] = {
        { "Ana", {8,7,0,0}, 1234567},
        { "Bia", {8,10,0,0}, 1234568},
        { "Dri", {8,10,0,0}, 1234570},
        { "Juli", {8,10,0,0}, 1234571},
        { "Edu", {9,8,0,0}, 1234569}
    };
    */
    qCreate();
    int tamanho = sizeof(vet)/sizeof(Tipo);
    for (int i=0;i<tamanho;i++){
        if (qIn(vet[i]) == FALSE)
            printf("nao consegui colocar %s\n", vet[i].nome);
    }
    while (!qIsEmpty()){
        Tipo e;
        qOut(&e);
        printf("sai %s\n", e.nome);
    }
    qDestroy();
    return 0;
}
