/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah080423;

/**
 *
 * @author HP-PC
 */
public class LatModul11_1 extends StudentRecord{
    
    public LatModul11_1(){
        super( "kinah", "Pariaman" ); 
    }
    
    public static void main( String[] args ){  
        LatModul11_1 kinah = new LatModul11_1();
        System.out.println("Nama    :" + kinah.name);
        System.out.println("Alamat  :" + kinah.address);
        
        System.out.println("Count= "+StudentRecord.getStudentCount());
    }
    
    @Override
    public String getName(){
        System.out.println("kinah adalah student");
        return name;
    }
}