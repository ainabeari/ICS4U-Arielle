/*
 * Arielle
 * Fri. Dec. 9, 2016
 * Version 1.0
 * Declaring usefiul methods. 
 */
package ca.arielle.ics4u.utility;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 1ainabeari
 */
public class Method {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
    }
    public static void sopl(String n){
        System.out.println(n);
    }
    
    public static void sop(String n){
        System.out.print(n);
    }
    
    public static void displayArray(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]);
        }
        System.out.println();
    }
    
    public static void displayArray(double[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ",");
        }
        System.out.println();
    }
    
    public static void displayArray(String[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ",");
        }
        System.out.println();
    }
    
      public static void displayArray(char[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + "");
        }
        System.out.println();
    }
    

    
    public static void swap(int[] data, int x, int y) {
        int z = data[y];
        data[y] = data[x];
        data[x] = z;

    }
    
    public static void swap(double[] data, int x, int y) {
        double z = data[y];
        data[y] = data[x];
        data[x] = z;

    }
    
    public static void swap(String[] data, int x, int y) {
        String z = data[y];
        data[y] = data[x];
        data[x] = z;

    }
    
//    public static int index(RandomAccessFile recordFile, ScienceRecord c) throws IOException{
//         int num = (int) recordFile.length() / c.getRECORD_SIZE();
//        int index = (num - 1) * c.getRECORD_SIZE();
//        return index;
//            
//        }
//    
//    public static void add(RandomAccessFile recordFile, ScienceRecord c) throws IOException{
//        if(c.getDbID() == -1){
//        recordFile.seek(recordFile.length());
//        }else{
//        recordFile.seek((c.getDbID() - 1) * ScienceRecord.RECORD_SIZE);    //gte index
//        }
//        recordFile.writeChars(c.getName());
//        recordFile.writeChars(c.getProject());
//        int num = (int) recordFile.length() / c.getRECORD_SIZE();
//        c.setDbID(num);
//    }
//    
//    public static String get(RandomAccessFile recordFile, int id) throws IOException{
//        int index = (int) (id - 1) * ScienceRecord.RECORD_SIZE;
//        
//        recordFile.seek(index);
//        System.out.println(index);
//        ScienceRecord record = new ScienceRecord();
//        
//        char name[] = new char[ScienceRecord.LENGTH_NAME];
//        for (int i = 0; i < ScienceRecord.LENGTH_NAME; i ++) {
//            name[i] = recordFile.readChar();
//        }
//        record.setName(new String(name));
//                
//        return record.getName();
//    }
    
}
