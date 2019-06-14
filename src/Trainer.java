import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class Trainer {

    private int x;
    private String identity;
    private BufferedImage Brock;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

    public Trainer(int x,int y,String identity) {
        this.identity = identity;
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y ,48 ,72);
    }

    public void move(int changex, int changey){
        x= x+changex;
        y= y+changey;
        x = this.clamp(x,144,624);
        y = this.clamp(y,144,720);
    }

    public void draw(Graphics2D g2){
        if(identity == "Red") {
            g2.setColor(Color.RED);
            g2.fillRect(x, y, 48, 48);
        }
        if(identity == "Brock"){
            try {
                Brock = ImageIO.read(new File("res/" + "Brock.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            g2.drawImage(Brock,x,y,null);
           // g2.draw(getBounds());
        }
    }
    public static int clamp(int var, int min, int max){
        if (var>= max)
            return var = max;
        else if (var<= min )
            return var = min;
        else
            return var;
    }

}
