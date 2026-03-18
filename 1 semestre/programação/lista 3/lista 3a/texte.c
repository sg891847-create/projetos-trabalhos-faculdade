#include <stdio.h>
#include <ctype.h>
int main() {

    char ch = ' ';

    while(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
            printf("%c\n", toupper(ch));
            scanf(" %c",&ch);
    }
return 0;
}
