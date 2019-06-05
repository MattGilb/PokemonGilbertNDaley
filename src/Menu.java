import java.awt.*;


public class Menu {


    private int oneX = 725, oneY = 675, twoX = 875, twoY = 675, threeX = 725, threeY = 750, fourX = 875, fourY = 750;
    private String fightStr = "Fight", bagStr = "Bag", pokeStr = "Poké", runStr = "Run";


    private Font menuFont = new Font("Verdana", Font.BOLD, 25);
    private boolean onFight, onPoke, onBag, onRun;


    public Menu() {

        onFight = true; // sets the first cursor to be onFight


    }


    public void draw(Graphics2D g2) {


        //the box of menu
        g2.setColor(Color.red.darker());
        g2.fillRect(0, 600, Main.FRAMEWIDTH - 2, 200);
        g2.setColor(Color.green.darker().darker());
        g2.fillRect(25, 625, 950, 150);
        //end of box menu

        //right options
        g2.setColor(Color.white);
        g2.setFont(menuFont);
        g2.drawString(fightStr, oneX, oneY);
        g2.drawString(pokeStr, twoX, twoY);
        g2.drawString(bagStr, threeX, threeY);
        g2.drawString(runStr, fourX, fourY);
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.black);
        g2.drawLine(700, 630, 700, 770);
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(1));


        //end of right options


        //start cursor
        if (onFight) {
            g2.fillOval(oneX - 13, oneY - 13, 10, 10);
        }
        if (onPoke) {
            g2.fillOval(twoX - 13, twoY - 13, 10, 10);
        }
        if (onBag) {
            g2.fillOval(threeX - 13, threeY - 13, 10, 10);
        }
        if (onRun) {
            g2.fillOval(fourX - 13, fourY - 13, 10, 10);
        }
        // end cursor


    }

    public boolean isOnFight() {
        return onFight;
    }

    public void setOnFight(boolean onFight) {
        this.onFight = onFight;
    }

    public boolean isOnPoke() {
        return onPoke;
    }

    public void setOnPoke(boolean onPoke) {
        this.onPoke = onPoke;
    }

    public boolean isOnBag() {
        return onBag;
    }

    public void setOnBag(boolean onBag) {
        this.onBag = onBag;
    }

    public boolean isOnRun() {
        return onRun;
    }

    public void setOnRun(boolean onRun) {
        this.onRun = onRun;
    }
}
