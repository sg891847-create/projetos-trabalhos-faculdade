#include <stdio.h>
int main() {

float V, B;


 printf ("valor das vendas");
 scanf ("&f,&V");

if(V <= 900){
    B=V*0.05;

     printf ("bonus 5%% = R$ %f\n",B);

} else if (V < 1400){
         B=V*0.08;

           printf ("bonus 8%% = R$ %f\n",B);

       } else {
             B=V*0.1;

               printf ("bonus 10%% = R$ %f\n",B);
}

 printf("quantidade de vendas = R$ %f\n",V);

return 0;
}
