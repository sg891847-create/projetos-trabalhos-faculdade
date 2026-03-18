#include <stdio.h>
int main() {

    int b[10][10], i, j;
    int c[3][3];
    int I[5][5];
    int T[3][2];

    printf("transposta de b:\n");

    for(i = 0; i<3; i++){

        for(j = 0; j<2; j++){

            T[i][j] = b[j][i];

            printf("%d\t", T[i][j]);
        }
        printf("\n");
    }

return 0;
}
