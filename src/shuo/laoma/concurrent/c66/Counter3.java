package shuo.laoma.concurrent.c66;

public class Counter3 {

    private int count;
    private Object lock = new Object();
    
    public void incr(){
        synchronized(lock){
            count ++;    
        }
    }
    
    public int getCount() {
        synchronized(lock){
            return count;
        }
    }
}
