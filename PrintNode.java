package DataStructures;

public class PrintNode {
	/* Node class for printing trees - depth and count used for x and y coords */
	
	private Integer e;
	private int depth;
	private int count;
	
	
	public PrintNode(int element, int d, int c) {
		/* constructor for a node */
		e = element;
		depth = d;
		count = c;
	}
	
	
	public int get_element() {
		/* return the element of the node */
		return e;
	}
	
	public int get_depth() {
		/* return the depth of the node */
		return depth;
	}
	
	public int get_count() {
		/* return the count of the node */
		return count;
	}
	
	public void change_element(int el) {
		/* update the element */ 
		e = el;
	}
	
	public void change_depth(int d) {
		/* update the depth */ 
		depth = d;
	}
	
	public void change_count(int c) {
		/* update the count */ 
		count = c;
	}
	
}
