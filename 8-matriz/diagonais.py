#Faça um programa que leia uma matriz NxN de inteiros, troque os elementos da diagonal principal e da diagonal secundária, e inverta os elementos da primeira linha. Depois imprima a matriz.
#ENTRADA: inteiro N>=2 (pode acreditar) seguidos por N*N inteiros que irão compor a matriz (primeiros N elementos são a primeira linha, os próximos N elementos são a segunda, ...)
#SAIDA: matriz de inteiros transformada (formato padrão do python)

N=int(input())
matriz=[]

for i in range(N):
    linha=[]
    for j in range(N):
        linha.append(int(input()))
    matriz.append(linha)

diagonalPrincipal=[]

for i in range(N):
    matriz[i][i] , matriz[i][N-i-1] = matriz[i][N-i-1] , matriz[i][i]
for i in range(N//2):
    matriz[0][i] , matriz[0][N-i-1]= matriz[0][N-i-1] , matriz[0][i]

print(matriz)