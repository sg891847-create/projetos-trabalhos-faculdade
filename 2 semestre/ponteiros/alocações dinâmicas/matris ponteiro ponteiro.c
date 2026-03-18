#include<stdio.h>
#include<stdlib.h>

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

void mostrarMatriz(int **m, int r, int c, char *nomeMatriz){
    int i, j;

    printf("Matriz %s\n", nomeMatriz);

    for(i=0;i<r;i++){
        printf("\n");
        for(j=0;j<c;j++)
            printf("%d ", m[i][j]);
    }

    return ;
}

int main(void){
    int **a, i, j, lin=15, col=15;
    a = MATRIXint(lin, col, 23);

    mostrarMatriz(a, lin, col, "A");

    free(a);

    return 1;
}
