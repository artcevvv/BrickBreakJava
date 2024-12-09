import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick {
    private int x, y;
    private int width = 60, height = 20;
    private boolean visible = true;

    public Brick(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public void draw(Graphics g) {
        if (visible) {
            g.fillRect(x, y, width, height);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
}
