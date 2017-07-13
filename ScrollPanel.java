
import java.awt.Color;
import java.awt.Robot;
//code is still ugly
public class ScrollPanel extends javax.swing.JPanel
{
    private int w,l,x,y;
    public ScrollPanel(int width, int length)
    {
        w = width;
        l = length;
        this.setSize(width, length);
        this.setBackground(new Color(0,0,0,0));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e)
            {
                mouseMovedEvent(e);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                mouseEnteredEvent(e);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                mouseExitEvent(e);
            }
        });
    }
    public void mouseMovedEvent(java.awt.event.MouseEvent e)  //re evaluate and tidy  //uses lots of memory 50%+ maybe use onclick
    {
//        try
//        {
//            Robot r = new Robot();
//            for(int ctr=0;ctr<2;ctr++)
//            {
//                //r.mouseMove(this.getLocation().x+(w/2)+ctr, this.getLocation().y+(l/2)+30+ctr);
//                r.mouseMove(e.getXOnScreen(), e.getYOnScreen());
//                r.mouseMove(e.getXOnScreen()+1, e.getYOnScreen()+1);
//                r.mouseMove(e.getXOnScreen(), e.getYOnScreen());
//            }
//            //r.mouseMove(x,y);
//        }
//        catch(java.awt.AWTException ex)
//        {
//            
//        }
    }
    public void mouseEnteredEvent(java.awt.event.MouseEvent e)
    {
        //this.setBackground(Color.yellow);
    }
    public void mouseExitEvent(java.awt.event.MouseEvent e)
    {
        //this.setBackground(Color.white);
    }
}
