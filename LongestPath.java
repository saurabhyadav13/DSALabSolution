package com.xyz;

import java.util.ArrayList;


class Node {
	int nodeData;
	Node leftNode, rightNode;

	Node(int value) {
		nodeData = value;
		leftNode = rightNode = null;
	}
}



public class LongestPath {

	public static ArrayList<Integer> findLongestPath(Node root) {

		
		if (root == null) {
			ArrayList<Integer> path = new ArrayList<>();
			return path;
		}
		
		ArrayList<Integer> rightNode = findLongestPath(root.rightNode);

		
		ArrayList<Integer> leftNode = findLongestPath(root.leftNode);

		

		if (rightNode.size() < leftNode.size()) {
			leftNode.add(root.nodeData);
		} else {
			rightNode.add(root.nodeData);
		}

		
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
	}

	
	public static void main(String[] args) {

		LongestPath tree = new LongestPath();
		Node root = new Node(100);

		root.leftNode = newNode(20);
	root.rightNode = newNode(130);
	root.leftNode.leftNode = newNode(10);
	root.leftNode.rightNode = newNode(50);
	root.leftNode.leftNode.leftNode = newNode(5);
	root.rightNode.leftNode = newNode(110);
	root.rightNode.rightNode = newNode(140);

		
		ArrayList<Integer> longestPath = findLongestPath(root);
		int n = longestPath.size();

		System.out.println("Longest path is ");

		System.out.print(longestPath.get(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			System.out.print(" -> " + longestPath.get(i));
		}
	}
}
