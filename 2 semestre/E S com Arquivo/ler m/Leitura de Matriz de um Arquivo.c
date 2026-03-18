#include <stdio.h>

int main(){
    FILE *fp;

    int i, j, *m, lin, col, k;

    fp = fopen("matriz.txt", "r");
    if (!fp){
        printf("Erro na leitura\n");
        exit(0);
    }

    fscanf(fp, "%d\n", &lin);
    fscanf(fp, "%d\n", &col);

    printf("Linhas = %d\nColunas = %d\n", lin, col);

    m = (int *)malloc(lin * col * sizeof(int));

    if (!m){
        printf("Erro na alocação dinâmica\n");
        exit(0);
    }

    for(i=0; i<lin; i++){
        for(j=0; j<col; j++){
            k = i * col + j;
            *(m+k) = rand()%10;
            fscanf(fp, "%d %d %d", &i, &j, (m+k));
            printf("%d\t", *(m+k));
        }
        printf("\n");
    }

    printf("Matriz lida com sucesso!");
    free(m);
    fclose(fp);

    return 0;
}
