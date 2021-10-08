package HW4;

import HW4.*;

public class Account{
    private int accNum;
    private int accType;
    Customer accountHolder=new Customer();

    public Account(String name,String addr,int ssn,int accNum,int accType,double balance){

        //Customer accountHolder =new Customer();
        accountHolder.name=name;
        accountHolder.address=addr;
        this.accType=accType;
        accountHolder.accNum=accNum;
        accountHolder.ssn=ssn;
        accountHolder.balance=balance;
    }
}
