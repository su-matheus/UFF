#include <stdio.h>

int main (void) {
    int continuar = 1;
    char operacao;
    float a, b, resposta;

    do{
        printf("Digite a operação! \n");
        printf("(+)-Somar\n");
        printf("(-)-Subtrair\n");
        printf("(*)-Multiplicar\n");
        printf("(/)-Dividir\n");
        printf("(x)-Sair\n");

        scanf("%c", &operacao);

        if (operacao!="x") {
            printf("Digite dois números!\n");
            scanf("%f%f", &a, &b);

            switch (operacao) {
            case'+': resposta = a+b; break;
            case'-': resposta = a-b;break;
            case'*': resposta = a*b;break;
            case'/': resposta = a/b;break;
            default: break;
            }
            printf("%5.2f %c %5.2f = %5.2f\n", a, operacao, b, resposta);
        }

        else{
            continuar = 0;
        }

    }
    while (continuar);

    return 0;
}