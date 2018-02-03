/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_class_prg_01_hw_01_pod_racing_app;

import java.util.Random;
/**
 *
 * @author kbsmith01
 * This class contains all the information that the Pod class requires to be
 * drawn on the board. Keeps track of information like Pod position, current
 * direction of movement, and whether or not the Pod object has contacted
 * the player object in the game.
 * 
 * 
 */
public class Pod {
    /**
     * Keeps track of the Pod object's X position (horizontal)
     * Keeps track of the Pod object's Y position (vertical)
     */
    private int posX;
    private int posY;
    
    /**
     * Temporary variable that updates with a new player X Position
     * Temporary variable that updates with a new player Y position
     */
    private int playerX;
    private int playerY;
    
    /**
     * Static variables keeping track of the board's width and height for
     * comparing current Pod position to for switching directions and direction
     * of movement
     */
    final private int boardHeight;
    final private int boardWidth;
    
    /**
     * Keeps track of Pod's current direction with a string for use with enum
     */
    private String currentDirection;
    
    /**
     * Keeps track of whether or not this object should be visible or not
     */
    private boolean caught = false;
    
    /**
     * Random object created here for use in random direction change method
     * (created here rather than in method)
     */
    Random rand = new Random();
    
    /**
     * Used for switch statements related to movement of Pod objects
     */
    private enum directions {
        north, south, east, west;
    }
    
    /**
     * This is the default Pod object constructor
     * @param x X Position of Pod object passed in on creation
     * @param y Y Position of Pod object passed in on creation
     * @param direction Direction of movement of Pod object
     * @param width Defines width of board
     * @param height Defines height of board
     */
    public Pod(int x, int y, String direction, int width, int height) {
        posX = x;
        posY = y;
        
        currentDirection = direction;
        
        boardWidth = width;
        boardHeight = height;
        
//        System.out.println("DEBUG_POD_CREATED");
    }
    
    /**
     * 
     * @param x Player object X Position passed in from the main class to
     *   compare to the Pod object's X Position
     * @param y Player object Y Position passed in from the main class to
     *   compare to the Pod object's Y Position
     */
    public void playerAt(int x, int y) {
        playerX = x;
        playerY = y;
    }
    
    /**
     * This method uses the currentDirection variable to move the pod object
     * in a direction or changes the direction of movement to its opposite
     * (north to south, east to west, etc.) if its position is along
     * the boards edge is at a min/max value
     */
    public void move() {
        switch(currentDirection) {
            case "north":
                if (posY < boardHeight -1) {
                    posY++;
//                    System.out.println("DEBUG_MOVE_NORTH");
                }
                else if (posY == boardHeight - 1) {
                    currentDirection = "south";
//                    System.out.println("DEBUG_CHANGE_SOUTH");
                }
                break;
            case "south":
                if (posY > 0) {
                    posY--;
//                    System.out.println("DEBUG_MOVE_SOUTH");
                }
                else if (posY == 0) {
                    currentDirection = "north";
//                    System.out.println("DEBUG_CHANGE_NORTH");
                }
                break;
            case "east":
                if (posX < boardWidth -1) {
                    posX++;
//                    System.out.println("DEBUG_MOVE_EAST");
                }
                else if (posX == boardWidth - 1) {
                    currentDirection = "west";
//                    System.out.println("DEBUG_CHANGE_WEST");
                }
                break;
            case "west":
                if (posX > 0) {
                    posX--;
//                    System.out.println("DEBUG_MOVE_WEST");
                }
                else if (posX == 0) {
                    currentDirection = "east";
//                    System.out.println("DEBUG_CHANGE_EAST");
                }
                break;
            default:
                break;
        }
    }
    
    /**
     * This method fires with each movement and has a change to change the Pod
     * object's direction to any one of the four options
     */
    public void randomChange() {
        if(rand.nextInt(5)==0) {
            switch(rand.nextInt(4)) {
                case 0:
                    currentDirection = "north";
//                    System.out.println("DEBUG_RAND_CHANGE_NORTH");
                    break;
                case 1:
                    currentDirection = "south";
//                    System.out.println("DEBUG_RAND_CHANGE_SOUTH");
                    break;
                case 2:
                    currentDirection = "east";
//                    System.out.println("DEBUG_RAND_CHANGE_EAST");
                    break;
                case 3:
                    currentDirection = "west";
//                    System.out.println("DEBUG_RAND_CHANGE_WEST");
                    break;
            }
        }
    }
    
    /**
     * Method is compares player position and Pod object position. If they match
     * then the caught flag is passed back as true so the Pod object won't be
     * drawn on the gameboard anymore
     * @return Returns whether or not the Pod object has been "caught"
     */
    public boolean isCaught() {
        if(posX == playerX && posY == playerY) {
            caught = true;
//            System.out.println("DEBUG_POD_CAUGHT");
        }
        
        return caught;
    }
    
    /**
     * Returns the Pod's X Position (Horizontal)
     * @return Return X Position
     */
    public int getX() {
        return posX;
    }
    
    /**
     * Returns the Pod's Y Position (Vertical)
     * @return Return Y Position
     */
    public int getY() {
        return posY;
    }
}
