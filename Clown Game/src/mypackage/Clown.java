package mypackage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by Brandizzy on 5/18/2017.
 */
public class Clown extends GameObject {

    private int speed = 1;
    private BufferedImage image;

    public Clown(int x, int y, ID id){
        super(x, y , id);

        BufferedImageLoader loader = new BufferedImageLoader();

        try{
            image = loader.loadImage("/clown.png");

        } catch (IOException e) {
            e.printStackTrace();
        }

        velX = speed;
        velY = speed;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if(x <= 0 || x >= 605) velX *= -1;
        if(y <= 0 || y >= 420) velY *= -1;

    }

    @Override
    public void render(Graphics g) {
    	
        g.drawImage(image, x, y, null);

    }
}


