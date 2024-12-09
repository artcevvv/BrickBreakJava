import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y;
    private int diameter = 20;
    private int xSpeed = 2, ySpeed = -2;

    public Ball(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return diameter;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void draw(Graphics g) {
        g.fillOval(x, y, diameter, diameter);
    }

    public void reverseYSpeed() {
        ySpeed = -ySpeed;
    }

    public void reverseXSpeed() {
        xSpeed = -xSpeed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }
}
