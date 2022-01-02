#Faça um programa que receba uma lista A (vetor) de inteiros de dimensão N e:(a) inverta os valores de A, troque o primeiro pelo último, o segundo pelo penúltimo e assim por diante.(b) após este procedimento, criar um vetor B de dimensão N com o fatorial de cadavalor de A, respeitando as posições, caso o valor for positivo ou nulo. Deixe os valoresnegativos intactos.(c) imprima o vetor B.
#ENTRADA: inteiro N (>=1) e depois N números inteiros que irão compor o vetor A
#SAIDA: vetor B de inteiros

N=int(input())
a=[]*N

for i in range(1,N+1):
    valor=int(input())
    a.append(valor)
A=a[::-1]       #Até aqui inverte a lista sem problemas
B=[]            #Antes estava dentro do for abaixo, porém não printava tudo em 1 linha
for i in range(len(A)):
    fator=1
    if A[i]>=1:
        for j in range(1,A[i]+1):
            fator=fator*j
        B.append(fator)
    if A[i]==0:
        B.append(1)
    if A[i]<0:
        #A[j]=A[j] colocar isso se o de baixo não der certo
        B.append(A[i])
print(B)

#EXERCÍCIO ENTREGUE COM 100 PORCENTO DE ACERTO