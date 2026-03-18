#include <stdio.h>

void derivada(int grau, double coeficientes[], double coeficientes_derivada[]) {
    for (int i = 0; i < grau; i++) {
        coeficientes_derivada[i] = coeficientes[i] * (grau - i);
    }
}

void exibir_polinomio(int grau, double coeficientes[]) {
    for (int i = 0; i <= grau; i++) {
        if (coeficientes[i] != 0) {
            if (i < grau) {
                printf("%.1fx^%d ", coeficientes[i], grau - i);
                if (coeficientes[i + 1] != 0) {
                    printf("+ ");
                }
            } else {
                printf("%.1f ", coeficientes[i]);
            }
        }
    }
}

int main() {
    int grau;

    printf("Digite o grau do polinômio: ");
    scanf("%d", &grau);

    double coeficientes[grau + 1];
    for (int i = 0; i <= grau; i++) {
        printf("Digite o coeficiente de x^%d: ", grau - i);
        scanf("%lf", &coeficientes[i]);
    }

    printf("\nPolinômio: ");
    exibir_polinomio(grau, coeficientes);

    double coeficientes_derivada[grau];
    derivada(grau, coeficientes, coeficientes_derivada);

    printf("\nDerivada: ");
    exibir_polinomio(grau - 1, coeficientes_derivada);

    return 0;
}
