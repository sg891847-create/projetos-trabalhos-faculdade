#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main() {
    char nome[40];
    int i=0;

    printf("incira seu nome:");

    gets(nome);

    printf ("sue nome e %s \n", nome);

    puts(nome);

    printf("nome na vertical:\n");

    for(i=0; nome[i]!='\0'; i++){

        printf("%c\n", nome[i]);
    }
    printf("tamanho do nome%d\n",i);

    printf("  nome:%d\n",strlen(nome));

    printf("numero de vogais%d\n",i);
    printf("  nome:%d\n",strlen(nome));

    for(i=0; nome[i]!='\0'; i++){
        if(nome[i]== ' ')
              nome[i]='\0';
    }

    for( i=0; nome[i]; i++ ){
        if(toupper(nome[i])=='A'||toupper=='E'||toupper(nome[i])=='I'||toupper=='O'||toupper(nome[i])=='U'){

                    nome[i]='*';
        }
    }

puts(nome);
return 0;
}
