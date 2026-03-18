#include <stdio.h>
int main() {
int i=100;
int *p1, *p2;

p1 = &i;
p2 = p1;

printf("%p %p", p2, p1);
return 0;
}
