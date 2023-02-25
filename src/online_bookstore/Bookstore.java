package online_bookstore;

import java.sql.*;
import java.util.Scanner;

public class Bookstore {
	 void bookstore() {
		 int count=0,price=0,input=0,stocks=0;
		 int mysterystocks=0,fantasystocks=0,thrillerstocks=0,childrensstocks=0,historicalstocks=0;
	 
		 Scanner sc = new Scanner(System.in);
	     while(input < 6) {
	    	 System.out.println("\n###@Choose the book@###");
			 System.out.println("\t1.mystery");
			 System.out.println("\t2.fantasy");
			 System.out.println("\t3.thriller");
			 System.out.println("\t4.childrens literature");
			 System.out.println("\t5.historical fiction");
			 System.out.println("\tpress 6 to exit");
			 
			System.out.println("Enter the book sno");
			
			 input=sc.nextInt();
			 
		switch(input) {
		case 1:
			
			stocks=dbconnection(mysterystocks,input);
			if(stocks > 0){
			System.out.println("Mystery is in stock \t"+"price=250");
			System.out.println("Enter how many book want:");
			count=sc.nextInt();
			stocks=stocks-count;
			dbupdate(stocks,input);
			price=250*count;
			System.out.print("total book price is "+price);
			payment(price);
			}
			else{
				System.out.print("stocks not available");
			}
			
		break;
		case 2:
			stocks=dbconnection(fantasystocks,input);
			if(stocks > 0){
			System.out.println("Fantasy is in stock\n price=500\n");
			System.out.println("enter how many book want:");
			count=sc.nextInt();
			stocks=stocks-count;
			dbupdate(stocks,input);
			price=500*count;
			System.out.print("total book price is \n"+price);
			payment(price);
			}
			else{
				System.out.println("Stocks not available");
			}
		break;
		case 3:
			stocks=dbconnection(thrillerstocks,input);
			if(stocks > 0){
			System.out.println("Thriller is in stock\n"+"price=250\n");
			System.out.println("enter how many book want:");
			count=sc.nextInt();
			stocks=stocks-count;
			dbupdate(stocks,input);
			price=250*count;
			System.out.print("total book price is \n"+price);
			payment(price);
			}
			else{
				System.out.println("Stocks not available");
			}
		break;
		case 4:
			stocks=dbconnection(childrensstocks,input);
			if(stocks > 0){
			System.out.println("childrens litrature is in stock\n"+"price=350\n");
			System.out.println("enter how many book want:");
			count=sc.nextInt();
			stocks=stocks-count;
			dbupdate(stocks,input);
			price=350*count;
			System.out.print("total book price is "+price);
			payment(price);
			}
			else{
				System.out.println("Stocks not available");
			}
		break;
		case 5:
			stocks=dbconnection(historicalstocks,input);
			if(stocks >0){
			System.out.println("Historical fiction is in stock\n"+"price=550\n");
			System.out.println("enter how many book want:");
			count=sc.nextInt();
			stocks=stocks-count;
			dbupdate(stocks,input);
			price=550*count;
			System.out.print("total book price is \n"+price);
			payment(price);
			}
			else{
				System.out.println("Stocks not available");
			}
		break;
		case 6:
			return ;
		default:
			System.out.println("---This book is not found---");
			System.exit(0);

	     } 
		 	}}
	 


	 public static int dbconnection(int stocks,int input) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select stocks from books where id="+input+";");
				
				while(rs.next()){
				System.out.println("stocks"+rs.getInt(1));
				stocks=rs.getInt(1);
				}
			
				con.close();
			
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
			return stocks;
	 }
	 
	 public static int dbupdate(int stocks,int input){
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
				Statement st = con.createStatement();
				st.executeUpdate("update books set stocks="+stocks+" where id="+input+";");
				
				
			
				con.close();
			
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
			return stocks;	 
		 
	 }
	 
	 public static void payment(int price) {
		 Scanner sc = new Scanner(System.in);
		 int usercost;
		 
	 
		 System.out.println("\nSelect the payment method");
		 System.out.println("1.press ONE for cash on delivery");
		 System.out.println("2.press TWO for online payment");
		 int num=sc.nextInt();
		       if(num==1) {
		     	  System.out.println("you pressed cash on delivery" +" "+ "your order is confirmed");
		     	  System.out.println("Soon we have deliver the book");
		     	  System.out.println("Thank you for choosing us!!!!!!");
		     	  
		       }
		       else {
		     	  System.out.println("you pressed online payment"+ " " +"please fill your details");
		     	  System.out.println("Enter your bank name:");
		     	  sc.next();
		     	  System.out.println("Enter your bank ACCOUNT NO:");
		     	  sc.nextLong();
		     	  sc.nextLine();
		     	  System.out.println("Enter your bank IFSC code:");
		     	  sc.nextLine();
		     	  
		     	  while(true){
		     	  System.out.println("Enter the price of books:");
		     	  usercost=sc.nextInt();
		     	  if(usercost==price){
		     	  System.out.println("Soon we have deliver the book.....");
		     	  System.out.println("Thank you for choosing us!!!!!!");
		     	  break;
		     	  }
		     	  else{
		     		  System.out.println("unable to purchace \n please enter correct amount of the book");
		     		  System.out.println("your amount is ="+price);
		     	  }}
		     	  
		       }
	 }




}