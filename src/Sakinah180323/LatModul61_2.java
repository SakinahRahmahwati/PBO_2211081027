
package Sakinah180323;

import java.awt.Component;
import javax.swing.JOptionPane;

/*
Ambil tiga nilai ujian dari user dan hitung nilai rata-rata dari nilai tersebut. Berikan 
output rata-rata dari tiga ujian. Berikan juga smiley face pada output jika nilai rata-rata 
lebih besar atau sama dengan 60, selain itu beri output :-(. 
 
2. Gunakan JOptionPane untuk mendapat input dari user dan output hasilnya.
 */
public class LatModul61_2 {
    public static void main(final String[] args){
      String input1, input2, input3;
      
      input1 = JOptionPane.showInputDialog("Entri nilai A : ");
      double nilai1 = Double.parseDouble(input1);
              
      input2 = JOptionPane.showInputDialog("Entri nilai B : ");
      double nilai2 = Double.parseDouble(input2);
      
      input3 = JOptionPane.showInputDialog("Entri nilai C : ");
      double nilai3 = Double.parseDouble(input3); 
      
      double ratarata = (nilai1 + nilai2 + nilai3)/3;
      
      String smiley = ":-)";
      
      if (ratarata <60){
          smiley = ":-( " ;
      }
      

      String output = "Nilai rata-rata ujian adalah" + ratarata + " " + smiley;
      JOptionPane.showMessageDialog(null, output);
  
    }
}
