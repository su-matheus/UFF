#include <stdio.h>
#include <stdlib.h>

int main(){
    float total = 0.0;
    int mes = 0;
    float depositoMensal = 600.0;//guarde meio salario minimo todo mes
    float juros = 0.003;// apenas 0,3% de juros mensal
    // atualmente a taxa está em 1% dependendo da aplicacao
    float objetivo = 1000000.0;
    // observe em quantos anos você terá um milhao
    // Entenda que um milhao aplicado rende hoje (out2023)
    //  dez mil reais por mes, sem alterar seu um milhao
    float depositos=0.0;
    while (total < objetivo){
        total = total + total*juros + depositoMensal;
        depositos += depositoMensal;
        mes++;
        if (mes%12 == 0) // a cada ano aumento 5% os depositos mensais
            depositoMensal = depositoMensal*1.05;
    }
    printf("Terei %7.2f apos %5.1f anos\n", total, mes/12.0);
    printf("Depositos feitos %7.2f; No ultimo mes investi %7.2f\n", depositos, depositoMensal);
    return 0;
}
