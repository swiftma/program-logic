package shuo.laoma.collection.c46;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskQueue {

	static class Task {
	    int priority;
	    String name;
	    
	    public Task(int priority, String name) {
	        this.priority = priority;
	        this.name = name;
	    }

	    public int getPriority() {
	        return priority;
	    }
	    
	    public String getName() {
	        return name;
	    }
	}
	
	private static Comparator<Task> taskComparator = new Comparator<Task>() {

	    @Override
	    public int compare(Task o1, Task o2) {
	        if(o1.getPriority()>o2.getPriority()){
	            return -1;
	        }else if(o1.getPriority()<o2.getPriority()){
	            return 1;
	        }
	        return 0;
	    }
	};
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Task> tasks = new PriorityQueue<Task>(11, taskComparator);
		tasks.offer(new Task(20, "写日记"));
		tasks.offer(new Task(10, "看电视"));
		tasks.offer(new Task(100, "写代码"));

		Task task = tasks.poll();
		while(task!=null){
		    System.out.print("处理任务: "+task.getName()
		            +"，优先级:"+task.getPriority()+"\n");
		    task = tasks.poll();
		}

	}

}
