/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author tomru
 */
public class Ball {
    
    public int x, y, width = 25, height = 25;
        
    public int motionX, motionY;
    
    public Random random;
    private Tennis tennis;
    
    public Ball(Tennis tennis) {
        this.tennis = tennis;
        this.random = new Random();
        this.x = tennis.width / 2 - this.width / 2;
        this.y = tennis.height / 2 - this.height / 2;        
        this.motionX = - 2 + random.nextInt(4);
        
        if(motionY == 0){
            motionY = 1;
        }
        
        if(random.nextBoolean()){
            motionX = 1;
        } else {
            motionX = -1;
        }
    }
    
    public void update(Racket racket1, Racket racket2){
        int speed = 4;
        
        this.x += motionX*speed;
        this.y += motionY*speed;
        
        if(this.y + height > tennis.height || this.y < 0){
            if(this.motionY < 0){
                this.motionY = random.nextInt(2);
            } else {
                this.motionY = -random.nextInt(2);
            }
        }
        
        if(checkCollision(racket1) == 1){
            this.motionX = random.nextInt(4) + 1;
            this.motionY = -2 + random.nextInt(4);
        }else if(checkCollision(racket2) == 1){
            this.motionX = -random.nextInt(4) - 1;
            this.motionY = -2 + random.nextInt(4);
        }
    }
    
    public int checkCollision(Racket racket){
        if(this.x < racket.x + racket.width && this.x + width > racket.x && this.y < racket.y + racket.height && this.y + height > racket.y){
            return 1;
        } else if ((racket.x > x + width && racket.racketNumber == 1) || (racket.x < x && racket.racketNumber == 2)){
            return 2;
        }

        return 0;
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);
    }
    
}
