def decrescente(tamanhoLista):
    sequencia = 0
    for i in range (tamanhoLista):
        if lista[i] >= lista[i+1]:
            sequencia += 1
    return sequencia

tamanhoLista = int(input())
lista = []
sequencia = decrescente(tamanhoLista)

for i in range(tamanhoLista):
    lista.append(int(input()))

print(sequencia)