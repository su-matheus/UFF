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

tamanhoVetorTemp = nLinhas*nColunas
vetorTemp = [0]*tamanhoVetorTemp
ind = 0

for i in range(nLinhas):
    for j in range(nColunas):
        vetorTemp[ind] = matriz[i][j]
        ind+= 1

#ORDENA MATRIZ TEMPORARIA
for i in range(tamanho):
    for j in range(tamanho-1):
        if vetorTemp[j] < vetorTemp[j+1]:
            vetorTemp[j] , vetorTemp[j+1] = vetorTemp[j+1] , vetorTemp[j]

ind=0
for i in range(nLinhas-1):
    for j in range(nColunas-1-j):
        matriz[ind][j+1] = vetorTemp[ind]
        ind+= 1
print(matriz)
