package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.Foodtruck;

// foodtruck app does not pass in the id value for any foodtruck

public class FoodtruckApp {
	private Foodtruck[] fleet;
	private static int MAX_FOODTRUCKS = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Foodtruck[] fleet = new Foodtruck[MAX_FOODTRUCKS];

		fleet[0] = new Foodtruck();
		fleet[1] = new Foodtruck();
		fleet[2] = new Foodtruck();
		fleet[3] = new Foodtruck();
		fleet[4] = new Foodtruck();
		
		
		
		
		for (int i = 0; i < fleet.length; i++) {
			boolean greaterThanFive = true;

			System.out
					.print("Please enter the name of the food truck: " + "\nEnter quit to stop entering food trucks ");
			String name = sc.nextLine();
			if (name.equals("quit")) {
				break;
			}
			fleet[i].setFoodTruckName(name);
			System.out.println();

			System.out.print("Please enter the type of food this food truck serves: ");
			String type = sc.nextLine();
			fleet[i].setFoodType(type);
			System.out.println();

			while (greaterThanFive) {
				System.out.print("Please provide a rating for this food truck between 1 and 5: ");
				int rating = sc.nextInt();
				if (rating > 5) {
					System.err.println("Please enter a number between 1 and 5");
				}
				if (rating <= 5) {
					fleet[i].setNumericRating(rating);
					greaterThanFive = false;
					sc.nextLine();
				}
			}

			System.out.println(fleet[i]);
			System.out.println();
		}
		sc.close();
	}

}
