#include <stdio.h>
int main() {
int A[7][6],i , j;

        printf("digite os elementos da matriz A3x5\n");

            for(i = 0; i <7 ; i++)
                for(j = 0; j <6 ; j++){

                    printf("A[%d][%d] = ", i, j);
                    scanf("%d", &A[i][j]);
        }
    printf("\Matris A3x5\n");

    for(i = 0; i < 7; i++){
        for(j = 0; j < 6; j++){

            printf("%d\t", A[i][j]);
        }
        printf("\n");
    }


return 0;
}
