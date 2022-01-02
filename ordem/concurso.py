#Alguns candidatos prestaram concurso em uma empresa Capsule. Os resultados das provas do concurso são como o exemplo abaixo: Escreva um programa que:(a) O usuário fornecerá o número de candidatos N, a matrícula e a nota de cada candidato. O programa deve armazenar a matrícula dos candidatos em uma lista e a nota e outra lista.(b) Apresentar um relatório apresentando a matrícula do candidato em ordem crescente de classificação de acordo com a nota obtida, como exemplo abaixo.
#ENTRADA: inteiro N>=1 (pode acreditar) seguidos por N números inteiros positivos (pode acreditar) representando as matrículas, e mais N números reais positivos (pode acreditar) representando as notas.
#SAIDA: vetor de números inteiros de matrícula representando a classificação do concurso.

N=int(input())
m=[0]*N
n=[0]*N

for i in range(N):
    m[i]=int(input())
for i in range(N):
    n[i]=float(input())


for i in range(len(n)):
    n[i] = m[i]
    for j in range(len(n)-1):
        if n[j] > n[j+1]:
            n[j] , n[j+1] = n[j+1] , n[j]

#for i in range(len(n)):
#    i = m[i]
print(m)