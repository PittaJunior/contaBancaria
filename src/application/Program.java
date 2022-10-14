package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		
		if (amount < withdrawLimit  && amount < balance) {
			double newBalance = acc.getBalance() - amount;
			System.out.printf("New Balance: "+ String.format("%.2f", newBalance));
		}
		
	 	if (amount < balance && amount > withdrawLimit) {
			System.out.println("Withdraw Error: The amount exceeds withdraw Limit!");
		}
	 	if (amount > balance && amount > withdrawLimit) {
			System.out.println("Withdraw Error: The amount exceeds withdraw Limit!");
		}
	 	if (amount > balance && amount < withdrawLimit ) {
	 		System.out.println("Withdraw Error: Not enough balance.");
	 	}
		
		
		
		
		
		
		sc.close();
	}
}
