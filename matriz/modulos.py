#Faça um programa que receba uma matriz NxM de inteiros e some cada um dos “N” elementos de cada uma das “M” colunas pelo menor elemento em módulo daquela coluna. Imprima a matriz modificada
#ENTRADA: inteiros N>=2 e M>=2 (pode acreditar) seguidos por N*M inteiros que irão compor a matriz (primeiros M elementos são a primeira linha, os próximos M elementos são a segunda, ...)
#SAIDA: matriz de inteiros transformada (formato padrão do python)

nLinhas = int(input())
nColunas = int(input())
matriz = []

for i in range(nLinhas):
    linha = []
    for j in range(nColunas):
        linha.append(int(input()))
    matriz.append(linha)
#print(matriz)

for i in range(nLinhas):
    soma=0
    for j in range(nColunas):
        menorElemento = matriz[0][i]
        if matriz[i][j] < menorElemento:
            menorElemento = matriz[i][j]
    print(menorElemento)   #IMPRIMIU O VALOR CORRETO DO MENOR EM CADA LINHA
    #if menorElemento < 0:
    #    menorElemento = menorElemento*(-1)
    #soma += matriz[i][j]+menorElemento
    #matriz[i][j]=soma
