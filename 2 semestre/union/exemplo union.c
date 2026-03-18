#include <stdio.h>
#define Pi 3.14159

union angulo{

    float graus;
    float radianos;

};
int main() {
    union angulo ang;
    float AuxGrau;
    char op;

    printf("\nNumeros em graus (G) ou radianos (R)?");
    scanf("%c",&op);

    printf("digite o angulo: ");
    scanf("%f",&AuxGrau);

    if(op == 'G' || op == 'g'){
        printf("angulo digitado em graus%f\n", AuxGrau);
        ang.radianos = AuxGrau/180*Pi;
        printf("\nAngulo em radianos %f\n",ang.radianos);
        } else if (op == 'R' || op == 'R') {
                    printf("angulo digitadoem radianos %f\n",AuxGrau);
                    ang.graus = AuxGrau*180/Pi;
                    printf("\nAgulo em graus: %f\n",ang.graus);
                } else printf("\nEntrada individual!!\n");

return 0;
}
