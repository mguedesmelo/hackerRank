package com.hackerRank.oneMonth.week.four;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TreeHuffmanDecoding {
    private static Map<Character,String> mapA = new HashMap<Character ,String>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        String test = scanner.next();
 
        // Assume that all characters has code less than 256
        int[] charFreqs = new int[256];
      
        // Record the frequencies
        for (char c : test.toCharArray()) {
            charFreqs[c]++;
        }
 
        // Build tree
        NodeHuffman tree = buildTree(charFreqs);
 
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();
      
        for(int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }
      
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

        scanner.close();
    }

    // Input is an array of frequencies, indexed by character code
    private static NodeHuffman buildTree(int[] charFrequencies) {
        PriorityQueue<NodeHuffman> trees = new PriorityQueue<NodeHuffman>();
        // Initially we have a forest of leaves one for each non-empty character
        for (int i = 0; i < charFrequencies.length; i++) {
            if (charFrequencies[i] > 0) {
                trees.offer(new HuffmanLeaf(charFrequencies[i], (char)i));
            }
        }

        assert trees.size() > 0;

        while (trees.size() > 1) {
            NodeHuffman a = trees.poll();
            NodeHuffman b = trees.poll();
 
            trees.offer(new HuffmanNode(a, b));
        }
      
        return trees.poll();
    }
  
    public static void printCodes(NodeHuffman tree, StringBuffer prefix) {
        assert tree != null;
      
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            mapA.put(leaf.data,prefix.toString());
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // Traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // Traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}

abstract class NodeHuffman implements Comparable<NodeHuffman> {
	protected int frequency;
	protected char data;
	protected NodeHuffman left, right;

	public NodeHuffman(int frequency) {
		this.frequency = frequency;
	}

	public int compareTo(NodeHuffman tree) {
		return this.frequency - tree.frequency;
	}
}

class HuffmanLeaf extends NodeHuffman {
	public HuffmanLeaf(int frequency, char data) {
		super(frequency);
		this.data = data;
	}
}

class HuffmanNode extends NodeHuffman {
	public HuffmanNode(NodeHuffman left, NodeHuffman right) {
		super(left.frequency + right.frequency);
		this.left = left;
		this.right = right;
	}
}

class Decoding {
	void decode(String s, NodeHuffman root) {
		StringBuilder sb = new StringBuilder();
		NodeHuffman c = root;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i) == '1' ? c.right : c.left;
			if (c.left == null && c.right == null) {
				sb.append(c.data);
				c = root;
			}
		}
		System.out.print(sb);
	}
}
