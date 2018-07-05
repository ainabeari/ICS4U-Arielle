/*
 * Arielle
 * Mon. June. 04, 2018.
 * Data Base Interface. 
 */
package ca.arielle.ics4u.assignments;

import java.io.IOException;

/**
 *
 * @author 1ainabeari
 */
public interface DataBaseInterface {

    /**
     * @return
     */
    public void open();

    public void close();

    public ScienceRecord save(ScienceRecord c)throws IOException;

    public ScienceRecord get(long dbID)throws IOException;
    
    
    
}
