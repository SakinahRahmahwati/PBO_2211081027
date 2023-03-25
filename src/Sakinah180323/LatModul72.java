
package Sakinah180323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class LatModul72 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[10];

        // Tanyakan 10 nomor kepada user dan simpan dalam array
        for (int i = 0; i < numbers.length; i++) {
            String input = JOptionPane.showInputDialog(null, "Masukkan nomor ke-" + (i+1) + ":");
            numbers[i] = Integer.parseInt(input);
        }

        // Temukan nilai terbesar dalam array
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Tampilkan input terbesar yang diberikan oleh user
        JOptionPane.showMessageDialog(null, "Input terbesar yang diberikan oleh user adalah " + max);
    }
}


