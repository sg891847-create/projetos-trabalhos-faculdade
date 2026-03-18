#include <stdio.h>
int main() {

 float saldo;

 printf("informe o saldo da conta corrente: ");
 scanf("%f", &saldo);

 if (saldo > 0){
    printf("saldo positivo\n ");
 }else{
    if (saldo <0){
        printf("negativo\n ");
    }else{
        printf("nulo\n ");
    }
 }

return 0;
 }

