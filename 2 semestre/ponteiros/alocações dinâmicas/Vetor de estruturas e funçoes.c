#include<stdio.h>
#include<stdio.h>

struct aluno{
    char nome[80];
    char curso[60];
    int  anoIngresso;
    int  anoFormatura;
    };
void lerAluno(struct aluno *p){
    printf("nome: ");
    fflush(stdin);
    gets(p->nome);
    printf("curso: ");
    fflush(stdin);
    gets(p->curso);
    printf("ano do ingrsso: ");
    scanf("%d", &p->anoIngresso);
    printf("previão de formatura em: ");
    scanf("%d", &p->anoFormatura);
    return;
}
int main(){
    struct aluno a[3];
    int i;

    for(i=0; i<3; i++){
        lerAluno(&a[i]);
    }
    for(i=0; i<3; i++){
        printf("nome: %s\n", a[i].nome);
        printf("curso: %s\n", a[i].nome);
        printf("ano de ingresso: %s\n", a[i].anoIngresso);
        printf("previsao de formatura: %s\n", a[i].anoFormatura);
    }

    return 0;
}
