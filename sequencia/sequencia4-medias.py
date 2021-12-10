#Leia 3 valores, no caso, variáveis 𝐴, 𝐵 e 𝐶, que são as três notas de um aluno. A seguir, calcule a média do aluno, sabendo que a nota 𝐴 tem peso 2, a nota 𝐵 tem peso 3 e a nota 𝐶 tem peso 5. Considere que cada nota pode ir de 0 até 10.0.  
#ENTRADA: três números reais representando as 3 notas dos alunos 

A=float(input())
B=float(input())
C=float(input())
media=(A*2+B*3+C*5)/10
print("%.1f"%media)
