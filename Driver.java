/**
 *  
 *  Author: William Nicholas
 *  
 */

import java.util.Random;

import javax.swing.JOptionPane;

public class Driver
{
	public static void main(String[] args)
	{
		String programmerName, childName, toy = null;
		String card, balloon, orderID;
		String inputString, tryAgain = "yes", anotherGift = "yes";
		double totalCost = 0;
		int age;
		boolean ageSafe;
		
		Toy toyGift = new Toy();
		
		System.out.println("BIRTHDAY GIFTS");
		
		JOptionPane.showMessageDialog(null, "Welcome to the Birthday Gifts program!");
		
		do
		{
			// Get child's name
			childName = JOptionPane.showInputDialog("Enter the child's name. ");
			
			// Get child's age
			inputString = JOptionPane.showInputDialog("Enter the child's age. ");
			// Convert the input into an integer
			age = Integer.parseInt(inputString);
			
			// Convert the integer into another file
			toyGift.setAge(age);
			
			while(tryAgain.equals("yes")) {
				// Get child's toy
				toy = JOptionPane.showInputDialog("What kind of toy do you need for " + childName + "? plushie, blocks, or book? ");
				
				if (!toy.equals("plushie") && !toy.equals("blocks") && !toy.equals("book")) {
					toy = JOptionPane.showInputDialog("The toy has to be either plushie, blocks, or book; try again. ");
				}
				
				toyGift.setToy(toy);
				
				// Check if the toy is okay for the child
				ageSafe = toyGift.ageOK();

				if (ageSafe == false) {
					// Answer if you want to look for another gift
					tryAgain = JOptionPane.showInputDialog("Sorry, the toy is not age appropriate. Do you want to look for another toy? (yes or no) ");
					if (!tryAgain.equals("yes") && !tryAgain.equals("no")) {
						tryAgain = JOptionPane.showInputDialog("You have to pick yes or no, try again. ");
					}
					else if (tryAgain.equals("no")) {
						ageSafe = true;
						toy = "no gift";
						toyGift.setToy(toy);
					}
				}
				else {
					tryAgain = "no";
				}
			}
			
			toyGift.setCost(toy);
			
			// Answer if you want a card included
			card = JOptionPane.showInputDialog("Do you want to include a card? (yes or no) ");
			
			if (card.equals("yes")) {
				toyGift.addCard(card);
			}
			else if (!card.equals("yes") && !card.equals("no")) {
				card = JOptionPane.showInputDialog("You have to pick yes or no, try again. ");
			}
			
			// Answer if you want a card included
			balloon = JOptionPane.showInputDialog("Do you want to include a balloon? (yes or no) ");
						
			if (balloon.equals("yes")) {
				toyGift.addBalloon(balloon);
			}
			else if (!balloon.equals("yes") && !balloon.equals("no")) {
				balloon = JOptionPane.showInputDialog("You have to pick yes or no, try again. ");
			}
			
			if (!toy.equals("plushie") && !toy.equals("blocks") && !toy.equals("book")) {
				System.out.print("\n" + "No gift for " + childName + "? You monster!");
				if (card.equals("yes") || balloon.equals("yes")) {
					double valuable = 0;
					
					if (card.equals("yes")) {
						valuable += 2.95;
					}
					
					if (balloon.equals("yes")) {
						valuable += 6.0;
					}
					
					System.out.print(" At least you got something worth $" + toyGift.dollar.format(valuable));
				}
			}
			else {
				System.out.print("\n" + "The gift for " + childName + toyGift.toString());
			}
			
			totalCost += toyGift.getCost();
			
			// Answer if you need another gift or not
			anotherGift = JOptionPane.showInputDialog("Do you need another gift for another child? (yes or no) ");
			
			if (!anotherGift.equals("yes") && !anotherGift.equals("no")) {
				tryAgain = "yes";
				anotherGift = JOptionPane.showInputDialog("You have to pick yes or no, try again. ");
			}
			else if (anotherGift.equals("yes")) {
				tryAgain = "yes";
			}
		} while (anotherGift.equals("yes"));
		
		// Get programmer's name
		programmerName = JOptionPane.showInputDialog("Enter your name. ");
		
		Random random = new Random();
		orderID = String.format("%05d", (random.nextInt(99999) + 1));
		System.out.println("\n\nThe total cost for your order is $" + toyGift.dollar.format(totalCost) + ". Your order number is #" + orderID + ".");
		System.out.println("Take care of yourself, " + programmerName + ".");
	}
}
