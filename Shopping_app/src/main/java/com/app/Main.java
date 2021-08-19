package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.customer.service.CustomerService;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.customer.service.impl.CustomerServiceImpl;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		log.info("               Online Shopping Application..!    ");
		log.info("    **************************************************");
		log.info("1)For customer login");
		log.info("2)For Admin login");
		log.info("\nEnter your choice....");
		int ch = 0;
		try {
			ch = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
		}
		//do {
		  if(ch==1) {
			int n = 0;
			do {	
				log.info("              customer login/register     ");
				log.info("        *********************************     ");
				log.info("1)SignIn");
				log.info("2)SignUp");
				log.info("3)Forgot Password");
				log.info("4)Back to main");
				log.info("\nEnter your choice..");
				
			try {	
				n = (scanner.nextInt());
			}catch(NumberFormatException e ) {		
				}
			
			switch(n) {
			case 1:	
				   log.info("Enter your email: ");
				   String eMail = scanner.next();
				   log.info("Enter your password: ");
				   String passWord = scanner.next();
				   if(eMail.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z.]+$"))
				   {		
					log.info("Login Sucessfull");
				   }else {
					log.info("Enter a valid email Address");
				   }
				  
				   do {
					   int c = 0;
				     log.info("            welcome "+ eMail +  "          "      );
				     log.info(       "==============================");
				     log.info("1) View Items");
				     log.info("2) Add Items in Cart");
				     log.info("3) Delete Items in Cart");
				     log.info("4) Submit Cart");
				     log.info("5) Enter your Choice");
				     try {
				    	 c=Integer.parseInt(scanner.next());
				     }catch(NumberFormatException e) {
				    	 log.warn(e);	 
				     }
				     switch(c) {
				     case 1:
				    	 
				     }
				    	 
				     }while(c!=);
				     		
			break;
			case 2:					
				int result = 400;
				Customer customer = new Customer();
				log.info("Email: " ); 
				String newEmail = scanner.next();
				log.info("Password");
				String newPassword = scanner.next();
				log.info("ReEnter your Password ");
				String rePassword = scanner.next();
				log.info("Name: ");
				String newName = scanner.next();
				log.info("Phone Number: ");
				long newPhnumber = scanner.nextLong();	
				CustomerService customerService = new CustomerServiceImpl();
					if(newPassword.equals(rePassword)) {
						customer.setNewEmail(newEmail);
						customer.setNewName(newName);
						customer.setNewPhnumber(newPhnumber);
						customer.setRePassword(rePassword);
						try {
							result = customerService.validateCustomerSignup(customer);
							if(result==200) {
     						log.info("Account Created Sucessfully");
     						}
						}catch (BusinessException e) {
							log.warn("Invalid email or password");
						}		
					}else {
						log.info("Password mismatched...");
					    }
				  break;
			}
			}while(n!=4);
		  }
		
	 }
		  
}
	

