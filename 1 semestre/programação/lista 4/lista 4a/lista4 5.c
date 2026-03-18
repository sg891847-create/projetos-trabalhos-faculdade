#include <stdio.h>
int main() {

    int a[20], i, b[20];

    printf("digite os 20 elementos:\n");
    for(i=0; i<20; i++){
        scanf("%d",&a[i]);

    }
    i=0;
    while(i<20){
        if(a[i]!=0)
            b[i]=2;
        i++;
        }
        printf("vetor resultado:");
        for(i=0; i<20; i++)
            printf("%d\t", b[i]);
return 0;
}
