package com.mbelyamani.bst;

public class BinarySearchTree {
	
	private TreeNode<Integer> root;
	
	public BinarySearchTree(){
		
	}
	
	public void add(int item) {
	    if (root == null) {
	        root = new TreeNode<Integer>(null, item, null, null);
	    } else {
	        add(root, item);
	    }
	}

	public void add(TreeNode<Integer> node, Integer item) {
		if (node.getItem().compareTo(item) >= 0){
			if (node.getLeft()!=null)
				add(node.getLeft(), item);
			else
				node.setLeft(new TreeNode<Integer>(null, item, null, node));
		} else {
			if (node.getRight()!=null)
				add(node.getRight(), item);
			else 
				node.setRight(new TreeNode<Integer>(null, item, null, node));
		}			
	}
	
	/**
	 * This Method will return the first node with item in it
	 * @param item
	 * @return
	 */
	public TreeNode<Integer> find(Integer item){
		return findFirst(root, item);
	}
	
	private TreeNode<Integer> findFirst(TreeNode<Integer> node, Integer item) {
		if (node == null)
			return null;
		if (node.getItem().compareTo(item) == 0){
			return node;
		} else if (node.getItem().compareTo(item) > 0) {
			return findFirst(node.getLeft(), item);
		} else {
			return findFirst(node.getRight(), item);
		}
	}
	
	public void remove(Integer item){
		removeFirst(root, item);
	}
	
	private void removeFirst(TreeNode<Integer> node, Integer item){
		if (node == null)
			return;
		if (node.getItem().compareTo(item) == 0){
			TreeNode<Integer> parent = node.getParent();
			if (parent == null)
				node = null;
			
			if (parent.getLeft()!=null && parent.getLeft().equals(node)) {
				if (node.getRight() == null && node.getLeft() == null) {
					parent.setLeft(null);
					node.setParent(null);					
				} else if (node.getRight()!=null) {
					parent.setLeft(node.getRight());
					node.getRight().setParent(parent);
					if (node.getLeft() != null)
						putInLeft(node.getRight(), node.getLeft());
				} else {
					parent.setLeft(node.getLeft());
					node.getLeft().setParent(parent);
				}
				node = null;				
			} else if (parent.getRight()!=null && parent.getRight().equals(node)) {
				if (node.getRight() == null && node.getLeft() == null) {
					parent.setRight(null);
					node.setParent(null);
					
				} else if (node.getRight()!=null) {
					parent.setRight(node.getRight());
					node.getRight().setParent(parent);
					if (node.getLeft() != null)
						putInLeft(node.getRight(), node.getLeft());
				} else {
					parent.setRight(node.getLeft());
					node.getLeft().setParent(parent);
				}
				node = null;				
			}
			
			return;
		} else if (node.getItem().compareTo(item) > 0) {
			removeFirst(node.getLeft(), item);
		} else {
			removeFirst(node.getRight(), item);
		}
	}
	
	
	private void putInLeft(TreeNode<Integer> parent, TreeNode<Integer> left) {
		if (parent == null)
			return;
		if (parent.getLeft() == null) {
			parent.setLeft(left);
			left.setParent(parent);
		} else { 
			putInLeft(parent.getLeft(), left);
		}
	}

	
	
}
