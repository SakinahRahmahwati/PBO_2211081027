package Sakinah160323;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LatModul61_1 {
    public static void main(final String[] args) {
        final BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Entri nilai A : ");
            final int nilai1 = Integer.parseInt(dataIn.readLine());
            System.out.print("Entri nilai B : ");
            final int nilai2 = Integer.parseInt(dataIn.readLine());
            System.out.print("Entri nilai C : ");
            final int nilai3 = Integer.parseInt(dataIn.readLine());
            final int rata = (nilai1 + nilai2 + nilai3) / 3;
            System.out.println("Rata rata : " + rata);
            if (rata >= 60) {
                System.out.println(":-)");
            }
            else {
                System.out.println(":-(");
            }
        }
        catch (IOException ex) {}
    }
}

