#include <stdio.h>
#include <string.h>
int main() {

    int a[4] = {10, 20, 30, 40};

    char b[4] = {'a', 'b', 'c', '\0'};

    char nome[40];

    int i;

    for(i=0;i<4;i++){
    printf("%d\t", a[i]);

    }

    printf("\m%s", b);

    printf("incira seu nome");

    gets(nome);

    printf ("sue nome e %s \n", nome);

    puts(nome);
return 0;
}
