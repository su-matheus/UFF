#Faça um programa que informe a distância em quilômetros de um raio para o observador. O observador deve informar o tempo (em segundos) transcorrido entre ver o raio e ouvir o trovão. Assuma que a velocidade do som seja 340 m/s 
#ENTRADA: um número inteiro representando o tempo em segundos

tempo=float(input())
d=(340*tempo)*10**(-3)       #Considerando velocidade como 340 m/s
print("d = %.3f"%d)

