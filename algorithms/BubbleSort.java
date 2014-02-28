package algorithms;

/** Bubble Sort algorithm to sort an array by making several passes through the array.
 *  Totally useless algorithm... "bubbles" down an element to the bottom of the array.
 * 
 * 					nbr of comparisons			nbr of Exchanges 
 * 			 		Best		Worst			Best		Worst
 * 	Complexity:		O(n)		O(n²)			O(1)		O(n²)
 * 
 * @author Tobias Tikka
 *
 */

public class BubbleSort {

	/** Sort the array using bubble sort algorithm.
	 * pre: table contains Comparable objects.
	 * post: table is sorted.
	 * @param	table	The array to be sorted.
	 */
	
	public static<T extends Comparable<T>> void sort(T[] table){
		int pass = 1;
		boolean exchanges;
		do {
			exchanges = false; // no exchanges yet.
			//compare each pair of adjacent elements.
			for(int i = 0; i < table.length - pass; i++){
				if(table[i].compareTo(table[i+1]) > 0){
					//Exchange pair
					T temp = table[i];
					table[i] = table[i+1];
					table[i+1] = temp;
					exchanges = true;
				}
			}
			pass++;
		} while(exchanges);
		
	}
}