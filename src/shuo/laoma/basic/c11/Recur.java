package shuo.laoma.basic.c11;

public class Recur {

	public static long factorial(int n){
	    if(n==0){
	        return 1;
	    }else{
	        return n*factorial(n-1);
	    }
	}
	
	public static long factorial2(int n){
	    long result = 1;
	    for(int i=1; i<=n; i++){
	        result*=i;
	    }
	    return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
