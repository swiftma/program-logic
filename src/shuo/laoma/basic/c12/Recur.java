package shuo.laoma.basic.c12;

public class Recur {
	public static int factorial(int n) {
	    if(n==0){
	        return 1;
	    }else{
	        return n*factorial(n-1);
	    }
	}

	public static void main(String[] args) {
	    int ret = factorial(4);
	    System.out.println(ret);
	}

}
