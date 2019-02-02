package pong;

import java.awt.Color;

import javax.swing.JFrame;

public class Board extends JFrame
{
    private static final long serialVersionUID = -2879881297595065704L;
    private int xSize, ySize;
    private Player playerOne, playerTwo;
    private Ball ball;
    
    public static void main(String[] args)
    {
        new Board(1000, 500);
    }
    
    public Board(int xSize, int ySize)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        setSize(xSize, ySize);
        setTitle("Pong");
        setVisible(true);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        playerOne = new Player(this, 0, ySize / 2 - 1);
        playerTwo = new Player(this, xSize, ySize / 2 - 1);
        add(playerOne);
        add(playerTwo);
        playerOne.setBounds(0, ySize / 2 - 100, 10, 100);
        playerTwo.setBounds(xSize - 30, ySize / 2 - 100, 10, 100);
        ball = new Ball(this, xSize / 2, ySize / 2 - 1, (int) (Math.random() * 201) - 100, (int) (Math.random() * 201) - 100);
        add(ball);
        ball.setBounds(xSize / 2 - 10, ySize / 2 - 10, 10, 10);
        Thread t = new Thread(ball);
        t.start();  
    }

    public void updateBallPosition(int xPosition, int yPosition)
    {
        ball.setBounds(xPosition, yPosition, 10, 10);
        repaint();
    }
}
