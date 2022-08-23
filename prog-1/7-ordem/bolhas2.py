#Faça um programa que receba N vetores de inteiros de tamanho 5 e os ordene pelo método da bolha. Para cada vetor ordenado, imprima o número de trocas realizadas entre posições adjacentes.
#ENTRADA: inteiro N>=1 (pode acreditar) seguidos por 5*N inteiros, que de 5 em 5, irão compor os vetores
#SAIDA: N inteiros, um por linha, representando o número de trocas em cada vetor, respectivamente. 

N=int(input())
v=([0]*5)
t=0

for i in range(5):
        v[i]=int(input())

for i in range(len(v)):
    for j in range(len(v)-1):
        if v[j] > v[j+1]:
            v[j] , v[j+1] = v[j+1] , v[j]
            t=t+1

for i in range(N):
    print(t)

#33.3 PORCENTO CERTO