package stacks_and_queues;

public class customstack {
    int data[];
    private int top = -1;
    private static final int DEFAULT_SIZE = 10;

    public customstack() {
        this(DEFAULT_SIZE);
    }

    public customstack(int size) {
        this.data = new int[size];
    }

    public boolean push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        top++;
        data[top] = element;
        return true;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return data[top];
    }
}
