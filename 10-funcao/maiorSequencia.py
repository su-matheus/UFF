def decrescente(lista):
    sequencia = 0
    for i in range (len(lista)-1):
        if lista[i] >= lista[i+1]:
            sequencia += 1
    return sequencia

tamanhoLista = int(input())
lista = []

for i in range(tamanhoLista):
    lista.append(int(input()))

sequencia = decrescente(lista)

print(sequencia)