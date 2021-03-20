package testPackage;
import java.util.Scanner;

import  loan.*;
import savingAccount.*;

class Customer extends LoanDetails implements Account{
	 Scanner s = new Scanner(System.in);

	public void withdrawal()
	{
		System.out.println("Enter withdrawal amount: ");
		int c1=0;
		while(c1<1)
		{
			
		
		int w=s.nextInt();
		if(w<balance)
		{
			c1+=1;
			balance-=w;
		}
		else 
		{
			System.out.println("Invalid withdrawal amount");

		}
		}
	}
	
	public void deposit()
	{
		System.out.println("Enter deposit amount: ");
		int w=s.nextInt();
		balance+=w;


	}
	public void display()
	{
		System.out.println("Account number: "+accno);
		System.out.println("Name: "+name);
		System.out.println("Balance: "+balance);

	}
	
	public void EMI_calc()
	{
		if(balance_loan!=0)
		{
			
		
			EMI=10000+(interest_rate*0.01*balance_loan);
			amount_paid+=EMI;
			balance-=EMI;
			//balance_loan-=10000;
			if(balance_loan-10000<0)
			{
				balance_loan=0;
				//amount_paid-=EMI;
				
			}
			else {
				balance_loan-=10000;
			}
		}
		else
		{
			System.out.println("Loan Paid off");
			EMI=0;
		}
		if(balance<0)
		{
			System.out.println("Bank Balance empty");
			java.lang.System.exit(1);
		}
		else
		{
			System.out.println("Balance loan amount: "+balance_loan);
			System.out.println("Total Amount paid:"+amount_paid);
			System.out.println("EMI:"+EMI);
			System.out.println("Total bank Balance: "+balance);
			System.out.println();
		}

	}
	
	public void remaining_installment()
	{
		double RI=balance_loan/10000;
		System.out.println(RI+" Installments left");

	}
	
	
	Customer()
	{
		System.out.println("Enter name: ");
		name=s.next();
		accno=cnt++;
		System.out.println("Enter balance: ");
		balance=s.nextInt();
		display();
		System.out.println("Enter loan account number: ");
		loan_accno=s.nextInt();
		System.out.println("Enter Loan amount: ");
		loan_amt=s.nextInt();
		System.out.println("Enter interest rate: ");
		interest_rate=s.nextDouble();
		System.out.println("Enter amount paid: ");
		amount_paid=s.nextInt();
		balance_loan=loan_amt-amount_paid;
	}
}

public class l6p1customerz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s = new Scanner(System.in);
		 Customer c=new Customer();
		System.out.println("Deposit: ");
		 c.deposit();
		 c.display();
		System.out.println("Withdrawal: ");
		 c.withdrawal();
		 c.display();
		System.out.println("2 EMI Payments: ");
		 c.EMI_calc();
		 c.EMI_calc();
		System.out.println("Remaining Installment: ");
		 c.remaining_installment();
		 
		 
	}

}
