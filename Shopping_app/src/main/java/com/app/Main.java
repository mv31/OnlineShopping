package com.app;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.OrderDAO;
import com.app.dao.ProductAddDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.OrderDAOImpl;
import com.app.dao.impl.ProductAddDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Order;
import com.app.model.Product;
import com.app.product.service.ProductService;
import com.app.service.CartService;
import com.app.service.CustomerService;
import com.app.service.OrderService;
import com.app.service.ProductSearchService;
import com.app.service.impl.CartServiceImpl;
import com.app.service.impl.CustomerServiceImpl;
import com.app.service.impl.OrderServiceImpl;
import com.app.service.impl.ProductSearchServiceImpl;



public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static String Email = "";
	public static String Password = "";
	public static int customerId;
	public static String customerName;
	public static String orderStatus;
	public static String viewList;
	public static Customer customerDetails;

	public static void main(String[] args) throws BusinessException {

		CustomerService customerService = new CustomerServiceImpl();
		CustomerDAO customerDAO = new CustomerDAOImpl();
		ProductAddDAO productAddDAO = new ProductAddDAOImpl();
		ProductSearchService productSearchService = new ProductSearchServiceImpl();
		CartService cartAddService = new CartServiceImpl();
		CartDAO cartAddDAO = new CartDAOImpl();
		OrderService orderService = new OrderServiceImpl();
		OrderDAO orderDAO = new OrderDAOImpl();
//		StatusDAO statusDAO = new StatusDAOImpl();
//		StatusService statusService = new StatusServiceImpl();

		Scanner sc = new Scanner(System.in);
		log.info("Welcome to Shop World  Application");
		log.info("--------------------------------------");

		int ch = 0;

		do {
			log.info("\nMAIN MENU");
			log.info("1) Customer Login");
			log.info("2)Employee Login");
			log.info("3)New user? Register Now..! ");
			log.info("4)EXIT");
			log.info("Enter your choice among 1 to 4 ");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.error(e);
			}

			switch (ch) {
			case 1:
				log.info("Customer Authentication");
				Customer checkCustomer = new Customer();
				log.info("\nEnter User Eamil");
				checkCustomer.setNewEmail(sc.nextLine());
				 //String userEmail = checkCustomer.getEmail();
				Email = checkCustomer.getNewEmail();
				log.info("Enter User Password");
				checkCustomer.setNewPassword(sc.nextLine());
				// String userPassword = checkCustomer.getPassword();
				Password = checkCustomer.getNewPassword();

				List<Customer> cusList = new ArrayList<>();
				cusList = customerDAO.signIn(Email, Password);
				if (!cusList.isEmpty()) {
					customerId = cusList.get(0).getCusId();
					customerName = cusList.get(0).getNewName();
				} else {
					log.info("SignIn Unsuccessfull");
				}

				try {
					String customerSignIn = customerService.signIn(Email, Password);
					if (customerSignIn == "SignIn Successfull") {
						log.info("SignIn Successfully done...");
						log.info("\nWelcome " + customerName + " to Shop World :)");
						log.info("----------------------------------------------------");
						int val = 0;
						do {
							log.info("\nNew and Exciting products are here");
							log.info("1)View all Products");
							log.info("2)Search Products");
							log.info("3)View Orders");
							log.info("4)View status");
							log.info("5)SignOut");
							log.info("Please enter your option 1-5 only");

							try {
								val = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								log.error(e);
							}
							switch (val) {
							case 1:
								log.info(" Available Products to shop :>");
								try {
									List<Product> productList = productAddDAO.getAllProducts();
									if (productList != null && productList.size() > 0) {
										for (Product products : productList) {
											log.info(products);
										}

										log.info("Add Products to Cart to place orders");
										int button = 0;
										do {
											log.info("1)Add to Cart");
											log.info("2)Go Back");
											try {
												button = Integer.parseInt(sc.nextLine());
											} catch (NumberFormatException e) {
												log.error(e);
											}
											switch (button) {
											case 1:
												log.info("Enter the Product Id to Add it in cart");
												Cart addCart = new Cart();
												addCart.setProductId(Integer.parseInt(sc.nextLine()));
												int productId = addCart.getProductId();
												log.info("Enter Quantity");
												addCart.setQuantity(Integer.parseInt(sc.nextLine()));
												int quantity = addCart.getQuantity();

												String addInCart = cartAddService.addToCart(customerId, productId, quantity);
												if (addInCart == "Product added in cart") {
													log.info("Product successfully added in cart");
												} else {
													log.info("Product adding failed..  retry..");
												}
												break;
											case 2:
												log.info("Going back");
												break;
											default:
												log.warn(
														"Invalid Entry.... Enter values 1 or 2 only.. kindly retry");
												break;
											}

										} while (button != 2);
									}
								} catch (BusinessException e) {
									log.error(e);
								}
								break;
							case 2:
								int select = 0;
								do {
									log.info("Search filters for Products");
									log.info("1)Filter By Product Id");
									log.info("2)Filter By Product Name");
									log.info("3)Filter By Product Price");
									log.info("4)Filter By Product categories");
									log.info("5)Previous Menu");

									try {
										select = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
										log.error(e);
									}
									switch (select) {
									case 1:
										log.info("Enter the Product Id");
										try {
											int productId = Integer.parseInt(sc.nextLine());
											Product product = productSearchService.getProductById(productId);
											if (product != null) {
												log.info("Entered product id " + productId + " is found successfully");
												log.info(product);
											}
										} catch (NumberFormatException e) {
											log.warn("Product id should be digit only...");
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
									case 2:
										log.info("Enter the Product Name");

										try {
											String productName = sc.nextLine();
											List<Product> productList = productSearchService.getProductsByProdName(productName);
											if (productList != null && productList.size() > 0) {
												for (Product product : productList) {
													log.info(product);
												}
											}
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
									case 3:
										log.info("Enter the Price Range of Product");

										try {
											double price = Double.parseDouble(sc.nextLine());
											List<Product> productList = productSearchService.getProductsByPrice(price);
											if (productList != null && productList.size() > 0) {
												for (Product product : productList) {
													log.info(product);
												}
											}
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
									case 4:
										log.info("Enter the category");

										try {
											String Category = sc.nextLine();
											List<Product> productList = productSearchService
													.getProductsByCategory(Category);
											if (productList != null && productList.size() > 0) {
												for (Product product : productList) {
													log.info(product);
												}
											}
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
									case 5:
										log.info("You are in Previous menu");
										break;
									default:
										log.warn(
												"Invalid entry.... Selection should be numbers and 1-5 only.. kindly retry");
										break;
									}
								} while (select != 5);

								break;

							case 3:

								log.info("You can Place your orders here");
								int choose = 0;
								do {
									log.info("1)View Products in cart");
									log.info("2)Place order");
									log.info("3)Go Back..");
									try {
										choose = Integer.parseInt(sc.nextLine());
									} catch (NumberFormatException e) {
										log.error(e);
									}
									switch (choose) {
									case 1:
										log.info("Products which you added in cart");

										String cartListCheck = cartAddService.getAllItemsInCart(customerId);
										if (cartListCheck == "Cart List Shown") {
											List<Cart> cartList = cartAddDAO.getAllItemsInCart(customerId);
											if (cartList != null && cartList.size() > 0) {
												for (Cart cart : cartList) {
													log.info(cart);
												}
												for (int i = 0; i < cartList.size(); i++) {
													String productName = null;
													double cost = 0;
													productName = cartList.get(i).getProduct().getProdName();
													cost = cost + (cartList.get(i).getProduct().getPrice())
															* (cartList.get(i).getQuantity());
													log.info("The total cost of this product " + productName + " : "
															+ cost);
												}

												log.info("Do you want to place order?");
												log.info("Kindly select option 2");
											}
										}
										break;
//									case 2:
//										log.info("Place Your Order here");
//										log.info("Type true if you need to place the order");
//										String orderStatus = sc.nextLine();
//
//										List<Cart> cartList = cartAddDAO.getAllItemsInCart(cId);
//										String orderCheck = orderService.placeOrder(cartList, orderStatus);
//
//										if (orderCheck == "Order Placed") {
//											log.info("Orders successfully placed..");
//
//											log.info("You can view the order list");
//											int op1 = 0;
//											do {
//												log.info("1)View Order List");
//												log.info("2)Previous Menu");
//
//												try {
//													op1 = Integer.parseInt(sc.nextLine());
//												} catch (NumberFormatException e) {
//													log.error(e);
//												}
//												switch (op1) {
//												case 1:
//													log.info("Products Order List");
//													String orderListCheck = orderService.getOrderList(cId);
//													if (orderListCheck == "Order List Shown") {
//														List<Order> orderedList = orderDAO.getOrderList(cId);
//														if (orderedList != null && orderedList.size() > 0) {
//															for (Order order : orderedList) {
//																log.info(order);
//															}
//														}
//													}
//
//													break;
//												case 2:
//													log.info("Going previous menu");
//													break;
//												default:
//													log.warn(
//															"Invalid Option.... Choice should be numbers and 1-2 only.. kindly retry");
//													break;
//												}
//											} while (op1 != 2);
//
//										} else {
//											log.info("Order Unsuccessfull");
//											log.info("Please provide Order Status as true");
//										}
//
//										break;
									case 3:
										log.info("Going back.....");
										break;
									default:
										log.warn(
												"Invalid Option.... Choice should be numbers and 1-3 only.. kindly retry");
										break;
									}

								} while (choose != 3);

								break;
//							case 4:
//								log.info("Viewing shipping status");
//								log.info("If you placed the order then type true");
//								log.info("Otherwise type false");
//								String orderStatus = sc.nextLine();
//								List<Cart> cartList = cartAddDAO.getAllItemsInCart(cId);
//								String orderCheck = orderService.placeOrder(cartList, orderStatus);
//								if (orderCheck == "Order Placed") {
//
//								String shippingCheck = statusService.updateShippingStatus(cId, "true");
//									if (shippingCheck == "Shipping Successfull") {
//										log.info("Product Shipped successfully...");
//									}
//									int op2 = 0;
//									do {
//										log.info("Updating status Received");
//										log.info("1)Update Received status");
//										log.info("2)Go back");
//										try {
//											op2 = Integer.parseInt(sc.nextLine());
//										} catch (NumberFormatException e) {
//											log.error(e);
//										}
//										switch (op2) {
//										case 1:
//											log.info("Updating Received status");
//											String ReceivedCheck = statusService.updateDeliveryStatus(cId, "true");
//
//											if (ReceivedCheck == "Received Successfull") {
//												log.info("Updated Received successfully...");
//											}
//											break;
//										case 2:
//											log.info("Going back..");
//											break;
//										default:
//											log.warn(
//													"Invalid Option.... Choice should be numbers and 1-2 only.. kindly retry");
//											break;
//										}
//
//									} while (op2 != 2);
//									
//								} else {
//									log.info("First place the order");
//								}
//								break;
							case 5:
								log.info("Thanks for using this APP... See you soon..");
								break;
							default:
								log.warn("Invalid Option.... Choice should be numbers and 1-4 only.. kindly retry");
								break;
							}
						} while (ch != 5);

					}
				} catch (BusinessException e) {
					log.error(e);
				}
				break;

			case 2:
				log.info("Employee Authentication");
				Employee checkEmployee = new Employee();
				log.info("\nEnter Employee Username");
				checkEmployee.setUserName(sc.nextLine());
				String employeeUsername = checkEmployee.getUserName();
				log.info("Enter Employee Password");
				checkEmployee.setPassWord(sc.nextLine());
				String employeePassword = checkEmployee.getPassWord();
				String employeeLogIn = checkEmployee.logIn(employeeUsername, employeePassword);
				if (employeeLogIn == "LogIn Successfull") {
					log.info("Employee LogIn Successfull...");
					int click = 0;
					do {
						log.info("\nHello Manoj M V, Select what you want to do?");
						log.info("1)Add a new Product");
						log.info("2)View Product List");
						log.info("3)View Ordered List");
						log.info("4)Shipping status");
						log.info("5)Logout");
						log.info("Please select any one of the option 1-5 only");

						try {
							click = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							log.error(e);
						}
						switch (click) {
						case 1:
							log.info("Give Product Details to Add a new product");
							Product product = new Product();
							log.info("Enter Product Name");
							product.setProdName(sc.nextLine());
							String productName = product.getProdName();
							log.info("Enter Product Price");
							product.setPrice(Double.parseDouble(sc.nextLine()));
							double price = product.getPrice();
							log.info("Enter Product Ratings");
							product.setCategory(sc.nextLine());
							String category = product.getCategory();

							Product productDetails = new Product(productName, price, category);
							try {
								productDetails = productAddDAO.addProduct(productDetails);
								if (productDetails.getProductId() != 0) {
									log.info(productDetails);
									log.info("Product Successfully added..");
								}
							} catch (BusinessException e) {
								log.error(e);
							}

							break;
						case 2:
							log.info("The Product List is detailed below");
							try {
								List<Product> productList = productAddDAO.getAllProducts();
								if (productList != null && productList.size() > 0) {
									for (Product products : productList) {
										log.info(products);
									}

									log.info("Product List shown.......");
								}
							} catch (BusinessException e) {
								log.error(e);
							}

							break;
						case 3:
							log.info("You are viewing ordered list");
							List<Order> orderedList = new ArrayList<>();
							orderedList = orderDAO.getOrderList(customerId);
							for (Order order : orderedList) {
								log.info(order);
							}
							int cho = 0;
							do {
								log.info("You can view and update the status of Order");
								log.info("1)Update status");
								log.info("2)Update status as Shipping");
								log.info("3)Go back");
								try {
									cho= Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									log.error(e);
								}

								switch (cho) {
//								case 1:
//									log.info("Updating status...");
//									for (int i = 1; i <= orderedList.size(); i++) {
//										Status status = new Status();
//										status.setOrderId(i);
//										status.setCustomerId(cId);
//										status.setOrderShipped("false");
//										status.setOrderReceived("false");
//										String statusCheck = statusService.updateStatus(status);
//										if (statusCheck == "Successfull") {
//											log.info("Update successfull for Order ID " + i);
//										}
//									}
//									break;
//								case 2:
//									log.info("Updating Shipping status...");
//									String shippingCheck = statusService.updateShippingStatus(cId, "true");
//									if (shippingCheck == "Shipping Successfull") {
//										log.info("Shipping update successfull");
//									}
//									break;
								case 3:
									log.info("Going back to previous menu");
									break;
								default:
									log.warn("Invalid Option.... Choice should be numbers and 1-3 only.. kindly retry");
									break;
								}
							} while (cho != 3);

							break;
//						case 4:
//							log.info("Packing the products and ready to dispatch");
//							log.info("Updating status...");
//							List<Order> updatedList = new ArrayList<>();
//							updatedList = orderDAO.getOrderList(customerId);
//							for (int i = 1; i <= updatedList.size(); i++) {
//								Status status = new Status();
//								status.setOrderId(i);
//								status.setCustomerId(cId);
//								status.setOrderShipped("false");
//								status.setOrderReceived("false");
//								String statusCheck = statusService.updateStatus(status);
//								if (statusCheck == "Successfull") {
//									log.info("Update successfull for Order ID " + i);
//								}
//							}
//
//							break;
						case 5:
							log.info("Session Logout");
							break;
						default:
							log.warn("Invalid Option.... Choice should be numbers and 1-5 only.. kindly retry");
							break;
						}
					} while (click != 5);

				} else {
					log.info("Employee Authentication failed..Try with valid Credentials...");
				}

				break;

			case 3:
				log.info("Register by using your Name, Email, Password and Phone Number");
				Customer customer = new Customer();
				log.info("Enter Customer Name");
				customer.setNewName(sc.nextLine());
				String name = customer.getNewName();
				log.info("Enter Customer Email");
				customer.setNewEmail(sc.nextLine());
				String email = customer.getNewEmail();
				log.info("Enter Customer Password");
				customer.setNewPassword(sc.nextLine());
				String password = customer.getNewPassword();
				log.info("Enter Contact Number");
				customer.setNewPhnumber(Long.parseLong(sc.nextLine()));
				long phnumber = customer.getNewPhnumber();

				customerDetails = new Customer(name, email, password, phnumber);
				System.out.println(customerDetails + "in main");
				try {
					customerDetails = customerDAO.signUp(customerDetails);
					if (customerDetails.getCusId() != 0) {
						log.info(customerDetails);
						log.info("SignUp Successfully done...Now you can SignIn");
					}
				} catch (BusinessException e) {
					log.error(e);
				}

				break;
			case 4:
				log.info("Thank You...Have a nice day :-)");
				break;
			default:
				log.warn("Invalid Option.... Choice should be numbers and 1-4 only.. kindly retry");
				break;
			}

		} while (ch!= 4);

	}
	
	
}
	

