package shuo.laoma.concurrent.c71;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread (){
	        public void run(){
	            LockSupport.park();
	            System.out.println("exit");
	        }
	    };
	    t.start();    
	    Thread.sleep(1000);
	    LockSupport.unpark(t);

	}

}
