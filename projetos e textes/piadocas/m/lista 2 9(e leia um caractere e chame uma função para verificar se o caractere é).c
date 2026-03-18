#include <stdio.h>
int vogal(char letra) {
    if(toupper(letra)=='A'||
       toupper(letra)=='E'||
       toupper(letra)=='I'||
       toupper(letra)=='O'||
       toupper(letra)=='U')
            return 1;
        else
             if(toupper(letra)=='M')
                return 2;
return 0;
}
int main() {
    char c;
    printf("digite uma letra:");
    scanf("%c",&c);
    if(vogal(c)==1)
        printf("eh vogal!, seu animal!");
    if(vogal(c)==2)
        printf("me mama");
    else
        printf("nao eh vogal, seu animal!");
return 0;
}

