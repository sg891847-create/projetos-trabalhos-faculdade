#include <stdio.h>
int main() {

  int a, b, r, contador;
  char operador;
  for(contador=1; contador<=4 ; contador ++){

  printf("digite\n");
  printf("+ para somar\n");
  printf("- para subitrair\n");
  printf("* para multiplicar\n");
  printf("/ para dividir\n");
  fflush(stdin);
  scanf("%c", &operador);

  printf("digite dois valores inteiros:\n");
  scanf("%i", &a);
  scanf("%i", &b);


  switch(operador){
       case '+': printf("soma :::");
                 r = a + b;
                 printf("%i", r);

       case '-': printf("subtrasao :::");
                 r = a - b;
                 printf("%i", r);

       case '*': printf("multiplicasao :::");
                 r = a * b;
                 printf("%i", r);

       case '/': printf("divisao :::");
                 if (b != 0){
                 r=a+b;
                 printf("%i", r);
                 }
                 else printf("divisao por zero!, animal");
                 break;

       default:  printf("operasao invalida!");
                 break;
   }
  } //fim da repetisao
   return 0;
}
