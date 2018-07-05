/*
 * Arielle
 * Mon. May. 28, 2018.
 * Master U Lock (child of Configure). 
 */
package ca.arielle.ics4u.assignments;


/**
 *
 * @author A & J
 */
//What do I need to fix for this?
public class MasterU extends Configure{
    private final String MANUFACTURER = "Master";
    
    public MasterU (){
        super(4);
        this.locked = true;
    }
        
    
    public static void main(String args[]) {
        //Test Code
        MasterU test = new MasterU();
        
        int[] combo = new int[4];
        
        //Making sure digits are within range
        for (int i = 0; i < combo.length; i ++){
            assert(combo[i]>= 0 && combo[i] < 10);
        }
        
        //Testing default combo
        assert(test.locked());
        test.unlock(combo);
        assert(!test.locked());
        
        //Testing new combo
        combo[0] = 1;
        combo[1] = 3;
        combo[2] = 4;
        combo[3] = 5;
        
        test.configureCombo(combo);
        test.lock();
        test.unlock(combo);
        assert(!test.locked());
        
        //Testing incorrect range of numbers for combo and being locked our
        int[] fakeCombo = {-1, 50, -6, 88};
        
        test.configureCombo(fakeCombo);
        test.lock();
        test.unlock(fakeCombo);
        assert(test.locked());
        assert(test.getCombination() == combo);
        
        
        
        
        
        
        
        
}
}
