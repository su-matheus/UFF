def tribonacci(tamanho):
    for i in range(tamanho):
        if i == 0:
            lista[i] = 1
        if i == 1:
            lista[i] = 1
        if i == 2:
            lista[i] = 2
        if i >=3:
            lista[i] = lista[i-1] + lista[i-2] + lista[i-3]
        

tamanho = int(input())
lista = [0]*tamanho
tribonacci(tamanho)
print(lista)