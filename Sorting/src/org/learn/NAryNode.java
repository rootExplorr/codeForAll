package org.learn;

import java.util.ArrayList;
import java.util.List;

public class NAryNode {
	String value;
	List<Node> nodeList = new ArrayList<Node>();
	//ArrayList is resizable
	Node[] nodeList1 = new Node[10]; //ArrayIndexOutOfBoundException
	//Array is not
}

//time complexity and space complexity
//