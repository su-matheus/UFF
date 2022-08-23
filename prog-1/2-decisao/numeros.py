#Escreva um programa que recebe três números e retorna a soma deles, porém se houver números repetidos o valor deles não é contabilizado. 
#ENTRADA: três números inteiros 
#SAIDA: um número inteiro representando a soma de números não repetidos

n1=int(input())
n2=int(input())
n3=int(input())

if n1!=n2 and n2!=n3 and n3!=n1:
    print(n1+n2+n3)
else:
    if n1==n2:
        print(n1-n2+n3)
    elif n2==n3:
        print(n2-n3+n1) 
    elif n3==n1:
        print(n3-n1+n2) 

#NÃO ESTÁ 100 PORCENTO CORRETO