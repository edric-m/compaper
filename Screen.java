

//import java.util.*;

public class Screen extends javax.swing.JComponent
{
    private ScrollPanel top, bottom, left, right;
    private Map map;
    //private ArrayList l;
    private javax.swing.JButton button;
    private int width, length;
    public java.awt.Point point;
    
    public Screen()
    {
        width = 700;
        length = 1160;
        this.setSize(length, width);
        this.setLayout(null);
        point = new java.awt.Point(0,0);
        this.setFocusable(true);
        
        this.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e)
            {
                frameKeyTyped(e);
            }
        });
        top = new ScrollPanel(1160, 20);
        top.setLocation(0,1);
        top.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e)
            {
                point.y = point.y + 25;
                screenPositionChanged(e);
            }
        });
        this.add(top);
        
        bottom = new ScrollPanel(1160, 20);
        bottom.setLocation(0,600);
        bottom.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e)
            {
                point.y = point.y - 25;
                screenPositionChanged(e);
            }
        });
        this.add(bottom);
        
        left = new ScrollPanel(20, 580);
        left.setLocation(1,20);
        left.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e)
            {
                point.x = point.x -25;
                screenPositionChanged(e);
            }
        });
        this.add(left);
        
        right = new ScrollPanel(20, 580);
        right.setLocation(1124,20);
        right.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e)
            {
                point.x = point.x +25;
                screenPositionChanged(e);
            }
        });
        this.add(right);
        
        //l = new ArrayList();
        button = new javax.swing.JButton("clear");
        button.setLocation(10,625);
        button.setSize(100,30);
        button.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearPressed(evt);
            }
        });
        this.add(button);
        //l.add(button);
        map = new Map();
        map.setLocation(0,0);
        add(map);  
    }
    
    public void clearPressed(java.awt.event.ActionEvent e)
    {
        map.removeAll();
        map.clear();
    }
    private void frameKeyTyped(java.awt.event.KeyEvent e)
    {
        TextElement text;
        text = new TextElement(e.getKeyChar());
        text.setLocation(getMousePosition().x-3,getMousePosition().y-3);
        add(text);
        repaint();
        text.requestFocus();  //still messy
        
//        TextElement text;
//        int x,y;
//        text = new TextElement(e.getKeyChar());
//        ArrayList<TextElement> c = new ArrayList<TextElement>();
//        
//        x = getMousePosition().x-3 - this.point.x;
//        y = this.point.y + getMousePosition().y;
//        c.add(y, text);
//        textGrid.add(x, c);
    }
    public void screenPositionChanged(java.awt.event.MouseEvent e)
    {
        int x,y;
        //draw the list of elements
//        if(button.getLocation().x >= getScreenPosition().x)
//        {
//            if(button.getLocation().x <= getScreenPosition().x + length)
//            {
//                if(button.getLocation().y <= getScreenPosition().y)
//                {
//                    if(button.getLocation().y >= getScreenPosition().y - width)
//                    {
                        //x = 0 - point.x; //0 is button location (doesnt change)
                        //y = point.y - 0; //0 is button location (doesnt change)
                        //button.setLocation(x,y);
        
        x = 0 - point.x;
        y = point.y - 0;
        map.setLocation(x, y);
//                    }
//                }
//            }
//        }
    }
}
