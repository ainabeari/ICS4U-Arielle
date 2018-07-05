/*
 * Arielle
 * Wed. May. 02, 2018.
 * Class implementing StackInterface. 
 */
package ca.arielle.ics4u.assignments;

import static ca.arielle.ics4u.utility.Method.displayArray;



/**
 *
 * @author 1ainabeari
 */
public class Stack implements StackInterface {

    public static final int DEFAULT_CAPACITY = 5;
    private int[] array;
    private int pointer;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        if (capacity < 0) {
            System.err.println("Sorry, no negative sizes for arrays. Setting size to default.");
        } else {
            this.array = new int[capacity];
            this.pointer = -1;
        }
    }

    @Override
    public String toString() {
        displayArray(array);
        System.out.println("Pointer = " + pointer);
        return "Stack{" + "array=" + array + ", pointer=" + pointer + '}';
    }

    @Override
    public int top() {
        if (!isEmpty()) {
            return this.array[pointer];
        }
        return -1;

    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            int x = this.array[this.pointer];
            this.array[this.pointer] = 0;
            this.pointer--;
            return x;
        }
        System.err.println("Stack.pop() : Stack is Empty ");
        return -1;

    }

    @Override
    public void push(int value) {
        if (!isFull()) {
            this.pointer++;
            this.array[this.pointer] = value;

        } else {
            System.err.println("Stack.push() : Stack is Full ");
        }
    }

    @Override
    public int size() {
        return this.pointer + 1;
    }

    @Override
    public int capacity() {
        return this.array.length;
    }

    @Override
    public boolean isEmpty() {
        if (this.pointer == -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (pointer == array.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void makeEmpty() {
        if (isEmpty()) {
        } else {
            this.array = new int[this.array.length];
            this.pointer = -1;
        }
    }

    public static void main(String[] args) {
        int capacity = 10;
        //do I have to test default?
        Stack test = new Stack(capacity);

        //Test Code 
        //Test #1 -  If Stack is empty
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.pointer == -1);
        assert (!test.isFull());
        System.out.println("Yay! Test #1 is a success!\n");
        //How is this possible?: test.pointer = 1;

        //Test #2 - If Stack is not empty
        //is not int
        for (int i = 1; i < test.capacity(); i++) {
            test.push(i);
            assert (test.pointer == i - 1);
            assert (test.top() == test.array[i - 1]);
            System.out.println("Yay! " + i + " was successfully pushed.");
            assert (test.size() == i);
            assert (test.capacity() == capacity);
            assert (!test.isEmpty());
            assert (!test.isFull());

        }
        System.out.println("Yay! Test #2 is a success!\n");

        //Test #3 - If Stack is Full
        test.push(capacity);
        assert (test.pointer == capacity - 1);
        System.out.println("Yay! " + capacity + " was successfully pushed.");
        assert (test.size() == capacity);
        assert (test.capacity() == capacity);
        assert (!test.isEmpty());
        assert (test.isFull());
        assert (test.top() == test.array[capacity - 1]);
        
        //push when full
        test.push(capacity);
        assert (test.pointer == capacity - 1);
        System.out.println("Yay! " + capacity + " was successfully pushed.");
        assert (test.size() == capacity);
        assert (test.capacity() == capacity);
        assert (!test.isEmpty());
        assert (test.isFull());
        assert (test.top() == test.array[capacity - 1]);
        System.out.println("Yay! Test #3 is a success!\n");

        //Test #4 - Testing Pop method
        for (int i = capacity; i > 1; i--) {
            test.pop();
            assert (test.pointer == i - 2);
            assert (test.top() == test.array[i - 2]);
            System.out.println("Yay! " + i + " was successfully popped.");
            assert (test.size() == i - 1);
            assert (test.capacity() == capacity);
            assert (!test.isEmpty());
            assert (!test.isFull());
        }
        test.pop();
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.pointer == -1);
        assert (!test.isFull());

        System.out.println("Yay! Test #4 is a success!\n");

        //Test #5 - Make empty
        for (int i = 1; i < test.capacity(); i++) {
            test.push(i);
        }
        test.makeEmpty();
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.pointer == -1);
        assert (!test.isFull());

        System.out.println("Yay! Test #5 is a success!\n");

        //Test #6 - Pop empty
        assert (test.pop() == -1);
        assert (test.size() == 0);
        assert (test.capacity() == capacity);
        assert (test.isEmpty());
        assert (test.pointer == -1);
        assert (!test.isFull());

        System.out.println("Yay! Test #6 is a success!\n");

        //Do I have to make this good?
        test.toString();
    }
}
