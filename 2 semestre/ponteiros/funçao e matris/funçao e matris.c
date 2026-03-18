#include<stdio.h>

void mostraMatriz(float mat[][2]){
    int i,j;
    for(i=0;i<2;i++)
        for(j=0;j<2;j++){
            printf("%f\n", mat[i][j]);
    }
}
void f1(float mat[][2]){
    int i, j;
    printf("Matriz alterada em f1:\n");
        for(i=0;i<2;i++)
            for(j=0;j<2;j++){
                mat[i][j] = i+j+10;
                printf("f1: %f\n",mat[i][j]);
        }
}
    int main(void){
        float x[2][2];

        int i, j;

        printf("Informe os elementos da matriz 2x2:\n");

        for(i=0;i<2;i++)

            for(j=0;j<2;j++)

                scanf("%f", &x[i][j]);

    printf("Matriz digitada:\n");

    mostraMatriz(x);

    f1(x);

    printf("Na main, a matriz apos a execucao de f1...\n");

    mostraMatriz(x);

    system("pause");

return 1;
}
