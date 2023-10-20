#include "listaQueRoda.h"


int main() {

    system("clear");
    printf("Menu:\n");
    printf("digite c(cadastro) f(fim) \n");
    printf("d(delete)  \n");
    printf("ou setas dir e esq\n");
    printf("\nLista Circular:\n");
    clPrint();


    char input;

    while (TRUE){
        input = getchar();
        if (input == "c"){
            Tipo element;
            printf("Digite um nome: ");
            scanf("%s", &(element.nome));
            clInsert(element);
        } else if (input == "f"){
            break;
        } else if (input == 26){//right arrow
            //lcNext();
            //codigoTecla = 0;
        } else if (input == 27){//left arrow
            //lcPrevious();
            //codigoTecla = 0;
        }
    }

    return 0;
}
