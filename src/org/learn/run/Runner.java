package org.learn.run;

import java.util.List;

import org.learn.BinaryTree;
import org.learn.ExpressionEvaluation;
import org.learn.Node;
import org.learn.pattern.BinaryTreePattern;

public class Runner {
	public static void main(String[] args) {
		String expr = "((3+1)*3)/((9-5)+2))-((3*(7-4))+6))";
		Node root = (Node) ExpressionEvaluation.infixToBinaryTree(expr);
		List<List<Node>> list = BinaryTree.levelOrder(root);
		
		int n=5;
		String pattern[][] = new String[(int)Math.pow(2, n-1)][(int) Math.pow(2, n)];
		
		for(int i=0; i<(Math.pow(2, n-1)); i++) {
			for(int j=0; j<(int) (int) Math.pow(2, n); j++) {
				pattern[i][j] = " ";
			}
		}
		BinaryTreePattern.printBinaryTree_1(list, pattern, n);
		
		for(int i=0; i<Math.pow(2, n-1); i++) {
			for(int j=0; j<(int) (int) (Math.pow(2, n)); j++) {
				System.out.print(pattern[i][j]);
			}
			System.out.println();
		}
	}
}
