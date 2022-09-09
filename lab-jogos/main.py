from PPlay.window import *
from PPlay.gameimage import *
from PPlay.sprite import *

#### setting window and background image ####
window_game = Window(880,520)
window_game.set_title("Pong")
bg_image = GameImage("galaxy.jpg")



#### elements of the game ####
right_player = Sprite("right_player.png", 1)
left_player = Sprite("left_player.png", 1)
ball = Sprite("ball.png", 1)


#### ball position ####
ball.x = window_game.width/2 - ball.width/2
ball.y = window_game.height/2 - ball.height/2

#### player position ####
right_player.x = window_game.width - right_player.width -15
right_player.y = window_game.height/2 - right_player.height/2

left_player.x = 15
left_player.y = window_game.height/2 - left_player.height/2

while (True):
    bg_image.draw()
    ball.draw()
    right_player.draw()
    left_player.draw()
    window_game.update()


##sem o window_game.update() não é possível mostrar a imagem de fundo