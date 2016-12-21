package shuo.laoma.basic.c11;

public class VarArg {

	public static int max(int min, int ... a){
	    int max = min;
	    for(int i=0;i<a.length;i++){
	        if(max<a[i]){
	            max = a[i];
	        }
	    }
	    return max;
	}

	public static void main(String[] args) {
	    System.out.println(max(0));
	    System.out.println(max(0,2));
	    System.out.println(max(0,2,4));
	    System.out.println(max(0,2,4,5));
	}

}
