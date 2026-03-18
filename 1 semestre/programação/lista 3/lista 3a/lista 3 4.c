#include <stdio.h>
int main() {

 int n,qP=0, qI=0;

 printf("digite um numero:");
 scanf("%i",&n);


 while(n!=0){

    if(n%2 == 0)
        qP++;
     else
        qI++;

 printf("digite um numero:");
 scanf("%i",&n);
    }

 printf("foram digitados %d pares e %i impares",qP, qI);

return 0;
}
