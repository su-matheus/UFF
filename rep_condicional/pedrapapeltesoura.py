#Faça um jogo de pedra, papel, tesoura, spock e lagarto (de onde vem isso?), onde dois jogadores escolhem entre “0-pedra 1-spock 2-paper 3-lagarto 4-tesoura”. Serão disputadas 3 partidas e o programa deve informar quantas vezes cada jogador ganhou e quantas vezes deu empate.
#ENTRADA: 6 números (inteiros) representando as jogadas alternadas dos jogadores 1 e 2, isto é, o primeiro número é a jogada 1 do jogador 1, o segundo número é a jogada 1 do jogador 2, e assim por diante.
#SAIDA: 3 números inteiros (um em cada linha) indicando o número de vitórias do jogador 1, o número de vitórias do jogador 2 e o número de empates.

pedra,spock,paper,lagarto,tesoura=0,1,2,3,4
v1=0
v2=0
e=0

while v1+v2+e<=2:
    jogador1=int(input())
    jogador2=int(input())
    if jogador1==0:
        if jogador2==0:
            e=e+1
        elif jogador2==1:
            v2=v2+1
        elif jogador2==2:
            v2=v2+1
        elif jogador2==3:
            v1=v1+1
        elif jogador2==4:
            v1=v1+1
    if jogador1==1:
        if jogador2==0:
            v1=v1+1
        elif jogador2==1:
            e=e+1
        elif jogador2==2:
            v2=v2+1
        elif jogador2==3:
            v2=v2+1
        elif jogador2==4:
            v1=v1+1
    if jogador1==2:
        if jogador2==0:
            v1=v1+1
        elif jogador2==1:
            v1=v1+1
        elif jogador2==2:
            e=e+1
        elif jogador2==3:
            v2=v2+1
        elif jogador2==4:
            v2=v2=1
    if jogador1==3:
        if jogador2==0:
            v2=v2+1
        elif jogador2==1:
            v1=v1+1
        elif jogador2==2:
            v1=v1+1
        elif jogador2==3:
            e=e+1
        elif jogador2==4:
            v2=v2+1
    if jogador1==4:
        if jogador2==0:
            v2=v2+1
        elif jogador2==1:
            v2=v2+1
        elif jogador2==2:
            v1=v1+1
        elif jogador2==3:
            v1=v1+1
        elif jogador2==4:
            e=e+1
print(v1)
print(v2)
print(e)

#FUNCIONANDO 100 PORCENTO 