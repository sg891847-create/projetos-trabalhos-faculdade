#include <stdio.h>
int main() {

    int i, A[10];

    for(i=0;i<10;i++){

        scanf("%d", &A[i]);
    }

    printf("vetor digitado:\n");

    for(i=0;i<10;i++){

        printf("A[%d]=%d\n",i,A[i]);

    }
return 0;
}
