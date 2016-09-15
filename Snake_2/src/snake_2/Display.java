/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_2;

/**
 *
 * @author Ankit
 */
public class Display {

    void printOutput() {
      
        int [] snake = new int [25];
        snake = Snake_2.getSnake();
        int toDisplay ;
        int count=0;
        System.out.println("       ------------------------------");
        for(int i=0;i<=4;i++){
           System.out.print("       |");
           for(int j =0;j<=4;j++){
              toDisplay =snake[count++];
              if(toDisplay != 100){
                  if(toDisplay == 0){
                      System.out.print("     ");
                  }else if(toDisplay == 1) {
                      System.out.print("    H");
                  }else{
                       System.out.print("    0");
                  }
                  
              }else{
                  System.out.print("    X");
              }
               
           }
           if(i == 2){
               System.out.println("   |");
               System.out.println("       |                            |       SCORE = "+Snake_2.getScore());
           }else{
               System.out.println("   |");
           System.out.println("       |                            |");
           }
           
        }
        System.out.println("       ------------------------------");
        
    }
    
    void DisplaySnake(){
        int snake [] = Snake_2.getSnake();
        int score = Snake_2.getScore();
        Snake snakeBody = new Snake();
        int body [] ;
        body = snakeBody.getBodyOfSnake(score, snake);
        for(int i =0 ;i<body.length;i++){
            System.out.print(body[i]+",");
        }
    }
    
    void PrintInstructions(){
        System.out.println("INSTRUCTIONS");
        System.out.println("Use W to move up , S to move down,");
        System.out.println("A to move left , D to move right.");
        System.out.println("H will denote the head of the snake.");
    }
}
