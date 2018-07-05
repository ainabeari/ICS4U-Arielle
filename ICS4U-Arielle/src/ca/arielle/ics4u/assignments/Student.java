/*
 * Arielle
 * Wed. May. 2, 2018.
 * Creating a student object. 
 */
package ca.arielle.ics4u.assignments;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1ainabeari
 */
public class Student {
    //primary key
    private Integer id;
    
    //secondary key
    private String name;
    private Long phone;
    private Date dob;

    //I'm going to assume that ther can only be a maximum of 2000 students at a school. Do I need getHashCode()?
    public Student() {
        name = "AYEE";
        phone = (long) (Math.random() * 2000) + 1;
        dob = new Date();
        //primary key
        id = (int) (Math.random() * 2000) + 1;
    }
    
    public Student(long phone){
        this();
        this.phone = phone;
    }
    
    public Student(String name){
        this();
        this.name = name;
    }
    
    public Student(int id){
        this();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.phone);
        return hash;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
       // final Student other = (Student) obj;
        return true;
    }
    
    public static void main(String[] hey){
        System.out.println(Long.MAX_VALUE + 1);
    }
    
    
    
}
