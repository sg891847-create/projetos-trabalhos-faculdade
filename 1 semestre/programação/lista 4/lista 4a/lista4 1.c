#include <stdio.h>
int main() {

int v[20], x, par=0;

    printf("digite 20 numeros inteiros:\n");

    x=0;
    while(x<=19){
            printf("vetor [%i]:",x);
            scanf("%i",&v[x]);
            x++;
    }

    for(x=0; x<=19; x++){
            printf("%i\t",v[x]);
    }

    for(x=0; x=19; x++){
        if(v[x]%2==0)
            par++;
    }
    printf("%i sao numeros pares:\n", par);

    printf("os elementos armazenados nas posiçoes pares dos vetores sao:\n");
        if("x%i\t", v[x]);

return 0;
}
