import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    int score;
    
    Timer timer;

    Ball ball;
    Paddle paddle;
    ArrayList<Brick> bricks;

    public GamePanel() {
        timer = new Timer(1000 / 60, this); // 60 FPS
        timer.start();
        this.setFocusable(true);
        this.addKeyListener(this);

        ball = new Ball(400, 300);
        paddle = new Paddle(350, 550);
        bricks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                bricks.add(new Brick(80 + j * 70, 50 + i * 30));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        paddle.draw(g);

        drawScore(g);

        for (Brick brick : bricks) {
            brick.draw(g);
        }

        if (checkGameOver()) {
            g.setColor(Color.red);
            g.drawString("Game over", 400, 300);
            g.setColor(Color.green);
            g.drawString("Score: "+score, 400, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        if(ball.getX() <= 0 || ball.getX() + ball.getWidth() >= getWidth()) {
            ball.reverseXSpeed();
        }

        if(ball.getY() <= 0 || ball.getY() + ball.getWidth() >= getWidth()) {
            ball.reverseYSpeed();
        }

        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.reverseYSpeed();
        }

        for (Brick brick : bricks) {
            if (brick.isVisible() && ball.getBounds().intersects(brick.getBounds())) {
                ball.reverseYSpeed();
                brick.setVisible(false);
                score++;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            paddle.move(-15);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            paddle.move(15);
        }
    }

    private boolean checkGameOver() {
        if (ball.getY() > getHeight()) {
            timer.stop();
            return true;
        }
        return false;
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Score: "+score, 10, 10);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
