package shuo.laoma.commoncls.c34;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {

	private static void swap(int[] arr, int i, int j){
	    int tmp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = tmp;
	}

	public static void shuffle(int[] arr){
	    Random rnd = new Random();
	    for(int i=arr.length; i>1; i--) {
	        swap(arr, i-1, rnd.nextInt(i));
	    }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[13];
		for(int i=0; i<arr.length; i++){
		    arr[i] = i;
		}
		shuffle(arr);
		System.out.println(Arrays.toString(arr));

	}

}
