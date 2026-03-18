#include <stdio.h>
int main() {
    int i;
    printf("tabela ASCII\n");
    for (i=33;i<255;i++){
        printf("decimal: %i  octal: %o  hexagonal:  %x  charactere: %c \n",i ,i ,i ,i);
    }
    getchar();
return 0;
}
