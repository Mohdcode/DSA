import java.util.NoSuchElementException;

public class CyclicLinkedList {
    Node head;
    int size;

    // Node class
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // make it circular
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // make it circular
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // make it circular
        }
        size++;
    }

    // Add a node at a specific position in the list
    public void add(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        if (position == 0) {
            addFirst(data);
        } else if (position == size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Remove the first node from the list
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty!");
        }
        if (size == 1) {
            head = null;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            Node current = head;
            while (current.next != temp) {
                current = current.next;
            }
            current.next = head; // make it circular
        }
        size--;
    }

    // Remove the last node from the list
    public void removeLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty!");
        }
        if (size == 1) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head; // make it circular
        }
        size--;
    }

    // Remove a node from a specific position in the list
    public void remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        if (position == 0) {
            removeFirst();
        } else if (position == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = temp.next;
            temp.next = null;
            size--;
        }
    }

    // Get the size of the list
    public int size() {
        return size;
    }}

// Check if the list is empty
