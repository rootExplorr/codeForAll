package org.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.learn.Node;

public class ExpressionEvaluation {
	public static Object infixToBinaryTree(String expr){
		List list = new ArrayList();
		Stack stack = new Stack();
		//stack.push(expr.charAt(0));
		//Node root = null;
		for(int i=0; i<expr.length(); i++) {
			if(expr.charAt(i)=='(')
				stack.push("(");
			
			else if(expr.charAt(i)=='+')
				stack.push("+");
				
			else if(expr.charAt(i)=='-')
				stack.push("-");
			
			else if(expr.charAt(i)=='*')
				stack.push("*");
			
			else if(expr.charAt(i)=='/')
				stack.push("/");
				
			else if((expr.charAt(i)+"").matches("\\d+")) {
				stack.push((expr.charAt(i)+""));
			}
			
			else if(expr.charAt(i)==')') {
				
				Object right = stack.pop();
				String root = (String) stack.pop();
				Object left = stack.pop();
				
				Node node = new Node(root);
				if(left.getClass()==Node.class)
					node.setLeft((Node) left);
				else {
					Node temp = new Node(left.toString());
					node.setLeft(temp);
				}
				
				if(right.getClass()==Node.class)
					node.setRight((Node) right);
				else {
					Node temp = new Node(right.toString());
					node.setRight(temp);
				}
				if(!stack.isEmpty() && stack.peek()=="(")
					stack.pop();
				stack.push(node);
			}
		}
		return stack.peek();
	}
	
	public static void main(String[] args) {
		String expr = "((3+1)*3)/((9-5)+2))-((3*(7-4))+6))";
		Node start = (Node) infixToBinaryTree(expr);		
	}
}