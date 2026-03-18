#include <stdio.h>
int main() {

int a, b, i, aux, soma=0;

    ptintf("digite o intervalo desejado: ", a, b);
    scanf("%i%i", &a, &b);

    if(a>b){
       aux=a;
       a=b;
       b=aux;
       }
    for (i=a; i<=b; i++ ){
       soma = soma + i;
    }
    printf("somatoriodo intervalo: %i", soma);
return 0;
}
