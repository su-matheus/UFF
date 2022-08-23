#Faça um programa que recebe uma lista de números reais distintos positivos de tamanho 5. O programa deve percorrer esta lista e imprimir o valor mais próximo da média dos valores deste vetor
#ENTRADA: 5 números reais positivos (>= 0) e distintos (pode acreditar)
#SAIDA: número real (com 2 casas decimais) que representa o valor do vetor que tem a menor distância para a média do vetor

v=[0]*5

for i in range(5):
    v[i]=float(input())
soma=sum(v)
media=soma/5
resto=0
for i in range(len(v)):
    resto=v[i]%media
    if resto==v[i]:
        resto==v[i]
    print(v[i])
    #print(resto)
#print("%.2f"%media)