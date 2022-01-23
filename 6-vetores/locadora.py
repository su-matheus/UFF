#Uma locadora de videogame tem guardada, em uma lista de 10 posições, a quantidade de jogos retirados por seus clientes durante o ano passado (i.e. Clientes[i] = X -> o cliente “i” retirou X jogos no ano passado). Agora esta locadora está fazendo uma promoção e, para cada 5 jogos retirados no ano passado, o cliente tem direito a uma locação grátis. Faça um programa que crie um outro vetor contendo a quantidade de locações gratuitas a que cada cliente tem direito.
#ENTRADA: 10 números inteiros (>=0) indicando o número de locações de cada cliente
#SAIDA: vetor de inteiros indicando o número de locações gratuitas de cada cliente

clientes=[0]*10

for i in range(10):
    clientes[i]=int(input())   #Outro jeito de fazer isso é n=int(input()) e v.append(n), porém a lista v tem que ser vazia ao invés de um vetor com zeros

l=[]
for i in range(len(clientes)):
    g=clientes[i]//5
    l.append(g)
print(l)

#EXERCÍCIO ENTREGUE COM 100 PORCENTO DE ACERTO