/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_2;

import java.util.Random;

/**
 *
 * @author Ankit
 */
public class Food {
    
    public void genrateFood(){
        while(true){
            int score = Snake_2.getScore();
            
            Random rand = new Random();
            int  food = rand.nextInt(24) + 0;
            int [] snakeTemp = new int [25];
            snakeTemp = Snake_2.getSnake();       
            if(snakeTemp[food] == 0){
                snakeTemp[food] = 100;
                Snake_2.setSnake(snakeTemp);
                score++;
                Snake_2.setScore(score);
                break;
            }
        }
    }

    boolean checkForFood() {
        int [] snakeTemp = new int [25];
        snakeTemp = Snake_2.getSnake();
        for(int i = 0 ; i < 25 ; i++){
            if(snakeTemp[i] == 100){
                //food is there
                return true;
            }
        }
        return false;
        //System.out.println(score);
    }
    

   
    
}
