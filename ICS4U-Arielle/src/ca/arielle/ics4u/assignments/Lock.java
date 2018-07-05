/*
 * Arielle
 * Mon. May. 28, 2018.
 * Implementing Lock Interface (Parent class). 
 */
package ca.arielle.ics4u.assignments;

import java.util.Arrays;

/**
 *
 * @author 1ainabeari
 */
public abstract class Lock implements LockInterface{
    
    private static int lastID = 0;
    
    protected int[] combo;
    protected boolean locked;
    private int serialNum;  
    private int id;
    private boolean comboRevealed;
    //private final String MANUFACTURER;

    public Lock() {
        comboRevealed = false;
        this.locked = false;
        id = (int) (Math.random() * 2000) + 1;
        serialNum = ++lastID;
        System.out.println("And your serial number is: " + this.serialNum);
        
    }
        
    public Lock( int numOfDigits ) {
        this();
        this.combo = new int[numOfDigits];
    }
    
    //Use for Master and Dudley
    protected void setUp(int range){
        this.combo = getCombo(this.combo, range);
        
    }
    
  
    @Override
    public boolean locked() {
        return this.locked;
    }

    

    @Override
    public void lock() {
        this.locked =  true;
        System.out.println("Your lock is now locked.");
    }

    
    private boolean unlock(int[] ans, int[] combo) {
        if (Arrays.equals(combo, ans)){
            this.locked = false;
            System.out.println("Your lock is now unlocked.");
            return true;
        }
        else{
            System.out.println("Wrong passcode. Please try again. ");
            return false;
        }
        
    }
    
    @Override
    public boolean unlock(int[] ans){
        if(this.locked){
            System.out.println(this.combo[1]);
        return unlock(ans, combo);
        }
        return false;
    }

    
    public int[] getCombo(int[] combo, int range){
        for (int i = 0; i < combo.length; i ++){
            combo[i] = (int) (Math.random() * range);
        }
        
        //TRACE
        System.out.println("Your lock combo is (Do not forget): " + printCombo(combo)
        );
        
        return combo;
    }
    
   

    
    private String printCombo(int[] combo) {
        String ans = "";
        for(int i = 0; i < combo.length; i ++){
            ans += combo[i] + " ";
        }
        
        return ans;
    }

   

    @Override
    public int[] getCombination() {
        if( !comboRevealed ) {
            comboRevealed = true;
            return combo;
        }
        return null;
    }
    
    
   
}
