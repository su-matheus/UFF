#Faça um programa que leia a matriz A de inteiros e de dimensão NxN. Calcule a Matriz B = AxA e depois calcule a matriz C = B+AT , onde AT é a matriz transposta de A. No fim, imprima a matriz C. Definição: matriz transposta é a matriz que se obtém da troca de linhas por colunas de uma dada matriz.
#ENTRADA: inteiro N>=2 (pode acreditar) seguidos por N*N inteiros que irão compor a matriz (primeiros N elementos são a primeira linha, os próximos N elementos são a segunda, ...)
#SAIDA: matriz de inteiros calculada C=B+AT (formato padrão do python)


N = int(input())
matriz = []


#MATRIZ PRINCIPAL  
for i in range(N):
    linha = []
    for j in range(N):
        linha.append(int(input()))
    matriz.append(linha)

#MATRIZ MULTIPLICADA
segundaMatriz = []
for i in range(N):
    linhaSegundaMatriz = []
    for j in range(N):
        pe=0
        for k in range(N):
            pe+= matriz[i][k]*matriz[k][j]
        linhaSegundaMatriz.append(pe)
    segundaMatriz.append(linhaSegundaMatriz)

#MATRIZ TRANSPOSTA    #NÃ0 ESTÁ FUNCIONANDO CERTINHO
for i in range(N):
    for j in range(N):
        matriz[i][j] = matriz[j][i]

#SOMA DA MATRIZ PRINCIPAL E MATRIZ TRANSPOSTA

somaMatriz = []
for i in range(N):
    linhaSomaMatriz = []
    for j in range(N):
        soma=0
        soma= matriz[i][j] + segundaMatriz[i][j]
        linhaSomaMatriz.append(soma)
    somaMatriz.append(linhaSomaMatriz)
print(somaMatriz)


#33,3% CERTO