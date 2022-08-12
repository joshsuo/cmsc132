package sysImplementation;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;  /* Needed for Random class */
import java.util.Stack; 


public class RosterTree {
	
	private class Node {
		private int id;

		private Node left, right;

		private Node(int id) {
			this.id = id;
			
		}
	}
	
	private Node root = null;
	private int size =0;
	

	public int getSize() {
		return size;
	}



	public boolean add(int id) {
		if (root == null) {
			root = new Node(id);
			size++;
			return true;
		} else {
			return addAux(id,root);
		}
	}

	private boolean addAux(int id, Node rootAux) {
		int comparison = Integer.valueOf(id).compareTo(rootAux.id);

		if (comparison == 0) {
			return false;
		} else if (comparison < 0) {
			if (rootAux.left == null) {
				rootAux.left = new Node(id);
				size++;
				return true;
			} else {
				return addAux(id, rootAux.left);
			}
		} else {
			if (rootAux.right == null) {
				rootAux.right = new Node(id);
				size++;
				return true;
			} else {
				return addAux(id, rootAux.right);
			}
		}
	}
	
	 private static boolean isCsId(int id) {
		   if (id>=200 && id <=299)
			   return true;
			return false;
	}
	
	
	
	public static RosterTree makeRosterTree(int seed, int loopCount) {
		
		RosterTree tree = new RosterTree();
		Random random = new Random(seed);
		
		for (int i =0; i <loopCount; i++){	
			tree.add(random.nextInt(900)+100);  //add a random id to the tree

		}
		
		return tree;
	}
	
	public int[] countCSIdParents() {
		
		int[] array = new int[3];
		
		array = countCSIdParentsAux(array, this.root);
		
		return array;
	}
	
	// write private countCSIdParentsAux
	private int[] countCSIdParentsAux(int[] array, Node node)
	{
		if(node == null)
		{
			return array;
		}
		
		if(node.left != null)
			array = countCSIdParentsAux(array, node.left);
		
		if(node.right != null)
			array = countCSIdParentsAux(array, node.right);
		
		if(node.left != null && node.right != null)
		{
			if(isCsId(node.left.id) && isCsId(node.right.id))
			{
				array[2] += 1;
			}
			else if((!isCsId(node.left.id) && isCsId(node.right.id)) || (isCsId(node.left.id) 
					&& !isCsId(node.right.id)))
			{
				array[1] += 1;
			}
			else
			{
				array[0] += 1;
			}
		}
		else if(node.left != null && node.right == null)
		{
			if(isCsId(node.left.id))
			{
				array[1] += 1;
			}
			else
			{
				array[0] += 1;
			}
		}
		else if(node.left == null && node.right != null)
		{
			if(isCsId(node.right.id))
			{
				array[1] += 1;
			}
			else
			{
				array[0] += 1;
			}
		}
		else
		{
			array[0] += 1;
		}
		return array;
	}
	
		
	
	public String csIdPerLevel() {
		
		Queue <Node> queue = new ArrayDeque<Node>();
		
		//As for the queue, can only use methods add, remove and isEmpty
		String result = "";
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			Node temp = queue.remove();
			
			if(isCsId(temp.id))
				result += temp.id + " ";
			
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
           
			if(temp.right != null)
            {
                queue.add(temp.right);
            }
			
		}
		return result;
	
	}
	
	
	//assume r1 and r2 are not null, if non-empty have valid ids that might repeat
    public static boolean reversableRosters(int [] r1, int [] r2) {
		
    	Stack <Integer> stack = new Stack<Integer>();
		
    	for(int i = 0; i < r1.length; i++)
    	{
    		if(isCsId(r1[i]))
    			stack.push(r1[i]);
    	}
    	
    	for(int i = 0; i < r2.length; i++)
    	{
    		if(isCsId(r2[i]))
    		{
    			if(stack.pop().compareTo(r2[i]) != 0)
    			{
    				return false;
    			}
    		}
    			
    	}
    	return true;
	}


}



