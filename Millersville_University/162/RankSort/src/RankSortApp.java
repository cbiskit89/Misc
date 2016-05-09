import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RankSortApp {
	
	public static void main (String[] args) throws FileNotFoundException{
		int[] a = new int[30];
		int[] b = new int[a.length];
		int temp = 0;
		Scanner scanner = new Scanner(new File("data.txt"));
		int i = 0;
		
		while(scanner.hasNextInt()){	
			temp = scanner.nextInt();
			a[i] = temp;
			i++;
		}
		
		System.out.print("Unsorted Array is: ");
		for (int j = 0; j < a.length; j++){
			System.out.print(a[j] + " ");
		}
		System.out.println();
		
		sortingMethods outputArray = new sortingMethods(a);
		
		b = outputArray.rankSort();
		
		System.out.print("Sorted Array is: ");
		for (int k = 0; k < b.length; k++){
			System.out.print(b[k] + " ");
		}
	}
}
