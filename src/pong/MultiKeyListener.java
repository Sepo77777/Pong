package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;


public class MultiKeyListener implements KeyListener
{
    private Player player;
    private final Set<Integer> pressed = new HashSet<>();
    private boolean firstPlayer;
    
    public MultiKeyListener(Player player, boolean firstPlayer)
    {
        this.player = player;
        this.firstPlayer = firstPlayer;
    }

    @Override
    public synchronized void keyPressed(KeyEvent e)
    {
        pressed.add(e.getKeyCode());
        if (pressed.size() >= 1) 
        {
            Iterator<Integer> iter = pressed.iterator();
            while (iter.hasNext())
            {
                int keyCode = iter.next();
                switch (keyCode)
                {
                    case KeyEvent.VK_W:
                        if (firstPlayer)
                        {
                            player.moveUp();
                            player.getBoard().updatePlayerPosition(player.getXPosition(),  player.getYPosition(), firstPlayer);
                        }
                        break;
                    case KeyEvent.VK_S:
                        if (firstPlayer)
                        {
                            player.moveDown();
                            player.getBoard().updatePlayerPosition(player.getXPosition(),  player.getYPosition(), firstPlayer); 
                        }
                        break;
                    case KeyEvent.VK_UP: 
                        if (!firstPlayer)
                        {
                            player.moveUp();
                            player.getBoard().updatePlayerPosition(player.getXPosition(),  player.getYPosition(), firstPlayer); 
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (!firstPlayer)
                        {
                            player.moveDown();
                            player.getBoard().updatePlayerPosition(player.getXPosition(),  player.getYPosition(), firstPlayer); 
                        }
                        break;
                }     
            }
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e)
    {
        pressed.remove(e.getKeyCode());
    }

    @Override
    public synchronized void keyTyped(KeyEvent e)
    {
    }
}
