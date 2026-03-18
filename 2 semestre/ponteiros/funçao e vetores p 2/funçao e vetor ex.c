#include<stdio.h>
void f1(float vet[]);
void f2(float *v);
int main(void){
float x[2]={3, 4};
int i;
printf("Na main, antes das funcoes:\n x[0] = %f, x[1] = %f\n", x[0], x[1]);
f1(x);
printf("Na main, apos f1:\n x[0] = %f, x[1] = %f\n", x[0], x[1]);
f2(x);
printf("Na main, apos f2:\n x[0] = %f, x[1] = %f\n", x[0], x[1]);
system("pause");
return 1;
}
void f1(float vet[]){
vet[0]=10;
vet[1]=20;
printf("Em f1:\n vet[0] = %f, vet[1] = %f\n", vet[0], vet[1]);
}
void f2(float *v){
v[0]=1;
v[1]=2;
printf("Em f2:\n v[0] = %f, v[1] = %f\n", v[0], v[1]);
}
