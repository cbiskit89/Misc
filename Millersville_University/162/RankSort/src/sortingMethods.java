public class sortingMethods {
	private int [] a;
	
	public sortingMethods(int [] inputArray){
		a = inputArray;
	}
	
	public int[] rankSort(){
		int [] b = new int [a.length]; 
		int count = 0;
		
		for (int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				if (a[i] > a[j] && i != j)
					count++;
			}
			b[count] = a[i];
			count = 0;
		}

		return b;
	} // end rankSort()
}
