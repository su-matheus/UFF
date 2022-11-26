import pygame
from random import randint

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
        self.points = 0

        self.next = True

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


    def player_hit_enemy(self):
        for shot in self.shot_player_group:
            for lin in range(len(self.aliens_group)-1, -1, -1):
                for col in range(len(self.aliens_group[lin])):
                    if (self.aliens_group[lin][col].collided(shot)):
                        print("player hit enemy")
                        print("linha {}".format(lin))
                        print("coluna:{}".format(col))
                        self.aliens_group[lin].pop(col)
                        self.shot_player_group.remove(shot)
                        self.points += 33
                        break


    
    def set_alien_pos(self):
        self.alien_col = 5
        self.alien_lin = 3
        self.next = True
        
        self.aliens_group = [[Sprite("./assets/enemy_green.png") for i in range(self.alien_col)] for j in range(self.alien_lin)]
        for i in range(self.alien_lin):
            for j in range(self.alien_col):
                self.aliens_group[i][j].set_position(80 + j * 60, 30 + i * 60)

        

    def move_alien(self):
        
        for l in range(len(self.aliens_group)):
            for c in range(len(self.aliens_group[l])):
                self.aliens_group[l][c].x += glb.SPEED_ENEMY * self.window_game.delta_time()

                first = self.aliens_group[l][0].x
                last = self.aliens_group[l][-1].x

                if (last >= glb.GAME_WIDTH):
                    self.aliens_group[l][c].x += (glb.SPEED_ENEMY * self.window_game.delta_time()) * -1
                if (first <= 0):
                    self.aliens_group[l][c].x += (glb.SPEED_ENEMY * self.window_game.delta_time()) * -1





        """
        for l in range(len(self.aliens_group)):
            first = self.aliens_group[l][0]
            last = self.aliens_group[l][-1]

            if (self.next):
                if ((last.x + last.width) > glb.GAME_WIDTH):
                    glb.SPEED_ENEMY *= -1
                    self.next = not self.next
            else:
                if (first.x <= 0):
                    glb.SPEED_ENEMY *= -1
                    self.next = not self.next
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
            i = randint(0, len(self.aliens_group) - 1)
            j = randint(0 , len(self.aliens_group[i]) - 1)
            self.shot_img = Sprite("./assets/shot.png")
            self.shot_img.x = self.aliens_group[i][j].x + self.aliens_group[i][j].width/2 - self.shot_img.width/2
            self.shot_img.y = self.aliens_group[i][j].y

            self.shot_alien_group.append(self.shot_img)
            self.last_shot_alien = self.time_now

    def update(self):
        self.clock += self.window_game.delta_time()
        self.frames += 1
        self.bg_image.draw()

        [[alien.draw() for alien in linha] for linha in self.aliens_group]

        self.spaceship.draw()
        self.move_player()
        self.shot_player()
        self.player_hit_enemy()

        self.set_alien_pos()
        self.move_alien()
        self.shot_alien()


        if self.clock >= 1:
            self.fps = self.frames
            self.clock = 0
            self.frames = 0
        
        self.window_game.draw_text("FPS: " + str(self.fps), 30, 50, 15, (255, 255, 255))
        self.window_game.draw_text("Points: "+str(self.points), glb.GAME_WIDTH - 150, 50, 30, (255,255,255), "Impact")