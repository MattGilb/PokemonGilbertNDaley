import sun.tools.jstat.Scale;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

//TODO: PUT YOUR NAME HERE

public class MapMain extends JPanel{

    private BufferedImage gym;
    private Trainer player = new Trainer(384,720,"Red");
    private Trainer leader = new Trainer(384,266,"Brock");
    private boolean initiateBattle;
    private boolean battleStart;

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 800;
    private Font norm = new Font("Verdana", Font.BOLD, 12);
    private Font pokeText = new Font(Font.MONOSPACED, Font.BOLD, 30);

    private boolean clickedOpt, pokeMenuVis = false;

    public MapMain() {
        setUpKeyListener();
        this.initiateBattle=false;
        this.battleStart=false;

    }


    //The paint method.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            gym = ImageIO.read(new File("res/" + "PewterGym.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(gym,26,0,null);
        g2.setColor(Color.red);
        player.draw(g2);
        leader.draw(g2);
        if(initiateBattle) {
            g2.setColor(Color.red.darker());
            g2.fillRect(0, 600, Main.FRAMEWIDTH - 2, 200);
            g2.setColor(Color.green.darker().darker());
            g2.fillRect(25, 625, 950, 150);
            g2.setFont(pokeText);
            g2.setStroke(new BasicStroke(15));
            g2.setColor(Color.BLACK);
            g2.drawString("My rock-hard willpower is evident in even my Pokémon.",27,660);
            g2.drawString("My Pokémon are all rock hard and have true-grit ",27,695);
            g2.drawString("determination. That's right - my Pokémon are all the ",27,730);
            g2.drawString("Rock type!",27,760);
        }else if(battleStart){

        }
    }


    public void setUpKeyListener() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int key = keyEvent.getKeyCode();
                if (key == keyEvent.VK_RIGHT){

                    player.move(48,0);

                }
                if (key == keyEvent.VK_LEFT){
                    player.move(-48,0);

                }
                if (key == keyEvent.VK_UP) {

                    player.move(0, -48);
                }
                if (key == keyEvent.VK_DOWN){
                    player.move(0,48);
                }
                if(key == keyEvent.VK_Q&& player.getBounds().intersects(leader.getBounds())&&!initiateBattle){
                   initiateBattle=true;
                }else if(key == keyEvent.VK_Q&& player.getBounds().intersects(leader.getBounds())&&initiateBattle){
                    battleStart= true;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
    }

    //sets ups the panel and frame.  Probably not much to modify here.
    public static void main(String[] args) {
        JFrame window = new JFrame("Catch Em All!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        MapMain panel = new MapMain();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}