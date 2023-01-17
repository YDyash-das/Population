

import java.util.ArrayList;
import java.util.List;

/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author Yash Das 
 *	@since	1/9/23
 */
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	// public void bubbleSort(List<City> arr) {
		
	// 	for(int outer = arr.length-1; outer>0; outer--)
	// 	{
	// 		for(int inner = 0; inner <outer; inner++)
	// 		{
	// 				if(arr[inner].compareTo(arr[inner+1])>0)
	// 			swap(arr,inner, inner+1);
	// 		}
			
	// 	}
		
	// 	}
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(List<City> arr, int x, int y) {
		
		City temp = arr.get(x);
		arr.set(x, arr.get(y));
		arr.set(y,temp);		
		}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public List<City> selectionSort(List<City> arr) {
	int index =0;// index of List 
		for(int p = 0; p<arr.size()-1; p++)
		{
			index = 0;
			 for(int i = 0; i< arr.size()-1; i++)
			 {
				if(arr.get(index).getPopulation() - (arr.get(i+1).getPopulation())>0)
				{
					swap(arr,index,i+1);
				}
				else 
					index=i+1;
		}
							
		}
			return arr;
		}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public List<City> insertionSort(List<City> arr) {
		
		for (int outer = 1; outer < arr.size(); outer++)
		{
			int position = outer;// list position 
			City key = arr.get(position);

			// Shift larger values to the right
			while (position > 0 && (arr.get(position-1).getName().compareTo(key.getName()))>0)
			{
				arr.set(position, arr.get(position-1));
				position--;
			}
			arr.set(position,key);
			
		}
		return arr;
		
		
		
		
		}
	
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 *  @return the total list
	 */
	public List<City> mergeSort(List<City> arr, int choiceIn) {
		if (arr.size() > 1) {
			int mid = arr.size() / 2;
			List<City> left = new ArrayList<City>(mid);
			List<City> right = new ArrayList<City>(arr.size() - mid);
			for (int i = 0; i < mid; i++) {
				left.add(arr.get(i));
			}
			for (int i = mid; i < arr.size(); i++) {
				right.add(arr.get(i));
			}
			mergeSort(left,choiceIn);
			mergeSort(right,choiceIn);
			arr = merge(arr, left, right, choiceIn);
		}
		return arr;
	}
	/**
	 * Combines the 2 halfs of the the List after comparing which population is bigger
	 * @param arr the totol List
	 * @param left the left side of List
	 * @param right the right side of List
	 * @param choice whether to compare names or population
	 * @return the total List
	 */
	public List<City> merge(List<City> arr, List<City> left, List<City> right, int choice) {
		int arrIndex = 0;// index of total list
		int rightIndex = 0; //index of right list
		int leftIndex = 0;//index of left list
		if(choice == 1)
		{
			while (leftIndex < left.size() && rightIndex < right.size())
			{
				if (left.get(leftIndex).getPopulation() >= right.get(rightIndex).getPopulation()) 
				{
					arr.set(arrIndex, left.get(leftIndex));
					leftIndex++;
				} else 
				{
					arr.set(arrIndex, right.get(rightIndex));
					rightIndex++;
				}
				arrIndex++;
			}
		}
		else 
		{
			while (leftIndex < left.size() && rightIndex < right.size()) 
			{
				if (left.get(leftIndex).getName().compareTo(right.get(rightIndex).getName()) >= 0) 
				{
					arr.set(arrIndex, left.get(leftIndex));
					leftIndex++;
				} else {
					arr.set(arrIndex, right.get(rightIndex));
					rightIndex++;
				}
				arrIndex++;
			}
		}
		while (leftIndex < left.size()) 
		{
			arr.set(arrIndex, left.get(leftIndex));
			leftIndex++;
			arrIndex++;
		}
		while (rightIndex < right.size()) 
		{
			arr.set(arrIndex, right.get(rightIndex));	
			rightIndex++;	
			arrIndex++;	
		}
		return arr;
	}
	
	
	
	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/
	
	/**
	 *	Print an array of Integers to the screen
	 *	@param arr		the array of Integers
	 */
	// public void printArray(List<City> arr) {
	// 	if (arr.length == 0) System.out.print("(");
	// 	else System.out.printf("( %4d", arr[0]);
	// 	for (int a = 1; a < arr.length; a++) {
	// 		if (a % 10 == 0) System.out.printf(",\n  %4d", arr[a]);
	// 		else System.out.printf(", %4d", arr[a]);
	// 	}
	// 	System.out.println(" )");
	// }

	// public static void main(String[] args) {
	// 	SortMethods se = new SortMethods();
	// 	se.run();
	// }
	
	// public void run() {
	// 	Integer[] arr = new Integer[10];
	// 	// Fill arr with random numbers
	// 	for (int a = 0; a < 10; a++)
	// 		arr[a] = (int)(Math.random() * 100) + 1;
	// 	System.out.println("\nBubble Sort");
	// 	System.out.println("Array before sort:");
	// 	printArray(arr);
	// 	System.out.println();
	// 	bubbleSort(arr);
	// 	System.out.println("Array after sort:");
	// 	printArray(arr);
	// 	System.out.println();
		
	// 	for (int a = 0; a < 10; a++)
	// 		arr[a] = (int)(Math.random() * 100) + 1;
	// 	System.out.println("\nSelection Sort");
	// 	System.out.println("Array before sort:");
	// 	printArray(arr);
	// 	System.out.println();
	// 	selectionSort(arr);
	// 	System.out.println("Array after sort:");
	// 	printArray(arr);
	// 	System.out.println();

		
	// 	for (int a = 0; a < 10; a++)
	// 		arr[a] = (int)(Math.random() * 100) + 1;
	// 	System.out.println("\nInsertion Sort");
	// 	System.out.println("Array before sort:");
	// 	printArray(arr);
	// 	System.out.println();
	// 	insertionSort(arr);
	// 	System.out.println("Array after sort:");
	// 	printArray(arr);
	// 	System.out.println();
		
	// 	for (int a = 0; a < 10; a++)
	// 		arr[a] = (int)(Math.random() * 100) + 1;
	// 	System.out.println("\nMerge Sort");
	// 	System.out.println("Array before sort:");
	// 	printArray(arr);
	// 	System.out.println();
	// 	mergeSort(arr);
	// 	System.out.println("Array after sort:");
	// 	printArray(arr);
	// 	System.out.println();

	// }
}
