#include <stdio.h>
int main() {
int x, y, *p1, *p2;
x=10;
p1=&x;
y=*p1 * 2;
printf("%d,%d,%d\n", x, *p1, y);
p2=&x;
*p2=30;
printf("%d,%d,%d\n", x, *p1, y);
return 0;
}
