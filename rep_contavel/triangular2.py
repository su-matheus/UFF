número = int(input())

i = 1
while i * (i+1) * (i+2) < número:
    i = i + 1

if i * (i+1) * (i+2) == número:
    print(i)
    print(i+1)
    print(i+2)
else:
    print("%d não" %(número))

#ENTREGUE COM 66.6 PORCENTO DE ACERTO