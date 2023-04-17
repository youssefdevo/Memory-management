import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Partition>partitions = new ArrayList<>();
		ArrayList<Process>processes = new ArrayList<>();
		System.out.println("Enter number of partition:");
		
		//Partition input.
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Partition name and its size:");
			String name = in.next();
			int size = in.nextInt();
			Partition p = new Partition(name,size);
			partitions.add(p);
		}
		
		//process input
		System.out.println("Enter number of processes:");
		n = in.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Process name and its size:");
			String name = in.next();
			int size = in.nextInt();
			Process p = new Process(name,size);
			processes.add(p);
		}
		//select policy
		System.out.println("1. First fit\n2. Best fit\n3. Worst fit");
		int request = in.nextInt();
		if(request==1) {
			
			FirstFit first = new FirstFit(partitions,processes);
			first.doWork();
			first.print();
			System.out.println("/nDo you want to compact? 1.yes 2.no");
			int order = in.nextInt();
			if(order == 1) {
				first.compact();
				first.print();
			}
			
		}
		else if(request == 2) {
			
			BestFit best = new BestFit(partitions,processes);
			best.doWork();
			best.print();
			System.out.println("/nDo you want to compact? 1.yes 2.no");
			int order = in.nextInt();
			if(order == 1) {
				best.compact();
				best.print();
			}
			
		}
		else if(request == 3) {
			
			WorstFit worst = new WorstFit(partitions,processes);
			worst.doWork();
			worst.print();
			System.out.println("/nDo you want to compact? 1.yes 2.no");
			int order = in.nextInt();
			if(order == 1) {
				worst.compact();
				worst.print();
			}
			
			
		}
	}

}




















