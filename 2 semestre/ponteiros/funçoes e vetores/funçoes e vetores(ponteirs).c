#include <stdio.h>

void lervetor(int *p){
    int i;
    for(i=0; i<5; i++){
        scanf("%d",p++);
    }
return;
};
void mostrarvetor(int *p){
    int i;
    for(i=0; i<5; i++){
        scanf("%d\t",*(p+i));
    }
return;
}
void somarvetores(int *pa, int *pb, int *pc){
    int i;
    for(i=0; i<5; i++){
       *(pc+i)= *(pa+i) + *(pb+i);
    }
return;
}
int main() {

    int a[5], b[5], c[5];
    lervetor(a);
    printf("vetor b:\n");
    lervetor(b);
    somarvetores(a, b, c);
    printf("vetor a digitado:");
    mostrarvetor(a);
    printf("vetor b digitado:");
    mostrarvetor(b);
return 0;
}
