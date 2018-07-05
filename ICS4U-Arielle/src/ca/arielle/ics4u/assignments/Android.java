/*
 * Arielle
 * Tues. May. 29, 2018.
 * Child class of Dudley.java. Lock similar to that of an Android. 
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author A & J
 */
public class Android extends Configure {
    
    private final String MANUFACTURER = "Android";

    public Android() {
        super(3);
    }
   
    @Override
    public void lock() {
        
        if (configure){
            super.lock();
        }
        else{
            System.out.println("PLEASE CONFIGURE YOUR CODE BEFORE LOCKING.");
        }
    }
   

    public static void main(String args[]) {
       //Test Code
       Android test = new Android ();
       int[] combo = {1,2,3};
       
       //Making sure digits are within range
        for (int i = 0; i < combo.length; i ++){
            assert(combo[i] >= 0 && combo[i] < 10);
        }
       
       //Unlocking with configured combo
       assert(!test.locked());
       test.configureCombo(combo);
       test.lock();
       assert(test.locked());
       test.unlock(combo);
       assert(!test.locked());
        
       //Testing incorrect range of numbers for combo and being locked our
        int[] fakeCombo = {-1, 50, -6};
        
        test.configureCombo(fakeCombo);
        test.lock();
        test.unlock(fakeCombo);
        assert(test.locked());
        assert(test.getCombination() == combo);
        
       
        
        
        
    }
}
