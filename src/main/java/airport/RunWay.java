package airport;

//Generic class implementation for linked list
public class RunWay<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    //Method for printing the Linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
    }

    //Method for adding elements first in the linked list
    public void addFirst(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
    }

    //Method for adding elements last in the linked list
    public void addLast(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newNode1 = new Node(data);
            tail.next = newNode1;
            tail = newNode1;

        }


    }
}