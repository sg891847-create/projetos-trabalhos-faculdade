#include <stdio.h>
int main() {

    int v[20], i, n, existe=0;

    printf("digite os 10 elementos:\n");
    for(i=0; i<10; i++){
        scanf("%d",&v[i]);

    }

    printf("digite um numero: ");
    scanf("%d",&n);

    for(i=0; i<10; i++){
        if(n==v[i]){
            printf("%existe na posicao %dn\n", n, i);
            existe=1;
        }
    }
    if(existe==0){
        printf("o valor %d nao existe no vetor\n",n);
    }
return 0;
}
