#include <stdio.h>
int main() {
int x[5]={1, 2, 3, 4, 5};
int *p, i;
p = x;
for(i=0; i<5; i++){
    printf("%d", x[i]);
}
printf("\n");
for(i=0; i<5; i++){
    printf("%d",*(p+i));
}
return 0;
}
