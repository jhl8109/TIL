package interview;

public class ArrayQueue<E> { // 배열의 경우 circular queue로 구현해야함.
    int front;
    int rear;
    int size;
    Object[] queue;
    ArrayQueue(int capacity) {
        // this.queue = new Object[DEFAULT_CAPACITY];
        this.queue = new Object[capacity];
        this.front = 0;
        this.size = 0;
        this.rear = 0;
    }
    public boolean isEmpty(){
        return front == rear && queue[front] == null; // 원형 큐
    }
    public boolean isFull() {
        return front == rear && queue[front] != null;
    }
    
    public void enqueue(Object data) {
        if(isFull()) {
            System.out.println("큐에 더 이상 데이터를 저장할 공간이 없습니다.");
            return;
        }
        queue[rear++] = data;
        rear = rear % queue.length;
    }
    public Object dequeue() {
        if(isEmpty()) {
            System.out.println("큐가 비어있습니다");
            throw new ArrayIndexOutOfBoundsException();
        }
        Object dequeueData = queue[front];
        queue[front++] = null;
        front = front % queue.length;

        return dequeueData;
    }
}
