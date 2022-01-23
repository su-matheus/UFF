#Faça um programa que receba dois inteiros A e B e imprima todos os números primos entre os números A e B (incluindo A e B) 
#ENTRADA: números inteiros A e B onde 1<= A<= B (Pode acreditar) SAIDA: número(s) (inteiros), um por linha, indicando os números primos entre A e B

a=int(input())
b=int(input())

for i in range(a,b+1):   #POR ESTAR DO LADO DE FORA E ENGLOBANDO TODOS OS NÚMEROS, "i" SE TORNA MAIS IMPORTANTE QUE "y"
    p=0
    for y in range(2,i):    #TEM QUE COLOCAR "i"  PQ É CALCULADO "i" NAQUELE MOMENTO, SE USASSE "b+1" IRIA ATÉ 15 E DARIA ERRADO
        if i%y==0:          #SE ENCONTRAR PELO MENOS UM NÚMERO QUE DÊ RESTO 0 ENTÃO NÃO É PRIMO,TIPO 9
            p=p+1           #SE TODOS OS CASOS DA LINHA DE CIMA FOREM FALSOS ENTÃO "p==0"
    if p==0 and i!=1:
        print(i)

#EXERCÍCIO ENTREGUE COM 100 PORCENTO DE ACERTO