from PPlay.window import *
from PPlay.mouse import *
from PPlay.gameimage import *

import globals as gbl

class Menu(object):
    def __init__(self, window_game):
        self.window_game = window_game
        self.window_game.set_title("Menu")
        self.bg_image = GameImage("./assets/background-image-menu.jpg")

        self.play_btn = GameImage("./assets/Play.png")
        self.play_btn.set_position(gbl.GAME_WIDTH/2 - self.play_btn.width/2 , gbl.GAME_HEIGHT/4)

        self.difficulty_btn = GameImage("./assets/Difficulty.png")
        self.difficulty_btn.set_position(gbl.GAME_WIDTH/2 - self.difficulty_btn.width/2 , gbl.GAME_HEIGHT/4 + 60)

        self.ranking_btn = GameImage("./assets/Ranking.png")
        self.ranking_btn.set_position(gbl.GAME_WIDTH/2 - self.difficulty_btn.width/2 , gbl.GAME_HEIGHT/4 + 120)

        self.exit_btn = GameImage("./assets/Exit.png")
        self.exit_btn.set_position(gbl.GAME_WIDTH/2 - self.difficulty_btn.width/2 , gbl.GAME_HEIGHT/4 + 180)


        self.mouse = mouse.Mouse()
        


        pass

    def update(self):
        self.bg_image.draw()
        self.play_btn.draw()
        self.difficulty_btn.draw()    
        self.ranking_btn.draw()
        self.exit_btn.draw()


        if (self.mouse.is_over_object(self.play_btn)):
            ##efeito de luz no botão
            if (self.mouse.is_button_pressed(1)):
                gbl.GAME_SCREEN = 2
            
        if (self.mouse.is_over_object(self.difficulty_btn)):
            ##efeito de luz no botão
            if (self.mouse.is_button_pressed(1)):
                gbl.GAME_SCREEN = 3

        if (self.mouse.is_over_object(self.ranking_btn)):
            ##efeito de luz no botão
            if (self.mouse.is_button_pressed(1)):
                gbl.GAME_SCREEN = 4

        if (self.mouse.is_over_object(self.exit_btn)):
            ##efeito de luz no botão
            if (self.mouse.is_button_pressed(1)):
                gbl.GAME_SCREEN = 5
                
        pass