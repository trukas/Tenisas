/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author tomru
 */
public class Tennis implements ActionListener, KeyListener {
    public static Tennis tennis;
    public int width = 800, height = 800;
    public Renderer renderer;
    public Racket player1;
    public Racket player2;
    public Ball ball;
    public boolean w, s, up, down;
    public Timer timer;
    
    public Tennis() {
        
        JFrame jframe = new JFrame("Tennis");
        
        renderer = new Renderer();
        
        jframe.setSize(width + 18, height + 47);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(renderer);
        jframe.addKeyListener(this);
        
        timer = new Timer(30, this);
        
        start();
        
    }
    public void start(){
        player1 = new Racket(this, 1);
        player2 = new Racket(this, 2);
        ball = new Ball(this);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        tennis = new Tennis();
    }
    
    public void update(){
        if(w){
            player1.move(true);
        }
        if(s){
            player1.move(false);
        }
        if(up){
            player2.move(true);
        }
        if(down){
            player2.move(false);
        }
        ball.update(player1, player2);
    }
    
    void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);
        
        g.setColor(Color.WHITE);
        g.drawLine(width / 2 - 10, 0, width / 2 - 10, height);
        
        g.setColor(Color.WHITE);
        g.drawLine(width / 2 + 10, 0, width / 2 + 10, height);
        
        player1.render(g);
        player2.render(g);
        
        ball.render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        renderer.repaint();        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();
        if(id == KeyEvent.VK_W){
            w = true;
        }
        if(id == KeyEvent.VK_S){
            s = true;
        }
        if(id == KeyEvent.VK_UP){
            up = true;
        }
        if(id == KeyEvent.VK_DOWN){
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int id = e.getKeyCode();
        if(id == KeyEvent.VK_W){
            w = false;
        }
        if(id == KeyEvent.VK_S){
            s = false;
        }
        if(id == KeyEvent.VK_UP){
            up = false;
        }
        if(id == KeyEvent.VK_DOWN){
            down = false;
        }
    }
    
}
