package shuo.laoma.cls.c24;

public class ExceptionTest {
  
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("请输入数字");
            return;
        }
        try{
            int num = Integer.parseInt(args[0]);
            System.out.println(num);    
        }catch(NumberFormatException e){
            System.err.println("参数"+args[0]
                    +"不是有效的数字，请输入数字");
        }
    }
}
