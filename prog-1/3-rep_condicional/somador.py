#Faça um programa que receba números inteiros e calcule a soma desses números, até que seja fornecido novamente o primeiro número fornecido desta soma. Neste caso o programa soma novamente este primeiro número, para, e imprime a soma.
#ENTRADA: números inteiros
#SAIDA: número inteiro representando a soma dos números informados

numero=int(input())
continuar=True
soma=0

while continuar:
    n=int(input())
    soma=soma+n
    if numero==n:
        soma=soma+numero
        print(soma)
        break

#EXERCÍCIO NÃO ENTREGUE, PORÉM FUNCIONANDO 100 PORCENTO NO VSCODE