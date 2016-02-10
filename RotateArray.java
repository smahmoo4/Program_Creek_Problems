import java.util.Random;
import java.util.Arrays;

class RotateArray {
	
	// PROBLEM 1
	//Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
	
	public static void main(String[] args) {
		int [] array = new int[]{1,2,3,4,5,6,7};
		printArray(array);
		//array = rotate(array, array.length, 2);
		array = rotateInPlace(array, array.length, 2);
		printArray(array);
	}
	

	//Method 1: using extra array
	public static int [] rotate(int [] array, int size, int k){
		int [] result = new int[size];
		if(k == 0){
			return array;
		}
		if(k > size || k < 0){
			System.out.println("Invalid k: "+ k);
			return array;
		}
		
		for(int i =0; i<k; i++){
			result[i]= array[size-k+i];
		}
		
		System.arraycopy(array, 0, result, k, size-k);
		
		return result;
		
	}
	
	
	// Method 2: In-Place Rotation
	public static int [] rotateInPlace(int [] array, int size, int k) {
		if(k == 0){
			return array;
		}
		if(k > size || k < 0){
			System.out.println("Invalid k: "+ k);
			return array;
		}

		for(int i = 0; i<k; i++){
			int j = size - k + i;
			int temp = array[j];
			int endIndex = i;
			while(j>endIndex){
				array[j] = array[j-1];
				j--;
			}
			array[endIndex] = temp; 
		}
		
		return array;
	}
	
	public static void printArray(int [] arr){
		for(int i = 0; i< arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}