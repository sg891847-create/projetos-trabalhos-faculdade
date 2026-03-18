#include <stdio.h>
#include <math.h>
int main(){
float A, B, C, X1, X2, delta;

printf("calculo de raizes do 2 grau\n");

printf("informe os valores de A, B, C:\n");

scanf("%f%f%f",&A, &B, &C);

delta= (B*B)-(4*A*C);

X1 = (-B+sqrt(delta))/(2*A);

X2 = (-B-sqrt(delta))/(2*A);

printf("raizez:\n");

printf("X1= %f\n",X1);

printf("X2=%f\n",X2);












return 0;
}
