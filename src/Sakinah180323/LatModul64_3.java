/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah180323;
import java.util.Scanner;

public class LatModul64_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int angka = input.nextInt();
        System.out.print("Masukkan pangkat: ");
        int pangkat = input.nextInt();
        int hasil = 1;
        for (int counter = 1; counter <= pangkat; counter++) {
            hasil *= angka;
        }
        System.out.println(angka + " pangkat " + pangkat + " adalah " + hasil);
    }
}

