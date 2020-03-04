
public class Pruebas {

	// Tail recursive function 
	static int arrSum(int []array, int size, int sum) 
	{ 
	    // Base Case 
	    if (size == 0)  
	        return sum; 
	  
	    // Function Call Observe sum+array[size-1] 
	    // to maintain sum of elements 
	    return arrSum(array, size - 1, sum + array[size - 1]); 
	} 
	  
	// Driver code 
	public static void main(String[] args) 
	{ 
	    int array[] = { 2, 55, 1, 7 }; 
	    int size = array.length; 
	    System.out.print(arrSum(array, size, 0)); 
	} 

}
