//Cory Miller

import java.util.Arrays;
import java.util.Random;

public class ArraySort {
	public static void main (String[] args){
		Random r = new Random();
		int[]a = new int[7]; 
		int[]b = new int[5];
		int[]c = new int[12];
		
		for (int i = 0; i < a.length; i++){
			//generate random integers from 1 to 100
			a[i] = r.nextInt(100) + 1;
		}
		
		for (int j = 0; j < b.length; j++){
			//generate random integers from 1 to 100
			b[j] = r.nextInt(100) + 1;
		}
		
		//sort arrays from smallest int to largest
		Arrays.sort(a);
		Arrays.sort(b);
		
		//display array a
		System.out.print("Array A: { ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println("}");
		
		//display array b
		System.out.print("Array B: { ");
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println("}");
		
		//mergesort a and b into c
		mergeSort(a, b, c);
		
		//display c
		System.out.print("Array C (Merged Array): { ");
		for (int i = 0; i < c.length; i++)
			System.out.print(c[i] + " ");
		System.out.println("}");
	}//end of main
	
	public static void mergeSort (int[] a, int[] b, int[] c){
		int j = 0;
		int count = 0;
		
		//merge a into c comparing them with b values
		for (int i = 0; i < a.length; i++){
			while (j < b.length){
				if (a[i] <= b[j]){
					c[i + count] = a[i];
					break;
				}
				count++;
				j++;
			}//end while loop
			
			//add numbers larger than highest b values
			if (a[i] > b[b.length - 1])
				c[i + b.length] = a[i]; 
		}//end for loop
		
		//reset the counter variables for the second half of the merge process
		j = 0;
		count = 0;
		
		//merge b into c comparing them with a values
		for (int i = 0; i < b.length; i++){
			while (j < a.length){
				if (b[i] < a[j]){
					c[i + count] = b[i];
					break;
				}
				//if the value of b = the value of a, the b value should be placed
				//one index position higher than the index position of a
				else if (b[i] == a[j]){
					c[i + count + 1] = b[i];
					break;
				}
				count++;
				j++;
			}//end while loop
			
			//add numbers larger than highest a values
			if (b[i] > a[a.length - 1])
				c[i + a.length] = b[i]; 
		}//end for loop
	}//end of mergeSort
}//end of class ArraySort
