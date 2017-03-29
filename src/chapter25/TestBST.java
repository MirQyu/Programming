package chapter25;

public class TestBST {
	public static void main(String[] args) {
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.print("\nPostorder: ");
		tree.postorder();
		System.out.println("\nPreorder: ");
		tree.preorder();
		System.out.println("\nThe number of nodes is " + tree.getSize());
		
		System.out.print("\nIs Peter in the tree? " + tree.search("Peter"));
		
		System.out.print("\nA path from the root to Peter is: ");
		
		
	}
}
