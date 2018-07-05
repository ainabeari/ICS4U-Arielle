/*
 * Arielle
 * Mon. June. 18, 2018.
 * DataBase of Science Fair Participants. 
 */
package ca.arielle.ics4u.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1ainabeari
 */
public class DataBase implements DataBaseInterface {
    
    RandomAccessFile recordFile;
    String fileName;
    boolean open = false;
    
    public DataBase(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        try {
            this.recordFile = new RandomAccessFile(fileName, "rw");
            this.open = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void close() {
        try {
            this.recordFile.close();
            this.open = false;
        } catch (IOException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public ScienceRecord save(ScienceRecord c) throws IOException {
        //Add and update
        if (this.open) {
            if (c.getDbID() == -1) {
                //Add
                recordFile.seek(recordFile.length());
            } else {
                //Update (over writes file)
                recordFile.seek(getIndex(c));
            }
            recordFile.writeChars(c.getName());
            recordFile.writeChars(c.getProject());
            recordFile.writeChars(c.getFair());
            recordFile.writeInt(c.getProjectNum());
            recordFile.writeInt(c.getAge());
            recordFile.writeDouble(c.getScore());
            recordFile.writeChar(c.getProjectSection());
            recordFile.writeBoolean(c.isWon());
            
            if (c.getDbID() == -1) {
                int num = (int) recordFile.length() / c.getRECORD_SIZE();
                c.setDbID(num);
            }
            
        } else {
            System.err.println("Please open the Data Base.");
            return null;
        }
        
        return c;
    }
    
    private int getIndex(ScienceRecord c) throws IOException {
        return (c.getDbID() - 1) * ScienceRecord.RECORD_SIZE;
    }
    
    public ScienceRecord get(ScienceRecord c) throws IOException {
        return get(c.getDbID());
    }
    
    @Override
    public ScienceRecord get(long dbID) throws IOException {
        if (this.open) {
            int index = (int) (dbID - 1) * ScienceRecord.RECORD_SIZE;
            if (index >= recordFile.length()) {
                System.err.println("INVALID ID ENTERED.");
                return null;
            }
            recordFile.seek(index);
            ScienceRecord record = new ScienceRecord();

            //Writing Name to the new Science Record
            char name[] = new char[ScienceRecord.LENGTH_NAME];
            for (int i = 0; i < ScienceRecord.LENGTH_NAME; i++) {
                name[i] = recordFile.readChar();
            }
            record.setName(new String(name));

            //Writing the Project Title to the new Record
            char project[] = new char[ScienceRecord.LENGTH_PROJECT];
            for (int i = 0; i < ScienceRecord.LENGTH_PROJECT; i++) {
                project[i] = recordFile.readChar();
            }
            record.setProject(new String(project));

            //Writing the Fair to a new project
            char fair[] = new char[ScienceRecord.LENGTH_FAIR];
            for (int i = 0; i < ScienceRecord.LENGTH_FAIR; i++) {
                fair[i] = recordFile.readChar();
            }
            record.setFair(new String(fair));

            //Writing projectNum (int)
            record.setProjectNum(recordFile.readInt());

            //Writing age (int)
            record.setAge(recordFile.readInt());

            //Writing score (double)
            record.setScore(recordFile.readDouble());

            //Writing Project Section
            record.setProjectSection(recordFile.readChar());

            //Writing the boolean value for if the exhibitor won anything
            record.setWon(recordFile.readBoolean());
            
            return record;
        }
        System.err.println("Please Open Data Base.");
        
        return null;
    }
    
    public int numRecords() throws IOException {
        int ans = (int) (recordFile.length() / ScienceRecord.RECORD_SIZE);
        return ans;
        
    }
    
    public static void main(String[] args) throws IOException {
        File f = new File("TesterForScienceStuff");
        f.delete();
        
        DataBase test = new DataBase("TesterForScienceStuff");
        
        //Test Code 
        //Testing save
        ScienceRecord c1 = new ScienceRecord("Ellie Xu", "CODIA", "CWSF", 321, 17, 92.5, 'N', true);
        ScienceRecord c3 = new ScienceRecord("Arielle Ainabe", "Tardigrade", "ISEF", 054, 17, 92.5, 'M', true);
        test.open();
        test.save(c1);
        assert(test.get(1).getName().trim().equals("Ellie Xu"));
        assert( test.get(1).getProject().trim().equals("CODIA"));
        assert( test.get(1).getFair().trim().equals("CWSF"));
        assert (test.get(1).getProjectNum() == 321);
        assert (test.get(1).getAge() == 17);
        assert (test.get(1).getScore() == 92.5);
        assert (test.get(1).getProjectSection() == 'N');
        assert (test.get(1).isWon());
        test.save(c3);
        assert (test.get(2).getProjectNum() == 054);
        assert (test.get(2).getAge() == 17);
        assert (test.get(2).getScore() == 92.5);
        assert (test.get(2).getProjectSection() == 'M');
        assert (test.get(2).isWon());

        //Testing Update
        ScienceRecord c2 = new ScienceRecord("A", "B", "c", 222, 2, 10.73, 'D', false);
        c2.setDbID(1);
        test.save(c2);
        assert( test.get(1).getName().trim().equals("A"));
        assert( test.get(1).getProject().trim().equals("B"));
        assert( test.get(1).getFair().trim().equals("c"));
        assert (test.get(1).getScore() == 10.73);
        assert (test.get(1).getProjectSection() == 'D');
        assert (!test.get(1).isWon());
        
        //Testing out of bounds
        test.get(3);
        
        //Testing other get method
        assert( test.get(c3).getName().trim().equals("Arielle Ainabe"));
        assert( test.get(c3).getProject().trim().equals("Tardigrade"));
        assert( test.get(c3).getFair().trim().equals("ISEF"));
        assert (test.get(c3).getProjectNum() == 054);
        assert (test.get(c3).getAge() == 17);
        assert (test.get(c3).getScore() == 92.5);
        assert (test.get(c3).getProjectSection() == 'M');
        assert (test.get(c3).isWon());
        
        //Testing numRecords()
        assert (test.numRecords() == 2);
        assert (test.numRecords() != 3);
        
        test.get(999);
        test.close();
        
        

       
    }
    
}
