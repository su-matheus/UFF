def granizo(h):
    n = 1
    while valor[n] != 1:
        if (n-1)%2 == 0:
            variavel = n-1
            if variavel == 0:
                numero = h
                valor.append(numero)
            else:
                valor.append(valor[n-2]/2)
                n += 1
        
        if (n-1)%2 != 0:
            variavel = n-1
            valor.append(3*valor[n-2])
            n += 1

h=int(input())
valor = [0]
granizo(h)
print()