# 2048Game
files:

Grid.java
  The file creates the 4 * 4 matrix (double array) of tiles and saves them in 
  grid object were merging, moving, drawing is handled.

Tile.java
  the file creates new tiles define their position, value and color is determined
  based on the value.

Game.java
  This file runs the game by drawing tiles and move them based on the 
  key that user's presses. it also determines if player win or loses
  and prints a winning message with number of movements that it took them 
  to win 


  Execution: java Game 
 mouse must be clicked on the drawing before the first key is pressed 
 Keys used in the game 
  w : to move up 
  s : to move down 
  d : to move right
  a : to move left
