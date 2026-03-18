#include <stdio.h>
int main() {

    int a[8], b[8], i;

    printf("digite os 8 elementos do primeiro vetor:\n");
    for(i=0; i<8; i++){
        scanf("%d",&a[i]);

    }
    i=0;
    while(i<8){
        if(a[i]!=0)
            b[i]=2;
        i++;
        }
    printf("digite os 8 elementos do segundo vetor:\n");
    for(i=0; i<8; i++){
        scanf("%d",&b[i]);

    }
    i=0;
    while(i<8){
        if(b[i]!=0)
            a[i]=2;
        i++;
        }

return 0;
}
