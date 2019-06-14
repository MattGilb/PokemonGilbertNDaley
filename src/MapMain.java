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

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 800;
    private Font norm = new Font("Verdana", Font.BOLD, 12);
    private Font pokeText = new Font(Font.MONOSPACED, Font.BOLD, 30);

    private boolean clickedOpt, pokeMenuVis = false;

    public MapMain() {
        setUpKeyListener();

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
        for (int i = 0; i < FRAMEWIDTH; i += 48) {
            g2.drawLine(i, 0, i, FRAMEWIDTH);
            g2.drawString("" + i, i, 12);
        }
        for (int i = 0; i < FRAMEWIDTH; i += 48) {
            g2.drawLine(0, i, FRAMEWIDTH, i);
            g2.drawString("" + i, 1, i);
        }
        player.draw(g2);
        leader.draw(g2);
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
                if(key == keyEvent.VK_Q&& player.getBounds().intersects(leader.getBounds())){
                    System.out.println("hi");

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