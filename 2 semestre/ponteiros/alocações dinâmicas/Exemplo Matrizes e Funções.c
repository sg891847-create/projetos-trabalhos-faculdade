#include<stdio.h>
#define N 2
void lerMatriz(int a[N][N]){
 int i, j;

 for(i=0;i<N;i++)
 for(j=0;j<N;j++)
 scanf("%d", &a[i][j]);
 return;
}
int somatorio(int a[N][N]){
 int i, j, s=0;

 for(i=0;i<N;i++)
 for(j=0;j<N;j++)
 s +=a[i][j];
 return s;
}
void mult(int a[N][N], int s){
 int i, j;

 for(i=0;i<N;i++)
 for(j=0;j<N;j++)
 a[i][j] = s * a[i][j];
 return;
}
void mostrarMatriz(int a[N][N]){
 int i, j;

 for(i=0;i<N;i++){
 printf("\n");
 for(j=0;j<N;j++)
 printf("%d ", a[i][j]);
 }
 return;
}
int main(){
 int mat[N][N], x;

 lerMatriz(mat);
 x = somatorio(mat);
 mult(mat, x);
 mostrarMatriz(mat);

 system("pause");
 return;
}
