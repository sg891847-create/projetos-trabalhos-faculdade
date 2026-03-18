#include <stdio.h>
#include<locale.h>
int main(){

setlocale(LC_ALL,"portuguese");

int a, b, c;

printf("digite 3 valores distintos");

scanf ("%i%i%i",&a, &b, &c);

if (a!=b && b!=c &&a!=c){


 }else printf("os valores devem ser distintos!, seu animal");

    if(a>b && a>c)
            printf("maior valor =%i",a);



            if (b>a && b>c)

            printf("maior valor =%i",b);

 else{ printf("maior valor =%i",c);

 }


return 0;
}
