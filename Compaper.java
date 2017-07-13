public class Compaper extends javax.swing.JFrame 
{
    private javax.swing.JPanel totalGUI;
    //private Map map;
    //private javax.swing.JButton clearBtn;
    private Screen view;
    
    public Compaper() 
    {
        initComponents();
    }
    private void initComponents() 
    {
        //base panel
        totalGUI = new javax.swing.JPanel();
        totalGUI.setBackground(java.awt.Color.gray);
        totalGUI.setLayout(null);
        
        
        
        //screen
        view = new Screen();
        view.setLocation(0,0);
        totalGUI.add(view);
        
        //drawpad
//        map = new Map();
//        map.setLocation(0,0);
//        totalGUI.add(map);  //all controls added changed to drawpad instead of totalGUI
        
        
        
        //controls for testing
//        clearBtn = new javax.swing.JButton("shake");
//        clearBtn.setLocation(10,625);
//        clearBtn.setSize(120, 30);
//        clearBtn.addActionListener(new java.awt.event.ActionListener()
//        {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent evt)
//            {
//                clearPressed(evt);
//            }
//        });
        //totalGUI.add(clearBtn);
        
        //set up base panel
        setTitle("Compaper Alpha");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1160,700);
        setContentPane(totalGUI);
    }
//    public void clearPressed(java.awt.event.ActionEvent e)
//    {
//        view.map.removeAll();
//        view.map.clear();
//        view.repaint();
//    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compaper().setVisible(true);
            }
        });
    }
}
