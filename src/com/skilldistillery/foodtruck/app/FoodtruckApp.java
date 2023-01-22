package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.Foodtruck;


public class FoodtruckApp {
	private Foodtruck[] fleet = new Foodtruck[MAX_FOODTRUCKS];
	private static int MAX_FOODTRUCKS = 5;
	private static double totalFoodtrucks;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		FoodtruckApp app = new FoodtruckApp();
		app.createTrucks();
		app.selectFromMenu();
		
	}

	public void createTrucks() {

		for (int i = 0; i < fleet.length; i++) {
			boolean greaterThanFive = true;

			System.out.print("Please enter the name of the food truck " + 
							"\nEnter quit to stop entering food trucks: ");
			String name = sc.nextLine();
			if (name.equals("quit")) {
				break;
			}

			fleet[i] = new Foodtruck();

			fleet[i].setFoodTruckName(name);
			System.out.println();

			System.out.print("Please enter the type of food this food truck serves: ");
			String type = sc.nextLine();
			fleet[i].setFoodType(type);
			System.out.println();

			while (greaterThanFive) {
				System.out.print("Please provide a rating for this food truck between 1 and 5: ");
				int rating = sc.nextInt();
				if (rating > 5 || rating < 1) {
					System.err.println("Please enter a number between 1 and 5");
				} else {
					fleet[i].setNumericRating(rating);
					greaterThanFive = false;
					sc.nextLine();
				}
			}
			totalFoodtrucks = i;
			System.out.println();
		}
		totalFoodtrucks += 1;
	}

	public void selectFromMenu() {

		boolean stillUsingMenu = true;

		do {
			System.out.println();
			System.out.println("Please select a number from this menu");
			System.out.println("-----------------Menu--------------------");
			System.out.println("|      1. List all entered trucks       |");
			System.out.println("|         2. See average rating         |");
			System.out.println("|      3. Show highest rated truck      |");
			System.out.println("|             4. Quit                   |");
			System.out.println("|---------------------------------------|");

			int userMenuSelection = sc.nextInt();
			if (userMenuSelection == 1) {
				for (int i = 0; i < totalFoodtrucks; i++) {
					if (fleet[i] != null) {
						System.out.println(fleet[i]);
					}
				}
				System.out.println("These are your food trucks!");
			}

			if (userMenuSelection == 2) {
				double sum = 0;
				for (int i = 0; i < totalFoodtrucks; i++) {

					sum = (sum + fleet[i].getNumericRating());
				}
				double dividedSum = sum / totalFoodtrucks;

				System.out.println("The average of all your food truck ratings is " + dividedSum + ".");
			}

			if (userMenuSelection == 3) {
				int max = fleet[0].getNumericRating();
				int lastIndx = 0;
				for (int i = 0; i < totalFoodtrucks; i++) {

					if (fleet[i].getNumericRating() > max) {
						max = fleet[i].getNumericRating();
						lastIndx = i;
					}

				}
				System.out.println("The highest rated food truck is... " + fleet[lastIndx] + ".");

			}

			if (userMenuSelection == 4) {
				stillUsingMenu = false;
				System.out.println("Thank you for sharing your food truck opinions, goodbye.");
			}

		} while (stillUsingMenu);
		
		sc.close();
	}
	
}
