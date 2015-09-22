package com.mbelyamani.bst;

public class TreeNode<T> {
	private TreeNode<T> left;
    private Comparable<T> item;
    private TreeNode<T> right;
    private TreeNode<T> parent;

    TreeNode(TreeNode<T> left, Comparable<T> item, TreeNode<T> right, TreeNode<T> parent) {
        this.setLeft(left);
        this.setRight(right);
        this.setItem(item);
        this.setParent(parent);
    }

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public Comparable<T> getItem() {
		return item;
	}

	public void setItem(Comparable<T> item) {
		this.item = item;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
    
    

}
