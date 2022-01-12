#Faça um programa que recebe como parâmetro uma matriz NxN de números inteiros. Esse programa deve informar:- a soma dos elementos acima da diagonal principal- o número de células da matriz que têm valor menor que a média dos valores das células da matriz,
#ENTRADA: inteiro N>=2 (pode acreditar) seguidos por N*N inteiros que irão compor a matriz (primeiros N elementos são a primeira linha, os próximos N elementos são a segunda, ...)
#SAIDA: dois números inteiros representando a soma dos elementos acima da diagonal principal e o número de células da matriz que têm valor menor que a média dos valores das células da matriz.

N=int(input())
matriz=[]

for i in range(N):
    linha=[]
    for j in range(N):
        linha.append(int(input()))
    matriz.append(linha)

média=0

for i in range(N-1):
    #diagonalPrincipal = matriz[i][i]
    soma=0
    soma=soma+matriz[i][N-i-1]
print(soma)