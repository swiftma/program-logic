package shuo.laoma.commoncls.c34;

import java.util.Random;

public class RandomDemo {

	public static void basic(){
		Random rnd = new Random();
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt(100));
		
		for(int i=0;i<3;i++){
		    System.out.println(Math.random());
		}
	}
	
	public static String randomPassword(){
	    char[] chars = new char[6];
	    Random rnd = new Random();
	    for(int i=0; i<6; i++){
	        chars[i] = (char)('0'+rnd.nextInt(10));
	    }
	    return new String(chars);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
