#include <stdio.h>

int main(){
    int number = 33;
    float floatNumber = 2.4;
    char letter = 'a';
    double doubleNumber = 2.4563473;

    printf("int = %i\n", sizeof(number));
    printf("float = %i\n", sizeof(floatNumber));
    printf("char = %i\n", sizeof(letter));
    printf("double = %i\n", sizeof(doubleNumber));
    //Dependendo do compilador pode ser necessário colocar %lu para representar o tamanho da variável e quer dizer long undefined int
    
    return 0;
};