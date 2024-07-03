package DSA_Practice;

public class Stacks {
    private static class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
        }
    }
    Node top;
    public boolean isEmpty(){
        return top == null;
    }
    public int peek(){
        return top.data;
    }
    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public static void main(String[] args) {
        Stacks stack = new Stacks();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.peek()); // Should print 30
        System.out.println(stack.pop()); // Should print 30
        System.out.println(stack.pop()); // Should print 20
        System.out.println(stack.pop()); // Should print 10

        System.out.println(stack.isEmpty());
    }
}
