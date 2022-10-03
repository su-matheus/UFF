#include<stdio.h>


void imprime_polinomio(char *nome_id, float *p, int grau){
  if (grau<0) return;

  printf("%s = %.1f",nome_id,p[0]);
  for (int i=1;i<=grau;i++){
    printf(" +%.1fx^%d ",p[i],i);
  }
  printf("\n");
  
}


void derivada_polinomio(float *p, int *grau){
  for (int i = 0;i<=*grau-1;i++){
    p[i] = p[i+1]*(i+1);
  }
  p[*grau] = 0.0;
  *grau = *grau-1;
  
}


int main() {
  
  float p[5] = {2.5,3.0,8.0,0.0,2.0};
  float *q;
  q = p;
  
  // 2.5 + 3.0x + 8.0x^2 + 2.0x^4
  
  int grau = 4;
  imprime_polinomio("p",p,grau);
  derivada_polinomio(p,&grau);
  imprime_polinomio("d(p)/dx",q,grau);
    
  
  return 0;
}