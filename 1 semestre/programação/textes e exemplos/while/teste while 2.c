#include<stdio.h>
int main() {

    float nota;
    int qtde = 0;

    do{

    printf("digite a nota");
    scanf("%f", &nota);
    qtde++;
    }while (nota > 0);

     printf("\nA quantidadede notas digitadas eh %d\n", qtde-1);


return 0;
}
