#Receba uma matriz A (NxM) de inteiros e ordene seus elementos de forma que os maiores fiquem na primeira coluna, depois os próximos maiores na segunda coluna e assim por diante (e cada coluna também esteja ordenada).
#ENTRADA: inteiro N,M>=2 (pode acreditar) seguidos por N*M inteiros que irão compor a matriz (primeiros N elementos são a primeira linha, os próximos N elementos são a segunda,...)
#SAIDA: matriz A ordenada (formato padrão do python)

nLinhas=int(input())
nColunas=int(input())
matriz=[]

for i in range(nLinhas):
    linha=[]
    for j in range(nColunas):
        linha.append(int(input()))
    matriz.append(linha)

maiorElemento=matriz[0][0]
for i in range(nLinhas):
    for j in range(nColunas):
        maiorElemento=matriz[i][j]
        