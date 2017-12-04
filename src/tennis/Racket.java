/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author tomru
 */
public class Racket {
    
    public int racketNumber;
    
    public int x, y, width = 20, height = 100;
    
    public int score;
            
    public Racket(Tennis tennis, int racketNumber){
        this.racketNumber = racketNumber;
        
        if(racketNumber == 1){
            this.x = 0;
        } else {
            this.x = tennis.width - width;
        }
        this.y = tennis.height / 2 - this.height /2;
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }



    void move(boolean up) {
        int speed = 15;
        if(up){
            if(y - speed > 0) y -= speed;
            else y = 0;
        } else {
            if(y + height + speed < Tennis.tennis.height) y += speed;
            else y = Tennis.tennis.height - height;
        }
    }
}
