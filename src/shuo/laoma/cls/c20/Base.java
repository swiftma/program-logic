package shuo.laoma.cls.c20;

public class Base extends AbstractAdder {
    private static final int MAX_NUM = 1000;
    private int[] arr = new int[MAX_NUM];
    private int count;
    
    @Override
    public void add(int number){
        if(count<MAX_NUM){
            arr[count++] = number;    
        }
    }
}