def granizo(h):
    n=1
    valor = []
    if (n-1)%2 == 0:
        variavel = n-1
        if variavel == 0:
            valor += h
            n += 1
    
    if (n-1)%2 != 0:
        variavel = n-1
        valor += 3*valor+1
        n += 1

h=int(input())
granizo(h)
print(h)