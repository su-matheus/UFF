from PPlay.window import *
from PPlay.keyboard import *
from display import menu, play, difficulty, ranking

import globals as glb

window_game = Window(glb.GAME_WIDTH, glb.GAME_HEIGHT)
window_game.set_title(glb.GAME_TITLE)

menu_page = menu.Menu(window_game)
play_page = play.Play(window_game)
difficulty_page = difficulty.Difficulty(window_game)
##ranking_page = ranking.Rankiwng(window_game)

user_input = keyboard.Keyboard()
current_game = 0##por padrão nada será mostrado na tela

while (glb.GAME_SCREEN > 0 and glb.GAME_SCREEN < 5):##será quase sempre verdadeiro
    window_game.set_background_color(glb.GAME_BACKGROUND_COLOR)


    #if currGme == 0 and glb.GAME_SCREEN == 3:
        #currGme = 3
        #ranking_page = ranking.Ranking(window_game)
    #elif currGme == 3 and glb.GAME_SCREEN != 3:
        #currGme = 0

    if (glb.GAME_SCREEN == 1):
        menu_page.update()

    if (glb.GAME_SCREEN == 2):
        play_page.update()
    
    if (glb.GAME_SCREEN == 3):
        difficulty_page.update()
        
    #if (current_game == 4):
        #ranking_page.update()

    if (user_input.key_pressed("ESC")):
        glb.GAME_SCREEN = 1

    print(glb.GAME_SCREEN)

    play_page.move_player()
    window_game.update()

## Não é necessário usar posição do mouse aqui pois a tela de menu é a primeira a ser renderizada e na página de menu eu já utilizo as opções de mouse. Mesma coisa acontece na página de dificuldade