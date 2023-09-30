/*
* Name: Majd Ayyad
* PennKey: mayyad
* Execution : NA
*
* description: the class has all the methods used to move and merge tiles in
* 2048 game based on the user's input.
*/

public class Grid {
    
    private Tile[][] tiles;
    private int moveNum;
    
    /*
    * Inputs: NA
    * Outputs: NA
    * description: constructor to make a grid that has tiles
    */
    public Grid() {
        this.tiles = new Tile[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                tiles[row][col] = new Tile();
                tiles[row][col].setResult(0);
            }
        }
    }
    
    /*
    * Inputs: NA
    * Outputs: NA
    * description: draw tiles and their values
    */
    public void drawTiles() {
        PennDraw.clear(127, 127, 127);
        // each sqaure and tile
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                tiles[row][col].setColor();
                PennDraw.filledSquare(0.12 + (col * 0.25),
                1 - (0.12 + (row * 0.25)), 0.1);
                if (!tiles[row][col].isTileEmpty()) {
                    String result = tiles[row][col].getResult() + " ";
                    PennDraw.setFontSize(25);
                    PennDraw.setPenColor(PennDraw.BLACK);
                    PennDraw.text(0.12 + (col * 0.25),
                    1 - (0.12 + (row * 0.25)), result);
                }
            }
        }
        
    }
    
    /*
    * Inputs: a tile object two integers presenting location in a double array
    * Outputs: NA
    * description: add a tile to the tile arrays
    */
    private void addTileHelper(Tile t, int row, int col) {
        tiles[row][col] = t;
    }
    
    /*
    * Inputs: 3 integers presenting positons and value of tile
    * Outputs: NA
    * description: add a tile to the tile arrays (used for debugging)
    */
    public void addTile(int value , int row, int col) {
        tiles[row][col] = new Tile(value, row, col);
    }
    
    /*
    * Inputs: NA
    * Outputs: NA
    * description: add a random tile in an empty location at the beginning of the
    *game and when key is pressed
    */
    public void addRandom() {
        Tile newTile = new Tile();
        int posX = newTile.getPosX();
        int posY = newTile.getPosY();
        
        while (!tiles[posX][posY].isTileEmpty()) {
            newTile = new Tile();
            posX = newTile.getPosX();
            posY = newTile.getPosY();
        }
        tiles[posX][posY] = newTile;
        addTileHelper(newTile, posX, posY);
    }
    
    /*
    * Inputs: NA
    * Outputs: NA
    * description: a method to move tiles up
    */
    public void moveUp() {
        for (int k = 0; k < 4; k++) {
            for (int row = 3; row > 0; row--) {
                for (int col = 0; col < 4; col++) {
                    if (tiles[row - 1][col].isTileEmpty()) {
                        tiles[row - 1][col] = new Tile(tiles[row][col].getResult(),
                        tiles[row][col].getPosX(),
                        tiles[row][col].getPosY());
                        tiles[row][col].setResult(0);
                    }
                }
            }
        }
    }
    
    /*
    * Inputs: NA
    * Outputs: NA
    * description: a method to move tile down
    */
    public void moveDown() {
        for (int k = 0; k < 4; k++) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 4; col++) {
                    if (tiles[row + 1][col].isTileEmpty()) {
                        tiles[row + 1][col] = new Tile(
                        tiles[row][col].getResult(),
                        tiles[row][col].getPosX(),
                        tiles[row][col].getPosY());
                        tiles[row][col].setResult(0);
                    }
                }
            }
        }
    }
    
    /*
    * Inputs: NA
    * Outputs: NA
    * description: a method to move tiles right
    */
    public void moveRight() {
        for (int k = 0; k < 4; k++) {
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 3; col++) {
                    if (tiles[row][col + 1].isTileEmpty()) {
                        tiles[row][col + 1] = new Tile(
                        tiles[row][col].getResult(),
                        tiles[row][col].getPosX(),
                        tiles[row][col].getPosY());
                        tiles[row][col].setResult(0);
                    }
                }
            }
        }
    }
    
    /*
    * Inputs: NA
    * Outputs: NA
    * description: a method to move tiles left
    */
    public void moveLeft() {
        for (int k = 0; k < 4; k++) {
            for (int row = 0; row < 4; row++) {
                for (int col = 1; col < 4; col++) {
                    if (tiles[row][col - 1].isTileEmpty()) {
                        tiles[row][col - 1] = new Tile(
                        tiles[row][col].getResult(),
                        tiles[row][col].getPosX(),
                        tiles[row][col].getPosY());
                        tiles[row][col].setResult(0);
                    }
                }
            }
        }
    }
    
    /*
    * Inputs: a charecter (a key on keyboard (w, a, s, d))
    * Outputs: NA
    * description: merges tiles based on the  input
    */
    public void merge(char inputChar) {
        // merge when move left
        if (inputChar == 'a') {
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 3; col++) {
                    int value = tiles[row][col].getResult();
                    if (value != 0 && tiles[row][col + 1].getResult() == value) {
                        // add them
                        tiles[row][col].setResult(value * 2);
                        tiles[row][col + 1].setResult(0);
                        // move one step
                        for (int i = 0; i < 4; i++) {
                            for (int j = 1; j < 4; j++) {
                                if (tiles[i][j - 1].isTileEmpty()) {
                                    tiles[i][j - 1] = new Tile(
                                    tiles[i][j].getResult(),
                                    tiles[i][j].getPosX(),
                                    tiles[i][j].getPosY());
                                    tiles[i][j].setResult(0);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // merge when move right
        else if (inputChar == 'd') {
            for (int row = 0; row < 4; row++) {
                for (int col = 1; col < 4; col++) {
                    int value = tiles[row][col].getResult();
                    if (value != 0 && tiles[row][col - 1].getResult() == value) {
                        // add them
                        tiles[row][col].setResult(value * 2);
                        tiles[row][col - 1].setResult(0);
                        // move one step
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (tiles[i][j + 1].isTileEmpty()) {
                                    tiles[i][j + 1] = new Tile(
                                    tiles[i][j].getResult(),
                                    tiles[i][j].getPosX(),
                                    tiles[i][j].getPosY());
                                    tiles[i][j].setResult(0);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // merge when move up
        else if (inputChar == 'w') {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 4; col++) {
                    int value = tiles[row][col].getResult();
                    if (value != 0 && tiles[row + 1][col].getResult() == value) {
                        tiles[row][col].setResult(value * 2);
                        tiles[row + 1][col].setResult(0);
                        // move one step
                        for (int i = 3; i > 0; i--) {
                            for (int j = 0; j < 4; j++) {
                                if (tiles[i - 1][j].isTileEmpty()) {
                                    tiles[i - 1][j] = new Tile(
                                    tiles[i][j].getResult(),
                                    tiles[i][j].getPosX(),
                                    tiles[i][j].getPosY());
                                    tiles[i][j].setResult(0);
                                }
                            }
                        }
                    }
                }
            }
            
        }
        
        // merge when move down
        else if (inputChar == 's') {
            for (int row = 3; row >= 1; row--) {
                for (int col = 0; col < 4; col++) {
                    int value = tiles[row][col].getResult();
                    if (value != 0 && tiles[row - 1][col].getResult() == value) {
                        tiles[row][col].setResult(value * 2);
                        tiles[row - 1][col].setResult(0);
                        // move step
                       for (int k = 0; k < 3; k++) {
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 4; j++) {
                                    if (tiles[i + 1][j].isTileEmpty()) {
                                        tiles[i + 1][j] = new Tile(
                                        tiles[i][j].getResult(),
                                        tiles[i][j].getPosX(),
                                        tiles[i][j].getPosY());
                                        tiles[i][j].setResult(0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /*
    * Inputs: NA
    * Outputs: an array of tile objects
    * description:getter function for tiles
    */
    public Tile[][] getTiles() {
        return this.tiles;
    }
    
    /*
    * Inputs: NA
    * Outputs: boolean
    * description: a mehtod to check if did player win
    */
    public boolean didPlayerWin() {
        int win = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (tiles[row][col].getResult() == 2048) {
                    win++;
                }
            }
        }
        return win >= 1;
    }
    
    /*
    * Inputs: NA
    * Outputs: boolean
    * description: a method to check if  player loses
    */
    public boolean didPlayerLose() {
        int numFullTile = 0;
        int move = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (!tiles[row][col].isTileEmpty()) {
                    numFullTile++;
                }
            }
        }
        // check if no movemet in the rows
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[i][j] == tiles [i][j + 1]) {
                    move++;
                }
            }
        }
        // check if no more movemet in the cols
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (tiles[i][j] == tiles [i + 1][j]) {
                    move++;
                }
            }
        }
        return numFullTile == 16 && move == 0;
    }
    
}
