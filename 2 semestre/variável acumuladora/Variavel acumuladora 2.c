#include <stdio.h>
int main() {

    int x;
    float media, nota, soma = 0;
    printf("digite a nota de cada aluno: \n");

    for (x = 1; x <= 5; x++){
           printf("aluno %d: ", x);
           scanf("%f", &nota);

           soma += nota; //soma + soma = nota;
    }
    media = soma/5;
    printf("a media da turma = %1.f\n", media);
return 0;
}
