from PPlay.window import *
from PPlay.gameimage import *
from PPlay.sprite import *

import globals as glb

class Play():
    def __init__(self, window_game):
        self.window_game = window_game
        self.window_game.set_title("Space Invaders")
        self.bg_image = GameImage("./assets/background-image-menu.jpg")
        self.spaceship = Sprite("./assets/player.png")
        self.spaceship.set_position(glb.GAME_WIDTH/2 , glb.GAME_HEIGHT-50)


    def move_player(self):
        self.user_input = Window.get_keyboard()

        if (self.user_input.key_pressed("a") and self.spaceship.x > 0):
            self.spaceship.x -= glb.SPEED * self.window_game.delta_time()

        if (self.user_input.key_pressed("d") and self.spaceship.x + self.spaceship.width < glb.GAME_WIDTH):
            self.spaceship.x += glb.SPEED * self.window_game.delta_time()


    def shot_player(self):
        self.shot_img = Sprite("./assets/shot.png")

        if (self.user_input("SPACE")):
            self.shot_img.x = self.spaceship.x + self.spaceship.width/2 
            self.shot_img.y = self.spaceship.y

    def update(self):
        self.bg_image.draw()
        self.spaceship.draw()

        
    