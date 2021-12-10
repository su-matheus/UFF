#Você vai viajar e planeja levar na viagem todos os seus vários equipamentos eletrônicos:  celular, tablet, notebook, ponto de acesso wifi, câmeras, etc, e sabe que necessitará de várias  tomadas de energia para conectar todos esses equipamentos. Você é informado de que ficará em um quarto de hotel que contém apenas uma tomada de energia disponível. Precavido, você comprou quatro réguas de tomadas, permitindo assim ligar vários aparelhos na única tomada do quarto de hotel. Você pode, também, ligar uma régua em outra para aumentar ainda mais o número de tomadas disponíveis. No entanto, como as réguas têm muitas tomadas, você resolve escrever um programa que, dado o número de tomadas em cada régua, determine o número máximo de aparelhos que podem ser conectados à energia num mesmo instante. 
#ENTRADA: A entrada consiste de quatro números inteiros, indicando o número de tomadas de cada uma das quatro réguas

tomada1=int(input())
tomada2=int(input())
tomada3=int(input())
tomada4=int(input())
total=((tomada1-1)+(tomada2-1)+(tomada3-1)+tomada4)
print(total)