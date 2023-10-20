#include "Fila.h"


int main() {
    //char alunos[][10] = {"ana", "bia", "edu"};
    Tipo alunos[] = {"ana", "bia", "carla", "duda", "edu"};

    queueCreate();
    int tamanho = sizeof(alunos)/sizeof(Tipo);
    for (int i=0; i<tamanho; i++){
        if (queueIn(alunos[i]) == FALSE){
            printf("tento colocar %s\n", alunos[i].nome);
            //printf("fila esta cheia!\n");
        }
    }


    while(queueIsEmpty() == FALSE){
        Tipo aux;
        queueOut(&aux);
        printf("saiu %s\n", aux.nome);
    }
    queueDestroy();

    return 0;
}
