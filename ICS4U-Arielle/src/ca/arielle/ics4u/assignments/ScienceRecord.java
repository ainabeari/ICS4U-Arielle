/*
 * Arielle
 * Tues. May. 22, 2018.
 * Science Fair Data Base. 
 */
package ca.arielle.ics4u.assignments;


/**
 *
 * @author 1ainabeari
 */
public class ScienceRecord {

    //Record's fields
    private int dbID;
    private String name;
    private String project;
    private String fair;
    private int projectNum;
    private int age;
    private double score;
    private char projectSection;
    private boolean won;

    //Amount of Space each takes up - CONSTANTS
    public static final int RECORD_SIZE = 81; //total number of bytes in a record
    public static final int LENGTH_NAME = 15;
    public static final int LENGTH_PROJECT = 10;
    public static final int LENGTH_FAIR = 6;

    //Primary Key
    public ScienceRecord(int DBid) {
        setDbID(DBid);
    }

    //Secondary Keys
    public ScienceRecord(String name, String project, String fair, int projectNum, int age, double score, char projectSection, boolean won) {
        this();
        setName(name);
        setProject(project);
        setFair(fair);
        setProjectNum(projectNum);
        setAge(age);
        setScore(score);
        setProjectSection(projectSection);
        setWon(won);

    }

    //Default constructor
    public ScienceRecord() {
        dbID = -1;
    }

    public void setName(String name) {
        StringBuilder temp = new StringBuilder();

        if (name != null) {
            temp.append(name.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_NAME);
        this.name = temp.toString();
    }

    public void setProject(String project) {
        StringBuilder temp = new StringBuilder();

        if (project != null) {
            temp.append(project.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_PROJECT);
        this.project = temp.toString();
    }

    public void setFair(String fair) {
        StringBuilder temp = new StringBuilder();

        if (fair != null) {
            temp.append(fair.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_FAIR);
        this.fair = temp.toString();
    }

    public void setProjectNum(Integer projectNum) {
        if (projectNum != null) {
            this.projectNum = projectNum;
        } else {
            System.err.println("Null Integer inputted. PLease input a valid number");
        }
    }

    public void setAge(Integer age) {
        if (age != null) {
            this.age = age;
        } else {
            System.err.println("Null Integer inputted. Please input a valid number");
        }
    }

    public void setScore(Double score) {
        if (score != null) {
            this.score = score;
        } else {
            System.err.println("Null Double inputted. Please input a valid number");
        }
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
    }

    public void setProjectSection(char projectSection) {
        this.projectSection = projectSection;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
    
    
    
    

//Getters 
    public String getName() {
        return this.name;
    }

    public String getProject() {
        return this.project;
    }

    public int getRECORD_SIZE() {
        return this.RECORD_SIZE;
    }

    public int getLENGTH_NAME() {
        return this.LENGTH_NAME;
    }

    public int getLENGTH_PROJECT() {
        return this.LENGTH_PROJECT;
    }

    public String getFair() {
        return this.fair;
    }

    public int getLENGTH_FAIR() {
        return this.LENGTH_FAIR;
    }

    public int getProjectNum() {
        return this.projectNum;
    }

    public int getAge() {
        return this.age;
    }

    public double getScore() {
        return this.score;
    }

    public int getDbID() {
        return this.dbID;
    }

    public char getProjectSection() {
        return this.projectSection;
    }

    public boolean isWon() {
        return this.won;
    }
            

    @Override
    public String toString() {
        return "ScienceRecord{" + "dbID=" + dbID + ", name=" + name + ", project=" + project + '}';
    }

 

}
