package com.app;

import java.util.List;
import java.util.Scanner;


import org.apache.log4j.Logger;

import com.app.customer.service.CustomerService;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.product.service.ProductService;
import com.app.product.service.impl.ProductServiceImpl;
import com.app.customer.service.impl.CustomerServiceImpl;
import com.app.dao.ProductDAO;
import com.app.dao.impl.ProductDAOImpl;

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
				n = Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e ) {		
				}
			
			switch(n) {
			case 1:	
				try {
				   log.info("Enter your email: ");
				   String eMail = scanner.nextLine();
				   log.info("Enter your password: ");
				   String passWord = scanner.nextLine();
				   CustomerService customerService = new CustomerServiceImpl();
				   Customer customer = customerService.validateSignin(eMail, passWord);
				   log.info(customer);
				   if(customer == null) {
				   throw new BusinessException("User not found/or Sign Up");
				   }
				}catch(BusinessException e) {
					 e.printStackTrace();
					 continue;
				   }
			
				
				
			
				
					   
				   
				   int c = 0;
				   do {
					   
				     log.info("                welcome  User        "             );
				     log.info( "      ==============================");
				     log.info("1) View Items");
				     log.info("2) Add Items in Cart");
				     log.info("3) Delete Items in Cart");
				     log.info("4) Submit Cart");
				     log.info("5) exit");
				     log.info(" Enter your Choice");
				     
				     try {
				    	 c=Integer.parseInt(scanner.next());
				     }catch(NumberFormatException e) {
				    	 log.warn(e);	 
				     }
				     switch(c) {
				     case 1:
				    	 ProductService productDao = new ProductServiceImpl();
				    	 List<Product> allProduct=null;
				    	 
						try {
							allProduct = productDao.getAllProducts();
						} catch (BusinessException e) {
							// TODO Auto-generated catch block
							log.warn(e);
						}
				    	 for(Product p:allProduct) {
				    		 log.info(p);
				    	 }
				    	 
				     }
				    	 
				     }while(c!=5);
				     		
			break;
			case 2:					
				int result = 400;
				Customer customer = new Customer();
				log.info("Email: " ); 
				String newEmail = scanner.nextLine();
				log.info("Password");
				String newPassword = scanner.nextLine();
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
	

