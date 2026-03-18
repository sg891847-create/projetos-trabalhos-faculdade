void funcao1(){
   printf("1");
   return;
}

void funcao2(){
    return;
    printf("%d",100);

}
void main(void){
    printf ("10");
    funcao1();
    printf ("20");
    funcao2();
    printf ("30");
    return;
}
