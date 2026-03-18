#include <stdio.h>
#include <string.h>
#define tamanho 4
struct TipoAluno{

    char matricula[11];
    char nome[30];
    int anoingresso;
    float mediavestibular};

int main() {

    struct TipoAluno a[tamanho];
    int i;
    printf("nome do aluno:");
        for(i = 0; i<tamanho; i++){
        gets(a[i].nome);
    printf("ano do ingresso:%f\n", a[i].anoingresso);
        scanf("%d",&a[i].anoingresso);
    printf("media vestibular:%f\n", a[i].mediavestibular);
           }
                 for(i = 0; i<tamanho; i++){
                    puts(a[i].nome);
                 }


return 0;
}
