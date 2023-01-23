package com.skilldistillery.foodtruck.entities;

public class Foodtruck {
	private static int nextTruckId = 1;
	private int id;
	private String foodTruckName;
	private String foodType;
	private int numericRating;
	
	
	public Foodtruck() {
		id = nextTruckId;
		nextTruckId++;
		
	}


	public Foodtruck(int id, String foodTruckName, String foodType, int numericRating) {
	
		this.foodTruckName = foodTruckName;
		this.foodType = foodType;
		this.numericRating = numericRating;
		
		
	}

	public int getId() {
		return id;
	}

	public String getFoodTruckName() {
		return foodTruckName;
	}

	public void setFoodTruckName(String foodTruckName) {
		this.foodTruckName = foodTruckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getNumericRating() {
		return numericRating;
	}

	public void setNumericRating(int numericRating) {
		this.numericRating = numericRating;
	}

	@Override
	public String toString() {
		return "[id= " + id + ", foodTruckName= " + foodTruckName + ", foodType= " + foodType
				+ ", numericRating= " + numericRating + "]";
	}
	


}