package DataStructures;
import java.util.ArrayList;

public class TreeNodeQueue {
	/* Queue implemented with ArrayList that stores BTnodes */
	
	private ArrayList<TreeNode> data;
	
	public TreeNodeQueue() {
		/* constructor for the queue class */
		data = new ArrayList<TreeNode>();
		
	}
	
	public int len() {
		/* returns the size of the queue*/
		return data.size();
	}
	
	public boolean is_empty() {
		/* returns true if the queue is empty, otherwise returns false */
		return data.size() == 0;
	}
	
	public TreeNode first() {
		/* returns the first element of the queue */
		if (data.size() == 0) {
			System.out.println("error: queue is empty.");
			return null;
		}
		else {
			return data.get(0);
		}
	}
	
	public TreeNode dequeue() {
		/* removes the first element of the queue */
		if (data.size() == 0) {
			System.out.println("error: queue is empty.");
			return null;
		}
		else {
			TreeNode e = data.get(0);
			data.remove(0);
			return e;
		}
	}
	
	public void enqueue(TreeNode e) {
		/* adds an element to the end of the queue */
		data.add(e);
	}
	
	public void print_queue() {
		/* prints the elements of the queue */
		System.out.println("printing queue:");
		for (int i=0; i<data.size(); i++) {
			TreeNode node = data.get(i);
			System.out.println(node.get_element());
		}
		System.out.println(" ");
	}

}
