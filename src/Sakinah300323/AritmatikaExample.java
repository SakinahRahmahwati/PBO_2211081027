/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah300323;

/**
 *
 * @author HP-PC
 */
public class AritmatikaExample {
    public static void main(String[] args){
        Aritmatika aritmatika = new Aritmatika();
        int c = aritmatika.tambah(10,5);
        System.out.println("C : " + c);
        System.out.println("Ganjil? "+ aritmatika.ganjil(c) );

        
        int[] hasil = aritmatika.tampilkanGanjil();
        System.out.println("5 Bilangan ganjil: ");
        for (int i = 0; i < hasil.length; i++) {
            System.out.print(hasil[i] + " ");
        }
    }
}

        