#include <stdio.h>
int main() {

 float X, Y, SF;
 int   TC, TV, V;

 printf("indique codigo do vendedor: ");

  scanf("%f",&V);

 printf("indique valor do X (salario fixo): ");

 scanf("%f",&X);

 printf("indique valor de Y (comissao): ");

 scanf("%f",&Y);

 printf("indique valor de TC (total carros vendidos): ");

 scanf("%f",&TC );

 printf("indique valor do TV (total de vendas): ");

 scanf("%f",&TV );

 SF = X + (TC * Y) + (TV*0.04);

 printf("R=%f\n",SF);
 printf("R=%f\n",V);




return 0;
}
