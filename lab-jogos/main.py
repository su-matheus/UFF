from PPlay.window import *
from PPlay.gameimage import *
from PPlay.sprite import *

#### setting window and background image ####
janela_jogo = Window(880,520)
janela_jogo.set_title("Pong")
imagem_fundo = GameImage("galaxy.jpg")



#### elements of the game ####
jogador_direita = Sprite("right_player.png", 1)
jogador_esquerda = Sprite("left_player.png", 1)
bola = Sprite("ball.png", 1)


#### posição da bola ####
bola.x = janela_jogo.width/2 - bola.width/2
bola.y = janela_jogo.height/2 - bola.height/2

velocidade_x = 0.25
velocidade_y = 0.25

#### player position ####
jogador_direita.x = janela_jogo.width - jogador_direita.width -15
jogador_direita.y = janela_jogo.height/2 - jogador_direita.height/2

jogador_esquerda.x = 15
jogador_esquerda.y = janela_jogo.height/2 - jogador_esquerda.height/2

while (True):

    if (bola.x > (janela_jogo.width-15)):
        velocidade_x *= -1

    if (bola.y > (janela_jogo.height-15)):
        velocidade_y *= -1

    if (bola.x < 0):
        velocidade_x *= -1

    if (bola.y < 0):
        velocidade_y *= -1

    imagem_fundo.draw()
    bola.x += velocidade_x
    bola.y += velocidade_y
    bola.draw()
    jogador_direita.draw()
    jogador_esquerda.draw()
    janela_jogo.update()


##sem o window_game.update() não é possível mostrar a imagem de fundo