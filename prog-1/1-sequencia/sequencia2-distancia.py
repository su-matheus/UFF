#Faça um programa que leia dois pontos num espaço bidimensional e calcule a distância entre esses pontos
#ENTRADA: quatro números reais representando as 2 coordenadas (x,y) dos pontos 

x1=float(input())
y1=float(input())
x2=float(input())
y2=float(input())
ponto1=(x1,y1)
ponto2=(x2,y2)
d=(((x2-x1)**2)+((y2-y1)**2))**(0.5)
print("d = %.2f"%d)