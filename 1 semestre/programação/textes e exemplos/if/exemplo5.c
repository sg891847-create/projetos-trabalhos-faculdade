#include <stdio.h>
int main() {

char letra;

printf("digite uma letra: ");

scanf("%c",&letra);


           if(!(letra=='a' || letra=='e' || letra=='i' || letra=='o' || letra=='u')){

                  printf("econsoante!, seu idiota");


            }else

                 printf("e vogal!, seu idiota ");



return 0;
}
