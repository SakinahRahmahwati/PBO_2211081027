/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah010423;

/**
 *
 * @author HP-PC
 */
public class StudentRecordExample {
    public static void main(String[] args){
        StudentRecord sasa = new StudentRecord();
        StudentRecord rara = new StudentRecord();
        StudentRecord wati = new StudentRecord("Wati");
        
        //isi data
        sasa.setName ("Sasa");
        sasa.setAddress("Padang");
        sasa.setAge(18);
        sasa.setMathGrade(90);
        sasa.setEnglishGrade(93);
        sasa.setScienceGrade(91);
        
        rara.setName ("Rara");
        rara.setAddress("Bukittinggi");
        rara.setAge(20);
        rara.setMathGrade(89);
        rara.setEnglishGrade(91);
        rara.setScienceGrade(90);
        
        //menampilkan data sasa
        System.out.println("Data Objek Sasa");
        System.out.println("Nama        :" + sasa.getName());
        System.out.println("Alamat      :" + sasa.getAddress());
        System.out.println("Umur        :" + sasa.getAge());
        System.out.println("Rata Rata   :" + sasa.getAverage());    //menampilkan rata rata
        System.out.println("Nilai Huruf :" + sasa.nilaiHuruf());    //menampilkan nilai huruf
        
        
        //memanggil method print
        System.out.println("\nData Objek Rara");
        rara.print("");
        rara.print(70, 80, 90);
        
        System.out.println("\nData Objek Wati");
        wati.print("");
        
        //menampilkan jumlah mahsiswa
        System.out.println("Count="+ StudentRecord.getStudentCount());
        
        
    }
}
