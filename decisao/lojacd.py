#Em uma loja de CD's existem apenas quatro tipos de preços que estão associados a cores. Assim os CD's que ́ficam na loja não são marcados por preços e sim por cores. Desenvolva o algoritmo que a partir da entrada da cor o software mostre o preço. A loja está atualmente com a seguinte tabela de preços. 
#Verde    R$ 10,00; Azul   R$ 20,00; Amarelo  R$ 30,00; Vermelho  R$ 40,00
#ENTRADA: texto equivalente a cor do preço
#SAIDA: a frase “Custo R$ X” onde X é um valor real com duas casas decimais 

Cor=input()
Verde=10
Azul=20
Amarelo=30
Vermelho=40
Cores=10,20,30,40

if Cor=="Verde":
    print("Custo R$","%.2f"%Verde)
elif Cor=="Azul":
    print("Custo R$","%.2f"%Azul)
elif Cor=="Amarelo":
    print("Custo R$ 30,00", "%.2f"%Amarelo)
elif Cor=="Vermelho":
    print("Custo R$ 40,00","%.2f"%Vermelho)
else :
    print("Não disponível") 
#NÃO ENTREGUE, PORÉM RODANDO PERFEITAMENTE NO VSCODE