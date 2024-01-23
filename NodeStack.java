package DataStructures;
import java.util.ArrayList;

public class NodeStack {
	/* Stack implemented with ArrayList that stores BTnodes */

	private ArrayList<BTnode> data;
	
	public NodeStack(){
		/* constructor for stack objects */
		data = new ArrayList<BTnode>();
	}
	
	public void push(BTnode e) {
		/* adds element e to the stack */
		data.add(e);
	}
	
	public BTnode pop() {
		/* removes the top element from the stack */
		if (data.size() == 0) {
			System.out.println("error: stack is empty.");
			return null;
		} 
		else {
			int n = data.size();
			BTnode e = data.get(n-1);
			data.remove(n-1);
			return e;
		}
	}
	
	public BTnode top() {
		/* returns the top element from the stack */
		if (data.size() == 0) {
			System.out.println("error: stack is empty.");
			return null;
		} 
		else {
			int n = data.size();
			BTnode e = data.get(n-1);
			return e;
		}
	}
	
	public int len() {
		/* returns the size of the stack */
		return data.size();
	}
	
	public boolean is_empty() {
		/* returns true if the stack is empty, otherwise returns false */
		return data.size() == 0;
	}
	
	public void print_stack() {
		/* prints the elements of the stack */
		System.out.println("printing stack:");
		for (int i=0; i<data.size(); i++) {
			BTnode node = data.get(i);
			System.out.println(node.get_element());
		}
		System.out.println(" ");
	}
}