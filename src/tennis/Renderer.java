/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author tomru
 */
public class Renderer extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Tennis.tennis.render(g);
    }
}
