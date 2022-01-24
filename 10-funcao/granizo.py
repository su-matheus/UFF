def granizo(h):
    n = 1
    indice = 0
    while valor[indice] != 1:
        if (valor[indice])%2 == 0:
            variavel = n-1
            if variavel == 0:
                valor.append(h)
                indice += 1
                n += 1
            else:
                valor.append(valor[n-1]/2)
                indice += 1
                n += 1
        
        if (valor[indice])%2 != 0:
            valor.append(3*valor[n-1]+1)
            indice += 1
            n += 1


h=int(input())
valor = [0]
granizo(h)
print(valor)