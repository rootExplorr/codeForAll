package org.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Scanner;
import java.util.Comparator;

import java.util.*;



public class BinaryTree {
	
	//Returns the start node of the generated binary tree.
	public static Node generateBinaryTree(int depth) {
		if(depth==0)
			return null;

		int k=1;
		Node root = new Node(k + "", null, null);
		List<Node> previousDepth = new ArrayList<Node>(); //list1
		previousDepth.add(root);
		
		List<Node> currentNodes = new ArrayList<Node>(); //list2
		
		for(int l=1; l<=depth; l++) {
			for(int m=0; m<previousDepth.size();m++) {
				k=k+1;
				previousDepth.get(m).left = new Node(k+"", null, null);
				
				k=k+1;
				previousDepth.get(m).right = new Node(k+"", null, null);
				
				currentNodes.add(previousDepth.get(m).left);
				currentNodes.add(previousDepth.get(m).right);
			}
			previousDepth = currentNodes;
			currentNodes = new ArrayList<Node>();
		}
		return root;
	}

	public static void inOrder(Node node) {
		if(node==null)
			return;
		
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	public static void preOrder(Node node) {
		if(node==null)
			return;

		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node==null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	public static List<List<Node>> levelOrder(Node node) {
		List<Node> list = new ArrayList<Node>();
		list.add(node);
		
		List<List<Node>> traversal = new  ArrayList<List<Node>>();
		
		List<Node> currentList = new ArrayList<Node>();
		while(!list.isEmpty()) {
			traversal.add(new ArrayList<Node>(list));
			for(int k=0; k<list.size(); k++) {
				//System.out.print(list.get(k).value + " ");
				if(list.get(k)!=null){
					currentList.add(list.get(k).left);
					currentList.add(list.get(k).right);
				}
			}
			list = currentList;
			currentList.removeIf((cNode) -> {return cNode==null;});
			currentList = new ArrayList<Node>();
		}
		return traversal;
	}
	
	public static void main(String[] args) {
		Node tree = BinaryTree.generateBinaryTree(4);
		BinaryTree.preOrder(tree);
		System.out.println();
		
		BinaryTree.inOrder(tree);
		System.out.println();
		
		BinaryTree.postOrder(tree);
		System.out.println();
		
		List<List<Node>> list = BinaryTree.levelOrder(tree);
		System.out.println();
	}
}