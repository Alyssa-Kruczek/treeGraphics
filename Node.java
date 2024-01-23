package DataStructures;

public class Node {
	/* class for nodes in a linked list */
	
	private Integer e;
	private Node next;
	private Node prev;
	
	public Node(int element, Node before, Node after) {
		/* constructor for node class */
		e = element;
		prev = before;
		next = after;
	}
	
	public Node() {
		/* constructor for head/tail nodes */
		e = null;
		prev = null;
		next = null;
		
	}
	
	public int get_element() {
		/* returns element of node */
		if (e == null) {
			System.out.println("error: no element");
			return -1;
		}
		else return e;
	}
	
	public Node get_next() {
		/* returns the next node in the linked list */
		return next;
	}
	
	public Node get_prev() {
		/* returns the previous node in the linked list */
		return prev;
	}
	
	public void change_next(Node new_next) {
		/* updates the next node */
		next = new_next;	
	}
	
	public void change_prev(Node new_prev) {
		/* updates the previous node */
		prev = new_prev;
	}
	
	public void remove_node() {
		/* removes a node from the list */
		prev.change_next(next);
		next.change_prev(prev);
		e = null;
	}

}
