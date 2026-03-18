#include <stdio.h>
int main() {

    int codigo[10], indice;
    float peso[10];

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
return 0;
}
