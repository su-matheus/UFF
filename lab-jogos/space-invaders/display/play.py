import pygame

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

        self.cooldown = 500 #milissegundos
        self.shot_array = []
        self.last_shot = pygame.time.get_ticks()
        


    def move_player(self):
        self.user_input = Window.get_keyboard()

        if (self.user_input.key_pressed("a") and self.spaceship.x > 0):
            self.spaceship.x -= glb.SPEED * self.window_game.delta_time()

        if (self.user_input.key_pressed("d") and self.spaceship.x + self.spaceship.width < glb.GAME_WIDTH):
            self.spaceship.x += glb.SPEED * self.window_game.delta_time()


    def shot_player(self):
        self.time_now = pygame.time.get_ticks()

        n = 0
        for shot in range(len(self.shot_array)):
            self.shot_array[shot+n].y -= glb.SPEED * self.window_game.delta_time()
            self.shot_array[shot+n].draw()
            if self.shot_array[shot+n].y < 0:
                self.shot_array.pop(shot+n)
                n -= 1


        if (self.user_input.key_pressed("space") and self.time_now - self.last_shot > self.cooldown):
            self.shot_img = Sprite("./assets/shot.png")
            self.shot_img.x = self.spaceship.x + self.spaceship.width/2 - self.shot_img.width/2
            self.shot_img.y = self.spaceship.y

            self.shot_array.append(self.shot_img)
            self.last_shot = self.time_now


    def update(self):
        self.bg_image.draw()
        self.shot_player()
        self.spaceship.draw()

        