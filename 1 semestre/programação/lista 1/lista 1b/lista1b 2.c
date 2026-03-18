#include <stdio.h>
#include <math.h>
int main(){
float X, Y, R;

printf("indique valor x: ");

scanf("%f",&X );

printf("indique valor y: ");

scanf("%f",&Y );

R = sqrt(X*Y)+(X*Y/2*X)+(pow(3,2))+(pow(X,2)/4);

printf("R=%f\n",R);









return 0;
}
