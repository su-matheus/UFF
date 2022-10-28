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

        self.clock, self.frames, self.fps = 0, 0, "Calculando..."

        self.aliens_group = []
        self.shot_alien_group = []
        self.last_shot_alien = pygame.time.get_ticks()
        self.move_counter = 0
        self.move_direction = 1


        self.shot_player_group = []
        self.last_shot_player = pygame.time.get_ticks()
        


    def move_player(self):
        self.user_input = Window.get_keyboard()

        if (self.user_input.key_pressed("a") and self.spaceship.x > 0):
            self.spaceship.x -= glb.SPEED_PLAYER * self.window_game.delta_time()

        if (self.user_input.key_pressed("d") and self.spaceship.x + self.spaceship.width < glb.GAME_WIDTH):
            self.spaceship.x += glb.SPEED_PLAYER * self.window_game.delta_time()


    def shot_player(self):
        self.time_now = pygame.time.get_ticks()

        n = 0
        for shot in range(len(self.shot_player_group)):
            self.shot_player_group[shot+n].y -= glb.SPEED_BULLET * self.window_game.delta_time()
            self.shot_player_group[shot+n].draw()
            if self.shot_player_group[shot+n].y < 0:
                self.shot_player_group.pop(shot+n)
                n -= 1


        if (self.user_input.key_pressed("space") and self.time_now - self.last_shot_player > glb.PLAYER_COOLDOWN):
            self.shot_img = Sprite("./assets/shot.png")
            self.shot_img.x = self.spaceship.x + self.spaceship.width/2 - self.shot_img.width/2
            self.shot_img.y = self.spaceship.y

            self.shot_player_group.append(self.shot_img)
            self.last_shot_player = self.time_now


    def set_alien_pos(self):
        self.alien_col = 5
        self.alien_lin = 3
        
        
        for i in range(self.alien_lin):
            for j in range(self.alien_col):
                self.alien = Sprite("./assets/enemy_green.png")
                self.alien.set_position(70 + j * 60, 30 + i * 60)
                self.aliens_group.append(self.alien)
                self.alien.draw()

        self.alien.x += (glb.SPEED_ENEMY * self.window_game.delta_time()) * -1

    def move_alien(self):
        #self.move_counter += 1

        self.alien.x += (glb.SPEED_ENEMY * self.window_game.delta_time())

        """
        if (abs(self.move_counter) > 70):
            self.alien.x += (glb.SPEED_ENEMY * self.window_game.delta_time()) * -1
            self.move_counter = 0
        else:
            self.alien.x += (glb.SPEED_ENEMY * self.window_game.delta_time())
        """

    def shot_alien(self):
        self.time_now = pygame.time.get_ticks()
        self.shot_alien_img = Sprite("./assets/shot.png")

        n = 0
        for shot in range(len(self.shot_alien_group)):
            self.shot_alien_group[shot+n].y += glb.SPEED_BULLET * self.window_game.delta_time()
            self.shot_alien_group[shot+n].draw()
            if self.shot_alien_group[shot+n].y > glb.GAME_HEIGHT:
                self.shot_alien_group.pop(shot+n)
                n -= 1

        if (self.time_now - self.last_shot_alien > glb.ALIEN_COOLDOWN):
            self.shot_img = Sprite("./assets/shot.png")
            self.shot_img.x = self.alien.x + self.alien.width/2 - self.shot_img.width/2
            self.shot_img.y = self.alien.y

            self.shot_alien_group.append(self.shot_img)
            self.last_shot_alien = self.time_now

    def update(self):
        self.clock += self.window_game.delta_time()
        self.frames += 1
        self.bg_image.draw()

        self.spaceship.draw()
        self.move_player()
        self.shot_player()

        self.set_alien_pos()
        self.move_alien()
        self.shot_alien()


        # self.alien.x += glb.SPEED_ENEMY * self.window_game.delta_time()

        if self.clock >= 1:
            self.fps = self.frames
            self.clock = 0
            self.frames = 0
        
        self.window_game.draw_text("FPS: " + str(self.fps), 30, 50, 15, (255, 255, 255))