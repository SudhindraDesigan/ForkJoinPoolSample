import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

 class RecursiveActionSample extends RecursiveAction{

	
	private static final long serialVersionUID = 8614371070587200445L;
	@Override
	protected void compute() {
		
		List<String> str = Arrays.asList("a2", "b2", "c2", "d2");
		str.stream().forEach(System.out::println);
	}
	

}
 class RecursiveTaskSample extends RecursiveTask<int[]>{

	private static final long serialVersionUID = 6779214818480947352L;

	int n;
	int[] arr; 
	
	public RecursiveTaskSample() {
		super();
	}

	public RecursiveTaskSample(int n) {
		super();
		this.n = n;
	}

	@Override
	protected int[] compute() {
		arr = new int[this.n];
		for(int i=0;i<this.n;i++)
		{
			arr[i]=i;
		}
		return arr;
	}}
 public class ForkJoinPoolSample {
	 public static void main(String arg[])
		{
			RecursiveActionSample sample = new RecursiveActionSample();
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.invoke(sample);
			System.out.println("-------------------------------------------------");
			RecursiveTaskSample taskSample = new RecursiveTaskSample(200);
			int[] arr = forkJoinPool.invoke(taskSample);
			Arrays.stream(arr).forEach(System.out::println);
		}
 }

