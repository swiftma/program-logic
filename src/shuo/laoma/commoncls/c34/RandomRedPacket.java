package shuo.laoma.commoncls.c34;

import java.util.Random;

public class RandomRedPacket {

    private int leftMoney;
    private int leftNum; 
    private Random rnd;
    
    public RandomRedPacket(int total, int num){
        this.leftMoney = total;
        this.leftNum = num;
        this.rnd = new Random();
    }
    
    public synchronized int nextMoney(){
        if(this.leftNum<=0){
            throw new IllegalStateException("抢光了");
        }
        if(this.leftNum==1){
            return this.leftMoney;
        }
        double max = this.leftMoney/this.leftNum*2d;
        int money = (int)(rnd.nextDouble()*max);
        money = Math.max(1, money);
        this.leftMoney -= money;
        this.leftNum --;
        
        return money;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomRedPacket redPacket = new RandomRedPacket(1000, 10);
		for(int i=0; i<10; i++){
		    System.out.print(redPacket.nextMoney()+" ");
		}

	}

}
