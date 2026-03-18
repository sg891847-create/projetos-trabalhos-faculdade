#include <stdio.h>
int main() {
    int flag = 1;
    char s[30], *ps, *pf;
    pf= ps= s;
    printf("digite uma palavral:");
    scanf("%s",s);
    for(  ; *pf!='\0'; pf++);
    pf--;
    for(  ; ps<pf; ps++, pf--){
            if(*ps!=*pf) flag = 0;
            }

            printf("%s ",s);

   if(flag==1)

        printf("eh um palindromo\n");

    else

        printf("nao um eh palindromo\n");

return 0;
}
