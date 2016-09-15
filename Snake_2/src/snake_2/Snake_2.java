/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_2;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;

/**
 *
 * @author Ankit
 */
public class Snake_2 {

    /**
     * @param args the command line arguments
     */
    
    private static boolean gameOver = false;
    private static int []  snake= new int [25];
    private static int  score ;

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Snake_2.gameOver = gameOver;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Snake_2.score = score;
    }
    public static int[] getSnake() {
        return snake;
    }

    public static void setSnake(int[] snake) {
        Snake_2.snake = snake;
    }
    
    public static void main(String[] args) {
        
        //intilize snake
        boolean toContinue = true,foodPresent ;
        String move;
        snake[12]= 1;
        snake[13]= 2;
        //snake[14]= 3;
        score=1;
        //int snake1 [] = getSnake();
        //genrate food
        Food food = new Food ();
        Display display = new Display () ;
        Scanner read = new Scanner (System.in);
        Snake snakeobj = new Snake ();
        
        display.PrintInstructions();
        
        while(toContinue){
            if(!gameOver){
                //System.out.println(snake1[24]);
                foodPresent =food.checkForFood();
                //System.out.println(score);
                if(!foodPresent){
                    food.genrateFood();
                    //System.out.println(score);
                    setScore(score);
                }
                //display.DisplaySnake();
                display.printOutput();
           
                move=read.next();
                try{
                    switch(move){
               
                        case "w":
                        case "W":
                            snakeobj.moveUp();
                            break;   
                        case "A":
                        case "a":
                            snakeobj.moveLeft();
                            break;
                        case "s":
                        case "S":
                            snakeobj.moveDown();
                            break;
                        case "d":
                        case "D":
                            snakeobj.moveRight();
                            break;
                    }
                }
                catch(Exception e){
                    //e.printStackTrace();
                    System.out.println("GAME OVER");
                    System.out.println("SCORE ="+score);
                    break;
                } 
            }else{
                    System.out.println("GAME OVER");
                    System.out.println("SCORE ="+score);
                    break;
            }
            


        }
    }
    
}
