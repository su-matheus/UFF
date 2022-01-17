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

for i in range(tamanhoVetorTemp-1):
    if vetorTemp[i] < vetorTemp[i+1]:
        vetorTemp[i] , vetorTemp[i+1] = vetorTemp[i+1] , vetorTemp[i]
print(vetorTemp)