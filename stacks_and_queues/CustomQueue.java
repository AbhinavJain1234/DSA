package stacks_and_queues;

public class CustomQueue {
    int end = 0;
    private int data[];
    private static final int DEFAULT_SIZE = 10;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        data[end] = element;
        end++;
        return true;
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int temp = data[0];
        for (int i = 0; i < end - 1; i++) {
            data[i] = data[i + 1];
        }
        end--;
        return temp;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
