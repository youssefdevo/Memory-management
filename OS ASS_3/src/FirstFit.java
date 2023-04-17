import java.util.ArrayList;

public class FirstFit {

	private ArrayList<Partition> partitions;
	private ArrayList<Process> processes;
	private int currentP;
	
	public FirstFit(ArrayList<Partition> partitions, ArrayList<Process> processes) {
		this.setPartitions(partitions);
		this.setProcesses(processes);
		currentP = partitions.size();
	}

	public ArrayList<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(ArrayList<Partition> partitions) {
		this.partitions = partitions;
	}

	public ArrayList<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(ArrayList<Process> processes) {
		this.processes = processes;
	}
	
	public void doWork() {
		for(int j = 0; j < processes.size(); j++) {
			Process p = processes.get(j);
			if(p.isDone())continue;
			int n = partitions.size();
			for(int i = 0; i < n; i++) {
				if(partitions.get(i).getSize() >= p.getSize() && partitions.get(i).empty() && !partitions.get(i).isCompacted()) {	
					partitions.get(i).setCurrent(p);
					int x = partitions.get(i).getSize() - p.getSize();
					partitions.get(i).setSize(p.getSize());
					if(x>0) {
						Partition newPartition = new Partition(("partition" + this.currentP++),x);
						if(i+1>=n)partitions.add(newPartition);
						else partitions.add(i+1, newPartition);
						
					}
					p.setDone();
					break;
				}
			
			}
		}
	}
	
	public void compact() {
		int size = 0;
		for(int i = 0; i<partitions.size(); ++i) {
			
			Partition p = partitions.get(i);
			if(p.empty && !p.isCompacted()) {
				size += p.getSize();
				p.compacted();
			}
		}
		Partition newPartition = new Partition(("partition" + this.currentP++),size);
		partitions.add(newPartition);
		this.doWork();
	}
	
	
	public void print() {
		for(Partition p:partitions) {
			if(p.isCompacted())continue;
			System.out.print(p.getName() + " (" + p.getSize() + ')' + " => ");
			if(p.empty())System.out.println("External fragment");
			else System.out.println(p.getCurrent().getName());
		}
		System.out.println();
		for(Process p:processes) {
			if(!p.isDone()) {
				System.out.print(p.getName() + " can not be allocated.\n");
			}
		}
	}
}












