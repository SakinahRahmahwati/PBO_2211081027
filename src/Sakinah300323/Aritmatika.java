package Sakinah300323;
public class Aritmatika {
   public int tambah (int a, int b){
       return a+b;
   }
   
   public boolean ganjil(int a){
       return (a%2!=0);
   }
   
   public int[] tampilkanGanjil() {
       int[] tampilkanGanjil = new int[5];
       int angka = 1;
       int count = 0;
        while(count < 5) {
            if (angka % 2 != 0) {
                tampilkanGanjil[count] = angka;
                count++;
            }
            angka++;
        }
        return tampilkanGanjil;
    }
   
}

