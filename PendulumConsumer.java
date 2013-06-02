/** PendulumConsumer.java
 */

import javax.swing.JFrame;
import java.awt.Dimension;

public class PendulumConsumer extends JFrame
{
    private static final String TITLE = "Double Pendulum";
    private static final int WIDTH = 800, HEIGHT = 800;

    public PendulumConsumer()
    {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        add(new PendulumComponent(WIDTH, HEIGHT));

        pack();
        setVisible(true);
    }

    private class PendulumComponent
    {
        public PendulumComponent(int w, int h)
        {
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage();
        }
    }
}
