#include<stdio.h>
#include<stdlib.h>
int **MATRIXint (int r, int c, int val);
int main(void){
 int **a, i, j, lin=15, col=15;

 a = MATRIXint(lin, col, 23);

 for(i=0;i<lin;i++){
 printf("\n");
 for(j=0;j<col;j++)
 printf("%d ", a[i][j]);
 }

 free(a);
 system("pause");
 return 1;
}
/* Funcao aloca uma matriz com linhas 0..r-1 e
colunas 0..c-1. Cada elemento da matriz recebe
valor val. */
int **MATRIXint (int r, int c, int val) {
 int i, j;
 int **m;

 m = malloc(r * sizeof(int *));

 if (!m){
 printf("Erro de alocação de memória!");
 exit(0);
 }

 for (i = 0; i < r; i++)
 m[i] = malloc(c * sizeof(int));
 for (i = 0; i < r; i++)
 for (j = 0; j < c; j++){
 m[i][j] = val;
 }
 return m;
}
