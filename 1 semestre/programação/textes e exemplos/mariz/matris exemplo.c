#include <stdio.h>
int main() {

    int A[3][4],i , j;

        printf("digite os elementos da matriz A3x4\n");

            for(i = 0; i < 3; i++)
                for(j = 0; j < 4; j++){

                    printf("A[%d][%d] = ", i, j);
                    scanf("%d", &A[i][j]);
        }
    printf("\Matris A3x4\n");

    for(i = 0; i < 3; i++){
        for(j = 0; j < 4; j++){

            printf("%d\t", A[i][j]);
        }
        printf("\n");
    }


return 0;
}
