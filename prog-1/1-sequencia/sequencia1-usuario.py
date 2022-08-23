#Faça um programa que leia o nome, a idade, a altura, o peso e a nacionalidade do  usuário e escreva essas informações na forma de uma frase de apresentação. 
#ENTRADA: três números: idade (inteiro), altura (real) e peso (real); e um texto representando a nacionalidade


nome=str(input())
idade=int(input())
altura=float(input())
peso=float(input())
nacionalidade=str(input())

print(nome)
print(idade,"anos")
print("%.2f"%altura,"de altura")
print("%.2f"%peso,"quilos")
print(nacionalidade)
