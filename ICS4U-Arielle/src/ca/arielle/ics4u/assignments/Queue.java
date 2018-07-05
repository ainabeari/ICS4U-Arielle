/*
 * ARIELLE
 * Wed. May. 02, 2018
 * Implementing Queue interface (it's like stack but circular).
 */
package ca.arielle.ics4u.assignments;



/**
 *
 * @author 1ainabeari
 */
public class Queue implements QueueInterface {

    //Default
    public static final int DEFAULT_CAPACITY = 5;
    private Integer[] array;
    private int rear = -1;
    private int front = -1;

    //Default constructor
    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    //Constructor for size
    public Queue(int capacity) {
        //negative array size exception
        if (capacity < 0) {
            System.err.println("Sorry, no negative sizes for arrays. Setting size to default.");
        } else {
            //Implement size
            this.array = new Integer[capacity];
        }
    }

    @Override
    public String toString() {
        //Output formatted version of array showing where front and rear is 
        for (int i = 0; i < this.array.length; i++) {
            if (rear == i && front == i && front == rear) {
                System.out.format("%2s | %2s\n", this.array[i], "RF");
            } else if (rear == i) {
                System.out.format("%2s | %2s\n", this.array[i], "R");
            } else if (front == i) {
                System.out.format("%2s | %2s\n", this.array[i], "F");
            } else {
                System.out.format("%2s | %2s\n", this.array[i], "");
            }

        }
        //idk what to do with this
        return "Queue{" + "array=" + array + ", rear=" + rear + ", front=" + front + '}';

    }

    @Override
    public Integer dequeue() {
        int ans = this.front;
        //Special Cases: if empty
        if (isEmpty()) {
            System.err.println("Cannot dequeue, queue empty.");
            return null;
        } else {
            
            Integer v = this.array[front];
            
            //if size == 1
            if (size() == 1) {
                makeEmpty();
                return v;
            }
            //if front is at the end of the array
            this.front = (this.front + 1)%capacity();
            return v;
        }
    }

    @Override
    public void enqueue(Integer value) {
        //Special cases: is full
        if (isFull()) {
            System.err.println("Queue is full. Enqueue failed");
        } else {
            //is empty
            if (isEmpty()) {
                this.front = 0;
            }
            //regular
            if (!((this.rear + 1) % capacity() == 0)) {
                this.rear++;
                //if rear needs to be made 0 (goes to other end of circle)
            } else {
                this.rear = 0;
            }
            this.array[this.rear] = value;
        }

    }

    @Override
    public Integer front() {
        if(isEmpty()){
            return null;
        }
        return this.array[this.front];
    }

    @Override
    public Integer back() {
        if(isEmpty()){
            return null;
        }
        return this.array[this.rear];
    }

    @Override
    public int size() {
        if (!isEmpty()) {
            if (rear < front) {
                return (capacity() - front) + (rear + 1);
            } else {
                return this.rear - this.front + 1;
            }
        }
        //Special case: if empty
        return 0;

    }

    @Override
    public int capacity() {
        return this.array.length;
    }

    @Override
    public boolean isEmpty() {
        if (this.rear == -1 && this.front == -1) {
            return true;
        }
        return false;

    }

    @Override
    public boolean isFull() {
        if (!isEmpty()) {
            //if linear
            if (this.front == 0 && this.rear == capacity() - 1) {
                return true;
            }
            //if it wraps around
            if (this.front - 1 == this.rear) {
                return true;
            }
        }
        //Special case: if empty
        return false;

    }

    @Override
    public void makeEmpty() {
        this.rear = -1;
        this.front = -1;
        
    }

    public static void main(String[] args) {
        //Test Code
        int capacity = 10;
        Queue test = new Queue(capacity);

        //Test #1 - Empty Queue
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.back() == null);
        assert (test.front() == null);
        assert (!test.isFull());
        System.out.println("Yay! Test #1 is a success!\n");

        //Test #2 - Not Empty Queue
        for (int i = 1; i < test.capacity(); i++) {
            test.enqueue(i);
            assert (test.front == 0);
            System.out.println("Yay! " + i + " was successfully pushed.");
            assert (test.size() == i);
            assert (test.capacity() == capacity);
            assert (!test.isEmpty());
            assert (!test.isFull());

        }
        System.out.println("Yay! Test #2 is a success!\n");

        //Test #3 - Full Queue
        test.enqueue(capacity);
        assert (test.front == 0);
        System.out.println("Yay! " + capacity + " was successfully pushed.");
        assert (test.size() == capacity);
        assert (test.capacity() == capacity);
        assert (!test.isEmpty());
        assert (test.isFull());
        System.out.println("Yay! Test #3 is a success!\n");

        //Test #4 - test dequeue method
        for (int i = 1; i < capacity; i++) {
            test.dequeue();
            assert (test.front == i);
            assert (test.front() == test.array[i]);//should I test back?
            System.out.println("Yay! " + i + " was successfully dequeued.");
            assert (test.size() == capacity - i);
            assert (test.capacity() == capacity);
            assert (!test.isEmpty());
            assert (!test.isFull());
        }
        //Test #4b - dequeue queue with one item
        test.dequeue();
        System.out.println("Yay! " + capacity + " was successfully dequeued.");
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.front == -1);
        assert (test.rear == -1);
        assert (!test.isFull());

        System.out.println("Yay! Test #4 is a success!\n");

        //Test #5 - Pop empty
        test.dequeue();
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.rear == -1);
        assert (test.front == -1);
        assert (!test.isFull());
        System.out.println("Yay! Test #5 is a success!\n");

        //Test #6 - If front is halfway
        //Filling it up (also testing enqueue when full (error method should appear)
        for (int i = 1; i <= capacity; i++) {
            test.enqueue(i);
        }

        //Dequeing halfway
        for (int i = 1; i < capacity / 2; i++) {
            test.dequeue();
        }

        //Filling it up
        for (int i = 1; i <= capacity / 2; i++) {
            test.enqueue(i);
        }

        //Full Queue testing
        System.out.println("Yay! " + capacity + " was successfully pushed.");
        assert (test.size() == capacity);
        assert (test.capacity() == capacity);
        assert (!test.isEmpty());
        assert (test.isFull());
        
       

        System.out.println("Yay! Test #6 is a success!\n");

        //Test #7 - Make Empty
        test.makeEmpty();
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.back() == null);
        assert (test.front() == null);
        assert (!test.isFull());

        System.out.println("Yay! Test #7 is a success!\n");
        
        //Test #8 - Seeing if it can input values not in sequential order (just for fun)
        test.enqueue(2);
        test.enqueue(4);

        test.toString();

    }
}
