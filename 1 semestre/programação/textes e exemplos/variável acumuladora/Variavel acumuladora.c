#include <stdio.h>
int main() {

    int x1, x2, soma = 0;
    int a;

    printf("digite os dois numeros que definem o intervalo de valores: ");
    scanf("%d%d", x1, x2);

    for (a = x1; a <= x2; a++){
            soma = soma + a;
            //sama += a;
    }
    printf("o somatorio dos numerosdo intervalo eh %d\n", soma);
return 0;
}
