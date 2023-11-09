//A program to implement fractional knapsack problem

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
	public static void main(String[] args) {
//		int[] val = {60, 100, 120};
//		int[] weight = {10, 20, 30};
//		int W = 50;						//full capacity of the bag
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many values you want to insert");
		int size = sc.nextInt();
		int val [] = new int[size];
		System.out.println("Insert the values of each item:");
		for(int i=0; i<size; i++) {
			val[i] = sc.nextInt();
		}
		
		int[] weight = new int[size];
		System.out.println("Insert the weights of each item: ");
		for(int i=0; i<size; i++) {
			weight[i] = sc.nextInt();
		}
		
		System.out.println("Enter the volume size of the knapsack: ");
		int W = sc.nextInt();
		double[][] ratio = new double[val.length][2];
		//0th col =>idx && 1st idx =>ratio
		
		for(int i=0; i<val.length; i++) {
			ratio[i][0]= i;
			ratio[i][1] = val[i]/(double)weight[i];
		}
		
		//sorting in ascending order(on the basis of ratio)
		Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
		
		int capacity = W;
		int finalVal =0;
		
		for(int i=ratio.length-1; i>=0; i--) {
			int idx = (int) ratio[i][0];
			if(capacity>=weight[idx]) {
				//full item is mountable
				capacity -= weight[idx];
				finalVal +=val[idx];
				System.out.println("Quantity of item number "+idx+" added in the knpasck is"+val[idx]);
			}
			else {
				//include fractional item
				finalVal+=ratio[i][1]*capacity;
				System.out.println("Quantity of item number "+idx+" added in the knpasck is"+ratio[i][1]*capacity);
				capacity = 0;			//bag gets full
				break;
			} 
		}
		System.out.println("Final total profit:"+finalVal);
		
	}
}