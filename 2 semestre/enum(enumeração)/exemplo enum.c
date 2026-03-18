#include <stdio.h>

int main (void) {
     enum estacoes {primavera, verao, outono, inverno };
     enum estacoes est_ano;

     est_ano = inverno;
     printf ("%d",est_ano);
     if (est_ano==2){
                     printf("outono");
                     }
     if (outono>verao){
        printf ("Frio");
     } else prinft("Quente");

     return 0;
}
