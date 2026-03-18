int main() {

    int A[3][5],i , j;

        printf("digite os elementos da matriz A3x5\n");

            for(i = 0; i < 3; i++)
                for(j = 0; j < 5; j++){

                    printf("A[%d][%d] = ", i, j);
                    scanf("%d", &A[i][j]);
        }
    printf("\Matris A3x5\n");

    for(i = 0; i < 3; i++){
        for(j = 0; j < 5; j++){

            printf("%d\t", A[i][j]);
        }
        printf("\n");
    }


return 0;
}
