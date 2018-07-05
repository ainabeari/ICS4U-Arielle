/*
 * ARIELLE 
 * Wed. Apr. 11, 2018
 * Que interface (it's like stack but circular).
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author 1ainabeari
 */
public interface QueueInterface {
    //WhAt if end is less than front? LEAPFROG, but don't change value
    public Integer front(); //one line
    
    public Integer back();
    
    public void enqueue( Integer value );

    public Integer dequeue(); //3 lines (check if its empty is first line,then something, then check if it equals f (special case if size == 1, then call makeEmpty) )

    public int size();
    
    public int capacity();

    public boolean isEmpty();
    
    public boolean isFull(); //is size == capacity

    public void makeEmpty(); //front minus one or back minus one

}