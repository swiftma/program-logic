package shuo.laoma.cls.c21.member;

public class Outer {
    private int a = 100;
    
    public class Inner {
        public void innerMethod(){
            System.out.println("outer a " +a);
            Outer.this.action();
        }
    }
    
    private void action(){
        System.out.println("action");
    }
    
    public void test(){
        Inner inner = new Inner();
        inner.innerMethod();
    }
}
