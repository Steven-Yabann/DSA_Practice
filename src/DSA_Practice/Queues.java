package DSA_Practice;

public class Queues {
    private static class Node{
        private int data;
        private Node next;

        private Node(int data){
            this.data = data;
        }
    }
    // Initialize the head and tail
    private Node head;
    private Node tail;

    // Method 1: To check if structure is empty
    public boolean isEmpty(){
        return head == null;
    }

    // Method 2: To add an element at the back
    public void add(int data){
        Node node = new Node(data); // Create a new node

        if (tail != null){          //Check if tail exists
            tail.next = node;       //Assign new node to tail
        }

        tail = node;                //Reassign the tail

        if(head == null){   //Check if head is empty
            head = node;    //Assign new node to head
        }
    }

    // Method 3: To leave the queue
    public int remove(){
        int data = head.data;   //In regard to the FIFO structure, the first data
                                //is to be removed
        head = head.next;
        if (head == null){
            tail = null;
        }
        return data;
    }
}
