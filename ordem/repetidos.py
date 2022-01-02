#Faça um programa que receba um vetor de inteiros de tamanho N, retire os elementos repetidos, ordene e imprima o resultado. OBS: Use qualquer método de ordenação
#ENTRADA: inteiro N>=1 (pode acreditar) seguidos por N números reais.
#SAIDA: vetor de números inteiros sem repetidos e ordenados.

N=int(input())
v=[0]*N
não_Repetidos=[]

for i in range(N):
    v[i]=int(input())
    if v[i] not in não_Repetidos:
        não_Repetidos.append(v[i])
        
for i in range(len(não_Repetidos)):
    for j in range(len(não_Repetidos)-1):
        if não_Repetidos[j]>não_Repetidos[j+1]:
            não_Repetidos[j],não_Repetidos[j+1] = não_Repetidos[j+1],não_Repetidos[j]
print(não_Repetidos) 

#ENTREGUE E FUNCIONANDO 100 PORCENTO