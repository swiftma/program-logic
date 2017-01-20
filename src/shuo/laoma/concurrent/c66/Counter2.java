package shuo.laoma.concurrent.c66;

public class Counter2 {
    private int count;

    public void incr(){
        synchronized(this){
            count ++;    
        }
    }
    
    public int getCount() {
        synchronized(this){
            return count;
        }
    }
}
