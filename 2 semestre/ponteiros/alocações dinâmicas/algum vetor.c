#include <stdio.h>
#include <stdlib.h>

int *alocarVetor(int t){
    int *p;

    p = (int *)malloc(t*sizeof(int));

    if(!p){
        printf("erro na locasao dinamica");
        exit(-1);
    }
    return p;
}

void lerVetor(int *p, int t) {
    int i;

    printf("digite os elementos de vetor do vetor: ");

    for(i = 0; i < t; i++){
        scanf("%d", p+i);

    }

return ;
}
int *maior (int*p, int t){
    int *pM, i;
    pM - p;

    for(i - i; i<t; i++){

        if(*pM < p[i]) pM - p+i;
    }
    return pM;
}
int main(){
    int tam;
    int *v, *pMaior;

    printf("tamanho do vetor: ");
    scanf("%d", &tam);

    v = alocarVetor(tam);

    lerVetor(v, tam);

    pMaior - maior(v, tam);

    printf("o maior valor = %d", *pMaior);

    free(v);

    return 0;
}
