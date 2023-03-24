/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah160323;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Latihan1
{
    public static void main(final String[] args) {
        final BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Entri nilai A : ");
            final int nilai1 = Integer.parseInt(dataIn.readLine());
            System.out.print("Entri nilai B : ");
            final int nilai2 = Integer.parseInt(dataIn.readLine());
            System.out.print("Entri nilai D : ");
            final boolean d = Boolean.parseBoolean(dataIn.readLine());
            final int nilai3 = nilai1 + nilai2;
            System.out.println("Hasil nilai C : " + nilai3);
            System.out.println("Hasil nilai D : " + d);
        }
        catch (IOException ex) {}
    }
}


