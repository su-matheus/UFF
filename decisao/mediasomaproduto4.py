#Escreva um programa que recebe três inteiros como entrada do teclado e escreva na tela a média, a soma, o produto, o menor valor e o maior valor, usando uma linha para cada resultado.
#ENTRADA: três números inteiros SAIDA:  um número real com uma casa decimal (média) e 4 inteiros (soma, produto, menor, maior)

n1=int(input())
n2=int(input())
n3=int(input())

média=(n1+n2+n3)/3
soma=n1+n2+n3
produto=n1*n2*n3

print("%.1f"%média)
print(soma)
print(produto)

#Maior que
if n1<n2<n3:
    print(n1)
elif n1<n3<n2:
    print(n1)
elif n2<n1<n3:
    print(n2)
elif n2<n3<n1:
    print(n2)
elif n3<n1<n2:
    print(n3)
elif n3<n2<n1:
    print(n3)

#Menor que
if n1>n2>n3:
    print(n1)
elif n1>n3>n2:
    print(n1)
elif n2>n1>n3:
    print(n2)
elif n2>n3>n1:
    print(n2)
elif n3>n1>n2:
    print(n3)
elif n3>n2>n1:
    print(n3)

#NÃO ESTÁ 100 PORCENTO CORRETO