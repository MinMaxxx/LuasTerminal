
/* Chakkarin Laksanakesim                                                                                  
  .--~*teu.        .n~~%x.           oe       u+=~~~+u.          oe          oe    dL ud8Nu  :8c         xeee    
 dF     988Nx    x88X   888.       .@88     z8F      `8N.      .@88        .@88    8Fd888888L %8        d888R    
d888b   `8888>  X888X   8888L  ==*88888    d88L       98E  ==*88888    ==*88888    4N88888888cuR       d8888R    
?8888>  98888F X8888X   88888     88888    98888bu.. .@*      88888       88888    4F   ^""%""d       @ 8888R    
 "**"  x88888~ 88888X   88888X    88888    "88888888NNu.      88888       88888    d       .z8      .P  8888R    
      d8888*`  88888X   88888X    88888     "*8888888888i     88888       88888    ^     z888      :F   8888R    
    z8**"`   : 88888X   88888f    88888     .zf""*8888888L    88888       88888        d8888'     x"    8888R    
  :?.....  ..F 48888X   88888     88888    d8F      ^%888E    88888       88888       888888     d8eeeee88888eer 
 <""888888888~  ?888X   8888"     88888    88>        `88~    88888       88888      :888888            8888R    
 8:  "888888*    "88X   88*`      88888    '%N.       d*"     88888       88888       888888            8888R    
 ""    "**"`       ^"==="`     '**%%%%%%**    ^"====="`    '**%%%%%%** '**%%%%%%**    '%**%          "*%%%%%%**~ 
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LuasApplication {
	
	private static Scanner input = new Scanner(System.in);
	private static DecimalFormat currency = new DecimalFormat("0.00");
	/* Global Variables to store data or statistics */
	private static int cartItems = 0;
	private static double cartTotal = 0;
	private static boolean login;
	private static int statsInkPaper = 100;
	private static int statsTotalIncome = 0;
	private static int statsNumAdult = 0;
	private static int statsNumChild = 0;
	private static int statsNumStudent = 0;
	private static int statsTicketSales = 0;
	private static int statsNumStandard = 0;
	private static int statsNumFlexi = 0;
	private static int statsNumSingle = 0;
	private static int statsNumReturn = 0;
	private static int statsNumFlexi1 = 0;
	private static int statsNumFlexi7 = 0;
	private static int statsNumFlexi30 = 0;
	private static int statsNumStandardAdult = 0;
	private static int statsNumStandardChild = 0;
	private static int statsNumFlexiAdult = 0;
	private static int statsNumFlexiChild = 0;
	private static int statsNumFlexiStudent = 0;
	private static double averagePrice = 0;
	private static double insertedMoney = 0;
	private static boolean machineStatus = true;
	private static String strDetails = "";
	private static String[] arrayMachineStatus = {"Offline", "Online"};
	
	public static void main(String[] args) {
		terminalMenu();
	}
	
	public static void terminalMenu() {
		System.out.println("Welcome to Luas Terminal");
		checkInkPaper(); // Check terminal ink and paper
		selectTicketType(); // First menu encounter
	}
	
	public static void checkInkPaper() {
		if(statsInkPaper == 0) {
			outOfService(); // If there are no ink and paper enter outOfService mode
		}
	}
	private static void outOfService() {
		System.out.println("Terminal is out of service");
		String choice = input.next();
		switch(choice) {
		case "a": {
			login();
		}
		default: {
			System.out.println("Invalid option, try again");
			outOfService();
		}
		}
	}

	public static void selectTicketType() {
		System.out.println("Please choose your ticket type");
		System.out.println("1) Standard");
		System.out.println("2) Flexi");
		String choice = input.next();
		switch(choice) {
		case "1": {
			String ticketType = "Standard";
			selectZone(ticketType);
			break;
		}
		case "2": {
			String ticketType = "Flexi";
			selectZone(ticketType);
			break;
		}
		case "a": {
			login();
			break;
		}
		case "x": {
			if(login == false) {
				login();
			} else {
			System.out.println("Shutting down...");
			System.exit(0);
			}
			break;
		}
		default: {
			System.out.println("Invalid option, try again");
			selectTicketType();
			break;
		}
		}
	}
	
	public static void selectZone(String ticketType) {
		System.out.println("Your selected Ticket Type: \t" + ticketType);
		System.out.println("Please select your zone");
		System.out.println("1) Zone 1");
		System.out.println("2) Zone 2");
		System.out.println("3) Zone 3");
		System.out.println("4) Zone 4");
		System.out.println("5) Zone 5-8");
		String choice = input.next();
		switch(choice) { 
		case "1": {
			String zone = "1";
			if(ticketType.equals("Standard")) {
			standardTicket(ticketType, zone);
			} else { // Flexi
				flexiTicket(ticketType, zone);
			}
			break;
		}
		case "2": {
			String zone = "2";
			if(ticketType.equals("Standard")) {
				standardTicket(ticketType, zone);
				} else {
					flexiTicket(ticketType, zone);
				}
			break;
		}
		case "3": {
			String zone = "3";
			if(ticketType.equals("Standard")) {
				standardTicket(ticketType, zone);
				} else {
					flexiTicket(ticketType, zone);
				}
			break;
		}
		case "4": {
			String zone = "4";
			if(ticketType.equals("Standard")) {
				standardTicket(ticketType, zone);
				} else {
					flexiTicket(ticketType, zone);
				}
			break;
		}
		case "5": {
			String zone = "5-8";
			if(ticketType.equals("Standard")) {
				standardTicket(ticketType, zone);
				} else {
					flexiTicket(ticketType, zone);
				}
			break;
		}
		default: {
			System.out.println("Invalid option, try again");
			selectZone(ticketType);
			break;
		}
		}
	}

	public static void standardTicket(String ticketType, String zone) {
		System.out.println("Your selected Ticket Type: \t" + ticketType);
		System.out.println("Your selected Ticket Zone: \t" + zone);
		System.out.println("Please choose your ticket fares");
		System.out.println("1) Single Ticket");
		System.out.println("2) Return Ticket");
		String choice = input.next();
		switch(choice) {
		case "1": {
			String ticketTypeFares = "Single";
			selectedStandard(ticketType, zone, ticketTypeFares);
			break;
		}
		case "2": {
			String ticketTypeFares = "Return";
			selectedStandard(ticketType, zone, ticketTypeFares);
			break;
		}
		default: {
			System.out.println("Invalid option, try again");
			standardTicket(ticketType, zone);
			break;
		}
		}
	}
	
	private static void flexiTicket(String ticketType, String selectedZone) {
		System.out.println("Your selected Ticket Type: \t" + ticketType);
		System.out.println("Your selected Ticket Zone: \t" + selectedZone);
		System.out.println("Please choose your ticket fares");
		System.out.println("1) 1 Day Ticket");
		System.out.println("2) 7 Day Ticket");
		System.out.println("3) 30 Day Ticket");
		String choice = input.next();
		switch(choice) {
		case "1": {
			String ticketTypeFares = "1 Day";
			selectedFlexi(ticketType, selectedZone, ticketTypeFares);
			break;
		}
		case "2": {
			String ticketTypeFares = "7 Day";
			selectedFlexi(ticketType, selectedZone, ticketTypeFares);
			break;
		}
		case "3": {
			String ticketTypeFares = "30 Day";
			selectedFlexi(ticketType, selectedZone, ticketTypeFares);
			break;
		}
		default: {
			System.out.println("Invalid option, try again");
			flexiTicket(ticketType, selectedZone);
			break;
		}
		}
	}
	
	public static void selectedStandard(String ticketType, String selectedZone, String ticketTypeFares) {
		System.out.println("Your selected Standard Ticket: \t" + ticketTypeFares);
			System.out.println("Please choose your ticket age");
			System.out.println("1) Adult");
			System.out.println("2) Child");
			String choice = input.next();
			switch(choice) {
			case "1": {
				String selectedAge = "Adult";
				int numTickets = 1;
				addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
				break;
			}
			case "2": {
				int numTickets = 1;
				String selectedAge = "Child";
				addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
				break;
			}
			default: {
				System.out.println("Invalid option, try again");
				selectedFlexi(ticketType, selectedZone, ticketTypeFares);
				break;
			}
		}
	}
	
	public static void selectedFlexi(String ticketType, String selectedZone, String ticketTypeFares) {
		System.out.println("Your selected Flexi Ticket: \t" + ticketTypeFares);
			System.out.println("Please choose your ticket age");
			System.out.println("1) Adult");
			System.out.println("2) Child");
			if(!selectedZone.equals("1")) {
			System.out.println("3) Student");
			}
			String choice = input.next();
			switch(choice) {
			case "1": {
				String selectedAge = "Adult";
				int numTickets = 1;
				addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
				break;
			}
			case "2": {
				String selectedAge = "Child";
				int numTickets = 1;
				addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
				break;
			}
			case "3": {
				if(!selectedZone.equals("1")) {
				String selectedAge = "Student";
				int numTickets = 1;
				addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
				} else {
					System.out.println("Zone 1 not available for student type");
					selectedFlexi(ticketType, selectedZone, ticketTypeFares);
				}
				break;
			}
			default: {
				System.out.println("Invalid option, try again");
				selectedFlexi(ticketType, selectedZone, ticketTypeFares);
				break;
			}
		}
	}
	
	public static void addToCart(String ticketType, String selectedZone, String ticketTypeFares, String selectedAge, int numTickets) {
		System.out.println("***********************************");
		System.out.println("Ticket Details:");
		System.out.println("Selected Ticket: \t" + ticketType);
		System.out.println("Selected Zone: \t\t" + selectedZone);
		System.out.println("Selected Ticket Fares: \t" + ticketTypeFares);
		System.out.println("Selected Ticket Age: \t" + selectedAge);
		System.out.println("Ticket Quantities: \t" + numTickets);
		System.out.println("***********************************");
		System.out.println("1) Choose Quantity");
		System.out.println("2) Confirm Order");
		System.out.println("3) Cancel");
		String choice = input.next();
		switch(choice) {
		case "1": {
			System.out.println("Enter amount of ticket");
			int qty = 1;
			try {
				qty = input.nextInt();
			} catch (Exception e) {
				qty = 1;
				addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
			}
			if(qty > 100) { // fall back statements
				System.out.println("You may not purchase more than 5 tickets at a time");
				numTickets = 5;
			} else {
			if(qty > 5) {
				System.out.println("You may not purchase more than 5 tickets at a time");
				if(qty > statsInkPaper) {
					System.out.println("Sorry only " + statsInkPaper + " tickets are available\nChanging your quantities to " + statsInkPaper);
					numTickets = statsInkPaper;
				} else {
					numTickets = 5;
				}
			} else if(qty <= 5){
				if(qty > statsInkPaper) { // If there are less than 5 tickets remaining
					System.out.println("Sorry only " + statsInkPaper + " tickets are available\nChanging your quantities to " + statsInkPaper);
					numTickets = statsInkPaper;
				} else {
					numTickets = statsInkPaper;
				}
				numTickets = qty;
			} else if(qty <= 0) {
				System.out.println("Invalid Values, try again");
				numTickets = 1;
				}
			addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
			break;
			}
		}
		case "2": {
			cartItems++;
			cart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
			break;
		}
		case "3": {
			if(cartItems == 0) {
			System.out.println("Returning to main menu...");
			terminalMenu();
			}
			else {
				System.out.println("Cancelling ticket order...");
				selectTicketType();
			}
			break;
		}
		default: {
			System.out.println("Invalid option, try again");
			addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
			break;
		}
		}
	}
	
	public static void cart(String ticketType, String selectedZone, String ticketTypeFares, String selectedAge, int numTickets) {
		double price = 0;
		if(ticketType.equals("Standard")) {
			if(ticketTypeFares.equals("Single")) {
				if(selectedAge.equals("Adult")) {
					switch(selectedZone) {
					case "1": {
						price = 2.10;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "2": {
						price = 2.50;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "3": {
						price = 3.00;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "4": {
						price = 3.00;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "5-8": {
						price = 3.30;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					}
					} else if(selectedAge.equals("Child")){ // Child
						switch(selectedZone) {
						case "1": {
							price = 1.00;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "2": {
							price = 1.00;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "3": {
							price = 1.00;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "4": {
							price = 1.20;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "5-8": {
							price = 1.20;
							price *= numTickets;
							cartTotal += price;
							break;
						}
					}
				} else {
					System.out.println("Error, Report administrator");
					terminalMenu();
				}
			} else {
				if(ticketTypeFares.equals("Return")) {
					if(selectedAge.equals("Adult")) { // return adult
						switch(selectedZone) {
						case "1": {
							price = 3.70;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "2": {
							price = 4.40;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "3": {
							price = 5.40;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "4": {
							price = 5.40;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						case "5-8": {
							price = 5.90;
							price *= numTickets;
							cartTotal += price;
							break;
						}
						}
						} else { // return Child
							switch(selectedZone) {
							case "1": {
								price = 1.80;
								price *= numTickets;
								cartTotal += price;
								break;
							}
							case "2": {
								price = 1.80;
								price *= numTickets;
								cartTotal += price;
								break;
							}
							case "3": {
								price = 1.80;
								price *= numTickets;
								cartTotal += price;
								break;
							}
							case "4": {
								price = 2.30;
								price *= numTickets;
								cartTotal += price;
								break;
							}
							case "5-8": {
								price = 2.30;
								price *= numTickets;
								cartTotal += price;
								break;
							}
						}
					}
				}
			}
		} else { // Statement for Flexi Pricings
			if(selectedAge.equals("Adult")) { // adult price table
				switch(ticketTypeFares) {
				case "1 Day": {
					price = 7.20;
					price *= numTickets;
					cartTotal += price;
					break;
				}
				case "7 Day": {
					switch(selectedZone) {
					case "1": {
						price = 16.30;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "2": {
						price = 19.70;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "3": {
						price = 24.50;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "4": {
						price = 24.50;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "5-8": {
						price = 27.00;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					}
					break;
				}
				case "30 Day": {
					switch(selectedZone) {
					case "1": {
						price = 65;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "2": {
						price = 79;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "3": {
						price = 95;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "4": {
						price = 95;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "5-8": {
						price = 102;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					}
					break;
				}
				}	
			} else if(selectedAge.equals("Child")) { // child price table
				switch(ticketTypeFares) {
				case "1 Day": {
					price = 3;
					price *= numTickets;
					cartTotal += price;
					break;
				}
				case "7 Day": {
					switch(selectedZone) {
					case "1": {
						price = 7.80;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "2": {
						price = 7.80;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "3": {
						price = 7.80;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "4": {
						price = 9.40;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "5-8": {
						price = 9.40;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					}
					break;
				}
				case "30 Day": {
					switch(selectedZone) {
					case "1": {
						price = 31;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "2": {
						price = 31;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "3": {
						price = 31;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "4": {
						price = 37.50;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "5-8": {
						price = 37.50;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					}
					break;
				}
				}	
			} else { // student price table
				switch(ticketTypeFares) {
				case "1 Day": {
					price = 0;
					price *= numTickets;
					cartTotal += price;
					break;
				}
				case "7 Day": {
					switch(selectedZone) {
					case "1": {
						price = 12;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "2": {
						price = 13.70;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "3": {
						price = 17.00;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "4": {
						price = 17.00;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "5-8": {
						price = 19;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					}
					break;
				}
				case "30 Day": {
					switch(selectedZone) {
					case "1": {
						price = 45.5;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "2": {
						price = 54.5;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "3": {
						price = 65;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "4": {
						price = 65;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					case "5-8": {
						price = 75;
						price *= numTickets;
						cartTotal += price;
						break;
					}
					}
					break;
				}
				}
			}
		}
		
		/*
		 * Displaying different orders in one global string values
		 */
		strDetails += "\n***********************************\nTicket Details: \nSelected Ticket: \t" + ticketType + " \nSelected Zone: \t\t" + selectedZone + " \nSelected Ticket Fares: \t" + ticketTypeFares + " \nSelected Ticket Age: \t" + selectedAge + " \nTicket Quantities: \t" + numTickets + "\n***********************************";
		System.out.println(strDetails);
		// Old Sysout for ticket details.
//		System.out.println("***********************************");
//		System.out.println("Ticket Details:");
//		System.out.println("Selected Ticket: \t" + ticketType);
//		System.out.println("Selected Zone: \t\t" + selectedZone);
//		System.out.println("Selected Ticket Fares: \t" + ticketTypeFares);
//		System.out.println("Selected Ticket Age: \t" + selectedAge);
//		System.out.println("Ticket Quantities: \t" + numTickets);
		System.out.println("Price: €" + currency.format(cartTotal));
//		System.out.println("***********************************");
		System.out.println("1) Pay");
		System.out.println("2) Add more items");
		System.out.println("3) Cancel");
		String choice = input.next();
		switch(choice) {
		case "1": {
			try {
			payment(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
			} catch(InputMismatchException e) {
				System.out.println("Error");
				payment(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
			}
			break;
		}
		case "2": {
			selectTicketType();
			break;
		}
		case "3": {
			System.out.println("Returning to main menu...");
			cartTotal = 0;
			strDetails = "";
			terminalMenu();
			break;
		}
		default: {
			System.out.println("Invalid option, try again");
			addToCart(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
		}
		}
	}
	
	private static void payment(String ticketType, String selectedZone, String ticketTypeFares, String selectedAge, int numTickets) {
		/*
		 * 2 Local duplicated variables of global variable , cartTotal and insertedMoney, are used for
		 * remaining balance calculation. for stable calculation payment method
		 */
		double LcartTotal = 0;
		double moneyIn = 0;
		LcartTotal = LcartTotal + cartTotal;
		System.out.println("Price €: " + LcartTotal);
		System.out.println("Please Insert Your Payment");
		moneyIn = input.nextDouble();
		/*
		 * First input, calc before while loop.
		 */
		double LmoneyIn = 0;
		LmoneyIn = LmoneyIn + moneyIn;
		insertedMoney += LmoneyIn;
		while(insertedMoney < cartTotal){
			LcartTotal -= LmoneyIn;
			if(LcartTotal == 0.00 | LcartTotal <= 0.00) { // Fixing logic errors for balance @ 0.00
				paymentSuccessful(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
			}
			System.out.println("Remaining Balance: " + currency.format(LcartTotal));
			System.out.println("Please insert remaining balance");
			LmoneyIn = input.nextDouble();
			insertedMoney += LmoneyIn;
		}
		paymentSuccessful(ticketType, selectedZone, ticketTypeFares, selectedAge, numTickets);
	}

	public static void paymentSuccessful(String ticketType, String selectedZone, String ticketTypeFares, String selectedAge, int numTickets) {
		/*
		 * Method for resetting data on global variables or adding to Statistics values
		 */
		strDetails = "";
		statsInkPaper -= numTickets;
		statsTotalIncome += cartTotal;
		/*
		 * Change Calc
		 */
		if(cartTotal < insertedMoney) {
			insertedMoney -= cartTotal;
			/*
			 * Data Conversion 
			 */
			String insertedMoneyConversion = "";
			insertedMoneyConversion += insertedMoney;
			double Converted = Double.parseDouble(insertedMoneyConversion);
			if(cartTotal != 0) {
				System.out.println("Your change is €" + currency.format(Converted));	
			} else {
				System.out.println("Debug 0.00");
			}
		}
		insertedMoney = 0;
		statsTicketSales += numTickets;
		switch(selectedAge) {
		case "Adult": {
			statsNumAdult += numTickets;
			if(ticketType.equals("Standard")) {
				statsNumStandardAdult += numTickets;
			} else {
				statsNumFlexiAdult += numTickets;
			}
			break;
		}
		case "Child": {
			statsNumChild += numTickets;
			if(ticketType.equals("Standard")) {
				statsNumStandardChild += numTickets;
			} else {
				statsNumFlexiChild += numTickets;
			}
			break;
		}
		case "Student": {
			statsNumStudent += numTickets;
			statsNumFlexiStudent += numTickets;
			break;
		}
		}
		switch(ticketType) {
		case "Standard": {
			statsNumStandard += numTickets;
			break;
		}
		case "Flexi": {
			statsNumFlexi += numTickets;
			break;
		}
		}
		switch(ticketTypeFares) {
		case "Single": {
			statsNumSingle += numTickets;
			break;
		}
		case "Return": {
			statsNumReturn += numTickets;
			break;
		}
		case "1 Day": {
			statsNumFlexi1 += numTickets;
			break;
		}
		case "7 Day": {
			statsNumFlexi7 += numTickets;
			break;
		}
		case "30 Day": {
			statsNumFlexi30 += numTickets;
			break;
		}
		}
		averagePrice = statsTotalIncome / statsTicketSales;
		cartItems = 0;
		cartTotal = 0;
		
		System.out.print("Thank you for your purchase\n");
		checkInkPaper();
		terminalMenu();
	}
	
	public static void login() {
		String password = "111";
		System.out.println("Enter password");
		String enteredPassword = input.next();
		if(enteredPassword.equals(password)) {
			login = true;
			admin();
		} else if(enteredPassword.equals("x")) {
			terminalMenu();
		} else {
			System.out.println("Incorrect Password, try again");
			System.out.println("( Press X to go back )");
			login();
		}
	}
	
	public static void admin() {
		if(login == false) {
			login();
		} else {
			if(statsInkPaper <= 20) {
				System.out.println("****************************");
				System.out.println("      (!) Alert (!)");
				System.out.println("Machine low on Ink / Paper");
				System.out.println("****************************");
			}
			System.out.println("-- Admin Panel --");
			System.out.println("1) Manage Terminal");
			System.out.println("2) Display Statistics");
			System.out.println("3) Logout");
			System.out.println("4) Return to Terminal Menu ( Without Logging Out ) ");
			System.out.println("X) Shut Down System");
			String choice = input.next();
			switch(choice) {
			case "1": {
				adminManage();
				break;
			}
			case "2": {
				stats();
				break;
			}
			case "3": {
				login = false;
				System.out.println("Logging out...");
				terminalMenu();
				break;
			}
			case "4": {
				terminalMenu();
				break;
			}
			case "x": {
				System.out.println("Shutting Down...");
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Invalid option, try again");
				admin();
				break;
			}
			}
		}
	}
	
	public static void adminManage() {
		System.out.println("-- Manage Terminal --");
		System.out.println("1) Refill Ink and Papers");
		System.out.println("2) Return to admin panel");
		String choice = input.next();
		switch(choice) {
		case "1": {
			statsInkPaper = 100;
			System.out.println("Your machine has been refilled.");
			break;
		}
		case "2": {
			System.out.println("Returning to admin panel...");
			admin();
			break;
		}
		default: {
			break;
		}
		}
		adminManage();
	}
	
	public static void stats() {
		System.out.println("-- Stats --");
		System.out.println("1) Statistics for Standard Tickets");
		System.out.println("2) Statistics for Flexi Tickets");
		System.out.println("3) Total Statistics");
		System.out.println("x) Return to admin panel");
		String choice = input.next();
		switch(choice) {
		case "1": {
			statsStandard();
			break;
		}
		case "2": {
			statsFlexi();
			break;
		}
		case "3": {
			statsTotal();
			break;
		}
		case "x": {
			admin();
			break;
		}
		default: {
			System.out.println("Returning to admin panel...");
			break;
		}
		}
	}

	private static void statsStandard() {
		System.out.println("Numbers of Standard ticket sold: \t" + statsNumStandard);
		System.out.println("Numbers of Adult|Child: \t" + statsNumStandardAdult + "|" + statsNumStandardChild);
		System.out.println("Numbers of Single|Return: \t" + statsNumSingle + "|" + statsNumReturn);
		System.out.println("\nPress any button to return to stats panel");
		String choice = input.next();
		switch(choice) {
		default: {
			stats();
		}
		}
	}
	private static void statsFlexi() {
		String localStatsNumFlexi = Integer.toString(statsNumFlexi);
		System.out.println("Numbers of Flexi ticket sold: \t" + localStatsNumFlexi);
		System.out.println("Numbers of Adult|Child|Student: \t" + statsNumFlexiAdult + "|" + statsNumFlexiChild + "|" + statsNumFlexiStudent);
		System.out.println("Numbers of 1 Day|7 Day|30 Day: \t" + statsNumFlexi1 + "|" + statsNumFlexi7 + "|" + statsNumFlexi30);
		System.out.println("\nPress any button to return to stats panel");
		String choice = input.next();
		switch(choice) {
		default: {
			stats();
		}
		}
	}
	
	private static void statsTotal() {
		String terminal = "";
		if(machineStatus == true) {
			terminal = arrayMachineStatus[1];
		} else {
			terminal = arrayMachineStatus[0];
		}
		
		System.out.println("-- Stats --");
		System.out.println("Machine Status: " + terminal + " | " + statsInkPaper + " Available Tickets");
		System.out.println("Total Income: €" + currency.format(statsTotalIncome));
		System.out.println("Average: €" + currency.format(averagePrice));
		System.out.println("Number Of Tickets Sold: " + statsTicketSales);
		System.out.println("Numbers of Adult|Child|Student ticket(s) bought: " + statsNumAdult + "|" + statsNumChild +"|" + statsNumStudent);
		System.out.println("\nPress any button to return to stats panel");
		String choice = input.next();
		switch(choice) {
		default: {
			stats();
		}
		}
	}
}