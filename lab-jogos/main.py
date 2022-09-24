import random

from PPlay.window import *
from PPlay.gameimage import *
from PPlay.sprite import *

#### configurando janela e imagem de fundo ####
janela_jogo = Window(880,520)
janela_jogo.set_title("Pong")
imagem_fundo = GameImage("galaxy.jpg")



#### elementos do jogo ####
jogador_direita = Sprite("right_player.png", 1)
jogador_esquerda = Sprite("left_player.png", 1)
bola = Sprite("ball.png", 1)


#### posição da bola ####
bola.x = janela_jogo.width/2 - bola.width/2
bola.y = janela_jogo.height/2 - bola.height/2



#velocidade_bola_x = random.uniform(0.4, 0.7) #(a variação da velocidade da bola nesse eixo deve ser até  0.5)
#velocidade_bola_y = random.uniform(0.6, 1.3) #(a variação da velocidade da bola nesse eixo deve ser até 1)

velocidade_bola_x = random.uniform(0.6, 0.8)
velocidade_bola_y = random.uniform(0.6, 1.2)
velocidade_segunda_bola_x = random.uniform(0.6, 0.8)
velocidade_segunda_bola_y = random.uniform(0.6, 1.2)


#### posição do jogador ####
jogador_direita.x = janela_jogo.width - jogador_direita.width -20
jogador_direita.y = janela_jogo.height/2 - jogador_direita.height/2

jogador_esquerda.x = 20
jogador_esquerda.y = janela_jogo.height/2 - jogador_esquerda.height/2

velocidade_jogador_esquerda = 300
velocidade_jogador_direita = 300

teclado = Window.get_keyboard()


#### pontuação ####
placar_direito = 0
placar_esquerdo = 0


print("velocidade da bola em y: {}".format(velocidade_bola_y))
print("velocidade da bola em x: {}".format(velocidade_bola_x))


while (True):

    #### movimentação da bola principal ####
    bola.x += velocidade_bola_x * janela_jogo.delta_time()
    bola.y += velocidade_bola_y * janela_jogo.delta_time()


    if (bola.x > (janela_jogo.width-15)):
        velocidade_bola_x *= -1

    if (bola.y > (janela_jogo.height-15)):
        velocidade_bola_y *= -1

    if (bola.x < 0):
        velocidade_bola_x *= -1

    if (bola.y < 0):
        velocidade_bola_y *= -1

    

    #### movimentação do jogador direito ####

    if (teclado.key_pressed("UP") and jogador_direita.y >= 0):
        jogador_direita.y = jogador_direita.y - velocidade_jogador_direita*janela_jogo.delta_time()

    if (teclado.key_pressed("DOWN") and jogador_direita.y + jogador_direita.height <= janela_jogo.height):
        jogador_direita.y = jogador_direita.y + velocidade_jogador_direita*janela_jogo.delta_time()



    #### movimentação da IA ####

    if (bola.y > jogador_esquerda.y):
        if (jogador_esquerda.y <= janela_jogo.height -jogador_esquerda.height):
            jogador_esquerda.y = jogador_esquerda.y + velocidade_jogador_esquerda * janela_jogo.delta_time()

    if (bola.y < jogador_esquerda.y):
        if (jogador_esquerda.y >= 0):
            jogador_esquerda.y = jogador_esquerda.y - velocidade_jogador_esquerda * janela_jogo.delta_time()



    #### quando a bola tocar no jogador ####

    if (bola.collided(jogador_direita) and velocidade_bola_x > 0):
        velocidade_bola_x *= -1

    if (bola.collided(jogador_esquerda) and velocidade_bola_x < 0):
        velocidade_bola_x *= -1


    #### quando alguém pontuar ####

    if (bola.x <= 0):
        bola.x = janela_jogo.width/2 - bola.width/2
        bola.y = janela_jogo.height/2 - bola.height/2
        placar_direito += 1

        velocidade_bola_x = random.uniform(0.6, 0.8)
        velocidade_bola_y = random.uniform(0.6, 1.2)

        print("velocidade da bola em y: {}".format(velocidade_bola_y))
        print("velocidade da bola em x: {}".format(velocidade_bola_x))

    if ((bola.x + bola.width) > janela_jogo.width):
        bola.x = janela_jogo.width/2 - bola.width/2
        bola.y = janela_jogo.height/2 - bola.height/2
        placar_esquerdo += 1
        
        velocidade_bola_x = random.uniform(0.6, 0.8)
        velocidade_bola_y = random.uniform(0.6, 1.2)

        print("velocidade da bola em y: {}".format(velocidade_bola_y))
        print("velocidade da bola em x: {}".format(velocidade_bola_x))



    #### renderização do jogo ####
    imagem_fundo.draw()
    bola.x += velocidade_bola_x
    bola.y += velocidade_bola_y
    bola.draw()
    jogador_direita.draw()
    jogador_esquerda.draw()
    janela_jogo.draw_text("Score Player One: " + str(placar_esquerdo), janela_jogo.width/16, 25, size=24, color=("green"), font_name="Verdana", bold=False, italic=True)
    janela_jogo.draw_text("Score Player Two: " + str(placar_direito), janela_jogo.width - (janela_jogo.width/3), 25, size=24, color=("green"), font_name="Verdana", bold=False, italic=True)
    janela_jogo.update()


##sem o janela_jogo.update() não é possível mostrar a imagem de fundo