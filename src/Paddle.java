import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
    private int x, y; 
    private int width = 100, height = 15;

    public Paddle(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    public void move(int direction) {
        x += direction;

        if (x < 0) x = 0;
        if (x > 800 - width) x = 800 - width;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
