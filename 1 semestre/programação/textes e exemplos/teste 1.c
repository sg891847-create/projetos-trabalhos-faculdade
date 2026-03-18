#include <stdio.h>
int main() {

int A, B;
float C, D;

A = 3;
B = A * 3;
C = B / 2;
D = A + C;
D = C - (D/2) + C * D;
C = A % 2;
C = C +D;

printf("C = %f\n", C);

return 0;
}
