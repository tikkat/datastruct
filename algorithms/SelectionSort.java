package algorithms;

/** Selection Sort algorithm to sort an array by making several passes through the array.
 *  The algorithm selects the smallest element each time it loops and places it where it
 *  belongs in the array, exchanging it with another element.
 * 
 * 					nbr of comparisons			nbr of Exchanges 
 * 			 		Best		Worst			Best		Worst
 * 	Complexity:		O(n²)		O(n²)			O(n)		O(n)
 * 
 * @author Tobias Tikka
 *
 */

public class SelectionSort {

	/** Sort the array using selection sort algorithm.
	 * pre: table contains Comparable objects.
	 * post: table is sorted.
	 * @param	table	The array to be sorted.
	 */
	
	public static void sort(Comparable[] table){
		int n = table.length;
		for(int fill = 0; fill < n-1; fill++){
			int posMin = fill;
			
			for(int next = fill +1; next < n; next++){
				if(table[next].compareTo(table[posMin]) < 0) {
					posMin = next;
				}
			}
			//Exchange table[fill] and table[posMin]
			Comparable temp = table[fill];
			table[fill] = table[posMin];
			table[posMin] = temp;
		}	
	}
}
