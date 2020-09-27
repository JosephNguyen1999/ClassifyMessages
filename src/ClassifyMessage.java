/*
 * ClassifytMessage.java
 * Author:  Joseph Nguyen
 * Submission Date:  2/4/2020
 *
 * Purpose: this program takes a formatted message and breaks it down into different sections
 * then determines what category the message belongs in and whether or not it is in range.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;

public class ClassifyMessage {
	
	//declaration of enumeration
	enum MessageCategory{NEED, OFFER, ALERT, INFO, UNKNOWN}

	public static void main(String[] args) {
		
		//declaration of variables
		String catString;
		String payload;
		double latitude;
		double longitude;
		boolean isInRange;
		MessageCategory category;
		
		//declaration and initialization of variables
		double south = 39.882343;
		double north = 40.231315;
		double west = -105.743511;
		double east = -104.907864;
		
		//Scanner keyboard 
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a formatted messsage:");
		
		//multi-branch if-else statement to categorize the message and also reads in value for catString
		catString = keyboard.next();
		catString = catString.trim();
		if (catString.equalsIgnoreCase("fire"))
			category = MessageCategory.ALERT;
		else if (catString.equalsIgnoreCase("smoke"))
			category = MessageCategory.ALERT;
		else if (catString.equalsIgnoreCase("need"))
			category = MessageCategory.NEED;
		else if (catString.equalsIgnoreCase("offer"))
			category = MessageCategory.OFFER;
		else if (catString.equalsIgnoreCase("structure"))
			category = MessageCategory.INFO;
		else if (catString.equalsIgnoreCase("road"))
			category = MessageCategory.INFO;
		else if (catString.equalsIgnoreCase("photo"))
			category = MessageCategory.INFO;
		else if (catString.equalsIgnoreCase("evac"))
			category = MessageCategory.INFO;
		else
			category = MessageCategory.UNKNOWN;
			
			
		//reads in values for the variables
		latitude = keyboard.nextDouble();
		longitude = keyboard.nextDouble();
		payload = keyboard.nextLine();
		payload = payload.trim();
		
		//if else statement to see if it is in range
		if ((latitude >= south && latitude <= north) && (longitude >= west && longitude <= east))
			isInRange = true;
		else
			isInRange = false;
		
		//prints out the information in the required format
		System.out.println("Category:\t" + category);
		System.out.println("Raw Cat:\t" + catString);
		System.out.println("Message:\t" + payload);
		System.out.println("Latitude:\t" + latitude);
		System.out.println("Longitude:\t" + longitude);
		System.out.println("In Range:\t" + isInRange);
		
		keyboard.close();

	}

}
