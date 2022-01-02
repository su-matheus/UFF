#Faça um programa que irá somar a média de X alunos. O programa recebe primeiro um número X de alunos, e para cada um desses alunos, irá receber 2 notas, onde a média dessas duas notas será somada (para cada aluno) e apresentada no final a soma das médias dos X alunos.
#ENTRADA: número X (inteiro) de alunos, seguido por 2X notas (reais) representando as notas dos alunos
#SAIDA: número (real com 2 casas decimais) representando a soma das médias

aluno=int(input())
soma=0

while aluno>=2:
    if aluno>=2:
        nota1=float(input())
        nota2=float(input())
        aluno=aluno-1
        media=(nota1+nota2)/2
        soma=soma+media

if aluno==1:
    nota1=float(input())
    nota2=float(input())
    media=(nota1+nota2)/2
    soma=soma+media

print("%.2f"%soma)

#EXERCÍCIO NÃO ENTREGUE, PORÉM FUNCIONANDO 100 PORCENTO NO VSCODE