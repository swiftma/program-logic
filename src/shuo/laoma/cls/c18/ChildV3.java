package shuo.laoma.cls.c18;

public class ChildV3 extends BaseV3 {
	
	private long sum;

	@Override
	public void add(int number) {
		super.add(number);
		sum+=number;
	}

	@Override
	public void addAll(int[] numbers) {
		super.addAll(numbers);
		for(int i=0;i<numbers.length;i++){
			sum+=numbers[i];
		}
	}
	
	public long getSum() {
		return sum;
	}
	
	@Override
	public void clear() {
	    super.clear();
	    this.sum = 0;
	}
}