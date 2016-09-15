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
public class Snake {

    public void moveUp() {
        //int head = getPositionOfHead();
        int score = Snake_2.getScore();
        int [] snake = new int [25];
        snake = Snake_2.getSnake();
        int [] bodyOfsnake = new int [score];       
        bodyOfsnake = getBodyOfSnake(score,snake);
        if(bodyOfsnake[0] - bodyOfsnake[1] == 5){
           moveDown();
        }else{
           //System.out.println(bodyOfsnake[0]);
           boolean gameOver = checkForCrash(bodyOfsnake,1 );
           //int validMove=checkForMove(bodyOfsnake[0],bodyOfsnake[1]);
           //System.out.println(bodyOfsnake[0]+""+bodyOfsnake[1]);
           //Display display=new Display();
            //System.out.println(head);
            if(!gameOver){
                int temp=0,count=0,runOnce=1;
                while(score != 0){
                    if(runOnce == 1){
                        temp=bodyOfsnake[count];
                        System.out.println(temp);
                        snake[temp - 5] = count + 1;
                        runOnce++;
                        }     
                    else{
                        snake[temp] = count+ 1;
                        temp=bodyOfsnake[count];
                        }
                    count++;  
                    score--;
                    if(score == 0 && snake[temp] != 1){
                        snake[temp]=0;
                    }
                }
            }else{
                Snake_2.setGameOver(true);
            }
       }
        //display.printOutput();
    }
    
    public int getPositionOfHead(){
        int [] snake = new int [25];
        snake = Snake_2.getSnake();
        int head=0;
        for(int i =0;i<25;i++){
            if(snake[i] == 1){
                head=i;
            }
        }
        return head;
    }

    public int[] getBodyOfSnake(int score,int [] snake) {
        int [] bodyToSend = new int [score];
        int count=1;
        for(int i=0;i<score;score--){
            for(int j= 0 ; j < 25; j++){
                if(snake[j] == count){
                    //System.out.println(j);
                    bodyToSend[count - 1]=j;
                    count++;
                    break;
                }
            }
        }
        return bodyToSend;
    }

    public void moveLeft() {
        int score = Snake_2.getScore();
        int [] snake = new int [25];
        snake = Snake_2.getSnake();
        int [] bodyOfsnake = new int [score];
        bodyOfsnake = getBodyOfSnake(score,snake);
        if(bodyOfsnake[0] - bodyOfsnake[1] == 1){
            moveRight();
            //System.out.println("hi");
       }else{
            System.out.println(bodyOfsnake[0] - bodyOfsnake[1]);
            //System.out.println(bodyOfsnake[0]);
            if(bodyOfsnake[0] % 5 == 0 ){
                //System.out.println(bodyOfsnake[0]);
                Snake_2.setGameOver(true);
            }
            //System.out.println(head);
            //System.out.println("left");
            boolean gameOver = checkForCrash(bodyOfsnake, 3 );
            if(!gameOver){
                int temp=0,count=0,runOnce=1;

                 while(score != 0){
                    if(runOnce == 1){
                        temp=bodyOfsnake[count];
                        snake[temp - 1] = count + 1;
                        runOnce++;
                    }     
                    else{
                        snake[temp] = count+ 1;
                        temp=bodyOfsnake[count];
                    }
                    count++;  
                    score--;
                    if(score == 0 && snake[temp] != 1){
                        snake[temp]=0;
                    }
                }
            }else{
                Snake_2.setGameOver(true);
            }
        }
        //display.printOutput();
    }

    void moveDown() {
        int score = Snake_2.getScore();
        int [] snake = new int [25];
        snake = Snake_2.getSnake();
        int [] bodyOfsnake = new int [score];
        bodyOfsnake = getBodyOfSnake(score,snake);
        
        if(bodyOfsnake[1] - bodyOfsnake[0] == 5){
           moveUp();
       }else{
            //Display display=new Display();
            //System.out.println(head);
            boolean gameOver = checkForCrash(bodyOfsnake,2 );

            if(!gameOver){
                int temp=0,count=0,runOnce=1;
                while(score != 0){
                    if(runOnce == 1){
                        temp=bodyOfsnake[count];
                        snake[temp + 5] = count + 1;
                        runOnce++;
                    }     
                    else{
                        snake[temp] = count+ 1;
                        temp=bodyOfsnake[count];

                    }
                    count++;  
                    score--;
                    if(score == 0 && snake[temp] != 1){
                        snake[temp]=0;
                    }
                }
            }else{
                Snake_2.setGameOver(true);
            }
        }
       // display.printOutput();
    }

    void moveRight() {
        int score = Snake_2.getScore();
        int [] snake = new int [25];
        snake = Snake_2.getSnake();
        int [] bodyOfsnake = new int [score];
        bodyOfsnake = getBodyOfSnake(score,snake);
        
         if(bodyOfsnake[1] - bodyOfsnake[0] == 1){
           moveLeft();
           }else{
                 //System.out.println("right");
                if(bodyOfsnake[0] == 4 || bodyOfsnake[0] == 9 || bodyOfsnake[0] == 14 || bodyOfsnake[0] == 19 || bodyOfsnake[0] == 24  ){
                    Snake_2.setGameOver(true);
                }
                //Display display=new Display();
                //System.out.println(head);
                 boolean gameOver = checkForCrash(bodyOfsnake,4 );

                if(!gameOver){
                    int temp=0,count=0,runOnce=1;
                    while(score != 0){

                        if(runOnce == 1){
                            temp=bodyOfsnake[count];
                            snake[temp + 1] = count + 1;
                            runOnce++;
                        }     
                        else{
                            snake[temp] = count+ 1;
                            temp=bodyOfsnake[count];
                        }
                        count++;  
                        score--;
                        if(score == 0 && snake[temp] != 1){
                            snake[temp]=0;
                        }

                    }
                }else{

                    Snake_2.setGameOver(true);
                }
            }
        //display.printOutput();
    }

    private int checkForMove(int head, int body) {
        int diff=head-body;
        //System.out.println(diff);
       return diff;
    }

    private boolean checkForCrash(int [] bodyOfsnake, int move) {
        
        //1-up 2 down 3-left 4-right
        int temp=0;
        if(move == 1){
            temp=bodyOfsnake[0] - 5;
        }else if(move == 2){
            temp=bodyOfsnake[0] + 5;
        }else if(move == 3){
            temp=bodyOfsnake[0] - 1;
        }else if(move == 4){
            temp=bodyOfsnake[0] + 1;
        }
        //System.out.println(temp);
        for(int i=1;i< bodyOfsnake.length - 1;i++){
                if(temp == bodyOfsnake[i]){
                    return true;
                }
            }
        return false;
    }  
    
    
}
