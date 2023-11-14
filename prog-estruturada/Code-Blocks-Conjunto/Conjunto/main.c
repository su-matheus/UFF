#include "sets.h"
// TAD de conjuntos


// observe que a função aqui, no mundo da aplicacao
// sabe quem é Tipo e pode fazer a comparacao desejada
// Ex: comparacao de nomes de alunos, de números, de precos de mercadorias etc
Result compareTo(Tipo a, Tipo b){
    if (a > b) return GT;
    if (a == b) return EQUAL;
    return LT;
}

void imprime(Tipo t){
    printf("%i", t); // essa função sabe quem é Tipo, no caso, um inteiro
}


char conjuntoAtual = 'A';
char conjuntosExibidos[]= {'A', 'B', 'C', 'D'};
void defineOrdemExibicaoConjuntos(){
    int tamanho = sizeof(conjuntosExibidos)/sizeof(char);
    int ix = -1;
    for (int i=0;i<tamanho;i++){
        if (conjuntoAtual == conjuntosExibidos[i]){
            ix = i;
            break;
        }
    }
    if (ix==-1){
        for (int i=tamanho-1;i>0;i--){
            // cai de prioridade na lista
            conjuntosExibidos[i]=conjuntosExibidos[i-1];
        }
    } else {
        for (int i=ix;i>=0;i--){
            // cai de prioridade na lista
            conjuntosExibidos[i]=conjuntosExibidos[i-1];
        }
    }
    conjuntosExibidos[0]=conjuntoAtual;
}
void menu(){
    system("cls");
    printf("Menu (m)\n");
    printf("Type int numbers followed by enter to add to current set\n");
    printf("Operations:\ne (end)\nr (remove)\n");
    printf("u (%c union %c into %c)\n", conjuntosExibidos[0],conjuntosExibidos[1],conjuntosExibidos[2]);
    printf("i (%c intersection %c into %c)\nd (destroy all)\nc (clean current set)\n", conjuntosExibidos[0],conjuntosExibidos[1],conjuntosExibidos[2]);
    printf("define first (current) set: A..Z \n");
    printf("current set: %c\n", conjuntoAtual);
    defineOrdemExibicaoConjuntos();
    printf("\nSets:\n");
    int tamanho = sizeof(conjuntosExibidos)/sizeof(char);
    for (int i=0;i<tamanho;i++){
        setsPrint(conjuntosExibidos[i], imprime); // imprimir o conjunto
    }
    printf("\n\n");
}

void conjuntos(){
    char ch;
    char strNumero[100];
    int algarismo=0;

    setsCreate();
    menu();
    while (TRUE){
        ch = getche();
        if (ch == 'e'){
            break;
        } else if (((ch >= '0') && (ch <= '9')) || (ch == '.')){
            strNumero[algarismo++] = ch;
        } else if (ch  == 'm'){
            menu();
        } else if (ch == 13){ // enter
            strNumero[algarismo] = '\0';// terminador de string
            Tipo num = atoi(strNumero);
            //printf("\n%i\n",num);
            if (num != 0)
                setsAddElement(conjuntoAtual, num);
            algarismo = 0;
            menu();
        } else if (ch >= 'A' && ch <= 'Z'){
            conjuntoAtual = ch;
        } else if (ch == 'c'){
            setsFreeSet(conjuntoAtual);
            menu();
        }  else if (ch == 'd'){
            setsDestroy();
            menu();
        } else if (ch == 'u'){
            setsUnion(conjuntosExibidos[0], conjuntosExibidos[1], conjuntosExibidos[2]);
            menu();
        } else if (ch == 'i'){
            setsIntersection(conjuntosExibidos[0], conjuntosExibidos[1], conjuntosExibidos[2]);
            menu();
        }
    }
}

int main(){
    conjuntos();
}


