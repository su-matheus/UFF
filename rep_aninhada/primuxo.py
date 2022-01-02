#Faça um programa que receba dois inteiros A e B e imprima todos os números PRIMUXOS entre os números A e B (incluindo A e B). Um número é primuxo se ele for primo e a soma de seus dígitos é um número par. Ex: 31 é um número primuxo já que é primo e 3+1=4 é par
#ENTRADA: números inteiros A e B onde 100<= A <= B <= 999 (Pode acreditar, veja que assim todos os números analisados tem necessariamente 3 dígitos) SAIDA: número(s) (inteiros), um por linha, indicando os números primuxos

a=int(input())
b=int(input())


for i in range(a,b+1):
    p=0
    for y in range(2,i):
        if i%y==0:
            p=p+1
    if p==0 and i!=1:
        for z in range(i):
            s1=(sum(int(i) for i in str(i)))
            s2=(sum(int(i) for i in str(i)))
        if (s1%2==0) and (s2%2==0):
            print(i)

#EXERCÍCIO ENTREGUE COM 100 PORCENTO DE ACERTO