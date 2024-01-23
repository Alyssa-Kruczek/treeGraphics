package DataStructures;
import java.util.ArrayList;

public class NodeQueue {
	/* Queue implemented with ArrayList that stores BTnodes */
	
	private ArrayList<BTnode> data;
	
	public NodeQueue() {
		/* constructor for the queue class */
		data = new ArrayList<BTnode>();
		
	}
	
	public int len() {
		/* returns the size of the queue*/
		return data.size();
	}
	
	public boolean is_empty() {
		/* returns true if the queue is empty, otherwise returns false */
		return data.size() == 0;
	}
	
	public BTnode first() {
		/* returns the first element of the queue */
		if (data.size() == 0) {
			System.out.println("error: queue is empty.");
			return null;
		}
		else {
			return data.get(0);
		}
	}
	
	public BTnode dequeue() {
		/* removes the first element of the queue */
		if (data.size() == 0) {
			System.out.println("error: queue is empty.");
			return null;
		}
		else {
			BTnode e = data.get(0);
			data.remove(0);
			return e;
		}
	}
	
	public void enqueue(BTnode e) {
		/* adds an element to the end of the queue */
		data.add(e);
	}
	
	public void print_queue() {
		/* prints the elements of the queue */
		System.out.println("printing queue:");
		for (int i=0; i<data.size(); i++) {
			BTnode node = data.get(i);
			System.out.print(node.get_element());
		}
		System.out.println(" ");
	}

}
