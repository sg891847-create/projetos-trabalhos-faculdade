#include <stdio.h>
#include <stdlib.h>

/**
 * código exemplo para tratar um MENU de opções
 */
int main() {
    int opcao;
    do {
        system("cls");
        printf("MENU PRINCIPAL\n");
        printf("1 - Popular vetor com numeros aleatorios\n");
        printf("2 - Listar vetor populado\n");
        printf("3 - Sair\n");
        printf("Opcao: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                printf("Populando o vetor com numeros aleatorios\n");
                break;
            case 2:
                printf("Listando o vetor com numeros aleatorios\n");
                break;
            case 3:
                printf("Sistema encerrado\n");
                break;
            default:
                printf("Opcao invalida. Redigite\n");
                break;
        }
        system("pause");
    } while (opcao != 3);

    return 1;
}