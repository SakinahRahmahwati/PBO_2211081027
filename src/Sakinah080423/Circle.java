/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah080423;

/**
 *
 * @author HP-PC
 */
public class Circle extends Shape{
    private int jari2;
    
    public Circle(String nama) {
        super(nama);
        jari2= 3;
    }
        
    public float getArea() {
        float luas;
        luas = (float) (3.14 * jari2 * jari2);
        return luas;
    }
}
