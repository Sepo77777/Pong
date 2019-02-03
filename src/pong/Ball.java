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
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        setBackground(Color.WHITE);
        setOpaque(true);
        inGame = true;
    }

    @Override
    public void run()
    {
        while (inGame)
        {
            if (yPosition == 0 || yPosition == board.getYSize() - 46)
            {
                yVelocity *= -1;
            }
            if (xPosition == 10 && yPosition >= board.getPlayer(true).getYPosition() && yPosition <= board.getPlayer(true).getYPosition() + 100
                || xPosition == board.getXSize() - 25 && yPosition >= board.getPlayer(false).getYPosition() 
                && yPosition <= board.getPlayer(false).getYPosition() + 100)
            {
                xVelocity *= -1;
            }
            if (xPosition == 0)
            {
                inGame = false;
                board.score(true);
                board.remove(this);
            }
            if (xPosition == board.getXSize() - 1)
            {
                inGame = false;
                board.score(false);
                board.remove(this);
            }
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
