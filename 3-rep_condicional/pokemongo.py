#Suponha que um jogador A de PokemonGO tenha X pokemons com uma taxa anual de crescimento/captura de 50% e que o jogador B tem Y pokemons com uma taxa de crescimento/captura de 30%. Vamos assumir que (pode acreditar): - X < Y - X >= 2- A quantidade de pokemons capturada por ano é inteira, quer dizer, por exemplo, se eu tenho 123 pokemons e tenho uma taxa de captura de 30% no ano, então em um ano irei capturar 36 pokemons pois 30% de 123 é 36.9 (pegamos só a parte inteira ou piso). Faça um programa que calcule e retorne o número de anos necessários para que o jogador A ultrapasse ou iguale o número de pokemons do jogador B, mantidas as taxas de crescimento
#ENTRADA: números inteiros X e Y indicando o número inicial de pokemons do jogador A e B respectivamente.
#SAIDA: número de anos (inteiro) para que A ultrapasse ou iguale B

jogador_A= int(input())         #esse é X,valor de X é menor que Y
jogador_B= int(input())         #esse é Y,valor de Y é maior que X
crescimento_A=(jogador_A*0.5)//10
crescimento_B=(jogador_B*0.3)//10
anos=0
#ATÉ AQUI APARECE O CRESCIMENTO CERTINHO

while crescimento_B>crescimento_A:
    if crescimento_B>crescimento_A:
        anos=anos+1
        crescimento_A=crescimento_A*anos
        crescimento_B=crescimento_B*anos
    else:
        crescimento_A>=crescimento_B
        print(anos)
