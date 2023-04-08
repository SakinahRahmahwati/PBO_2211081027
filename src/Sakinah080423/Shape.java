/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah080423;

/**
 *
 * @author HP-PC
 */
public abstract class Shape {
    private String nm;
 
        
    public Shape(String nama) {
        nm = nama; 
    }
    
    public String getName() {
        return nm;
    }

    public abstract float getArea();
}
