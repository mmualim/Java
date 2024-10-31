package Assignment_1;

import java.util.Scanner;

public class Rectangle {
    
    private int recWidth;
    private int recHeight;
    private int canvasWidth;
    private int canvasHeight;
    private String printingCharacter;
    private int[] topLeftCoordinate = {0,0}; // longer length of canvas

    // Constructor  
    public Rectangle(int recWidth, int recHeight, int canvasWidth, int canvasHeight, String printingCharacter) {
        
        this.recWidth = recWidth;
        this.recHeight = recHeight;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.printingCharacter = printingCharacter;
    }

    // Looping to draw the rectangle on the Canvas space.
    // w: Width; h: Height, to understand the loop easier.
    public void drawingRectangle(String backgroundCharacter) {

        int recHeight = this.recHeight;
        int recWidth = this.recWidth;

        for(int h=0; h < this.canvasHeight; h++) {
            String line = "";
            if (h < recHeight) {
                for(int w=0; w < this.canvasWidth; w++) {
                    if (w <recWidth) {
                        line += this.printingCharacter;
                    }
                    else {
                        line += backgroundCharacter;
                    }
                }
            }
            else {
                for(int w=0; w < this.canvasWidth; w++) {
                    line += backgroundCharacter;
                }
            }
            System.out.println(line);
        }
    }

    public void moveRectangle(String move, String backgroundCharacter) {
        if (move.equalsIgnoreCase("a")){
            topLeftCoordinate[0] -= 1;
            if (topLeftCoordinate[0] < 0) {
                topLeftCoordinate[0] = 0;
                System.out.println("You cannot move this rectangle outside of the drawing canvas!");
            }                   
        }
        if (move.equalsIgnoreCase("s")){
            topLeftCoordinate[0] += 1;
            if (topLeftCoordinate[0] > (this.canvasWidth - this.recWidth)) {
                topLeftCoordinate[0] -= 1;
                System.out.println("You cannot move this rectangle outside of the drawing canvas!");
            }   
        }
        if (move.equalsIgnoreCase("w")){
            topLeftCoordinate[1] -= 1;
            if (topLeftCoordinate[1] < 0) {
                topLeftCoordinate[1] = 0;
                System.out.println("You cannot move this rectangle outside of the drawing canvas!");
            }      
        }
        if (move.equalsIgnoreCase("z")){
            topLeftCoordinate[1] += 1;
            if (topLeftCoordinate[1] > (this.canvasHeight - this.recHeight)) {
                topLeftCoordinate[1] -= 1;
                System.out.println("You cannot move this rectangle outside of the drawing canvas!");
            } 
        }

        int recHeight = this.recHeight;
        int recWidth = this.recWidth;

        for(int h=0; h < this.canvasHeight; h++) {
            String line = "";
            if (h < topLeftCoordinate[1]) {
                line = backgroundCharacter.repeat(canvasWidth);
            }
            else if (h >= recHeight + topLeftCoordinate[1]) {
                line = backgroundCharacter.repeat(canvasWidth);

            }
            else {
                for(int w=0; w < this.canvasWidth; w++) {
                    if (w < topLeftCoordinate[0]) {
                        line += backgroundCharacter;
                        continue;
                    }
                    if (w < recWidth + topLeftCoordinate[0]) {
                        line += this.printingCharacter;
                    }
                    else {
                        line += backgroundCharacter;
                    }
                }
            }
            System.out.println(line);
            

        }

    }

    public void setRecWidth(int recWidth) {
        this.recWidth = recWidth;
    }
    public void setRecHeight(int recHeight) {
        this.recHeight = recHeight;
    }
    public int getRecWidth() {
        return this.recWidth;
    }
    public int getRecHeight() {
        return this.recHeight;
    }
    
}
