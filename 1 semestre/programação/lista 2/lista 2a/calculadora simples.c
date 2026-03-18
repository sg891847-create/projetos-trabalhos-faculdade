#include <stdio.h>
int main() {

    float a, b, r;
    int opcao;


    printf("informe dois valores\n");
    scanf("%f%f", &a, &b);
    printf("escolha a opcao:\n");
    printf("1 adicao\n");
    printf("2 subtracao\n");
    printf("3 multiplicacao\n");
    printf("4 divicao\n");
    scanf("%d", &opcao);

        if (opcao == 1){
            printf("***SOMA***\n");
            r=a+b;
            printf("%f+%f = %f\n", a, b, r);
        }else{
                if(opcao == 2){
                   printf("***SUBITRACAO***\n");
                   r=a-b;
                   printf("%f-%f = %f\n", a, b, r);
                }else{
                        if(opcao == 3){
                          printf("***MULTIPLICACAO***\n");
                          r=a*b;
                          printf("%f*%f = %f\n", a, b, r);
                        }else{
                            if(opcao == 4){
                               printf("***DIVISAO***\n");
                               if(b == 0){
                                    printf("divisao por zero\n");
                               }else{
                                     r=a/b;
                                     printf("%f/%f = %f\n", a, b, r);
                                }
                            }else printf ("opcao invalida");
                        }
                }
        }
return 0;
}
