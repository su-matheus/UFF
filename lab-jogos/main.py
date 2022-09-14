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



velocidade_x = random.uniform(0.4, 0.7)#(a variação da velocidade da bola nesse eixo deve ser até  0.5)
velocidade_y = random.uniform(0.6, 1.3) #(a variação da velocidade da bola nesse eixo deve ser até 1)



#### posição do jogador ####
jogador_direita.x = janela_jogo.width - jogador_direita.width -15
jogador_direita.y = janela_jogo.height/2 - jogador_direita.height/2

jogador_esquerda.x = 15
jogador_esquerda.y = janela_jogo.height/2 - jogador_esquerda.height/2

velocidade_jogador_esquerda = 0.5
velocidade_jogador_direita = 0.5

teclado = Window.get_keyboard()


print(velocidade_y)
print(velocidade_x)

while (True):

    #### movimentação da bola ####
    if (bola.x > (janela_jogo.width-15)):
        velocidade_x *= -1

    if (bola.y > (janela_jogo.height-15)):
        velocidade_y *= -1

    if (bola.x < 0):
        velocidade_x *= -1

    if (bola.y < 0):
        velocidade_y *= -1

    

    #### movimentação do jogador direito ####

    if (teclado.key_pressed("UP") and jogador_direita.y >= 0):
        jogador_direita.move_y(-velocidade_jogador_direita)

    if (teclado.key_pressed("DOWN") and jogador_direita.y + jogador_direita.height <= janela_jogo.height):
        jogador_direita.move_y(velocidade_jogador_direita)




    #### movimentação do jogador esquerdo ####

    if (teclado.key_pressed("w") and jogador_esquerda.y >= 0):
        jogador_esquerda.move_y(-velocidade_jogador_esquerda)

    if (teclado.key_pressed("s") and jogador_esquerda.y + jogador_esquerda.height <= janela_jogo.height):
        jogador_esquerda.move_y(velocidade_jogador_esquerda)



    #### quando a bola tocar no jogador ####

    if (bola.collided(jogador_direita)):
        velocidade_x *= -1

    if (bola.collided(jogador_esquerda)):
        velocidade_x *= -1



    #### renderização do jogo ####
    imagem_fundo.draw()
    bola.x += velocidade_x
    bola.y += velocidade_y
    bola.draw()
    jogador_direita.draw()
    jogador_esquerda.draw()
    janela_jogo.update()


##sem o window_game.update() não é possível mostrar a imagem de fundo