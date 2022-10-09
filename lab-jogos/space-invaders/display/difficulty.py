from PPlay.window import *
from PPlay.gameimage import *
from PPlay.sprite import *

import globals as glb

class Difficulty(object):
    def __init__(self, window_game):
        self.window_game = window_game
        self.window_game.set_title("Dificuldade do jogo")
        
        self.bg_image = GameImage("./assets/background-image-menu.jpg")

        self.easy_btn = Sprite("./assets/facil.png")
        self.easy_btn.set_position(glb.GAME_WIDTH/2 - self.easy_btn.width/2, glb.GAME_HEIGHT/4 + 60)

        self.normal_btn = GameImage("./assets/medio.png")
        self.normal_btn.set_position(glb.GAME_WIDTH/2 - self.normal_btn.width/2, glb.GAME_HEIGHT/4 + 120)

        self.hard_btn = GameImage("./assets/dificil.png")
        self.hard_btn.set_position(glb.GAME_WIDTH/2 - self.hard_btn.width/2, glb.GAME_HEIGHT/4 + 180)


    def update(self):
        self.bg_image.draw()

        self.easy_btn.draw()
        self.normal_btn.draw()
        self.hard_btn.draw()
