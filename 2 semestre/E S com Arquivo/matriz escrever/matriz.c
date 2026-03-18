/* Escrita de Matriz em Arquivo */
#include <stdio.h>

int main(){
    FILE *fp;

    int i, j, *m, lin, col, k;

    fp = fopen("matriz.txt", "w");
    if (!fp){
        printf("Erro na criação do arquivo\n");
        exit(0);
    }

    printf("Informe a quantidade de linhas e colunas da matriz:\n");
    scanf("%d%d", &lin, &col);
    fprintf(fp, "%d %d\n", lin, col);

    m = (int *)malloc(lin * col * sizeof(int));

    if (!m){
        printf("Erro na alocação dinâmica\n");
        exit(0);
    }

    for(i=0; i<lin; i++){
        for(j=0; j<col; j++){
            k = i * col + j;
            *(m+k) = rand()%10;
            fprintf(fp, "%d %d %d\n", i, j, *(m+k));
        }
    }

    printf("Matriz gerada com sucesso!");
    fclose(fp);
    free(m);

    return 0;
}
