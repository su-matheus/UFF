#Faça um programa que simule uma agenda telefônica onde o usuário informe os telefones (inteiros) e você deverá inserir estes valores numa lista, onde ela se mantem ordenada de forma crescente. A cada número inserido, imprima a agenda.
#ENTRADA: inteiro N>=1 (pode acreditar) representando o número de telefones a serem inseridos na agenda, seguidos por N números inteiros positivos (pode acreditar), que representam os números de telefone.
#SAIDA: N vetores de inteiros ordenados, um por linha, representando a impressão da agenda ordenada após inserir novo número.

N=int(input())
Agenda=[]*N

for i in range(N):
    numero = int(input())
    Agenda.append(numero)
    for j in range(len(Agenda)):
        for k in range(len(Agenda)-1):
            if Agenda[k] > Agenda[k+1]:
                Agenda[k] , Agenda[k+1] = Agenda[k+1] , Agenda[k]
    print(Agenda)

#ENTREGUE E FUNCIONANDO 100 PORCENTO