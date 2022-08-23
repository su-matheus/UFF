#Faça um programa que calcula os primeiros X números da Santa série de Seiya (X inteiro positivo fornecido pelo usuário). A série santificada de Seiya inicia com os números 1 e 2, e cada número posterior equivale à multiplicação dos dois números anteriores, mais 1. Por exemplo, caso o usuário informe X=6, o resultado seria: 1, 2, 3, 7, 22, 155. No final, receba mais um inteiro R para informar se o usuário quer repetir o processo (onde R será 1-sim, 2-não).
#ENTRADA: um número par de inteiros indicando o número de elementos da série impressos(X>=1) e o inteiro indicando se o processo será repetido (R=1 ou R=2)
# SAIDA: número(s) (inteiros), um por linha, indicando a(s) saída(s) da(s) série(s).

R=1
while R==1:
    X=int(input())
    a,b=1,2
    for i in range(1,X+1):
        if i==1:
            print("1")
        if i==2:
            print("2")
        if i>2:
            c=(a*b)+1
            a=b
            b=c
            print(b)
    R=int(input())

#EXERCÍCIO ENTREGUE COM 100 PORCENTO DE ACERTO