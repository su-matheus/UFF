from PPlay.window import *
from PPlay.gameimage import *
from PPlay.sprite import *

import globals as glb


class Ranking(object):
    def __init__(self, window_game):
        self.window_game = window_game
        self.window_game.set_title("Space Invaders - Ranking")
        
        self.bg_image = GameImage("./assets/background-image-menu.jpg")

        self.players = []


    def display_players(self):
        with open("score.txt", "r") as scores:
            players_scores = scores.readlines()
            for lin in players_scores:
                new_player = lin.rstrip("\n").split(",")
                self.players.append(new_player)



    def update(self):
        self.bg_image.draw()

        self.display_players()

        if (len(self.players) < 5):
            for i in range(len(self.players)):
                self.window_game.draw_text(self.players[i][0],glb.GAME_WIDTH/3, 90*(i+1), size=40, color=(255,255,255))
                #self.window_game.draw_text(self.players[i][1],glb.GAME_WIDTH/1.5, 90*(i+1),size=90, color=(255,255,255))

        elif (len(self.players) >= 5):
            for i in range(5):
                self.window_game.draw_text(self.players[i][0],glb.GAME_WIDTH/3, 70*(i+1), size=40, color=(255,255,255))
                #self.window_game.draw_text(self.players[i][1],glb.GAME_WIDTH/1.5, 90*(i+1),size=90, color=(255,255,255))