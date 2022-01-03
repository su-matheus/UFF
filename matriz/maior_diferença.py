#Faça um programa que leia uma matriz NxM de inteiros, descubra o maior elemento da matriz,diminua cada elemento da matriz por este maior elemento, imprima a matriz.
#ENTRADA: inteiros N>=2 e M>=2 (pode acreditar) seguidos por N*M inteiros que irão compor a matriz (primeiros M elementos são a primeira linha, os próximos M elementos são a segunda, ...)
#SAIDA: matriz de inteiros transformada (formato padrão do python)

nLinhas=int(input())
nColunas=int(input())
matriz=[]

for i in range(nLinhas):
    linha=[]
    for j in range(nColunas):
        linha.append(int(input()))
    matriz.append(linha)

maiorElemento=[0][0]

for i in range(nLinhas):
    for j in range(nColunas):
        if matriz[i][j] > maiorElemento:
            maiorElemento = matriz[i][j]

for i in range(nLinhas):
    for j in range(nColunas):
        matriz[i][j] = matriz[i][j] - maiorElemento

print(matriz)

# ENTREGUE COM 66.6 PORCENTO DE ACERTO