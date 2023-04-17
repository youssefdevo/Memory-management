
public class Process {
	
	private String name;
	private int size;
	private boolean done;
	public Process(String name2, int size2) {
		this.setName(name2);
		this.setSize(size2);
		this.done = false;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone() {
		this.done = true;
	}
}
