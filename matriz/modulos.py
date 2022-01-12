#Faça um programa que receba uma matriz NxM de inteiros e some cada um dos “N” elementos de cada uma das “M” colunas pelo menor elemento em módulo daquela coluna. Imprima a matriz modificada
#ENTRADA: inteiros N>=2 e M>=2 (pode acreditar) seguidos por N*M inteiros que irão compor a matriz (primeiros M elementos são a primeira linha, os próximos M elementos são a segunda, ...)
#SAIDA: matriz de inteiros transformada (formato padrão do python)

nLinhas = int(input())
nColunas = int(input())
matriz = []

for i in range(nLinhas):
    linha = []
    for j in range(nColunas):
        matriz.append(linha)
print(matriz)