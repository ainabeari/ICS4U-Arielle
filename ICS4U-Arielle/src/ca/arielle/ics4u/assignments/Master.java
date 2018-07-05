/*
 * Arielle
 * Tues. May. 29, 2018.
 * Child class of Dudley.java. 
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author A & J
 */
public class Master extends Lock {
    public final int DIGIT_MIN = 0;
    public final int DIGIT_MAX = 40;
    private final int RANGE = 40; //Constant
    private final String MANUFACTURER = "Master";
    
    //Is this too repetitive?
    public Master(){
        super(3);
        super.setUp(this.RANGE);
        
    } 
    
    public static void main(String args[]){
        //Test Code
        Master test = new Master();
        int[] combo = test.getCombination();
        assert(!test.locked());
        
        //Making sure digits are within range
        for (int i = 0; i < combo.length; i ++){
            assert(combo[i] >= 0 && combo[i] < 40);
        }
        
        //Locking and Unlocking 
        test.lock();
        assert(test.locked());
        test.unlock(combo);
        assert(!test.locked());
        
        //Wrong combo
        test.lock();
        int[] fake = {1,2,3}; //Assuming this is not the combo
        test.unlock(fake);
        assert(test.locked());
        
        int[] fake2 = {1,2}; //Assuming this is not the combo
        test.unlock(fake2);
        assert(test.locked());
    }
}
