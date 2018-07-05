/*
 * Arielle
 * Mon. May. 28, 2018.
 * Child class of Lock.java. 
 */
package ca.arielle.ics4u.assignments;



/**
 *
 * @author A & J
 */
//Do we need to have to check the combo for similarity to another object (primary key)
public class Dudley extends Lock{
    
    public final int DIGIT_MIN = 0;
    public final int DIGIT_MAX = 60;
    
    
    private final int RANGE = 60;
    private final String MANUFACTURER = "Dudley";
    
    public Dudley(){
        super( 3 );
        super.setUp(this.RANGE);
    }
    
    
    public static void main(String args[]){
        //Test Code
        Dudley test = new Dudley();
        int[] combo = test.getCombination();
        assert(!test.locked());
        
        //Making sure digits are within range
        for (int i = 0; i < combo.length; i ++){
            assert(combo[i] >= 0 && combo[i] < 60);
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
