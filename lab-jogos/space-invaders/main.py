from PPlay.window import *
from PPlay.gameimage import *
from PPlay.sprite import *

#### configuração inicial ####
janela_lar = 615
janela_alt = 412
janela = Window(janela_lar, janela_alt)
janela.set_title("Space Invaders")
imagem_fundo = GameImage("./assets/background-image-menu.jpg")

botao_play = GameImage("./assets/Play.png")
botao_play.set_position(janela_lar/2 - botao_play.width/2 , janela_alt/4)

botao_dificuldade = GameImage("./assets/Difficulty.png")
botao_dificuldade.set_position(janela_lar/2 - botao_dificuldade.width/2 , janela_alt/4 + 60)

botao_ranking = GameImage("./assets/Ranking.png")
botao_ranking.set_position(janela_lar/2 - botao_dificuldade.width/2 , janela_alt/4 + 120)

botao_exit = GameImage("./assets/Exit.png")
botao_exit.set_position(janela_lar/2 - botao_dificuldade.width/2 , janela_alt/4 + 180)



while (True):
    imagem_fundo.draw()
    botao_play.draw()
    botao_dificuldade.draw()    
    botao_ranking.draw()
    botao_exit.draw()
    janela.update()