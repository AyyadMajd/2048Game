/*
* Name: Majd Ayyad
* PennKey: mayyad
* Execution: NA
*
* Description: this class create a tile object with x and y position
* as well as a result represnting its value
*/

public class Tile {
    
    private int posX;
    private int posY;
    private int result;
    
    /*
    * inputs: three integers of X and Y position and the resulted value
    * output: NA
    * description: a constructor to create a new tile object that
    * has a value and positions
    */
    public Tile(int result, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.result = result;
    }
    
    /*
    * inputs: NA
    * output: NA
    * description: create a random tile and assign a value for the variables
    */
    public Tile() {
        double randomNum = Math.random();
        if (randomNum < 0.5) {
            this.result = 4;
            } else {
            this.result = 2;
        }
        this.posX = (int) (Math.random() * 4);
        this.posY = (int) (Math.random() * 4);
    }
    
    /*
    * inputs: NA
    * output: integer of the resulted value of tile
    * description: getter function for the result
    */
    public int getResult() {
        return result;
    }
    
    /*
    * inputs: NA
    * output: integer of resulted value of
    * description: getter for posX
    */
    public int getPosX() {
        return posX;
    }
    
    /*
    * inputs: NA
    * output: an integer of X position of the tile
    * description: getter for posY
    */
    public int getPosY() {
        return posY;
    }
    
    /*
    * inputs: an integer of the resulted value of tile
    * output: NA
    * description: setter for result
    */
    public void setResult(int result) {
        this.result = result;
    }
    
    /*
    * inputs: an integer of X position of tile
    * output: NA
    * description: setter for posX
    */
    public void setPosX(int posX) {
        this.posX = posX;
    }
    
    /*
    * inputs: an integer of Y positon of tile
    * output: NA
    * description: setter for posY
    */
    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    /*
    * inputs: NA
    * output: a boolean (true if tile is empty)
    * description: determines if the tile is empty
    */
    public boolean isTileEmpty() {
        return this.result == 0;
    }
    
    /**
    * Inputs: NA
    * Outputs: NA
    * Description: a method to set the color of tile based on its value
    */
    public void setColor() {
        if (this.result == 2) {
            PennDraw.setPenColor(218, 220, 238);
            } else if (this.result == 4) {
                PennDraw.setPenColor(237, 244, 201);
            } else if (this.result == 8) {
                PennDraw.setPenColor(245, 167, 122);
            } else if (this.result == 16) {
                PennDraw.setPenColor(23, 100, 205);
            } else if (this.result == 32) {
                PennDraw.setPenColor(245, 149, 100);
            } else if (this.result == 64) {
                PennDraw.setPenColor(237, 207, 11);
            } else if (this.result == 128) {
                PennDraw.setPenColor(237, 210, 114);
            } else if (this.result == 256) {
                PennDraw.setPenColor(235, 204, 99);
            } else if (this.result == 512) {
                PennDraw.setPenColor(237, 100, 97);
            } else if (this.result == 1024) {
                PennDraw.setPenColor(237, 197, 66);
            } else if (this.result == 2048) {
                PennDraw.setPenColor(237, 195, 146);
            } else {
                PennDraw.setPenColor(255, 255, 255);
        }
    }
    
}
