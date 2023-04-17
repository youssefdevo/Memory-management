
public class Partition {
	
	private String name;
	private int size;
	private Process current;
	boolean empty;
	boolean compact;
	public Partition(String name2, int size2) {
		this.setName(name2);
		this.setSize(size2);
		this.current = null;
		empty = true;
		compact = false;
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

	public Process getCurrent() {
		return current;
	}

	public void setCurrent(Process current) {
		this.current = current;
		this.empty = false;
	}

	public boolean empty() {
		return empty;
	}

	public boolean isCompacted() {
		return compact;
	}
	
	public void compacted() {
		this.compact = true;
	}
	
}
