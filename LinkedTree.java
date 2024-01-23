package DataStructures;
import java.awt.Graphics;
import java.util.ArrayList;

public class LinkedTree {
	/* linked tree implemented with TreeNode class */
	
	private TreeNode root;
	private int size;
	
	public LinkedTree() {
		/* constructor for the tree class */
		size = 0;
	}
	
	public int len() {
		/* returns the size of the tree */
		return size;
	}
	
	public TreeNode add_root(int e) {
		/* creates a root node */
		if (size == 0) {
			root = new TreeNode(e);
			size++;
		}
		else {
			System.out.println("error: this is not an empty tree");
		}
		return root;
	}
	
	public TreeNode parent(TreeNode node) {
		/* returns the parent of the node */
		return node.get_parent();
	}
	
	public ArrayList<TreeNode> children(TreeNode node){
		/* returns an ArrayList of the children of the node */
		int n = node.num_children();
		ArrayList<TreeNode> children = new ArrayList<TreeNode>();
		
		if (n==0) {
			return null;
		}
		
		else {
			TreeNode child = node.get_first_child();
			
			for (int i=0; i<n; i++) {
				children.add(child);
				child = child.get_next_sib();
			}
		}
		return children;
	}
	
	public int num_children(TreeNode node) {
		/* returns the number of children of a node */
		return node.num_children();
	}
	
	public boolean is_leaf(TreeNode node) {
		/* returns true if the node is a leaf */
		return node.num_children() == 0;
	}

	public TreeNode add_child(int e, TreeNode p) {
		/* adds a child to the node at the end of the children list */
		TreeNode child = new TreeNode(e, p);
		return child;
	}
	
	public void print_text() {
		/* prints the elements of the tree breadth-first */
		System.out.println("printing tree:");
		TreeNodeQueue Q = new TreeNodeQueue();
		TreeNode node = root;
		Q.enqueue(node);
		
		while (Q.is_empty() == false) {
			node = Q.dequeue();
			System.out.println(node.get_element());
			ArrayList<TreeNode> A;
			
			if (node.num_children()>0) {
				A = children(node);
				for (int i=0; i<node.num_children(); i++) {
					Q.enqueue(A.get(i));
				}
			}
			
			
		}
		System.out.println(" ");
	}
	
	public void print_t() {
		/* creates a graphical representation of a tree */
		
		
		//-----------------traverse the tree----------------
		
		int count = 1;								// used for x coord
		int max_count = 0;							// max num of children in one layer for printing
		int depth = 0;								// used for y coord
		ArrayList<TreeNode> A;						// store the children of a node
		
		TreeNodeQueue Q = new TreeNodeQueue();				// stores TreeNodes, used to do breadth first search
		TreeNodeQueue Q2 = new TreeNodeQueue();      // stores TreeNodes with information for printing  
		TreeNode node = root;
		node.change_count(1);
		node.change_depth(0);
		Q.enqueue(node); 							
			
		while (Q.is_empty() == false) {
			int loop = count;						// loop the number of children that were found in the last layer
			if (count>max_count) {
				max_count = count;
			}
			count = 0;								// count the number of children 
			depth++;								// increment depth since moving to another layer
			
			for (int i=0; i<loop; i++) {
				node = Q.dequeue();
				Q2.enqueue(node);
				int num_kids = num_children(node);
				A = children(node);
				for (int j=0; j<num_kids; j++) {
					count++;
					TreeNode kid = A.get(j);
					Q.enqueue(kid);
					kid.change_depth(depth);
					kid.change_count(count);
				}
				
			}
		}
		
		
		//-----------------draw the tree----------------
		
		final int width = 600;    		// screen width
		final int height = 600;			// screen height 
		
		DrawingPanel panel = new DrawingPanel(width, height);        // creates a canvas to draw on
		Graphics g = panel.getGraphics();							 // used to draw
		
		int xcoord;
		int ycoord;
		int circle_size = 30;			// how big the circles for the nodes are 
		Integer e;
		int div_height = height/depth;  // divide the height of the screen into equal sections for each layer

		
		while (Q2.is_empty()==false) {   // go through the stack and print each node
		
			TreeNode drawingNode = Q2.dequeue();
			
			int div_width = width/max_count; 					// divide the width of the screen by the number of nodes in the layer
			
			ycoord = (drawingNode.get_depth()+1)*div_height;
			xcoord = drawingNode.get_count()*div_width;
			drawingNode.change_xcoord(xcoord);
			e = drawingNode.get_element();
			
			if (drawingNode.get_depth()>0) {					// if not the root node, draw line connecting to parent
				g.drawString(e.toString(), xcoord-circle_size/2, ycoord-circle_size/3);         // draw the element on the screen
				g.drawOval(xcoord-circle_size, ycoord-circle_size, circle_size, circle_size);   // draw a circle around the element 
				TreeNode p = drawingNode.get_parent();
				g.drawLine(xcoord-circle_size/2, ycoord-circle_size, p.get_xcoord()-circle_size/2, drawingNode.get_depth()*div_height);
			}
			else {
				// root node
				g.drawString(e.toString(), width/2-circle_size/2, ycoord-circle_size/3);      	 // draw the element on the screen
				g.drawOval(width/2-circle_size, ycoord-circle_size, circle_size, circle_size);   // draw a circle around the element 
				drawingNode.change_xcoord(width/2);
			}
		}
	}

}
