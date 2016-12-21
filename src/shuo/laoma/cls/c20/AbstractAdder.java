package shuo.laoma.cls.c20;

public abstract class AbstractAdder implements IAdd {
    @Override
    public void addAll(int[] numbers) {
        for(int num : numbers){
            add(num);
        }
    }
}
