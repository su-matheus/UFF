#Escreva um programa que receba três números. O programa deve imprimir a palavra “soma” se a soma de dois deles for igual ao outro número, caso contrário, o programa deve imprimir a palavra “multi” se a multiplicação de dois deles for igual ao outro número. Caso nenhuma das duas possibilidades for verdade, então imprimir a palavra “par” se a soma dos três números for par, e imprimir a palavra “ímpar” caso contrário.  
#ENTRADA: três números inteiros SAIDA: palavra (soma,multi, par ou ímpar) equivalente a resposta

n1=int(input())
n2=int(input())
n3=int(input())

if n1+n2==n3 or n2+n1==n3 or n2+n3==n1 or n3+n2==n1 or n1+n3==n2 or n3+n1==n2:
    print("soma")
else:
    if n1*n2==n3 or n2*n1==n3 or n2*n3==n1 or n3*n2==n1 or n1*n3==n2 or n3*n1==n2:
        print("multi")
    elif ((n1+n2+n3)%2==0):
        print("par")
    else:
        print("ímpar")

#FUNCIONANDO 100 PORCENTO