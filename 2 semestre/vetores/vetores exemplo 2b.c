#include <stdio.h>
int main() {

    int codigo[10], indice, codigomaior, codigomenor;
    float peso[10], maiorpeso= 0, menorpeso= 9999999;

    printf("informe os dados (codigoe peso) dos 10 bois: \n");

    for(indice= 0; indice<= 9; indice++){
        printf("codigo: ");
        scanf("%d", &codigo[indice]);
        printf("peso: ");
        scanf("%f", &peso[indice]);
        }
        printf("\n\nOs dados informados foram: \n");
        for (indice = 0; indice<= 9; indice++){
            printf("codigo: %d peso:%.1f\n", codigo[indice], peso[indice]);
    }
    for(peso[10]= 0; peso[10]< 10; peso[10]++){
        if(peso[10]>maiorpeso){

            maiorpeso = peso[10];
            codigomaior = codigo[10];
        }
        if(peso[10]< menorpeso){
            menorpeso = peso[10];
            codigomenor = codigo[10];
        }
    }

    printf("maior peso = %f do boi %d\n", maiorpeso, codigomaior);
    printf("menor peso = %f do boi %d\n", menorpeso, codigomenor);


return 0;
}
