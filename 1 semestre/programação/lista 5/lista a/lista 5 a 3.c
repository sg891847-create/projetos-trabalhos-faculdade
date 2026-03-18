int main() {

    int A[3][2],B[3][2] ,i , j, o, z, x;

        printf("digite os elementos da matriz A3x2\n");

            for(i = 0; i < 3; i++)
                for(j = 0; j < 2; j++){

                    printf("A[%d][%d] = ", i, j);
                    scanf("%d", &A[i][j]);
        }
    printf("\Matris A3x2\n");

    for(i = 0; i < 3; i++){
        for(j = 0; j < 2; j++){

            printf("%d\t", A[i][j]);
        }
        printf("\n");
    }

            printf("indique o numero para multiplicar a matriz:\n");
        scanf("%d, x");

                            x * A[i][j];


        for(o = 0; o < 3; o++){
            for(z = 0; z < 2; z++){

            printf("%d\t", A[o][z]);
            }
        printf("\n");
        }


return 0;
}
