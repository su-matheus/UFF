#Faça um programa que receba um vetor de inteiros positivos de tamanho N, e ordene seguindo o seguinte critério.- primeiro os pares- depois os ímpares. Sendo que devem ser apresentados os pares em ordem crescente e os ímpares em ordem decrescente. OBS: Use qualquer método de ordenação
#ENTRADA: inteiro N>=1 (pode acreditar) seguidos por N números inteiros positivos (pode acreditar).
#SAIDA: vetor de números inteiros representando a ordem descrita acima

N=int(input())
v=[0]*N
p=[]
im=[]

for i in range(N):
    v[i]=int(input())
    if v[i]%2==0:
        p.append(v[i])
    if v[i]%2!=0:
        im.append(v[i])
        
for i in range(len(p)):
    for j in range(len(p)-1):
        if p[j] > p[j+1]:
            p[j],p[j+1] = p[j+1],p[j]
for i in range(len(im)):
    for j in range(len(im)-1):
        if im[j] < im[j+1]:
            im[j],im[j+1] = im[j+1],im[j]
print(p+im)

#ENTREGUE E FUNCIONANDO 100 PORCENTO