#Faça um programa que leia um número inteiro de 5 dígitos e indique se ele é palíndromo (Um número palíndromo é aquele que se lido da esquerda para a direita ou da direita para a esquerda possui o mesmo valor. 
#ENTRADA: Valor inteiro

num=int(input())

if str(num)==str(num)[::-1]:
    print("sim")
else:
    print("não")