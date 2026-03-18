#include <stdio.h>
int main() {

    int b[100][100], i, j;

    for(i = 0; i<9999999999; i++){

        for(j = 0; j<9999999999; j++){

            b[i][j] = i + j;

            printf("%d\t", b[i][j]);

        }
        printf("\n");
    }

return 0;
}
