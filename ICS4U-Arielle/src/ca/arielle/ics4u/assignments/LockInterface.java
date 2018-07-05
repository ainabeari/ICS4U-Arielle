/*
 * Arielle
 * Thurs. May. 10, 2018.
 * Lock Parent Class. 
 */
package ca.arielle.ics4u.assignments;

/**
 *
 * @author 1ainabeari
 */
public interface LockInterface {
    
    
     /**
     * @return Returns whether phone/lock can be opened.
     */
    
    public boolean locked();
    
   
     /**
     *  makes the lock locked
     */
    
    public void lock();
    
    /**
     * @param ans
     * @return makes the lock unlocked
     */ 
     public boolean unlock(int[] ans); 
     
    
     
       /**
     * @return gets combo
     */
     public int[] getCombination();
     
    
    
    
    
    
}
