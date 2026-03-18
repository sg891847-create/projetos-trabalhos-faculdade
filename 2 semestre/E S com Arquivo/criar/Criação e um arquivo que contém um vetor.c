#include <stdio.h>

int main(){
    FILE *fp;

    int i, n, *v;

    fp = fopen("vetor.txt", "w");
    if (!fp){
        printf("Erro na leitura\n");
        exit(0);
    }

    printf("Informe o tamanho do vetor:");
    scanf("%d", &n);
    fprintf(fp, "%d\n", n);

    v = (int *)malloc(n * sizeof(int));

    if (!v){
        printf("Erro na alocação dinâmica\n");
        exit(0);
    }

    for(i=0; i<n; i++){
        v[i] = rand()%10;
        fprintf(fp, "%d\t", v[i]);
    }

    fclose(fp);
    free(v);

    return 0;
}
