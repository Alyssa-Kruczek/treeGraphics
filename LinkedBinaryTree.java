package DataStructures;
import java.awt.*;

public class LinkedBinaryTree {
	/* Linked binary tree class implemented with BTnodes class for nodes */
	
	private BTnode root;
	private int size;

	public LinkedBinaryTree() {
		/* constructor for binary tree class */
		size = 0;
	}
	
	public int len() {
		/* returns the size of the tree */
		return size;
	}
	
	
	public BTnode parent(BTnode node) {
		/* returns the parent of the node */
		return node.get_parent();
	}
	
	public BTnode left(BTnode node) {
		/* returns the left child of the node */
		return node.get_left();
	}
	
	public BTnode right(BTnode node) {
		/* returns the right child of the node */
		return node.get_right();
	}
	
	public BTnode add_root(int e) {
		/* adds a root to the binary tree */
		if (size == 0) {
			root = new BTnode(e);
			size++;
		}
		else {
			System.out.println("error: this is not an empty tree");
		}
		return root;
	}
	
	public BTnode add_left(int e, BTnode p) {
		/* adds a left child p to the node */
		if (p.get_left()==null) {
			BTnode l = new BTnode(e, p);
			p.add_left(l);
			size++;
			return l;
		}
		else {
			System.out.println("error: the left child exists");
			return p;
		}
	}
	
	public BTnode add_right(int e, BTnode p) {
		/* adds a right child p to the node */
		if (p.get_right()==null) {
			BTnode r = new BTnode(e, p);
			p.add_right(r);
			size++;
			return r;
		}
		else {
			System.out.println("error: the left child exists");
			return p;
		}
	}
	
	public void print_text() {
		/* prints the elements of the tree breadth-first */
		System.out.println("printing tree:");
		NodeQueue Q = new NodeQueue();
		BTnode node = root;
		Q.enqueue(node);
		
		while (Q.is_empty() == false) {
			node = Q.dequeue();
			System.out.println(node.get_element());
			
			BTnode l = node.get_left();
			BTnode r = node.get_right();
			
			if (l != null) {
				Q.enqueue(l);
			}
			
			if (r != null) {
				Q.enqueue(r);
			}
		}
		System.out.println(" ");
	}
	
	
	public void print_t() {
		/* creates a graphical representation of a binary tree */
		
		
		//-----------------traverse the tree----------------
		
		int count = 1;								// used for x coord
		int depth = 0;								// used for y coord
		
		NodeQueue Q = new NodeQueue();				// stores BTnodes, used to do breadth first search
		PrintNodeStack S = new PrintNodeStack();    // stores PrintNodes with information for printing  
		BTnode node = root;
		Q.enqueue(node); 							
			
		PrintNode p = new PrintNode(node.get_element(), depth, count);
		S.push(p);  								
		
		while (Q.is_empty() == false) {
			
			int loop = count;						// loop the number of children that were found in the last layer
			count = 0;								// count the number of children 
			depth++;								// increment depth since moving to another layer
			int extra = 0;							// accounts for missing children if the binary tree isn't full
			
			for (int i=0; i<loop; i++) {
				node = Q.dequeue();
				
				BTnode l = node.get_left();
				BTnode r = node.get_right();
				
				if (l != null) {
					Q.enqueue(l);
					count++;
					p = new PrintNode(l.get_element(), depth, count+extra);
					S.push(p);
				}
				else {
					extra++;
				}
				
				if (r != null) {
					Q.enqueue(r);
					count++;
					p = new PrintNode(r.get_element(), depth, count+extra);
					S.push(p);
				}
				else {
					extra++;
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

		
		while (S.is_empty()==false) {   // go through the stack and print each node
		
			PrintNode drawingNode = S.pop();
			
			int diviser = 2;			// used to calculate x coord
			
			
			for (int i=0; i<drawingNode.get_depth(); i++) {     // calculate 2^(depth+1) (Math.pow returns double and need int type)
				diviser *= 2;
			}
			
			int div_width = width/diviser;     					// divide the width of the screen in equal sections
			
			ycoord = (drawingNode.get_depth()+1)*div_height;
			
			int c = drawingNode.get_count();                    
			int save_c = c;                                     // need unchanged count for printing lines later
			if (c > 1) {
				c += c-1;										// spaces the nodes properly 
				drawingNode.change_count(c);
			}
			xcoord = drawingNode.get_count() * div_width;
			e = drawingNode.get_element();
			
			g.drawString(e.toString(), xcoord-circle_size/2, ycoord-circle_size/3);         // draw the element on the screen
			
			g.drawOval(xcoord-circle_size, ycoord-circle_size, circle_size, circle_size);   // draw a circle around the element 
			
			if (drawingNode.get_depth()>0) {					// if not the root node, draw line connecting to parent
		
				if (save_c%2==1) {
					// left child - line goes up and to the right 
					g.drawLine(xcoord-circle_size/2, ycoord-circle_size, xcoord-(circle_size/2)+div_width, drawingNode.get_depth()*div_height);
				}
				else {
					// right child - line goes up and to the left
					g.drawLine(xcoord-circle_size/2, ycoord-circle_size, xcoord-(circle_size/2)-div_width, drawingNode.get_depth()*div_height);
				}
			}
		}
	}
}
