/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah080423;

/**
 *
 * @author HP-PC
 */
public class Square extends Shape{
    private int sisi;
    
    public Square(String nama) {
        super(nama);
        sisi = 3;
    }

    public float getArea() {
        float luas;
        luas = sisi * sisi;
        return luas;
    }
}
