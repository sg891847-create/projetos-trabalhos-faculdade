#include <stdio.h>
int main() {

int a, b, i, aux;

    ptintf("digite o intervalo desejado:");
    scanf("%i%i",&a,&b);

    if(a>b){
       aux=a;
       a=b;
       b=aux;



    }
    printf("numeros pares no intervalo:\n");
    for (i=a; i<=b; i++ ){
        if(i%2==0);
            printf("%i",i);

    }
return 0;
}
