#include <stdio.h>
int main() {

float sm;
float IRreais, IRprc;

    printf("salario:");
    scanf("%f",&sm);

if (sm <= 1566.61){

     IRreais = 0;
     IRprc = 0;

        }else if (sm <= 2375.85){

               IRreais = sm * 0.075;
               IRprc = 7.5;

                }else if (sm <= 3130.51){

                     IRreais = sm * 15.0;
                     IRprc = 15.0;

                        } else if (sm <= 3911.63){

                              IRreais = sm * 22.5;
                              IRprc =  22.5;

                           } else if (sm < 3911.64){

                                IRreais = sm * 27.5;
                                IRprc =  27.5;

                           }
                                  printf("sua aliquota e de: R$ %f\n",IRprc);
                                  printf("voce de pagar: R$ %f\n",IRreais);
return 0;
}
