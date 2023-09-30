/**
* Name:Majd Ayyad
* Pennkey: mayyad
* Execution: java Game
*
* Description:this class is the main class to run 2048 game, it handles
* calling other methods for the user to play the game and determines if the
* player wins or loses and displays a message based on that
**/

public class Game {
    
    public static void main(String[] args) {
        Grid g = new Grid();
        PennDraw.enableAnimation(30);
        // add two tiles to start game 
        g.addRandom();
        g.addRandom();
        g.drawTiles();
        int sumNumMoves = 0;

        // move and merge tiles based on user's input key
        while (!g.didPlayerWin() && !g.didPlayerLose()) {
            if (PennDraw.hasNextKeyTyped()) {
                sumNumMoves++;
                char key = PennDraw.nextKeyTyped();
                if (key == 'w') {
                    g.moveUp();
                    } else if (key == 'd') {
                        g.moveRight();
                    } else if (key == 's') {
                        g.moveDown();
                    } else if (key == 'a') {
                        g.moveLeft();
                }
                g.merge(key);
                g.addRandom();
                g.drawTiles();
            }
            PennDraw.advance();
        }

        // print vectory or loss message 
        if (g.didPlayerWin()) {
            PennDraw.clear();
            PennDraw.setFontSize(20);
            PennDraw.text(0.5, 0.5, "CONGRATS! you won with " +
            sumNumMoves + "moves");
            } else if (g.didPlayerLose()) {
                PennDraw.clear();
                PennDraw.setFontSize(20);
                PennDraw.text(0.5, 0.5, "GAMEOVER " +
                sumNumMoves + "moves");
            }
        PennDraw.disableAnimation();
    }
    
}
