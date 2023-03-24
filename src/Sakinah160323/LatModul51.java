
/* 
Menggunakan BufferedReader, tanyakan tiga kata dari user dan tampilkan output dari 
input user tersebut ke layar. Contoh, 
Enter word1:Goodbye 
Enter word2:and 
Enter word3:Hello 
Goodbye and Hello 
*/

package Sakinah160323;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LatModul51 {
    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in) );
        
        System.out.print("Enter word 1 : ");
        String word1 = reader.readLine();
        
        System.out.print("Enter word 2 : ");
        String word2 = reader.readLine();
        
        System.out.print("Enter word 3 : ");
        String word3 = reader.readLine();
        
        System.out.println(word1 + " " + word2 + " " + word3);

    }
}
