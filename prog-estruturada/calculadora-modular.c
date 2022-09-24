#include <stdio.h>


void imprimir_menu() {
    printf("Digite a operação! \n");
    printf("(+)-Somar\n");
    printf("(-)-Subtrair\n");
    printf("(*)-Multiplicar\n");
    printf("(/)-Dividir\n");
    printf("(x)-Sair\n");
}

float calcular_resultado(float a, float b, char operacao) {
    float resposta;
    switch (operacao) {
        case'+': resposta = a+b; break;
        case'-': resposta = a-b;break;
        case'*': resposta = a*b;break;
        case'/': resposta = a/b;break;
        default: break;
        }
    return resposta;
}

int main (void){
    int continuar = 1;
    char operacao;
    float a, b, resposta;

    do {
        imprimir_menu();
        scanf("%c", &operacao);
        if (operacao!="x") {
            printf("Digite dois números!\n");
            scanf("%f%f", &a, &b);
            resposta = calcular_resultado(a, b, operacao);
            printf("%.2f %c %.2f = %.2f \n", a, operacao, b, resposta);
        }
        else {
            continuar = 0;
        }
    }

    while (continuar == 1);
        
    return 0;
}

/*
Criei as funções depois da função main() e as declarei antes mesmo da função main(), porém não funcionou.
Primeiro tenho que criar as funções antes da main(), e depois chamar as funções que eu criei dentro da main()
*/