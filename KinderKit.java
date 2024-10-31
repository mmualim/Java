package Assignment_1;
/*
 * COMP90041, Sem1, 2023: Assignment 1
 * Name           : Merlyvia Mualim
 * Student ID     : 1086238
 * Unimelb email  : mmualim@student.unimelb.edu.au
 */

 import java.util.Scanner;

 public class KinderKit {
     
     // Constants for accessing command line argument indexes.
     final static int CANVAS_WIDTH_INDEX = 0;
     final static int CANVAS_HEIGHT_INDEX = 1;
     final static int BACKGROUND_CHARACTER_INDEX = 2;
     
     
     public KinderKit() {
 
 
     }
 
     public void welcomeMessage(int canvasWidth, int canvasHeight, String backgroundCharacter) {
         System.out.println("----DIGITAL KINDER KIT: LET'S PLAY & LEARN----");
         System.out.println("Current drawing canvas settings:");
         System.out.println("- Width: " + canvasWidth);
         System.out.println("- Height: " + canvasHeight);
         System.out.println("- Background character: " + backgroundCharacter); 
 
     }
 
     // Method to print the main menu with a list of options.
     public void menuOptions() {
         
         System.out.println("Please select an option. Type 4 to exit.");
         System.out.println("1. Draw triangles");
         System.out.println("2. Draw rectangles");
         System.out.println("3. Update drawing canvas settings");
         System.out.println("4. Exit");
 
     }
 
     public static void main(String[] args) {
         
         // Initialized the variables for canvas measurements.
         int canvasWidth = Integer.parseInt(args[CANVAS_WIDTH_INDEX]);
         int canvasHeight = Integer.parseInt(args[CANVAS_HEIGHT_INDEX]);
         String backgroundCharacter = args[BACKGROUND_CHARACTER_INDEX];
 
         // Scanner for reading in user input.
         Scanner scanner = new Scanner(System.in);
 
         // Displaying the main menu list of options.
         KinderKit display = new KinderKit();
         DrawingCanvas canvas = new DrawingCanvas(canvasWidth, canvasHeight, backgroundCharacter);
 
         display.welcomeMessage(canvasWidth, canvasHeight, backgroundCharacter);
         display.menuOptions();
         int input = scanner.nextInt();
 
         if ((input > 0) || (input < 5)) {
             if (input == 1) {
                 System.out.println("Side length: ");
                 int sideLength = scanner.nextInt();
                 if ((sideLength > canvasWidth) || (sideLength > canvasHeight)) {
                     System.out.println("Error! The side length is too long (Current canvas size is "+canvasWidth+"x"+canvasHeight+"). Please try again.");
                 }
                 else {
                     System.out.println("Printing character:");
                     String printingCharacter = scanner.next();
 
                     Triangle triangle = new Triangle(sideLength, canvasWidth, canvasHeight, printingCharacter);
                     triangle.drawingTriangle(backgroundCharacter);
 
                     System.out.println("Type Z/M for zooming/moving. Use other keys to quit the Zooming/Moving mode.");
                     String zoomOrMoveInput = scanner.next();
 
                     boolean zoom = false;
                     boolean move = false;
                     
                     if(zoomOrMoveInput.equalsIgnoreCase("z")){
                         zoom = true;
                     }
                     else if(zoomOrMoveInput.equalsIgnoreCase("m")){
                         move = true;
                     }
                     else {
                         
                     }
                     while(zoom) {
                         System.out.println("Type I/O to zoom in/out. Use other keys to go back to the Zooming/Moving menu.");
                         String zoomInput = scanner.next();
                         if (zoomInput.equalsIgnoreCase("i")){
                             triangle.setTriLength(triangle.getTriLength() + 1);
                             triangle.drawingTriangle(backgroundCharacter);
                         }
                         else if (zoomInput.equalsIgnoreCase("o")){
                             triangle.setTriLength(triangle.getTriLength() - 1);
                             triangle.drawingTriangle(backgroundCharacter);
 
                         }
                         else {
                             zoom = false;
                         }
                     }
                     while(move) {
                         System.out.println("Type A/S/W/Z to move left/right/up/down. Use other keys to go back to the Zooming/Moving menu.");
                         String moveInput = scanner.next();
                         if (moveInput.equalsIgnoreCase("a")){
                             triangle.moveTriangle("a", backgroundCharacter);
                             
                         }
                         else if (moveInput.equalsIgnoreCase("s")){
                             triangle.moveTriangle("s", backgroundCharacter);
     
                         }
                         else if (moveInput.equalsIgnoreCase("w")){
                             triangle.moveTriangle("w", backgroundCharacter);
                             
                         }
                         else if (moveInput.equalsIgnoreCase("z")){
                             triangle.moveTriangle("z", backgroundCharacter);
     
                         }
                         else {
                             move = false;
                         }
                     }
                 }
             }
             else if (input == 2) {
 
                 System.out.println("width: ");
                 int recWidth = scanner.nextInt();
                 if (recWidth > canvasWidth) {
                     System.out.println("Error! The width is too large (Current canvas size is "+canvasWidth+"x"+canvasHeight+"). Please try again.");
                 }
 
                 System.out.println("height: ");
                 int recHeight = scanner.nextInt();
                 if (recHeight > canvasHeight) {
                     System.out.println("Error! The height is too large (Current canvas size is "+canvasWidth+"x"+canvasHeight+"). Please try again.");
                 }
 
                 else {
                     System.out.println("Printing character:");
                     String printingCharacter = scanner.next();
 
                     Rectangle rectangle = new Rectangle(recWidth, recHeight, canvasWidth, canvasHeight, printingCharacter);
                     rectangle.drawingRectangle(backgroundCharacter);
 
                     System.out.println("Type Z/M for zooming/moving. Use other keys to quit the Zooming/Moving mode.");
                     String zoomOrMoveInput = scanner.next();
 
                     boolean zoom = false;
                     boolean move = false;
                         
                     if(zoomOrMoveInput.equalsIgnoreCase("z")){
                         zoom = true;
                     }
                     else if(zoomOrMoveInput.equalsIgnoreCase("m")){
                         move = true;
                     }
                     else {
                         
                     }                    
                 
                 while(zoom) {
                     System.out.println("Type I/O to zoom in/out. Use other keys to go back to the Zooming/Moving menu.");
                     String zoomInput = scanner.next();
                     if (zoomInput.equalsIgnoreCase("i")){
                         rectangle.setRecHeight(rectangle.getRecHeight() + 1);
                         rectangle.setRecWidth(rectangle.getRecWidth() + 1);
                         rectangle.drawingRectangle(backgroundCharacter);
                     }
                     else if (zoomInput.equalsIgnoreCase("o")){
                         rectangle.setRecHeight(rectangle.getRecHeight() - 1);
                         rectangle.setRecWidth(rectangle.getRecWidth() - 1);
                         rectangle.drawingRectangle(backgroundCharacter);
                     }
                     else {
                         zoom = false;
                     }
                     }
                 while(move) {
                         System.out.println("Type A/S/W/Z to move left/right/up/down. Use other keys to go back to the Zooming/Moving menu.");
                         String moveInput = scanner.next();
                         if (moveInput.equalsIgnoreCase("a")){
                             rectangle.moveRectangle("a", backgroundCharacter);
                             
                         }
                         else if (moveInput.equalsIgnoreCase("s")){
                             rectangle.moveRectangle("s", backgroundCharacter);
     
                         }
                         else if (moveInput.equalsIgnoreCase("w")){
                             rectangle.moveRectangle("w", backgroundCharacter);
                             
                         }
                         else if (moveInput.equalsIgnoreCase("z")){
                             rectangle.moveRectangle("z", backgroundCharacter);
     
                         }
                         else {
                             move = false;
                         }
                     }
                 }
             }
     }
     else {
             System.out.println("Unsupported option. Please try again!");
             display.menuOptions();
         }
     }   
 }
 
 