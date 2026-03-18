#include<stdio.h>
void imprime_letraMaiuscula(char *string);
void main(void){
char s[80];
gets(s);
imprime_letraMaiuscula(s);
}
void imprime_letraMaiuscula(char *string){
int i;
for(i=0;string[i];i++){
string[i]=toupper(string[i]);
putchar(string[i]);
}
}
