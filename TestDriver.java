package DataStructures;


public class TestDriver {

	public static void main(String[] args) {
		testBinarytree();
		testTree();
	}
	
	
	public static void testBinarytree() {
		/* driver for testing linked binary tree */
	
		LinkedBinaryTree T = new LinkedBinaryTree();
		
		BTnode root = T.add_root(10);
		
		BTnode l = T.add_left(11, root);
		BTnode r = T.add_right(12, root);
		
		T.add_left(13, l);
		T.add_right(14,l);
		T.add_left(15, r);
		BTnode r2 = T.add_right(16, r);
		
		T.add_left(17, r2);
		
		
		T.print_t();
		
	}
	
	public static void testTree() {
		/* driver for testing linked tree */
	
		LinkedTree T = new LinkedTree();
		
		TreeNode root = T.add_root(1);
		
		TreeNode child1 = T.add_child(2, root);
		TreeNode child2 = T.add_child(3, root);
		TreeNode child3 = T.add_child(4, root);
		
		TreeNode child4 = T.add_child(5, child1);
		
		T.add_child(6, child2);
		T.add_child(7, child2);
		
		T.add_child(9, child3);
		T.add_child(10, child3);
		
		T.add_child(11, child4);	
			
		
		T.print_t();
	}
	
}