#include <stdio.h>
int main() {

  int fat=1, i, n;

 printf("fatorial\n");
 printf("numero:");
 scanf("%i",&n);

    for(i=1;i<=n;i++){

        fat=fat*i;
        }

        printf("%i!=%i",n,fat);
return 0;
}
