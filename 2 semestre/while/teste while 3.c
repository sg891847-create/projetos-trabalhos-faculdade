#include<stdio.h>
int main() {

    float soma=0, media, nota;
    int i, n;
    printf("cauculo da media das notas em uma avaliacao \n\n");
    printf("quantos alunos realizaram a avaliacao");
    scanf("%d",&n);

    i=1;

    do{
        printf("digite a nota do aluno %d: ",i);
        scanf("%f", &nota);
        soma += nota ;
        i++;

    }while(i<=n);
    media = soma/n;
    printf("\nA mediafinal da turma eh %.2f\n", media);
return 0;
}
