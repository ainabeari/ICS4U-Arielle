/*
 * Arielle
 * Tues. May. 29, 2018.
 * Child class of Lock.java.
 */
package ca.arielle.ics4u.assignments;


/**
 *
 * @author A & J
 */
abstract public class Configure extends Lock{
    
    //for the user to see
    public final int DIGIT_MIN = 0;
    public final int DIGIT_MAX = 10;
    
    //All children of this class have a range of 10 minutes
    protected final int RANGE = 10; //CONSTANT
    protected boolean configure;

    public Configure(int num) {
        super(num);
    }
    
    
     public void configureCombo(int[] ans){
        if(!super.locked()){
            //making sure array is the right length and correct digits
            if(ans.length == 3 || ans.length == 4){
                boolean good = true;
                for (int i = 0; i < ans.length; i ++){
                    if(ans[i] >= this.RANGE || ans[i] < 0){
                        good = false;
                        System.out.println("INVALID NUMBER: " + ans[i]);
                    }
                }
                if(good){
                this.combo = ans;
                }
            }
        }else{
            System.out.println("LOCK IS LOCKED. PLEASE UNLOCK TO CHANGE THE COMBO.");
        }
        this.configure = true;
    } 

}
