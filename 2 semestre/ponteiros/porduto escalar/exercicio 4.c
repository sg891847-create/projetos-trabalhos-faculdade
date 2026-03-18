#include <stdio.h>
int main() {
    int a[4]={1, 2, 3, 4};
    int b[4]={10, 20, 30, 40};
    int *pa, *pb, i, pe=0;

    pa=&a[0];
    pb=&b[0];
    for(i=0; i<5; i++){
        //pe = pe + (*(pa+i)* *(pb+i)):
        pe += *(pa+i)* *(pb+i);

    }
    printf("produto ecalar= %d", pe);
return 0;
}
