import java.io.*;
import java.math.*;
import java.util.*;


public class Node {
		int value;
		int subnodes = 0;
		BigInteger combo;
		Node[] children = new Node[2];
		Node(int num) {
			this.value = num;
		}
	}
public class tree
{	
	Node root; 	
    Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		new tree().prog();
	}
	
	void addNumber(int a, Node parent, int index) {
		while (parent.children[index] != null) {
			parent = parent.children[index];
			if(a<parent.value){
				index = 0;
			}
			else{
				index=1;
			}
		}
		parent.children[index] = new Node(a);
	}

	void compute(Node nod) {

		BigInteger[] permutations = new BigInteger[2];
		int[] count = new int[2];

		for (int i = 0; i < 2; ++i) {
			Node child = nod.children[i];
			if (child == null) {
				permutations[i] = BigInteger.valueOf(1);
				count[i] = 0;
			} 
			else {
				compute(child);
				count[i] = child.subnodes;
				permutations[i] = child.combo;
			}
		}
		nod.subnodes = count[0] + count[1] + 1;
		nod.combo = permutations[0].multiply(permutations[1]).multiply( combine(count[0]+count[1], count[0]));
	}
	
	BigInteger combine(int n, int y) {
		if (y > n/2){
			y = n-y;
		}
		return multiply(n-y, n).divide(multiply(0, y));
	}

	BigInteger multiply(int a, int b) {

		BigInteger x = BigInteger.valueOf(1);

		for (int i = a+1; i <= b;i++ ) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		return x;
	}
		
	void prog()  throws Exception{
		while(true) {
			int a = scan.nextInt();
			if (a == 0){
				break;
			}
			root = new Node(0);
			while (a > 0) 
			{
			addNumber(scan.nextInt(), root, 0);
			a--;
			}
			compute(root);
			System.out.println(root.combo);
		}
	}
}