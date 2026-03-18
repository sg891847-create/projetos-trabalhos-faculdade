#include <stdio.h>
int main() {


 float A, L, T, C, M, S, AL, V, TN, SE, Smae, Spai, Sf;

  printf("indique valor da alimentasao (A): ");

  scanf("%f",&A );


  printf("indique valor da luz (L): ");

  scanf("%f",&L );


  printf("indique valor do telefone (T): ");

  scanf("%f",&T );


  printf("indique valor do condominio (C): ");

  scanf("%f",&C );


  printf("indique valor da mensalidade (M): ");

  scanf("%f",&M );


  printf("indique valor de saude (S): ");

  scanf("%f",&S );


  printf("indique valor da alimentasao (AL): ");

  scanf("%f",&AL );


  printf("indique valor vestuario (V): ");

  scanf("%f",&V );


  printf("indique valor do transporte (TN): ");

  scanf("%f",&TN );


  printf("indique valor seguransa (SE): ");

  scanf("%f",&SE );


  printf("indique valor do salario da mae (Smae): ");

  scanf("%f",&Smae );


  printf("indique valor do salario do pai (Spai): ");

  scanf("%f",&Spai );

       Sf=(Smae+Spai)-(A+L+T+C+M+S+AL+V+TN+SE);

       printf("R=%f\n",Sf);





return 0;
}
