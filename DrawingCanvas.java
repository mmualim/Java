package Assignment_1;

import java.util.Scanner;

public class DrawingCanvas {
    
    private int canvasWidth;
    private int canvasHeight;
    private String backgroundCharacter;

    /* Creating a new canvas with the measurements configured 
     * @param canvasWidth, 
     * 
    */
    public DrawingCanvas(int canvasWidth, int canvasHeight, String backgroundCharacter) {

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.backgroundCharacter = backgroundCharacter;
    }
    
    /* *
     * Checking the length of the width and height;
     * if canvasWidth > canvasHeight it returns true;
     * if canvasWidth < canvasHeight it returns false;
     * */ 
    public boolean checkLength() {

        if (canvasWidth > canvasHeight) {
            return true;
        } else {
            return false;
        }
        
    }

    // Set a new canvas measurements.
    public void setCanvas(int cWidth, int cHeight, String backgroundChar) {

        int canvasWidth = cWidth;
        int canvasHeight = cHeight;
        String backgroundCharacter = backgroundChar;

    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public String getBackgroundCharacter() {
        return backgroundCharacter;
    }
}
