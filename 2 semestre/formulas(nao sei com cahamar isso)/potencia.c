#include <stdio.h>

int potencia (int x, int y){

    if(y==0) return 1;
    else return x*potencia(x, y-1);
};

int main() {
    int a;

    a=potencia(2,8);


return 0;
}
