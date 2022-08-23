#Faça um programa que receba duas listas (vetores) A e B de inteiros, uma de tamanho N e outra de tamanho M, onde N<=M. O programa deve percorrer as duas listas e intercalar os elementos de ambas, formando uma terceira lista C. A terceira lista deve começar pelo primeiro elemento da lista A seguido pelo primeiro elemento da lista B. Quando acabar de intercalar os elementos, se ainda tiver elementos sobrando na lista maior (B), colocar esses elementos no fim da lista C.
#ENTRADA: dois inteiro N e M onde 1 <= N <= M (pode acreditar) seguidos por N inteiros (queirão compor o vetor A) e M inteiros (que irão compor o vetor B)
#SAIDA: vetor C de inteiros 

n=int(input())
m=int(input())
A,B= [0]*n, [0]*m
total=n+m

for i in range(n):
    A[i]=int(input())
for j in range(m):
    B[j]=int(input())

for k in range(m):
    C=[]
    for i in range(len(A)):
        C.append(A[i])
    for j in range(len(B)):
        C.append(B[j])
print(C)