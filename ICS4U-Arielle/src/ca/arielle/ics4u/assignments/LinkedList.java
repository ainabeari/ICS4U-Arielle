/*
 * Arielle
 * Wed. Apr. 25, 2018.
 * Implementing a Linked List. 
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author 1ainabeari
 */
public class LinkedList implements LinkListInterface {

    //Object Variables
    private Node tail = null;
    private Node head = null;

    @Override
    public int size() {
        int size = 0;
        //Special Case: Is Empty
        if (isEmpty()) {
            return 0;
        } //Special Case: Only one Node
        else if (head == tail) {
            return 1;
        }
        //regular
        for (Node n = head; n != null; n = n.getNext()) {
            size++;
        }
        return size;
    }

    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null && this.tail == null) {
            return true;
        }
        return false;
    }

    @Override
    public void addAtFront(String str) {
        if (isEmpty()) {
            this.tail = new Node(str);//duplicate code??
            this.head = new Node(str);

        } else {
            Node n = new Node(str);
            n.setNext(head);
            this.head = n;
        }

    }

    @Override
    public void addAtEnd(String str) {
        if (isEmpty()) {
            this.tail = new Node(str);//duplicate code??
            this.head = new Node(str);
        } else {
            Node n = new Node(str);
            //this.tail.setNext(n);
            Node r = this.head;
            if (size() == 1) {

            } else {
                do {
                    r = r.getNext();
                } while (r.getNext() != null);
            }
            r.setNext(n);
            this.tail = n;
        }
    }

    @Override
    public void remove(String str) {
        boolean removed = false;
        //Special cases
        if (!isEmpty()) {
            if (size() == 1) {
                if (head().equals(str)) {
                    makeEmpty();
                }
            } else {

                if (head().equals(str)) {
                    removeHead();
                }
                else if (size() != 2) {
                    Node n = this.head;
                    do {
                        
                        if (n.getNext().getValue().equals(str)) {
                            //Somewhere nice like the middle? (regular)
                            Node toDelete = n.getNext();
                            n.setNext(toDelete.getNext());
                            toDelete.setNext(null);
                            removed = true;
                        }
                        n = n.getNext();

                    } while (n.getNext() != null); //removeed != null
                    //If tail is the first instance of the str
                    if (!removed) {
                        if (tail().equals(str)) {
                            removeTail();
                        }
                    }
                }//What if it's at the tail (special case)
                else if (tail().equals(str)) {
                    removeTail();
                }

            }
        }
    }

    @Override
    public String removeHead() {
        if (isEmpty()) return null;
        String ans;
        if (size() == 1){
            ans = head();
            makeEmpty();
            return ans;
            
        }
        else{
        Node n = this.head;
        this.head = n.getNext();
        ans = n.getValue();
        n.setNext(null);
        return ans;
        }
    }

    @Override
    public String removeTail() {
        if( isEmpty() ) return null;

        
        Node n = this.head;
        String ans = tail();
        
        if (size() == 1) {
            makeEmpty();
           
        } else {
            do {
                if (n.getNext().getValue().equals(ans)) {
                    n.setNext(null);
                    this.tail = n;   
                }
                else{
                n = n.getNext();
                }
            } while (n.getNext() != null);
        }
        return ans;
    }

    @Override
    public String head() {
        if ( this.head == null) return null;
        return this.head.getValue();
    }

    @Override
    public String tail() {
        if( this.tail == null ) return null;
        return this.tail.getValue();
    }

    @Override
    
    public String toString() {
        //Output formatted version of array showing where front and rear is 
        Node n = head;
        if (size() > 1) {
            System.out.format("%2s | %2s\n", head.getValue(), "H");

            do {
                System.out.format("%2s | %2s\n", n.getNext().getValue(), " ");
                n = n.getNext();
            } while (n.getNext() != null);

        } else if (size() == 1) {
            System.out.format("%2s | %2s\n", tail.getValue(), "HT");
        }

        return "LinkedList{" + "tail=" + tail + ", head=" + head + '}';
    }

    public static void main(String[] args) {
        //Test Case
        LinkedList test = new LinkedList();

        //Test #1 - Empty List
        assert (test.size() == 0);
        assert (test.isEmpty());
        assert (test.head() == null );
        assert (test.tail() == null);
        assert (test.removeTail() == null);
        assert (test.removeHead() == null);
        System.out.println("Yay! Test #1 is a success!\n");
        
        //Test #2 - 1 item
        String a = "A";
        test.addAtFront(a);
        assert (test.size() == 1);
        assert (!test.isEmpty());
        assert (test.head().equals(a));
        assert (test.tail().equals(a));
        System.out.println("Yay! Test #2 is a success!\n");
        
        //Test #3 - remove tail
        assert (test.removeTail().equals(a));
        assert (test.size() == 0);
        assert (test.isEmpty());
        System.out.println("Yay! Test #3 is a success!\n");
        
        //Test #4 - remove head
        test.addAtFront(a);
        assert (test.removeHead().equals(a));
        assert (test.size() == 0);
        assert (test.isEmpty());
        System.out.println("Yay! Test #4 is a success!\n");
        
        //Test #5 - Add at end (2 items)
        String b = "B";
        test.addAtEnd(b);
        test.addAtFront(a);
        assert (test.size() == 2);
        assert (!test.isEmpty());
        assert (test.head().equals(a));
        assert (test.tail().equals(b));
        System.out.println("Yay! Test #5 is a success!\n");
        
        //Test #6 - remove tail
        assert (test.removeTail().equals(b));
        assert (test.size() == 1);
        assert (!test.isEmpty());
        assert (test.head().equals(a));
        assert (test.tail().equals(a));
        System.out.println("Yay! Test #6 is a success!\n");
        
        //Test #7 - remove head
        assert (test.removeHead().equals(a));
        assert (test.size() == 0);
        assert (test.isEmpty());
        System.out.println("Yay! Test #7 is a success!\n");
        
        //Test #8 - remove (if string is in the middle)
        test.addAtFront(a);
        test.addAtFront(b);
        test.addAtFront(a);
        test.remove(b);
        assert (test.size() == 2);
        assert (!test.isEmpty());
        assert (test.head().equals(a));
        assert (test.tail().equals(a));
        System.out.println("Yay! Test #8 is a success!\n");
        
        //Test #9 - remove when nothing is there
        test.makeEmpty();
        test.addAtFront(a);
        test.addAtFront(a);
        test.addAtFront(a);
        test.remove(b);
        assert (test.size() == 3);
        assert (!test.isEmpty());
        assert (test.head().equals(a));
        assert (test.tail().equals(a));
        System.out.println("Yay! Test #9 is a success!\n");
        
        //Test #10 - remove 2 items (remove tail)
        test.makeEmpty();
        test.addAtFront(a);
        test.addAtFront(b);
        test.remove(b);
        assert (test.size() == 1);
        assert (!test.isEmpty());
        assert (test.head().equals(a));
        assert (test.tail().equals(a));
        System.out.println("Yay! Test #10 is a success!\n");
        
        //Test #11 - remove, 2 items (remove what is not there)
        test.makeEmpty();
        test.addAtFront(a);
        test.addAtFront(b);
        test.remove("C");
        assert (test.size() == 2);
        assert (!test.isEmpty());
        assert (test.head().equals(b));
        assert (test.tail().equals(a));
        System.out.println("Yay! Test #12 is a success!\n");
        
        //Test #13 - .remove head from two items 
        test.makeEmpty();
        test.addAtFront(a);
        test.addAtFront(b);
        test.remove(b);
        assert (test.size() == 1);
        assert (!test.isEmpty());
        assert (test.head().equals(a));
        assert (test.tail().equals(a));
        System.out.println("Yay! Test #13 is a success!\n");
        
        //Test #14 - .remove tail from two items
        test.makeEmpty();
        test.addAtFront(a);
        test.addAtFront(b);
        test.remove(a);
        assert (test.size() == 1);
        assert (!test.isEmpty());
        assert (test.head().equals(b));
        assert (test.tail().equals(b));
        System.out.println("Yay! Test #14 is a success!\n");
        
    }

}
