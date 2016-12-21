package shuo.laoma.commoncls.c34;

import java.util.Random;

public class StrongPassword {

	private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";
	
	private static char nextChar(Random rnd){
	    switch(rnd.nextInt(4)){
	    case 0:
	        return (char)('a'+rnd.nextInt(26));
	    case 1:
	        return (char)('A'+rnd.nextInt(26)); 
	    case 2:
	        return    (char)('0'+rnd.nextInt(10));
	    default:
	        return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
	    }
	}
	
	private static int nextIndex(char[] chars, Random rnd){
	     int index = rnd.nextInt(chars.length);
	     while(chars[index]!=0){
	        index = rnd.nextInt(chars.length); 
	     }
	     return index;
	}

	private static char nextSpecialChar(Random rnd){
	    return SPECIAL_CHARS.charAt(rnd.nextInt(SPECIAL_CHARS.length()));
	}
	private static char nextUpperlLetter(Random rnd){
	    return (char)('A'+rnd.nextInt(26)); 
	}
	private static char nextLowerLetter(Random rnd){
	    return (char)('a'+rnd.nextInt(26)); 
	}
	private static char nextNumLetter(Random rnd){
	    return (char)('0'+rnd.nextInt(10));
	}
	public static String randomPassword(){
	    char[] chars = new char[8];
	    Random rnd = new Random();
	    
	    chars[nextIndex(chars, rnd)] = nextSpecialChar(rnd);
	    chars[nextIndex(chars, rnd)] = nextUpperlLetter(rnd);
	    chars[nextIndex(chars, rnd)] = nextLowerLetter(rnd);
	    chars[nextIndex(chars, rnd)] = nextNumLetter(rnd);
	    
	    for(int i=0; i<8; i++){
	        if(chars[i]==0){
	            chars[i] = nextChar(rnd);    
	        }
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
