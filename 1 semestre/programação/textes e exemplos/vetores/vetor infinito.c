#include <stdio.h>
#include <stdlib.h>
int main() {

    int a[80], i;

    for(i=0; i<80; i++){
        a[i]=rand()%100;
        printf("%i\t",a[i]);

    }

return 0;
}
