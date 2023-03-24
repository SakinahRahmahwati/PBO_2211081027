
package Sakinah160323;

import java.awt.Component;
import javax.swing.JOptionPane;

public class LatModul52 {
  public static void main(final String[] args){
      String word1, word2, word3;
      word1 = JOptionPane.showInputDialog("Enter Word 1");
      word2 = JOptionPane.showInputDialog("Enter Word 2");
      word3 = JOptionPane.showInputDialog("Enter Word 3");
      
      final String msg = word1 + " " + word2 + " " + word3;
      
      JOptionPane.showMessageDialog(null, msg);
  
  }
}
