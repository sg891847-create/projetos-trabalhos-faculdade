#include <stdio.h>
int main() {
    int i, idade, quantidade = 0;


    for (i = 1; i<=5; i++){
        printf("idade aluno %d", i);
        scanf("%d", &idade);

            if(idade >= 18){
                quantidade = quantidade + 1;
                //quantidade++;
            }

        }
        printf("ha %d aluno(s) com maioridade\n", quantidade);

return 0;
}
