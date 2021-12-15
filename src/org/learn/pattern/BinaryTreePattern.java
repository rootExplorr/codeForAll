package org.learn.pattern;

import java.util.List;

import org.learn.BinaryTree;
import org.learn.Node;

public class BinaryTreePattern {

public static void printBinaryTree_1(List<List<Node>> list, String pattern[][], int n){
		
		//String pattern[][] = new String[(int) Math.pow(2, n-1)][(int) (Math.pow(2, n))];
		int row = 0, column=0;
		for(int i=1; i<n; i++) {
			int nodesToPrint =  list.get(i-1).size();//1
			int initialSpace = (int) (Math.pow(2, n-i)-1); //(2 power(3))-1 = 7
			
			//Space from beginning.
//			for(int k=0; k<initialSpace; k++) {//1-3
//				pattern[row][k] = "";
//			}
			
			column = initialSpace;
			for(int l=1; l<=nodesToPrint; l++) {//1-1
				pattern[row][column++] = list.get(i-1).get(l-1).getValue(); //[0][7]
				
				if(l==nodesToPrint)
					break;
				
				column+=(Math.pow(2, n-i+1)-1);//2 power(4-1-1)-1 = 
//				for(int m=(int) (Math.pow(2, n-i-1)-1); m>=1 ;m--) {
//					column++;
//				}
			}
			
			//if(i>1) {
			for(int p=1; p<=(int) (Math.pow(2, n-i-1)); p++) {//4
				row++;
				//pattern[row][column--] = "/";
				}
			//}
		}
		//return pattern;
	}

public static void printBinaryTree_2(List<List<Node>> list, String pattern[][], int n){
	
	int row = 0, column=0;
	for(int i=1; i<n; i++) {
		int nodesToPrint =  list.get(i-1).size();//1
		int initialSpace = (int) (Math.pow(2, n-i)-1);//
		
		row = initialSpace;
		for(int l=1; l<=nodesToPrint; l++) {//1-2
			pattern[row++][column] = list.get(i-1).get(nodesToPrint-l).getValue();//1//4-(l)
			
			if(l==nodesToPrint)
				break;
			
			row+=(Math.pow(2, n-i+1)-1);
		}
		
		for(int p=1; p<=(int) (Math.pow(2, n-i-1)); p++) {
			column++;
		}
	}
	//return pattern;
}

	public static void main(String[] args) {

		int n = 5;
		Node root = BinaryTree.generateBinaryTree(n);
		List<List<Node>> list = BinaryTree.levelOrder(root);
		
		String pattern[][] = new String[(int)Math.pow(2, n-1)][(int) Math.pow(2, n)];
//		for(int i=0; i<(Math.pow(2, n-1)); i++) {
//			for(int j=0; j<(int) (int) Math.pow(2, n); j++) {
//				pattern[i][j] = " ";
//			}
//		}
//		printBinaryTree_1(list, pattern, n);
//		
//		for(int i=0; i<Math.pow(2, n-1); i++) {
//			for(int j=0; j<(int) (int) (Math.pow(2, n)); j++) {
//				System.out.print(pattern[i][j]);
//			}
//			System.out.println();
//		}
		
		
		//Pattern 2
		pattern = new String[(int)Math.pow(2, n)][(int) Math.pow(2, n-1)];
		for(int i=0; i<(Math.pow(2, n)); i++) {
			for(int j=0; j<(int) (int) Math.pow(2, n-1); j++) {
				pattern[i][j] = " ";
			}
		}
		printBinaryTree_2(list, pattern, n);
		
		for(int i=0; i<Math.pow(2, n); i++) {
			for(int j=0; j<(int) (int) (Math.pow(2, n-1)); j++) {
				System.out.print(pattern[i][j]);
			}
			System.out.println();
		}
	}
}