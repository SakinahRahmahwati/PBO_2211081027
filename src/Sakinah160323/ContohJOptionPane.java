/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah160323;

import java.awt.Component;
import javax.swing.JOptionPane;

public class ContohJOptionPane
{
    public static void main(final String[] args) {
        String name = "";
        name = JOptionPane.showInputDialog("Please enter your name");
        final String msg = "Hello " + name + "!";
        JOptionPane.showMessageDialog(null, msg);
    }
}

