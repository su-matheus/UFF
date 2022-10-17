#include<stdio.h>

#define M 10
#define N 10

void imprimir_matriz(int mat[][N], short m, short n){
  for (short i=0;i<m;i++){
    for (short j=0;j<n;j++){
      printf("%d ",mat[i][j]);   
    }
    printf("\n");
  }
}

void monta_matriz_identidade(short mat[][N], short n, short m){
    for ( int i = 0;i<m;i++){
        for (int j = 0;j<n;j++){
            if (i == j){
                mat[i][j] = 1;
            }
            else{
                mat[i][j] = 0;
            }
        }
    }
}
void monta_matriz(int mat[][N], int n, int m){
    for (int i = 0;i<m;i++){
        for (int j = 0;j<n;j++){
            if (j == (i + 1) % n){ //isso faz com que uma matriz identidade desloque uma unidade para a direita
                mat[i][j] = 1; //na última linha, j=0 e i=9 soma com 1 e divide por n=10 terá resto 0, logo j=(i+1)%10
            }
            else{
                mat[i][j] = 0;
            }
        }
    }
}

void multiplica_matriz_array(int mat[][N],int u[],int v[],int m, int n){
    for (int i = 0;i<m;i++){
        v[i] = 0;//isso faz com que cada linha da matriz seja zerada. É necessário pois ele somente é declarado como um array, porém nenhum valor é recebido.
        for (int j = 0;j<n;j++){
            v[i] = v[i] + mat[i][j]*u[j];//como cada linha começa com 0, a multiplicação do array u com a matriz de linha i funciona sem problemas e é salva na linha atual em que se encontra, ou seja, os valores originais que chegam nessa função(a matriz identidade deslocada uma unidade para a direita) são alterados para a multiplicação da linha atual.
        }
    }
}

void multiplica_matriz(int mat_a[][N], int mat_b[][N], int mat_c[][N], int m, int n, int o){
    for (int i=0;i<m;i++){
        for (int j=0;j<o;j++){
            mat_c[i][j] = 0;
            for (int k=0;k<n;k++){
                mat_c[i][j] += mat_a[i][k]*mat_b[k][j];//retorna a matriz sn 
            }
        }
    }
}

void matriz_copia(int mat_orig[][N], int mat_dest[][N], int m, int n){
    for (int i=0;i<m;i++){
        for (int j=0;j<n;j++){
            mat_dest[i][j] = mat_orig[i][j];
        }
    }
}
void matriz_potencia(int mat_a[][N], int e, int mat_b[][N], int m, int n){
    int mat_temp[M][N];
    monta_matriz_identidade(mat_b,n,m);
    matriz_copia(mat_a,mat_temp,m,n);
    for (int i = 2;i<e;i++){
        multiplica_matriz(mat_temp,mat_a,mat_b,m,n,n);
        matriz_copia(mat_b,mat_temp,m,n);
    }
}

void imprimir_array(int *v, int n){
    printf("[");
    for (int i = 0; i<n; i++){
        printf("%d ",v[i]);
    }
    printf("] \n");
}

int main(){
    int s[N][M];
    int sn[N][M];

    int m = 10 , n = 10, o = 10;
    monta_matriz(s,m,n);
    imprimir_matriz(s,m,n);
    
    int u[N] = {1,2,3,4,5,6,7,8,9,10};
    int v[N];
    printf("Matriz de deslocamento\n");
    multiplica_matriz_array(s,u,v,m,n);
    imprimir_array(u,n);
    imprimir_array(v,n);
    
    printf("Matriz de deslocamento duplo\n");
    multiplica_matriz(s,s,sn,m,n,o);
    imprimir_matriz(sn,m,o);
    multiplica_matriz_array(sn,u,v,m,n);
    imprimir_array(u,n);
    imprimir_array(v,n);

    unsigned short e = 4;
    printf("Matriz de deslocamento s^%d\n",e);
    matriz_potencia(s,e,sn,m,n);
    imprimir_matriz(sn,m,o);
    multiplica_matriz_array(sn,u,v,m,n);
    imprimir_array(u,n);
    imprimir_array(v,n);
   
}
