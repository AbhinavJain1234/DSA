package stacks_and_queues;

public class CircularQueueCustom {
    int front = 0;
    int end = 0;
    private int data[];
    private static final int DEFAULT_SIZE = 10;
    int size = 0;

    public CircularQueueCustom() {
        this(DEFAULT_SIZE);
    }

    public CircularQueueCustom(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        data[end] = element;
        end++;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int remove = data[front];
        front = (front + 1) % data.length;
        size--;
        return remove;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("END");

    }

    public static void main(String[] args) {
        CircularQueueCustom queue = new CircularQueueCustom(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.display();
        queue.remove();
        queue.display();
        queue.insert(6);
        queue.display();
        queue.remove();
        queue.display();
        queue.insert(7);
        queue.display();
        queue.remove();
        queue.display();
        queue.remove();
        queue.display();
        queue.remove();
        queue.display();
        queue.remove();
        queue.display();
        queue.remove();
        queue.display();
    }
}
