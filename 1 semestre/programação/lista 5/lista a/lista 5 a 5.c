#include <stdio.h>
#define L 2
#define C 4

int main() {
    float A[L][C], soma = 0, media;

    int i, j;

    printf("informe a produtividade da area(sacos/hectar):");

    for(i= 0; i<L; i++)
        for(j= 0; j<C; j++){
            printf("A%d%d:", i, j);
            scanf("%f", &A[i][j]);
        }
        for(i= 0; i<L; i++)
        for(j= 0; j<C; j++){

            soma = soma + A[i][j];
            //soma += A[i][j];

        }

    media = soma/8;

    printf("media de produtividade = %f sacos/hectatere\n", media);
    printf("areas acima da media:\n");

    for(i= 0; i<L; i++)
        for(j= 0; j<C; j++)
            if(A[i][j]>media)
                printf("A[%d][%d]=%f\n", i, j, A[i][j]);

        printf("areas abaicho da média:\n");

            for(i= 0; i<L; i++)
                for(j= 0; j<C; j++)
                    if(A[i][j]<media)
                        printf("A[%d][%d]=%f\n", i, j, A[i][j]);


return 0;
}
