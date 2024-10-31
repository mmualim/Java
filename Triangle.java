package Assignment_1;

import java.util.Scanner;

public class Triangle {
    
    private int triLength;
    private int canvasWidth;
    private int canvasHeight;
    private DrawingCanvas canvas;
    private int minLength; // shorter length of canvas
    private int maxLength;
    private String printingCharacter;
    private int[] topLeftCoordinate = {0,0}; // longer length of canvas
   
    /** 
     * Looping to draw the triangle on the Canvas space.
     * @param triLength is the length of the triangle.
     * @param canvasWidth 
     * @param canvasHeight
     * w: Width; h: Height, to understand the loop easier.
     */
    public Triangle(int triLength, int canvasWidth, int canvasHeight, String printingCharacter) {

        this.triLength = triLength;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.printingCharacter = printingCharacter;
    
    }

    public int canvasLength;
        // Checking which sides of the canvas is longer or if it has same length
        // true: canvasWidth > canvasHeight
        //if (canvas.checkLength) {
        //    minLength = canvasHeight;
        //    maxLength = canvasWidth;
            
        // false: canvasWidth < canvasHeight
        //} else {
        //    minLength = canvasWidth; 
        //    maxLength = canvasHeight;
        //}

    // Method to draw the triangle
    public void drawingTriangle(String backgroundCharacter) {
        int triLength = this.triLength;
        for(int h=0; h < this.canvasHeight; h++) {
            String line = "";
            for(int w=0; w < this.canvasWidth; w++) {
                if (w <triLength) {
                    line += this.printingCharacter;
                }
                else {
                    line += backgroundCharacter;
                }
            }
            System.out.println(line);
            triLength--;
        }
    }
    public void moveTriangle(String move, String backgroundCharacter) {
        if (move.equalsIgnoreCase("a")){
            topLeftCoordinate[0] -= 1;
            System.out.println(topLeftCoordinate[0]);
            if (topLeftCoordinate[0] < 0) {
                topLeftCoordinate[0] = 0;
                System.out.println("You cannot move this triangle outside of the drawing canvas!");
            }                   
        }
        if (move.equalsIgnoreCase("s")){
            topLeftCoordinate[0] += 1;
            System.out.println(topLeftCoordinate[0]);
            if (topLeftCoordinate[0] > (this.canvasWidth - this.triLength)) {
                topLeftCoordinate[0] -= 1;
                System.out.println("You cannot move this triangle outside of the drawing canvas!");
            }   
        }
        if (move.equalsIgnoreCase("w")){
            topLeftCoordinate[1] -= 1;
            if (topLeftCoordinate[1] < 0) {
                topLeftCoordinate[1] = 0;
                System.out.println("You cannot move this triangle outside of the drawing canvas!");
            }      
        }
        if (move.equalsIgnoreCase("z")){
            topLeftCoordinate[1] += 1;
            if (topLeftCoordinate[1] > (this.canvasHeight - this.triLength)) {
                topLeftCoordinate[1] -= 1;
                System.out.println("You cannot move this triangle outside of the drawing canvas!");
            } 
        }
        int triLength = this.triLength;
        for(int h=0; h < this.canvasHeight; h++) {
            String line = "";
            for(int w=0; w < this.canvasWidth; w++) {
                if (h < topLeftCoordinate[1]) {
                    line += backgroundCharacter;
                    continue;
                }
                if (w < topLeftCoordinate[0]) {
                    line += backgroundCharacter;
                    continue;
                }
                if (w <triLength + topLeftCoordinate[0]) {
                    line += this.printingCharacter;
                }
                else {
                    line += backgroundCharacter;
                }
            }
            System.out.println(line);
            if (!line.equals(backgroundCharacter.repeat(canvasWidth))) {
                triLength--;
            }
        }

    }
    public void setTriLength(int triLength) {
        this.triLength = triLength;
    }
    public int getTriLength() {
        return this.triLength;
    }
}
