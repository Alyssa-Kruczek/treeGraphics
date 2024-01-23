package DataStructures;

import java.util.ArrayList;

public class TreeNodeStack {
	/* Stack that stores PrintNodes for printing trees */
	
	private ArrayList<TreeNode> data;
	
	public TreeNodeStack(){
		/* constructor for stack objects */
		data = new ArrayList<TreeNode>();
	}
	
	public void push(TreeNode e) {
		/* adds element e to the stack */
		data.add(e);
	}
	
	public TreeNode pop() {
		/* removes the top element from the stack */
		if (data.size() == 0) {
			System.out.println("error: stack is empty.");
			return null;
		} 
		else {
			int n = data.size();
			TreeNode e = data.get(n-1);
			data.remove(n-1);
			return e;
		}
	}
	
	public TreeNode top() {
		/* returns the top element from the stack */
		if (data.size() == 0) {
			System.out.println("error: stack is empty.");
			return null;
		} 
		else {
			int n = data.size();
			TreeNode e = data.get(n-1);
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
			TreeNode node = data.get(i);
			System.out.println(node.get_element());
		}
		System.out.println(" ");
	}

}
