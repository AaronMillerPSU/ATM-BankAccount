   import javax.swing.*;
   import java.awt.*;    // container class located
   import java.awt.event.*;  // actionListener interface.

//
// ATMGUI Class used to define the JFrame and set up the actionlister feature
//
    public class ATMGUI extends JFrame implements ActionListener
   {
      private Container contentPane; 
      private JTextArea outArea;
      private JTextField inField;
      private JButton numbersButton;
      private JButton optionsButton;
      private JComboBox accountBox;
              
       public ATMGUI(String title) 
      {
         buildGUI();
         setLocation(200,150); // position window on screen (x,y)
         setTitle(title);
         setSize(600,500);  // width, height
         setVisible(true);  // makes the GUI appear in the window
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits JFRAME APPL.
      						 // uses a qualified name for a class constant
      
      } // GuessTheNumberGUI 
   
   
       private void buildGUI()		// designed to build the contentpane with panels
      {
         contentPane = getContentPane();
         buildNorthPanel();
         buildCenterPanel();
         buildSouthPanel();
         return;
      
      } // end buildGUI()
   
       private void buildNorthPanel()	
      {                                
         JPanel northPanel;
         JPanel nPanel;			
         JPanel sPanel;    
          
      
         northPanel = new JPanel(); // instantiation
         nPanel = new JPanel();        
         sPanel = new JPanel(); 
         outArea = new JTextArea(10,40);
         inField = new JTextField(5);
         
         outArea.setEditable(false);
         inField.setEditable(false);                            
      
         nPanel.add(outArea);
         sPanel.add(inField);
         northPanel.add(nPanel);
         northPanel.add(sPanel);
         northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));      
      
         contentPane.add("North", northPanel); // adding input panel to north area
      
         return;
      } // end buildNorthPanel()
   
       private void buildCenterPanel()   
      {
         JPanel centerPanel;
         JPanel numbersPanel;
         JPanel optionsPanel;
                  
         centerPanel = new JPanel();
         numbersPanel = new JPanel();
         optionsPanel = new JPanel();
         numbersButton = new JButton("Test 1");
         optionsButton = new JButton("Test 2");
         
         numbersPanel.add(numbersButton);
         numbersPanel.setLayout(new GridLayout(3,4));
         
         optionsPanel.add(optionsButton);
         optionsPanel.setLayout(new BoxLayout(optionsPanel,BoxLayout.Y_AXIS));
         optionsPanel.add(Box.createRigidArea(new Dimension(0,20)));
         
         centerPanel.add(numbersPanel);
         centerPanel.add(optionsPanel);
         
         contentPane.add("Center", centerPanel); 
               
         return;
      } // end buildCenterPanel
   
       private void buildSouthPanel()   // builds south panel where user will enter their guesses
      {
         JPanel southPanel;			
         JLabel accountLabel;
      
         southPanel = new JPanel();   
         accountLabel = new JLabel("Account Number: ");  // lookup these
         accountBox = new JComboBox();
         
         southPanel.add(accountLabel);
         southPanel.add(accountBox);                            
      
         contentPane.add("South", southPanel); // adding input panel to north area
      
         return;
      } // end buildSouthPanel
      
      public void actionPerformed(ActionEvent e)  
      {
         
         return;
      }// end action preformed	
      
   }