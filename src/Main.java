import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//TODO: PUT YOUR NAME HERE

public class Main extends JPanel {


    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 800;


    private Font norm = new Font("Verdana", Font.BOLD, 12);
    private Font pokeText = new Font(Font.MONOSPACED, Font.BOLD, 30);

    private boolean clickedOpt, pokeMenuVis = false;


    private Menu menu;

    Move tackle = new Move("Tackle", 20, 40);
    Move scratch = new Move("Scratch", 20, 40);
    Move thunder = new Move("Thunder", 80, 15);
    Move quickAttack = new Move("Quick Attack", 20, 40);
    Color sandColor = new Color(	194, 178, 128);
    Color grey = new Color(128,128,128);


    Poke pika = new Poke("Pikachu", "pika.png", tackle, scratch, thunder, quickAttack);


    public Main() {
        menu = new Menu();


        setUpKeyListener();


    }


    //The paint method.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(grey);
        g2.fillRect(0,0,FRAMEWIDTH,FRAMEHEIGHT-200);



        if (pokeMenuVis){ //if we in battle, draw the battle area

            g2.setColor(sandColor);
            g2.fillOval(100,535,325,200);
            g2.setColor(sandColor.darker());
            g2.fillOval(112, 545,300,175);


            g2.setColor(sandColor);
            g2.fillOval(635,140,325,200);
            g2.setColor(sandColor.darker());
            g2.fillOval(650, 150,300,175);




            //poke box one
            g2.setColor(Color.black);
            g2.fillRect(70,70,360,160);

            g2.setColor(Color.white);
            g2.fillRect(75,75,350,150);
            //end poke box one



            //start poke box 2

            g2.setColor(Color.black);
            g2.fillRect(595,370,360,160);

            g2.setColor(Color.white);
            g2.fillRect(600,375,350,150);

            // end of battle area (groud where they stand

            g2.setColor(Color.black);

            g2.setFont(pokeText);
            g2.drawString(pika.getName(), 100,110 );  //TODO: ENEMY NAME
            g2.drawString(pika.getName(),0,0);
            g2.setFont(norm);



        }





        menu.draw(g2);

        if (pokeMenuVis) {
            pika.drawPokeStuff(g2);
            repaint();
        }

        g2.setFont(norm);


        //this is the grid
        g2.setColor(Color.red);
        for (int i = 0; i < FRAMEWIDTH; i += 25) {
            g2.drawLine(i, 0, i, FRAMEWIDTH);
            g2.drawString("" + i, i, 12);
        }
        for (int i = 0; i < FRAMEWIDTH; i += 25) {
            g2.drawLine(0, i, FRAMEWIDTH, i);
            g2.drawString("" + i, 1, i);
        }

        //end grid



    }

    public void setUpKeyListener() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

                if (!clickedOpt) { //this makes us able to use the right menu

                    if (menu.isOnFight()) { // if its on "Fight"
                        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {  // if it moves right,
                            menu.setOnPoke(true);
                            menu.setOnFight(false);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                            menu.setOnBag(true);
                            menu.setOnFight(false);
                        }
                    }
                    // end of options for "Fight"

                    //start of options for "Poke"

                    if (menu.isOnPoke()) {
                        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {  // if it moves right,
                            menu.setOnPoke(false);
                            menu.setOnFight(true);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                            menu.setOnRun(true);
                            menu.setOnPoke(false);
                        }
                    }

                    //end of options for "Poke"

                    //start of options for "bag"

                    if (menu.isOnBag()) {
                        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {  // if it moves right,
                            menu.setOnBag(false);
                            menu.setOnFight(true);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                            menu.setOnRun(true);
                            menu.setOnBag(false);
                        }
                    }

                    //end of options for bag

                    //start of run options

                    if (menu.isOnRun()) {
                        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {  // if it moves right,
                            menu.setOnPoke(true);
                            menu.setOnRun(false);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                            menu.setOnRun(false);
                            menu.setOnBag(true);
                        }
                    }

                } else {
                    menu.setOnFight(false);
                    menu.setOnBag(false);
                    menu.setOnPoke(false);
                    menu.setOnRun(false);


                } // end of right menu


                if (keyEvent.getKeyCode() == KeyEvent.VK_Q) { // if an option is clicked
                    clickedOpt = true;


                    if (menu.isOnFight()) { // if the option is fight

                        pokeMenuVis = true;


                    }

                }

                //TODO: add all the other options other than "Fight"
                // END OF RIGHT SIDE OPTIONS


                //START OF POKE MOVE OPTIONS

                if (pokeMenuVis) {// if the poke menu is out

                    if (pika.isPosOne()) { // if its on "Fight"
                        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {  // if it moves right,
                            pika.setPosTwo(true);
                            pika.setPosOne(false);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                            pika.setPosThree(true);
                            pika.setPosOne(false);
                        }
                    }

                    if (pika.isPosTwo()) { // if its on move 2
                        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {  // if it moves right,
                            pika.setPosTwo(false);
                            pika.setPosOne(true);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                            pika.setPosFour(true);
                            pika.setPosTwo(false);
                        }
                    }

                    if (pika.isPosThree()) { // if its on move 3
                        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {  // if it moves right,
                            pika.setPosFour(true);
                            pika.setPosThree(false);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                            pika.setPosThree(false);
                            pika.setPosOne(true);
                        }
                    }

                    if (pika.isPosFour()) { // if its on move four
                        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {  // if it moves right,
                            pika.setPosThree(true);
                            pika.setPosFour(false);

                        }
                        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                            pika.setPosTwo(true);
                            pika.setPosFour(false);
                        }
                    }


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

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}