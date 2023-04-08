/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah080423;

/**
 *
 * @author HP-PC
 */
public class Student extends Person {
    
    public Student(){
        super( "Sakinah", "Padang" ); 
        System.out.println("Inside Student:Constructor");
    }
    
    @Override
    public String getName(){
        System.out.println("Student: getName");
        return name; 
    }
    
    public static void main( String[] args ){
        Student student = new Student();
        System.out.println("Nama    :" + student.name);
        System.out.println("Alamat  :" + student.address);
    }
    
    
}
