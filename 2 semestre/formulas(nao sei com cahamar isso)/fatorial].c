#include <stdio.h>

unsigned int fatorial(unsigned int n){
    int i;
    unsigned int f=1;
    for(i = 1; i <= n; i++){
        f = f * i;
    }
    return f;
};

int main() {
    unsigned int d;

    printf("incira o numero para fatorar:\n");

    scanf("%i",&d);

    printf("o fatorial de %i = %i\n", d, fatorial(d));

return 0;
}
