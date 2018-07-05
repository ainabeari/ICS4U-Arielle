/*
 * Arielle
 * Thurs. Apr. 26, 2018.
 * Implementing Node interface. (for use in linked lists)
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author 1ainabeari
 */
public class Node implements NodeInterface{
    //Pointer to next node in list
    private Node next = null;
    private String obj = null;

    public Node(String obj) {
        this.obj = obj;
    }

    @Override
    public Node getNext() {
        return this.next;       
    }

    @Override
    public void setNext(Node newNode) {
        this.next = newNode;        
    }

    @Override
    public String getValue() {
        return this.obj;       
    }
    
}
