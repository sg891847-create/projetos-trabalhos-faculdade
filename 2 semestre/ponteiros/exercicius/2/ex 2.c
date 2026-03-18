#include <stdio.h>
int main() {
int x[5]={1,2,3,4,5};
int y[5]={10, 20, 30, 40, 50};
int soma[5], *px, *py, *psoma, i;
px = x; //px=&[0];
py = y;
psoma = soma;
for(i=0; i<5; i++){
    //soma[i]= x[i]+y[i];
    *(psoma+i)= *(px+i)+(py+i);
    printf("soma[%d]=%d\n", i, *(soma+i));
}
return 0;
}
