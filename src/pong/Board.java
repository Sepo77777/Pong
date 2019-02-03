package pong;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Board extends JFrame
{
    private static final long serialVersionUID = -2879881297595065704L;
    private int xSize, ySize, firstScore, secondScore;
    private Player playerOne, playerTwo;
    private Ball ball;
    private JLabel firstLabel, secondLabel;
    
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
        playerOne = new Player(this, 0, ySize / 2 - 100);
        playerTwo = new Player(this, xSize - 17, ySize / 2 - 100);
        add(playerOne);
        add(playerTwo);
        playerOne.setBounds(0, ySize / 2 - 100, 10, 100);
        playerTwo.setBounds(xSize - 17, ySize / 2 - 100, 10, 100);
        ball = new Ball(this, xSize / 2 - 10, ySize / 2 - 10, 1, -1);
        add(ball);
        ball.setBounds(xSize / 2 - 10, ySize / 2 - 10, 10, 10);
        Thread t = new Thread(ball);
        t.start();
        addKeyListener(new MultiKeyListener(playerOne, true));
        addKeyListener(new MultiKeyListener(playerTwo, false));
        firstLabel = new JLabel("0");
        secondLabel = new JLabel("0");
        firstLabel.setForeground(Color.WHITE);
        secondLabel.setForeground(Color.WHITE);
        add(firstLabel);
        add(secondLabel);
        firstLabel.setBounds(xSize / 2 - 10, 0, 10, 10);
        secondLabel.setBounds(xSize / 2 + 10, 0, 10, 10);
        
    }
    
    public int getXSize()
    {
        return xSize;
    }
    
    public int getYSize()
    {
        return ySize;
    }
    
    public Player getPlayer(boolean firstPlayer)
    {
        if (firstPlayer)
        {
            return playerOne;
        }
        else
        {
            return playerTwo;
        }
    }
    
    public void score(boolean firstPlayer)
    {
        if (firstPlayer)
        {
            firstScore++;
            firstLabel.setText(Integer.toString(firstScore));
        }
        else
        {
            secondScore++;
            secondLabel.setText(Integer.toString(secondScore));
        }
        repaint();
        newBall();
    }

    public void newBall()
    {
        int random = (int) (Math.random() * 2);
        int random2 = (int) (Math.random() * 2);
        int xVelocity, yVelocity;
        if (random == 0)
        {
            xVelocity = 1;
        }
        else 
        {
            xVelocity = -1;
        }
        if (random2 == 0)
        {
            yVelocity = 1;
        }
        else
        {
            yVelocity = -1;
        }
        ball = new Ball(this, xSize / 2 - 10, ySize / 2 - 10, xVelocity, yVelocity);
        add(ball);
        ball.setBounds(xSize / 2 - 10, ySize / 2 - 10, 10, 10);
        Thread t = new Thread(ball);
        t.start();
    }
    
    public void updateBallPosition(int xPosition, int yPosition)
    {
        ball.setLocation(xPosition, yPosition);
        repaint();
    }
    
    public void updatePlayerPosition(int xPosition, int yPosition, boolean firstPlayer)
    {  
        if (firstPlayer)
        {
            playerOne.setLocation(xPosition, yPosition);
        }
        else
        {
            playerTwo.setLocation(xPosition, yPosition);
        }   
        repaint();
    }
}
