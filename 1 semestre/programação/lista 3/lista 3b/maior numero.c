#include <stdio.h>
int main() {

 int n, x= -999999, i;

 printf("digite 5 numeros: ");

    for(i=1; i<=5; i++){
            scanf("%i", &n);
            if(n>x);
              x=n;
    }

        printf("maior numero = %i\n", x);

return 0;
}
