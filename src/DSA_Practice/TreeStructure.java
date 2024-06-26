package DSA_Practice;

import java.util.ArrayList;
import java.util.Comparator;

public class TreeStructure {
    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }


        //Adding a node to the tree
        public void add(int value) {
            if (value <= data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.add(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.add(value);
                }
            }
        }

        //Finding an element in a tree structure (Search)
        public boolean search(int value){
            if (value == data){
                return true;
            } else if (value < data){
                if (left == null) {
                    return false;
                } else{
                    return left.search(value);
                }
            } else{
                if (right == null){
                    return false;
                } else{
                    return right.search(value);
                }
            }
        }

        //In-order traversal
        public void inOrder(){
            if (left != null){
                left.inOrder();
            }
            System.out.println(data);
            if(right != null){
                right.inOrder();
            }
        }

        //Post-order traversal
        public void postOrder(){
            if(right != null){
                right.postOrder();
            }
            if (left != null){
                left.postOrder();
            }
            System.out.println(data);
        }

        //pre-order traversal
        public void preOrder(){
            System.out.println(data);
            if (left != null){
                left.preOrder();
            }
            if(right != null){
                right.preOrder();
            }
        }

        public int findMin(){
            if(left == null){
                return data;
            }else{
                return left.findMin();
            }
        }

        public int findMax(){
            if(right == null){
                return data;
            }else{
                return right.findMax();
            }
        }

        public int height(){
            int leftHeight = (left != null) ? left.height() : 0;
            int rightHeight = (right != null) ? right.height() : 0;
            return 1+ Math.max(leftHeight, rightHeight);
        }

        public int depth(){
            int leftHeight = (left != null) ? left.height() : 0;
            int rightHeight = (right != null) ? right.height() : 0;
            return Math.max(leftHeight, rightHeight);
        }

        public int countNodes(){
            int leftCount = (left != null) ? left.countNodes() : 0;
            int rightCount = (right != null) ? right.countNodes() : 0;
            return 1 + rightCount + leftCount;
        }

//        public double findMedian(){
//            ArrayList<Integer> elements = new ArrayList<>();
//            if(size % 2 == 1){
//                return elements.get(size/2);
//            } else {
//                return (elements.get(size / 2 - 1) + elements.get(size / 2)) /2.0;
//            }
//        }

        public static void main(String [] args) {
            Node our_tree = new Node(10);

            our_tree.add(8);
            our_tree.add(4);
            our_tree.add(2);
            our_tree.add(6);
            our_tree.add(10);
            our_tree.add(9);
            our_tree.add(12);

            System.out.println("Pre Order");
            our_tree.preOrder();

            System.out.println("In Order");
            our_tree.inOrder();

            System.out.println("Post Order");
            our_tree.postOrder();

            System.out.println("Minimum Value: " + our_tree.findMin());
            System.out.println("Maximum Value: " + our_tree.findMax());
            System.out.println("Tree Height: " + our_tree.height());
            System.out.println("Tree Depth: " + our_tree.depth());
            System.out.println("Total Nodes: " + our_tree.countNodes());
//            System.out.println("Median Value: " + our_tree.findMedian());
        }
    }
}