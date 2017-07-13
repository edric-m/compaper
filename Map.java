
import java.util.ArrayList;

//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.RenderingHints;
//import java.awt.Toolkit;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.DataFlavor;
//import java.awt.datatransfer.UnsupportedFlavorException;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import javax.swing.JComponent;
//import javax.swing.SwingUtilities;

class Map extends javax.swing.JComponent
{
    private java.awt.Image image;
    private java.awt.Graphics2D graphics2D;
    private int currentX, currentY, oldX, oldY;
    private java.awt.datatransfer.Clipboard clipboard;
    //private TextElement text;  //list of textelements
    //private ArrayList<ArrayList<TextElement>> textGrid;
    
    public Map()
    {
        this.setSize(3000, 3000); //needed?
        clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
        //textGrid = new ArrayList<ArrayList<TextElement>>();
        
        
        setDoubleBuffered(false);
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e)
            {
                mousePressedEvent(e);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                panelMouseEnteredEvent(e);
            }
        });
        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e)
            {
                mouseDraggedEvent(e);
            }
            
        });
        addKeyListener(new java.awt.event.KeyAdapter()  //doesnt work if coming from draw pad why? (drawpad.addKeyLi...)
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e)
            {
                frameKeyTyped(e);
            }
            @Override
            public void keyPressed(java.awt.event.KeyEvent e)
            {
                frameKeyPressed(e);
            }
        });
    }
    
    @Override
    public void paintComponent(java.awt.Graphics g)
    {
        if(image == null)
        {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (java.awt.Graphics2D)image.getGraphics();
            graphics2D.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, 
                    java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        
        g.drawImage(image, 0, 0, null);
    }
    public void clear()
    {
        graphics2D.setPaint(java.awt.Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(java.awt.Color.black);
        repaint();
    }
    //below are events
    private void panelMouseEnteredEvent(java.awt.event.MouseEvent e)
    {
        requestFocus();
    }
    private void mousePressedEvent(java.awt.event.MouseEvent e)
    {
        if(javax.swing.SwingUtilities.isRightMouseButton(e))
        {
            graphics2D.setPaint(java.awt.Color.white);
            graphics2D.setStroke(new java.awt.BasicStroke(10));
        }
        else
        {
            graphics2D.setPaint(java.awt.Color.black);
            graphics2D.setStroke(new java.awt.BasicStroke(1));
        }
        oldX = e.getX();
        oldY = e.getY();
    }
    private void mouseDraggedEvent(java.awt.event.MouseEvent e)
    {
        currentX = e.getX();
        currentY = e.getY();

        graphics2D.drawLine(oldX, oldY, currentX, currentY);
        repaint();

        oldX = currentX;
        oldY = currentY;
    }
    private void frameKeyTyped(java.awt.event.KeyEvent e)
    {
        TextElement text;
        text = new TextElement(e.getKeyChar());
        text.setLocation(getMousePosition().x-3,getMousePosition().y-10);
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
    private void frameKeyPressed(java.awt.event.KeyEvent e)
    {
        if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F1)
        {
            try
            {
                java.awt.image.BufferedImage image = 
                        (java.awt.image.BufferedImage)clipboard.getData
                        (java.awt.datatransfer.DataFlavor.imageFlavor);
                graphics2D.drawImage(image, getMousePosition().x, 
                        getMousePosition().y, 
                        this);
            }
            catch(java.awt.datatransfer.UnsupportedFlavorException ufe)
            {
                ufe.printStackTrace();
            }
            catch(java.io.IOException ioe) 
            {
                ioe.printStackTrace();
            }
            repaint();
        }
    }
} 
