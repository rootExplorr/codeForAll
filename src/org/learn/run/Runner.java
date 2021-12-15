package org.learn.run;

import java.util.List;

import org.learn.BinaryTree;
import org.learn.ExpressionEvaluation;
import org.learn.Node;
import org.learn.pattern.BinaryTreePattern;

public class Runner {
	public static void main(String[] args) {
		
		//Expression Evaluation
//---------------------------------------------------------------------------------------------------------------------//
//		String expr = "((3+1)*3)/((9-5)+2))-((3*(7-4))+6))";
//		Node root = (Node) ExpressionEvaluation.infixToBinaryTree(expr);
//		List<List<Node>> list = BinaryTree.levelOrder(root);
//		
//		int n=5;
//		String pattern[][] = new String[(int)Math.pow(2, n-1)][(int) Math.pow(2, n)];
//		
//		for(int i=0; i<(Math.pow(2, n-1)); i++) {
//			for(int j=0; j<(int) (int) Math.pow(2, n); j++) {
//				pattern[i][j] = " ";
//			}
//		}
//		BinaryTreePattern.printBinaryTree_1(list, pattern, n);
//		
//		for(int i=0; i<Math.pow(2, n-1); i++) {
//			for(int j=0; j<(int) (int) (Math.pow(2, n)); j++) {
//				System.out.print(pattern[i][j]);
//			}
//			System.out.println();
//		}
//---------------------------------------------------------------------------------------------------------------------//
		
		//Patterns 1
//---------------------------------------------------------------------------------------------------------------------//
		int n = 5;
//		Node root = BinaryTree.generateBinaryTree(n);
//		List<List<Node>> list = BinaryTree.levelOrder(root);
//		
//		String pattern[][] = new String[(int)Math.pow(2, n-1)][(int) Math.pow(2, n)];		
//		for(int i=0; i<(Math.pow(2, n-1)); i++) {
//			for(int j=0; j<(int) (int) Math.pow(2, n); j++) {
//				pattern[i][j] = " ";
//			}
//		}
//		BinaryTreePattern.printBinaryTree_1(list, pattern, n);
//		
//		for(int i=0; i<Math.pow(2, n-1); i++) {
//			for(int j=0; j<(int) (int) (Math.pow(2, n)); j++) {
//				System.out.print(pattern[i][j]);
//			}
//			System.out.println();
//		}

		//Patterns 2
//---------------------------------------------------------------------------------------------------------------------//
//		Node root = BinaryTree.generateBinaryTree(n);
//		List<List<Node>> list = BinaryTree.levelOrder(root);
//		
//		String pattern[][] = new String[(int)Math.pow(2, n)][(int) Math.pow(2, n-1)];		
//		for(int i=0; i<(Math.pow(2, n)); i++) {
//			for(int j=0; j<(int) (int) Math.pow(2, n-1); j++) {
//				pattern[i][j] = " ";
//			}
//		}
//		BinaryTreePattern.printBinaryTree_2(list, pattern, n);
//		
//		for(int i=0; i<Math.pow(2, n); i++) {
//			for(int j=0; j<(int) (int) (Math.pow(2, n-1)); j++) {
//				System.out.print(pattern[i][j]);
//			}
//			System.out.println();
//		}

		//Traversals
//---------------------------------------------------------------------------------------------------------------------//
//		System.out.println("PreOrderTraversal Of The Tree");
//		Node tree = BinaryTree.generateBinaryTree(n);
//		BinaryTree.preOrder(tree);
//		System.out.println();
//		System.out.println();
//		
//		System.out.println("InOrderTraversal Of The Tree");
//		BinaryTree.inOrder(tree);
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		
//		System.out.println("PostOrderTraversal Of The Tree");
//		BinaryTree.postOrder(tree);
//		System.out.println();
//		System.out.println();
//		System.out.println("LevelOrderTraversal Of The Tree");
//		List<List<Node>> list = BinaryTree.levelOrder(tree);
//		System.out.println();
	}
}
