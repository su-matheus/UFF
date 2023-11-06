#include "conjunto.h"

char conjuntoAtual = 'A';
char conjuntosExibidos[]= {'A', 'B', 'C', 'D'};

void menu(){
    system("clear");

    //defineOrdemExibicaoConjuntos();
    printf("Menu (m)\n");
    printf("Digite diretamente os números para serem inseridos no conjunto atual.\n");
    printf("Operação: \n");
    printf("f: fim\n");
    printf("u: %c union %c -> %c\n", conjuntosExibidos[0], conjuntosExibidos[1], conjuntosExibidos[2]);
    printf("Defina o primeiro (current) set: A..Z \n");
    printf("cojunto atual: %c\n", conjuntoAtual);
    printf("\nCojuntos:\n");
    int tamanho = sizeof(conjuntosExibidos)/sizeof(char);
    /*
    for (int i=0;i<tamanho;i++){
        setsPrint(conjuntosExibidos[i], imprime); // imprimir o conjunto
    }
    */
    printf("\n\n");
}

void inputUsuario(){
    char ch;
    char strDoNumero[100];
    int algarismo;//não tenho certezo do que seja isso

    setsCreate();

    while(TRUE){
        char cA=conjuntosExibidos[0], cB=conjuntosExibidos[1], cC=conjuntosExibidos[2];
    }

}

int main()
{

    menu();
    inputUsuario();
    return 0;
}



