#Fazer um programa que lê N números inteiros do teclado, e no final informa se os números lidos estão ou não em ordem crescente. Vamos assumir que (pode acreditar): - N >= 2 Dica: guarde sempre o número anterior fornecido.
#ENTRADA: número inteiro N, seguido de N números inteiros
#SAIDA: “sim” se os números estão em ordem crescente e “não” caso contrário

#ordem crescente
numero=int(input())
crescente = True
decrescente = False


while numero>=1:
    n=int(input())
    n2=n+n
    if n2 >= n:
        crescente
        numero=numero-1
    else:
        n < n2
        decrescente
        numero=numero-1
if crescente:
    print("sim")
else:
    print("não")