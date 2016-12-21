package shuo.laoma.basic.c11;

public class Array {

	public static void reset(int[] arr){
	    for(int i=0;i<arr.length;i++){
	        arr[i] = i;
	    }
	}

	public static void main(String[] args) {
	    int[] arr = {10,20,30,40};
	    reset(arr);
	    for(int i=0;i<arr.length;i++){
	        System.out.println(arr[i]);
	    }
	}

}
