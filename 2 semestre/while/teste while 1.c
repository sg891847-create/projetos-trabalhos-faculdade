#include<stdio.h>
#include<ctype.h>
int main() {

    char ch = ' ';

    do{

    printf("%c\n", toupper(ch));
    scanf("%c", &ch);
    }while(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');



return 0;
}
