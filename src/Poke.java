import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Poke {

    private Move moveOne, moveTwo, moveThree, moveFour;
    private String name, fileName;

    private int oneX = 100, oneY = 675, twoX = 475, twoY = 675, threeX = 100, threeY = 750, fourX = 475, fourY = 750;

    private boolean posOne, posTwo, posThree, posFour;
    private BufferedImage poke;

    public Poke(String name, String fileName, Move moveOne, Move moveTwo, Move moveThree, Move moveFour) {


        this.name = name;
        this.fileName = fileName;
        this.moveOne = moveOne;
        this.moveTwo = moveTwo;
        this.moveThree = moveThree;
        this.moveFour = moveFour;
        posOne = true;

    }


    public void drawPokeStuff(Graphics2D g2) {


        try {
            poke = ImageIO.read(new File("res/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }


        g2.setColor(Color.white);
        g2.drawString(moveOne.getName(), oneX, oneY);
        g2.drawString(moveTwo.getName(), twoX, twoY);
        g2.drawString(moveThree.getName(), threeX, threeY);
        g2.drawString(moveFour.getName(), fourX, fourY);


        if (posOne) {
            g2.fillOval(oneX - 13, oneY - 13, 10, 10);
        }
        if (posTwo) {
            g2.fillOval(twoX - 13, twoY - 13, 10, 10);
        }
        if (posThree) {
            g2.fillOval(threeX - 13, threeY - 13, 10, 10);
        }
        if (posFour) {
            g2.fillOval(fourX - 13, fourY - 13, 10, 10);
        }
        // end cursor


        g2.drawImage(poke, 150, 423, null);


    }


    public boolean isPosOne() {
        return posOne;
    }

    public void setPosOne(boolean posOne) {
        this.posOne = posOne;
    }

    public boolean isPosTwo() {
        return posTwo;
    }

    public void setPosTwo(boolean posTwo) {
        this.posTwo = posTwo;
    }

    public boolean isPosThree() {
        return posThree;
    }

    public void setPosThree(boolean posThree) {
        this.posThree = posThree;
    }

    public boolean isPosFour() {
        return posFour;
    }

    public void setPosFour(boolean posFour) {
        this.posFour = posFour;
    }

    public String getName() {
        return name;
    }
}
