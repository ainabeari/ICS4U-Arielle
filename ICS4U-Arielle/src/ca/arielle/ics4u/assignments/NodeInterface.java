/*
 * Arielle
 * Monday. Apr. 23, 2018.
 * Node interface. 
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author 1ainabeari
 */
public interface NodeInterface {

    /**
     * The node pointed to by 'next' is returned
     */
    public Node getNext();

    /**
     * The node pointed to by 'next' is changed to newNode
     */
    public void setNext( Node newNode );

    /**
     * The value (data) of the node.
     */
    public String getValue();

}

