package HW4;

/*
Title: Bank
Date: 1 October 2021
Author: Esha Sawant
Abstract: The code creates max 5 bank accounts. If a bank account with the same SSN number exists then the balance is updated in the existing account.
It opens and closes accounts, updates address and balance, and gives bank and account information.
*/
import java.util.*;
public class Bank {
    private final String name;
    public static int numofAccounts=0;
    Account[] acc1=new Account[5];
    //ArrayList<String> li = new ArrayList<String>();
    //private Customer accountHolder;

    public Bank(String name){
        this.name=name;
        //System.out.println(acc1);
    }

    public boolean openAccount(String name, String addr, int ssn,int accNum,int accType, double balance){
       Account acc=new Account(name,addr,ssn,accNum,accType,balance);
       if (numofAccounts < 5) {
           if(ssnCheck(ssn,accNum,balance)==true){
               acc1[numofAccounts++] = acc;
           return true;
       }
       }
        return false;
    }

    private boolean ssnCheck(int ssn,int accNum,double bal){
        for(Account a: acc1) {
            if (a != null) {
                if ((a.accountHolder.ssn == ssn) | (a.accountHolder.accNum == accNum)) {
                    Balance(ssn, bal);
                    a = null;
                    return false;
                }
            }
        }
            return true;
    }

    public boolean closeAccount(int accNo){
        for(Account a:acc1){
            if(a==null){
                return false;
            }
            /*
            else{for(int i=0;i<acc1.length;i++){
                if(a!=null){
                    if(a.accountHolder.accNum==accNo){
                        acc1[i]=null;
                    }
                }
            }
            }
          */
            if(a!=null){
            //if(a.accountHolder!=null){
                if(a.accountHolder.accNum==accNo){
                    a=null;
                    return true;
               }
            }

            }
        return false;
    }


    public boolean updateAddress(int accNum, String addr){
        for(Account a:acc1){
            if(a!=null){
                if(a.accountHolder.accNum == accNum){
                    a.accountHolder.address=addr;
                    return true;
            }
            }
        }
        return false;
    }


    public void bankInfo(){
       double tot=0;
        System.out.println("Bank Name:"+this.name);
        System.out.println("Number of accounts: "+numofAccounts);
        for(Account a:acc1){
            if(a!=null){
                tot+=a.accountHolder.balance;
                System.out.println("\t"+a.accountHolder.accNum+" : $"+String.format("%.2f",a.accountHolder.balance)+" : "+a.accountHolder.name+" : "+a.accountHolder.ssn);
            }
        }
        System.out.println("Bank Total Balance: $"+String.format("%.2f",tot));
    }


    public boolean accountInfo(int accNum) {
        for(Account a:acc1){
            if(a!=null){
                if(a.accountHolder.accNum==accNum){
                    System.out.println("Account Info:\tAccount Number"+a.accountHolder.accNum);
                    System.out.println("Checking Account");
                    System.out.println("Balance: $"+String.format("%.2f",a.accountHolder.balance));
                    System.out.println("Customer: "+a.accountHolder.name);
                    System.out.println("Address: "+a.accountHolder.address);
                    System.out.println("SSN: "+a.accountHolder.ssn);
                }
            }
        }
        return false;
    }

    public void updateBalance(int accNo,double amt){
        for(Account a:acc1){
            if(a!=null){
                if(a.accountHolder.accNum==accNo){
                    a.accountHolder.balance=amt;
            }
        }
        }
    }

    private void Balance(int ssn,double amt){
        for(Account a:acc1){
            if(a!=null){
                if(a.accountHolder.ssn==ssn){
                    a.accountHolder.balance=amt;
                }
            }
        }

    }
}
