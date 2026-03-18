#include <stdio.h>

int main() {
    int td, a, m, d;


    printf("Digite o período de tempo em dias: ");
    scanf("%d", &totalDias);


    a = td / 365;
    td %= 365;
    meses = td / 30;
    dias = td % 30;


    printf("O período de dias equivale a:\n", td);
    printf("d a,  m , a  d.\n", a, m, d);

    return 0;
}
