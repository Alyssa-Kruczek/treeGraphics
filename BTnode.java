package DataStructures;

public class BTnode {
	/* Node class for linked binary trees */

	private Integer e;
	private BTnode parent;
	private BTnode left;
	private BTnode right;
	
	public BTnode() {
		/* constructor for a node with no links */
		e = null;
		parent = null;
		left = null;
		right = null;
	}
	
	public BTnode(int element) {
		/* constructor for a node with an element and no links */
		e = element;
		parent = null;
		left = null;
		right = null;
	}
	
	public BTnode(int element, BTnode p) {
		/* constructor for a node with parent */
		e = element;
		parent = p;
		left = null;
		right = null;
	}
	
	public BTnode(int element, BTnode p, BTnode l) {
		/* constructor for a node with parent and left child */
		e = element;
		parent = p;
		left = l;
		right = null;
	}
	
	public BTnode(int element, BTnode p, BTnode l, BTnode r) {
		/* constructor for a node with all of the links */
		e = element;
		parent = p;
		left = l;
		right = r;
	}
	
	public BTnode get_parent() {
		/* return the parent of a node */
		return parent;
	}
	
	public BTnode get_left() {
		/* return the left child of a node */
		return left;
	}
	
	public BTnode get_right() {
		/* return the right child of a node */
		return right;
	}
	
	public int get_element() {
		/* return the element of a node */
		return e;
	}
	
	public BTnode add_parent(BTnode p) {
		/* add a parent to a node */
		parent = p;
		return parent;
	}
	
	public BTnode add_left(BTnode l) {
		/* add a left child to a node */
		left = l;
		return left;
	}
	
	public BTnode add_right(BTnode r) {
		/* add a right child to a node */
		right = r;
		return right;
	}
	
	public BTnode add_element(int element) {
		/* add an element to a node */
		e = element;
		return this;
	}
	
}
