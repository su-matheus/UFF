#Faça um programa que receba um conjunto de 10 elementos numéricos e os armazene em uma lista (vetor). Em seguida, o programa deverá procurar se existem no vetor elementos iguais a um dado valor também informado pelo usuário e imprimir o índice das posições em que estes são encontrados.
#ENTRADA: 10 números inteiros e mais um número inteiro indicando o número a ser procurado
#SAIDA: vetor de inteiros indicando as posições em que o número foi encontrado no vetor.
v=[0]*10

for i in range(10):
    v[i]=int(input())   #Outro jeito de fazer isso é n=int(input()) e depois v.append(n), porém é colocado em vetor vazio ao invés de vetor com zeros
p=int(input())
r=[]
for i in range(len(v)):
    if v[i]==p:
        r.append(i)
print(r)

#EXERCÍCIO ENTREGUE COM 100 PORCENTO DE ACERTO