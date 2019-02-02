package pong;

import java.awt.Color;

import javax.swing.JLabel;

public class Ball extends JLabel implements Runnable
{
    private static final long serialVersionUID = -680279717659900612L;
    private Board board;
    private int xPosition, yPosition, xVelocity, yVelocity;
    private boolean inGame;
    
    public Ball(Board board, int xPosition, int yPosition, int xVelocity, int yVelocity)
    {
        this.board = board;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        setBackground(Color.WHITE);
        setOpaque(true);
        inGame = true;
    }

    @Override
    public void run()
    {
        while (inGame)
        {
            xPosition += xVelocity;
            yPosition += yVelocity;
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            board.updateBallPosition(xPosition, yPosition);
        }
    }

}
