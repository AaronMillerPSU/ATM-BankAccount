// Aaron Miller(agm5262@psu.edu) and Patrick Leeper(leeper@psu.edu)
// Lab/Homework 6
// Due 11/29/17
// ATMGUI.java

//*******************************************************
// program used to build a screen showing a msg area,
// input area, numbered keypad, vertical column of buttons,
// and an account dropdown box. includes functional keypad
// and is able to verify pin numbers for each account
//********************************************************


   import javax.swing.*;
   import java.awt.*;    // container class located
   import java.awt.event.*;  // actionListener interface

    public class ATMGUI extends JFrame implements ActionListener
   {
      private Container contentPane;   
	   private final static int NBUTTONS = 12;    //constant for number of kepad buttons
      private JPanel northJPanel = new JPanel();   
      private JPanel northDisplayJPanel = new JPanel();
      private JPanel northEnterJPanel = new JPanel();
      private JPanel southJPanel = new JPanel();
      private JComboBox accountBox;    //jcombobox with account numbers
      private JPanel eastButtonJPanel = new JPanel(); 
      private JPanel buttonJPanel = new JPanel();  
      private JPanel keyPadJPanel = new JPanel(); 
      private JLabel prompt = new JLabel("Account Number:        ");    //jlabel next to account number jcombobox
      private JTextField enterField = new JTextField(15);
      private JTextArea display = new JTextArea(5,30);     //text area for prompts and information
      private JButton enterButton = new JButton   ("<html><font size=4>Enter</font></html>");   //button to enter and check pin
      private JButton balanceButton = new JButton ("<html><font size=4>Balance</font></html>");    //check balance of selected account
      private JButton withDrawButton = new JButton("<html><font size=4>Withdraw</font></html>");    //withdraw funds from selected account
      private JButton doneButton = new JButton    ("<html><font size=4>Done</font></html>");    //resets gui for a new account to log in
      private JButton buttons[];    //array of jbuttons for keypad
      BankAccount[] accounts = new BankAccount[5];    //array of bankaccount objects for storing account info
      String accountNumber[] = new String[5];    //array of strings for storing account numbers
      private String labels[] =     //string labels for the keypad
      {"1","2","3",
         "4","5","6",
         "7","8","9",
         " ","0"," "};		
         		
  
 //---------------GUI----------------------------------------------------------        
   	  public ATMGUI(String title) 
      {
         buildGUI();
		   setLocation(200,150); // position window on screen (x,y)
         setTitle(title);
         setSize(600,500);  // width, height
         setVisible(true);  // makes the GUI appear in the window
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits JFRAME APPL.
      
      } // end ATMAppletGUI
      
       private void buildGUI()     // builds the necesary panels

      {
         contentPane = getContentPane();
		   buildNorthPanel();
         buildCenterPanel();
         buildSouthPanel();
      
         return;
      }// end buildGUI
      
       // method that builds a north panel and adds display to it
       private void buildNorthPanel()   
      {
         northJPanel.setLayout(new BorderLayout(0,0));    
         northDisplayJPanel.add(Box.createRigidArea(new Dimension(0,100)));
         northDisplayJPanel.add(display);   
         northJPanel.add("North",northDisplayJPanel);    
      
         display.setEditable(false);
         northEnterJPanel.add(enterField);
         northJPanel.add("South",northEnterJPanel);
         enterField.setEditable(false);
			
         add("North",northJPanel);
         display.append("Please select your account number");
         return;
      }// end buildNorthPanel
         	

		
   	 // builds center panel and adds several buttons along with an array of buttons
       private void buildCenterPanel()
       {
         buttonJPanel.add(Box.createRigidArea(new Dimension(20,250)));
         keyPadJPanel.setLayout(new GridLayout(4,3,0,0));
         buttons = new JButton[NBUTTONS];
         for (int k=0; k < buttons.length; k++)    //for loop that creates, disables, and adds keypad buttons to keypadpaneljpanel
         {
            buttons[k] = new JButton(labels[k]);
            buttons[k].addActionListener(this);
            buttons[k].setEnabled(false);
            keyPadJPanel.add(buttons[k]);
         } // end for
               	
            buttonJPanel.add(keyPadJPanel,"Center");
         
            eastButtonJPanel.setLayout(new BoxLayout(eastButtonJPanel,BoxLayout.Y_AXIS));
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(25,0)));
            
            //disables function buttons so the user properly uses the gui
            doneButton.setEnabled(false);
            enterButton.setEnabled(false);
            balanceButton.setEnabled(false);
            withDrawButton.setEnabled(false);
            
            //adds action listener to buttons and adds buttons to eastbuttonjpanel
            eastButtonJPanel.add(enterButton);
            enterButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));
            
            eastButtonJPanel.add(balanceButton);
            balanceButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));
            
            eastButtonJPanel.add(withDrawButton);
            withDrawButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));
            
            eastButtonJPanel.add(doneButton);
            doneButton.addActionListener(this);
            eastButtonJPanel.add(Box.createRigidArea(new Dimension(0,5)));      
         
            buttonJPanel.add("East",eastButtonJPanel); 
         
            add("Center",buttonJPanel);
         return;
       }// end buildCenterPanel
         	
       // builds south panel where user will select their account
       private void buildSouthPanel()   
       {
      
         accountBox = new JComboBox();
         accountBox.setMaximumRowCount(3);
         
         loadAccounts();   //loads appropriate info into each account
         populateAccounts();     //populates the jcombobox with account numbers
         accountBox.addActionListener(this);
         
         southJPanel.add(prompt);
         southJPanel.add(accountBox);                            
      
         contentPane.add("South", southJPanel); // adding input panel to north area
      
         return;
      } // end buildSouthPanel      
 //---------------END GUI-------------------------------------------------------    


      private void populateAccounts()   //method for adding each account number to the jcombobox       
      {

         //loops through each accountnumber string in the account number array and adds each to jcombobox 
         for (int i=0; i<accountNumber.length; i++)   
         {
            accountNumber[i] = String.valueOf(accounts[i].getAccountNumber());
            accountBox.addItem(accountNumber[i]);
         }
         return;
      }
            
      private void loadAccounts()    //method for loading each account's respective bank info
      {
         //loops through bankaccount objects and assigns each its bank info
         for (int i=0; i<accounts.length; i++)
         { 
            double defaultBalance = 500.75;         
            accounts[i] = new BankAccount((1000 + 1000 * i), 9999 - i, defaultBalance + 500.34 * i);
         }

         
         return;
      }
      
 //---------------ACTION PERFORMED-----------------------------------------------     
      public void actionPerformed(ActionEvent e)  //adds fucntionality to the atm gui
      {
         
         if(e.getSource() == accountBox)  //ensures the first thing the user clicks is the jcombobox then disables it
         {                                //also prompts user for their pin number after selecting their account 
              accountBox.setEnabled(false);
              display.setText("");
              enableKeypad();
              doneButton.setEnabled(true);
              display.setText("Please type in your PIN number.");
         }//end ComboBox AP
         
         else if(e.getSource() == balanceButton)   //enabled after successful pin entry, displays acct balance
         {
               display.setText("Balance Selected");  
         }//end Balance Button AP
         
         else if(e.getSource() == withDrawButton)  //enabled after successful pin entry, allows funds to be withdrawn
         {
               display.setText("Withdraw Selected");  
         }//end Withdraw Button AP
         
         else if(e.getSource() == doneButton)   //calls on resetgui method to reset entire gui 
         {
               resetGUI();  
         }//end Withdraw Button AP
         
         else if(e.getSource() == enterButton)  //enabled after user uses the keypad
         {
            String userPin = enterField.getText(); //stores the submitted pin as a string
            
            String accountNumberString = String.valueOf(accountBox.getSelectedItem()); //stores account number as a string
            int accountNumberInt = Integer.parseInt(accountNumberString.toString());   //converts string pin to int
   
              for(int i=0; i < accounts.length; i++)  //loops through accounts string array 
               {
                  
                  //checks if the user selected acct matches the corresponding acct number in the array
                  if(accountNumberInt == accounts[i].getAccountNumber())   
                  {
                     //after finding matching account, verifies that the submitted pin is correct 
                     //also enables all function buttons but done
                     if(accounts[i].verifyPIN(Integer.parseInt(userPin)))
                     {
                        display.setText("");
                        enterField.setText("");
                        enterButton.setEnabled(false);
                        disableKeypad();
                        balanceButton.setEnabled(true);
                        withDrawButton.setEnabled(true);
                        display.setText("Welcome to ATM Banking.");
                     }
                     else  //prompts user to retype pin if it is incorrect
                     {
                        enterField.setText("");
                        display.setText("PIN is incorrect. Please re-enter PIN");
                     }
                   }
                 }
             } 
         
             
         //end Enter Button AP
         
         else  //keypad functionality, enables enter button after keypad is used
         {       
               String keyLabel = ((JButton)e.getSource()).getText();
               zeroToNineJButtonActionPerformed(keyLabel);
               enterButton.setEnabled(true);                       
         }//end Key Pad AP
         
         
         return;
      }	
 //---------------END ACTION PERFORMED-----------------------------------------------     
     
      private void enableKeypad()   //enables all functional buttons on keypad
      {
           for (int i=0; i < buttons.length; i++)
         {
            buttons[i].setEnabled(true);
            buttons[9].setEnabled(false);
            buttons[11].setEnabled(false);
         }
         
         return;
      }//end enabledKeypad
      
      private void disableKeypad()    //disables all buttons on keypad
      {
           for (int i=0; i < buttons.length; i++)
         {
            buttons[i].setEnabled(false);
         }
         
         return;
      }//end disabledKeypad
      
      private void zeroToNineJButtonActionPerformed(String num)   //adds each pressed button to pin output textfield
      {
         enterField.setText(enterField.getText() + num);
         
         return;
      }//end zeroToNineJButtonActionPerformed

     private void resetGUI() //when done is pressed, resets and disables all gui except the account jcombobox
     {
         display.setText("Please type in your PIN number.");
         enterField.setText("");
         enterButton.setEnabled(false);
         withDrawButton.setEnabled(false);
         doneButton.setEnabled(false);
         balanceButton.setEnabled(false);
         accountBox.setEnabled(true);
         disableKeypad();
         return;
     }
      
      
   }