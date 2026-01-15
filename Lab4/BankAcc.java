package Lab4;

import java.util.*;

class Last_Deposit
{
    int D,M,Y;
    Last_Deposit(int date,int month,int year)
    {
        D=date;
        M=month;
        Y=year;
    }
}

class Account
{
    static int no=1;
    int acc_no;
    char acc_type;
    double balance;
    Last_Deposit ld;

    Account(char acc_type,double balance,int date,int month,int year)
    {
        this.acc_type=acc_type;
        this.balance=balance;
        acc_no=no++;
        ld= new Last_Deposit(date,month,year);
    }

    void getBalance()
    {
        System.out.println("Balance: "+balance);
    }

    void deposit(double depo)
    {
        System.out.println("Amount deposited: "+depo);
        balance+=depo;
        System.out.println("Current Balance: "+balance);
    }

    void withdraw(double amo)
    {
        //override later
    }
}

class Standard extends Account
{


    Standard(char acc_type, double balance, int date, int month, int year) {
        super(acc_type, balance, date, month, year);
    }

    void withdraw(double amo)
    {
        double penalty=0.0;
        if(amo>100000)
        {
            penalty = amo * 0.5 / 100;
            System.out.println("Penalty: "+penalty);
        }
        System.out.println("Amount withdrawn: "+amo);
        balance-= (amo+penalty);
        System.out.println("Current Balance: "+balance);
    }
}

class Premium extends Account
{
    Premium(char acc_type, double balance, int date, int month, int year)
    {
        super(acc_type, balance, date, month, year);
    }

    void withdraw(double amo)
    {

        System.out.println("Amount withdrawn: "+amo);
        balance-=amo;
        System.out.println("Current Balance: "+balance);
    }
}

public class BankAcc
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Account a;

        System.out.println("Enter account type (S/P):");
        char type=sc.next().charAt(0);

        System.out.println("Enter initial balance:");
        double bal=sc.nextDouble();

        System.out.println("Enter last deposit date:");
        int d=sc.nextInt();int m=sc.nextInt();int y=sc.nextInt();

        if(type=='S' || type=='s') a=new Standard('S',bal,d,m,y);
        else a=new Premium('P',bal,d,m,y);

        a.getBalance();

        System.out.println("Enter deposit amount:");
        a.deposit(sc.nextDouble());
        System.out.println("Enter withdrawal amount:");
        a.withdraw(sc.nextDouble());
    }
}
