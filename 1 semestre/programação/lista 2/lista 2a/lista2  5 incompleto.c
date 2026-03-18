#include <stdio.h>
int main() {

    int a, b;
    printf("informe dois valores inteiros:");
    scanf("%d%d, &a, &b");

    if(a%b==1){

       printf("%d+%d+1=%d", a, b, a+b+1)

   } }else{

          if (a%b==2){

            if (a%2==0){
               printf("%d e par\n", a);

            }else{
                 printf("%d e impar\n", a);

            }
            if (b%2==0){
               printf("%d e par\n", b);

            }else{
                 printf("%d e impar\n", b);

            }
          }else{

               if (a%b==2){
                    printf("soma = %d soma*%d= %d\n", (a+b), a, (a+b)*a);

              }else{




return 0;
}
