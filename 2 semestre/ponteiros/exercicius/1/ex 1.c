#include <stdio.h>
int main() {
int x, y;
int *p1, *p2, *p3;

p1 = &x;
p2 = &y;
scanf("%f%f",&x ,&y);
*p3 = (*p1 + *p2)/2;


printf("media eh %f\n", p3);
return 0;
}
