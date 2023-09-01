package interview;

class Node<T>{
    Node<T> prev;
    Node<T> next;
    T value;

    Node(T value) {
        this.prev = null;
        this.next = null;
        this.value = value;
    }

}

public class DoublyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    int size = 0;

    public Node<T> findNode(int searchIndex) {
        if(searchIndex < 0 || searchIndex >= size) 
            throw new ArrayIndexOutOfBoundsException();
        
        int idx=0;
        Node<T> curNode = this.head;
        
        while(searchIndex != idx) {
            curNode = curNode.next;
            idx++;
        }
        return curNode;
    }

    public void add(int addIndex, T data) {
        Node<T> newNode = new Node(data);
        
        if(this.size ==0) {
            this.head = newNode;
            this.tail = newNode;
        } else if(addIndex == 0) {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        } else if(addIndex == size-1) {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        } else {
            Node<T> rightNode = findNode(addIndex);
            Node<T> leftNode = rightNode.prev;
            rightNode.prev = newNode;
            leftNode.next = newNode;
            newNode.next = rightNode;
            newNode.prev = leftNode;
        }     
        size++;    
    }
    public void remove(int removeIndex) {
        Node<T> targetNode = findNode(removeIndex);
        Node<T> leftNode = targetNode.prev;
        Node<T> rightNode = targetNode.next;
        if (removeIndex < 0 || removeIndex >= size) 
            throw new ArrayIndexOutOfBoundsException();
        else if (size == 1) { 
            this.head = null;
            this.tail = null;
        } else if (removeIndex == 0) {
            Node<T> newHeadNode = this.head.next;
            this.head = newHeadNode;
            newHeadNode.prev = null;
        } else if(removeIndex == size-1) {
            Node<T> newTailNode = this.tail.prev;
            this.tail = newTailNode;
            newTailNode.next = null;
        } else { 
            leftNode.next = rightNode;
            rightNode.prev = leftNode;
        }
        targetNode.next = null;
        targetNode.prev = null;
        size--;
    } 
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }
    public void display() {
        Node<T> curNode = this.head;
        while(curNode != null) {
            System.out.print(curNode.value + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }
    
}
