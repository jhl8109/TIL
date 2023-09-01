package interview;

public class ArrayStack<T> {
    int top;
    int maxSize;
    int[] stack;
    ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }
    public void push(int item) {
        if(top+1 == maxSize) {
            System.out.println("스택이 가득 찼습니다.");

            int[] newStack = new int[maxSize*2];
            for(int i=0; i<maxSize; i++) {
                newStack[i] = stack[i];
            }
            maxSize *= 2;
            stack = newStack;
        } else {
            stack[++top] = item;
        }
    }
    public int pop() {
        if(top == -1) {
            System.out.println("스택이 비어있습니다.");
            return -1;
            
        } else {
            int pop = stack[top];
            stack[top--] = 0;
            return pop;
        }
    }
    public int peek() {
        if(top == -1) {
            System.out.println("스택이 비어있습니다.");
            return -1;
        } else {
            int peek = stack[top];
            return peek;
        }
    }
    public boolean isEmpty() {
        if(top == -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull() {
        if(top+1 == maxSize) {
            return true;
        } else {
            return false;
        }
    }
    public int size() {
        return top+1;
    }
}
