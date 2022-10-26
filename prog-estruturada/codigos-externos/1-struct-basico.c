#include <stdio.h>


struct horario {
    int horas;
    int minutos;
    int segundos;
};
//tudo dentro do colchetes é somente uma definição da estrutura, somente isso não quer dizer que criou de fato a estrutura

int main () {
    
    struct horario agora;//aqui eu declaro o tipo struct horario e seu nome é "agora", esse "agora" é uma nova estrutura

    agora.horas = 18;
    agora.minutos = 34;
    agora.segundos = 30;

    printf("%d %d %d\n", agora.horas, agora.minutos, agora.segundos);
    
    return 0;
}