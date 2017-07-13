//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.Color;
//import javax.swing.BorderFactory;

//'TODO' notes are on the bottom of the code

public class TextElement extends javax.swing.JTextArea
{
    //added properties
    private int sizewidth, sizelength, longestline, currentline;
    
    public TextElement(char firstLetter)//location parameters will go here (and text parameter?)
    {
        //parent constructor
        super();
        
        //set properties
        this.longestline = 0;
        this.currentline = 0;
        this.sizewidth = 15;
        this.sizelength = 25;
        this.setSize(sizewidth, sizelength);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue)); //improve/learn more about this
        this.append(""+firstLetter);
        this.setBackground(new java.awt.Color(0,0,0,0));
        
        //create event listeners
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
        addKeyListener(new java.awt.event.KeyListener()
        {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e)
            {
                keyPressedEvent(e);
            }
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) 
            {
                keyTypedEvent(e);
            }
            @Override
            public void keyReleased(java.awt.event.KeyEvent ke) 
            {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    
    public void keyTypedEvent(java.awt.event.KeyEvent e)
    {
        if(this.isEditable())
        {
            currentline++;

            if(currentline > longestline)
            {
                longestline = currentline;
                sizewidth = this.getWidth()+5;
                this.setSize(sizewidth,sizelength);
            }
        }
    }
    public void keyPressedEvent(java.awt.event.KeyEvent e)
    {
        if(this.isEditable())
        {
            if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
            {
                sizelength = sizelength + 16;
                this.setSize(sizewidth,sizelength);
                currentline = 0;
            }
        }
    }
    public void mouseExitEvent(java.awt.event.MouseEvent e)
    {
        this.setBorder(null);
        this.setEditable(false);
        if(this.getText().trim().length() == 0) //if this textElement has no text inside it
        {
            //remove it, raise hand for removal
        }
    }
    public void mouseEnteredEvent(java.awt.event.MouseEvent e)
    {
        this.grabFocus();
        this.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue));
        this.setEditable(true);
    }
    
    //TODO: create a 'resize' function called whenever this object is edited
    //      that will replace code in the existing keyboard events
    //TODO: include in the resize function the ability to remove the textElement
    //      if there is no text inside (see mouseExitEvent())
}
