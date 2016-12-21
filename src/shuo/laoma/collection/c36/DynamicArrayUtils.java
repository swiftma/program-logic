package shuo.laoma.collection.c36;

public class DynamicArrayUtils {
	
	public static int indexOf(DynamicArray<?> arr, Object elm){
	    for(int i=0; i<arr.size(); i++){
	        if(arr.get(i).equals(elm)){
	            return i;
	        }
	    }
	    return -1;
	}
	
	public static <D> void copy(DynamicArray<D> dest,
	        DynamicArray<? extends D> src){
	    for(int i=0; i<src.size(); i++){
	        dest.add(src.get(i));
	    }
	}

	public static <T extends Comparable<T>> T max(DynamicArray<T> arr){
	    T max = arr.get(0);
	    for(int i=1; i<arr.size(); i++){
	        if(arr.get(i).compareTo(max)>0){
	            max = arr.get(i);
	        }
	    }
	    return max;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
