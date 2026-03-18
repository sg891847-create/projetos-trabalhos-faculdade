#include <stdio.h>

int main(){
    FILE *fp;

    int i, n, *v;

    fp = fopen("vetor.txt", "r");
    if (!fp){
        printf("Erro na leitura\n");
        exit(0);
    }

    v = (int *)malloc(n * sizeof(int));

    if (!v){
        printf("Erro na alocação dianâmica\n");
        exit(0);
    }

    fscanf(fp, "%d", &n);

    printf("Tamanho do vetor = %d\n", n);

    for(i=0; i<n; i++){
        fscanf(fp, "%d", &v[i]);
        printf("%d\t", v[i]);
    }

    fclose(fp);
    free(v);

    return 0;

}
