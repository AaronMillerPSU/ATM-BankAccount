// Aaron Miller(agm5262@psu.edu) and Patrick Leeper(leeper@psu.edu)
// Lab/Homework 6
// Due 11/29/17
// BankAccount.java
// purpose of class
/**
  *Creates a bank account with a user defined account number, account PIN, and account balance.  Allows for
  *verification of PIN and withdrawl of funds
  */  
    public class BankAccount
   {
      private int accountNumber;		//holds the account number
      private int accountPIN;			//holds the PIN number
      private double accountBalance;//holds the current account balance
   
   /**
     *Default constructor sets account number, account PIN, and account balance to 0
     */
       public BankAccount()
      {	
         setAccountNumber(0); 
         setAccountPIN(0);  	
         setAccountBalance(0);
      }// end BankAccount()
   
   /**
     *Constructor sets account number, account PIN, and account balance with user defined values
     *@param
     */
       public BankAccount(int acctNum, int acctPIN, double acctBal)
      {
         setAccountNumber(acctNum);
         setAccountPIN(acctPIN);
         setAccountBalance(acctBal);
      }// end BankAccount(int, int, double)
   
   /**
     *Sets account number to user defined value
     *@param
     */
       public void setAccountNumber(int acctNum)
      {
         accountNumber = acctNum;
      
         return;
      }// end setAccountNumber
   
   /**
     *Sets account PIN to user defined value
     *@param
     */
       public void setAccountPIN(int acctPIN)
      {
         accountPIN = acctPIN;
      
         return;
      }// end setAccountPIN
   
   /**
     *Sets account balance to user defined value
     *@param
     */
       public void setAccountBalance(double acctBal)
      {
         accountBalance = acctBal;
      
         return;
      }// end setAccountBalance
   
   /**
     *Returns current value of account number
     */
       public int getAccountNumber()
      {
         return accountNumber;
      }// end getAccountNumber()
   
   /**
     *returns current value of account balance
     */
       public double getAccountBalance()
      {
         return accountBalance;
      }// end getAccountBalance
   
   /**
     *Compares value of PIN entered by user to correct PIN value.  Displays message 
     *to inform if PIN is correct or incorrect.
     *@param
     */
       public boolean verifyPIN(int userPIN)
      {
         if (userPIN == accountPIN)
         {
			return true;
         }// end if
         else
         {
            return false;
         }// end else
      }// end verifyPIN
   
   /**
     *Withdraws user defined value from current account balance.  Updates account balance
     *@param
     */
       public void withdrawFunds(double withdrawl)
      {
         accountBalance -= withdrawl;
         return;
      }// end withdrawFunds
   }// end BankAccount