package DataStructures;

public class TreeNode {
	/* node class for general tree structures */
	
	private Integer e;
	private TreeNode parent;
	private TreeNode first_child;
	private TreeNode last_child;
	private TreeNode prev_sib;
	private TreeNode next_sib;
	
	/* variables used for printing trees */
	private int depth;
	private int count;
	private int xcoord;
	
	public TreeNode() {
		/* constructor for a node with no links */
		e = null;
		parent = null;
		first_child = null;
		last_child = null;
		prev_sib = null;
		next_sib = null;
	}
	
	public TreeNode(int element) {
		/* constructor for a node with no links */
		e = element;
		parent = null;
		first_child = null;
		last_child = null;
		prev_sib = null;
		next_sib = null;
	}
	
	public TreeNode(int element, TreeNode p) {
		/* constructor for a node with parent. Puts new node at end of children list */
		e = element;
		parent = p;
		first_child = null;
		last_child = null;
		prev_sib = parent.get_last_child();
		next_sib = null;
		parent.change_last_child(this);
	}
	
	public int get_element() {
		/* returns the element of the node */
		return e;
	}
	
	public TreeNode get_parent() {
		/* returns the parent of the node */
		return parent;
	}
	
	public TreeNode get_first_child() {
		/* returns the first child added to the node */
		return first_child;
	}
	
	public TreeNode get_last_child() {
		/* returns the last child added to the node */
		return last_child;
	}
	
	public TreeNode get_next_sib() {
		/* returns the next child of the node's parent */
		return next_sib;
	}
	
	public TreeNode get_prev_sib() {
		/* returns the previous child of the node's parent */
		return prev_sib;
	}
	
	public int change_element(int el) {
		/* update the element */
		e = el;
		return e;
	}
	
	public TreeNode change_parent(TreeNode p) {
		/* update the parent */
		parent = p;
		return parent;
	}
	
	public TreeNode change_first_child(TreeNode p) {
		/* update the first child */
		first_child = p;
		if (num_children() == 0) {
			last_child = p;
		}
		return first_child;
	}
	
	public TreeNode change_last_child(TreeNode p) {
		/* update the last child */
		if (num_children() > 0) {
			TreeNode node = last_child;
			node.change_next_sib(p);
			p.change_prev_sib(node);
		}
		else {
			first_child = p;
		}
		
		last_child = p;
		return last_child;
	}
	
	public TreeNode change_next_sib(TreeNode p) {
		/* update the next sibling */
		next_sib = p;
		return next_sib;
	}
	
	public TreeNode change_prev_sib(TreeNode p) {
		/* update the previous sibling */
		prev_sib = p;
		return prev_sib;
	}
	
	public int num_children() {
		/* return the number of children of a node */
		int n = 1;
		if (first_child == null) {
			return 0;
		}
		else {
			TreeNode node = first_child;
			while (node.get_next_sib() != null) {
				n++;
				node = node.get_next_sib();
			}
			return n;
		}
	}
	
	public int get_depth() {
		/* return the depth */
		return depth;
	}
	
	public int get_count() {
		/* return the count */
		return count;
	}
	
	public int change_depth(int d) {
		/* update the depth */
		depth = d;
		return depth;
	}
	
	public int change_count(int c) {
		/* update the count */
		count = c;
		return count;
	}
	
	public int get_xcoord() {
		/* return the x coordinate */
		return xcoord;
	}
	
	public int change_xcoord(int x) {
		/* update the x coordinate */
		xcoord = x;
		return xcoord;
	}

}
