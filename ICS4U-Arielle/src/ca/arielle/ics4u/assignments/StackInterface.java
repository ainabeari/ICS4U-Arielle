/*
 * Arielle
    Thurs. Apr. 12, 2018.
    Making my own stack.
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author 1ainabeari
 */
public interface StackInterface {

    public int top();

    public int pop();

    public void push(int value);

    public int size();

    public int capacity();

    public boolean isEmpty();

    public boolean isFull();

    public void makeEmpty();

}
