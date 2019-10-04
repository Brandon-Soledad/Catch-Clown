package mypackage;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by Brandizzy on 5/18/2017.
 */
public class Square extends GameObject {

    public Square(int x, int y, ID id){
        super(x, y , id);

        velX = 2;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(x <= 0 || x >= 609) velX *= -1;
        if(y <= 0 || y >= 480) velY *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);


    }
}

