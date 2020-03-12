# MineSweeper-Sprint_1

This first version of the project implements a basic version of the game played within the terminal. 

List of requirements application for the app :

- Print the grid to the output in an enough nice way. 
       
       Tile : Desctiption
          # : An unrevealed tile
          ¶ : An unrevealed tile marked as armed
          @ : A revealed mine.
Blank space : A revealed tile with no adjacent mine

A revealed tile with as many adjacent mine(s) as the number indicates : 1 2 3 4 5 6 7 8

- Set up a timer to tell the player about her/his performance. It is enough to
  update it together with the update of the grid.
  
- Show the player how many flags remain to be placed.

- It must manage user interaction asking the user what and where to do and then
  reading and parsing user input.
  
- Perform the action typed by the user.

- Decide if the game finishes and then if the user wins or loses.

In this first version, it is not necessary to reveal every empty adjacent tile when an
empty tile is revealed.
