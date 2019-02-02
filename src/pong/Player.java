package pong;

import java.awt.Color;

import javax.swing.JLabel;

public class Player extends JLabel
{
    private static final long serialVersionUID = 6458617475249896299L;
    private int xPosition, yPosition;
    private Board board;
    
    public Player(Board board, int xPosition, int yPosition)
    {
        this.board = board;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        setBackground(Color.WHITE);
        setOpaque(true);
    }
}
