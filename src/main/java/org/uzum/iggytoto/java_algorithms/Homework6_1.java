package org.uzum.iggytoto.java_algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * Example 1:
 * 1
 * /   |   \
 * 3   2   4
 * /  |
 * 5   6
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * <p>
 * Example 2:
 * 1
 * /   /   |   \
 * 2   3   4   5
 * /|   |   |\
 * 6 7   8   9 10
 * |   |   |
 * 11  12  13
 * |
 * 14
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * The total number of nodes is in the range [0, 104].
 * The depth of the n-ary tree is less than or equal to 1000.
 */
public class Homework6_1 {

    // Definition for a Node.
    public static class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        int maxDepth = 0;
        int currentDepth;

        if(root == null) throw new IllegalArgumentException();
        maxDepth++;
        currentDepth = maxDepth;

        maxDepth = depthNode(root, currentDepth,  maxDepth);
        return maxDepth;
    }

    private int depthNode(Node currentNode, int depth, int maxDepth) {

        if (currentNode.children != null) {
            for (var i = 0; i < currentNode.children.size(); i++) {
                Node nextNode = currentNode.children.get(i);
                if (nextNode != null) {
                    depth++;
                    maxDepth = depthNode(nextNode, depth, maxDepth);
                }
                depth--;
            }
        } else if (maxDepth < depth)  maxDepth = depth;

        return maxDepth;
    }
}
