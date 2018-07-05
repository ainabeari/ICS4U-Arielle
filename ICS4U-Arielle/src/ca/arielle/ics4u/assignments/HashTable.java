/*
 * Arielle 
 * Monday. June. 11, 2018.
 * Implementing HashTableInterface (closed). 
 */
package ca.arielle.ics4u.assignments;

import java.util.Scanner;

/**
 *
 * @author 1ainabeari
 */
public class HashTable implements HashTableInterface {

    //DEFAULT
    final static int DEFAULT_CAPACITY = 53;
    
    //object variables
    private Student[] array;
    private int collisions = 0;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        capacity = makePrime(capacity);
        this.array = new Student[capacity];
    }

    @Override
    public String toString() {
       
        for (int i = 0; i < this.array.length; i++) {
            if (hasStudent(i)) {
                System.out.println(key(this.array[i]));
            } else {
                System.out.println("empty space");
            }
        }
        return "HashTable{" + "array=" + array + '}';
    }

    private boolean hasStudent(int index) {
        return this.array[index] != null;
    }
    
    //Only uses this once for toString()
    public int key(Student student) {
        return hash(student.getId());
    }

    public void addCollision() {
        this.collisions++;
    }

    public int getCollisions() {
        return this.collisions;
    }
    
    
    

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < capacity(); i++) {
            if (hasStudent(i)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int capacity() {
        return this.array.length;
    }

    @Override
    public double loadFactor() {
        return (double) size()/capacity(); //(double) size()/capacity()
    }

    @Override
    public void makeEmpty() {
        this.array = new Student[capacity()];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void rehash() {
        Student[] newArray = this.array;
        this.array = new Student[makePrime((size()) * 4)];
        for (int i = 0; i < newArray.length; i++) {
            if(newArray[i]!= null){
                //Using ID because put hashes the ID into something useful
                put(key(newArray[i]), newArray[i]);
            }
            
        }
    }

    @Override
    public Student get(int key) {
        int index = hash(key);
        int goUp = index;
        if (isEmpty()) {
            return null;
        }
        for (int i = 0; i < capacity() - 1; i++) {
            //Fix with simplified algorithm
            if (goUp + 1 >= capacity()) {
                goUp = 0;
            } else {
                goUp++;
            }
            if (this.array[goUp] != null) {
                if (this.array[goUp].getId() == key) {
                    return this.array[goUp];
                }
            }

             
        }
        return null;
    }

    @Override
    public void put(int key, Student value) {
        //key is ID
        this.collisions = 0;
        int index = hash(key);
        int goUp = index;
        

        for (int i = 0; i < capacity() - 1; i++) {
            if (goUp >= capacity() - 1) {
                goUp = 0;
            } else {
                goUp++;
            }
            if (!hasStudent(goUp)) {
                this.array[goUp] = value;
                i = capacity();
            } else {
                addCollision();
            }
        }if (loadFactor() >= .75) {
            rehash();
        }

    }

    @Override
    public boolean contains(Student value) {
        if (get(value.getId()) == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsKey(int key) {
        if (get(key) == null) {
            return false;
        }
        return true;
    }

    @Override
    //This is the index on the array
    public int hash(int key) {
        return key % capacity();
    }
    
    private int makePrime(int num){
        for (int i = 2; i < num; i++){
            if(num%i == 0){
                num += 1;
            }
        }
        return num;
    }

    public static void main(String[] iDontKnowWhatToPutHere) {
        HashTable test = new HashTable();
        //Test Code
        //Test #1 - Empty
        assert (test.size() == 0);
        assert (test.capacity() == 53);
        assert (test.get(123) == null);
        assert (test.contains(new Student()) == false);
        assert (test.containsKey(123) == false);
        assert (test.loadFactor() == 0);
        assert (test.isEmpty());
        System.out.println("Yay! Test #1 was a success!");
        

        //Test #2 - Filling it up
        for (int i = 0; i < ((double) .75 * test.capacity()-1); i++) {
            Student s = new Student();
            test.put(s.getId(), s);
            assert (test.size() == i + 1);
            assert (test.capacity() == 53);
            assert (test.contains(s) == true);
            assert (test.containsKey(s.getId()) == true);
            assert (test.get(s.getId()).equals(s));
            assert (test.loadFactor() <= 0.75);
            assert (!test.isEmpty());
            System.out.println("Number of Collisions: " + test.getCollisions());

        }
        
        System.out.println("Yay! Test #2 was a success!");

        //Test #3 - Testing rehash
        Student s = new Student();
        test.put(s.getId(), s);
        assert (test.size() == 40);
        assert (test.capacity() > 40);
        assert (test.contains(s) == true);
        assert (test.containsKey(s.getId()) == true);
        assert (test.get(s.getId()).equals(s));
        assert (test.loadFactor() <= .75);
        assert (!test.isEmpty());
        System.out.println("Number of Collisions: " + test.getCollisions());
        System.out.println("Yay! Test #3 was a success!");
        
        //Test #4 - Test make empty
        test.makeEmpty();
        assert (test.size() == 0);
        assert (test.capacity() > 40);
        assert (test.get(123) == null);
        assert (test.contains(new Student()) == false);
        assert (test.containsKey(123) == false);
        assert (test.loadFactor() == 0);
        assert (test.isEmpty());
        System.out.println("Yay! Test #4 was a success!");
        
        
        

    }

}
