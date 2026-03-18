#include <stdio.h>
int main() {

 int s=0;
 int x,i;
 float media;

 for(i=1; i<=5; i++){

 scanf("%d",&x);
 s+=x;
}

media= s/5;
printf("media= %f",media);

return 0;
}
