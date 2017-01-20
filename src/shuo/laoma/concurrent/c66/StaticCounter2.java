package shuo.laoma.concurrent.c66;

public class StaticCounter2 {

    private static int count = 0;

    public static void incr() {
        synchronized(StaticCounter.class){
            count++;    
        }    
    }

    public static int getCount() {
        synchronized(StaticCounter.class){
            return count;    
        }
    }

}
