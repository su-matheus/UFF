#Faça um programa que receba uma matriz A (NxN) e calcule e escreva a média dos elementos da sua área pintada. A Figura abaixo fornece um exemplo de uma matriz A (12x12) com os elementos a serem somados para a média pintados.Repare que um elemento está pintado se está acima da diagonal principal e da diagonal secundária (ao mesmo tempo), ou se o elemento está abaixo da diagonal secundária e da diagonal principal (ao mesmo tempo).
#ENTRADA: inteiro N>=3 (pode acreditar) seguidos por N*N inteiros que irão compor a matriz (primeiros N elementos são a primeira linha, os próximos N elementos são a segunda, ...)
#SAIDA: número real (2 casas decimais) representando a média dos números pintados

N = int(input())
matriz = []

for i in range(N):
    linha = []
    for j in range(N):
        linha.append(int(input()))
    matriz.append(linha)

limitadorSuperior = 1
limitadorInferior = 1

matrizPintada = []
for i in range(0,N//2):
    for j in range(j+1,N-j-1):
        matrizPintada[i][j] = matriz[i][j]
print(matrizPintada)