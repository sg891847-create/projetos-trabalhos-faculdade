#include <stdio.h>
int main() {
    char s[30], *ps, *pf, aux;
    pf= ps= s;
    printf("digite uma palavral:");
    scanf("%s",ps);
    for( ; *pf!='\0'; pf++);
    pf--;
    for( ; ps<pf; ps++, pf--){
            aux=*ps;
            *ps=pf;
            *pf=aux;
    }
    printf("%s",s);
return 0;
}
