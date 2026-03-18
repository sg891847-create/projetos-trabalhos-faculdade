#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main() {
    int magic;
    int adv;

    srand(time(NULL));
    magic= rand()%10;

    printf("adivenhe o numero magico (de 0 a 10): ");
    scanf("%d", &adv);

    if (adv == magic)

        printf("voce acertou\n");
    else{

        printf ("voce errou\n");
        printf ("o numero magico eh: %d, magic", magic);


    }

return 0;
}
