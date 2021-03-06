/*Build the mirror tree of the given tree (exchange the left and right nodes).
 * This can be done using Post order traversal where the left and right nodes 
 * are swapped (using post order traversal).
 * 
 */
import java.io.*;
import java.util.*;

public class GetMirrorTree {
	public static class Node{
		int data;
		Node left,right;
		Node(int d){
			this.data=d;
			this.left=null;
			this.right=null;
		}
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Node> hm = new HashMap<Integer,Node>();
		int inputs = 4;
		Node root=null;
		StringTokenizer st = new StringTokenizer("1 3 L 1 2 R 2 5 L 2 4 R"," ");
		while(inputs>0){
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
//			System.out.println("n1="+n1);
//			System.out.println("n2="+n2);
//			System.out.println("c="+c);
			//If parent doesn't exist in the hashmap, it means it is the root.
			Node parent = hm.get(n1);
			if(parent==null){
				parent = new Node(n1);
				if(root==null)
					root=parent;
				hm.put(n1,parent);
//				System.out.println("Adding root"+n1);
			}
			//If parent exists in the hashmap, just make a new node for the child and attach it to the tree.
			Node treeNode = new Node(n2);
			if(c=='L'){
				parent.left=treeNode;
			}
			else if(c=='R'){
				parent.right=treeNode;
			}
			hm.put(n2,treeNode);
			inputs--;
		}
		System.out.println("Inorder traversal of tree:");
		inorder(root);
		System.out.println("\nInorder traversal of mirror tree:");
		Node mirrorRoot= getMirror(root);
		inorder(mirrorRoot);
	}
	private static Node getMirror(Node root) {
		if(root==null)
			return null;
		getMirror(root.left);
		getMirror(root.right);
		Node temp = root.left;
		root.left=root.right;
		root.right=temp;
		return root;
	}
	private static void inorder(Node root) {
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
		
	}
}
