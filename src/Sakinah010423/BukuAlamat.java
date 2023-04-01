/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sakinah010423;

/**
 *
 * @author HP-PC
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BukuAlamat {
    public static void main(String[] args){
        EntryBukuAlamat namaRecord = new EntryBukuAlamat();
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String [] name = new String[100];
        String [] address = new String[100];
        String [] notelp = new String[100];
        String [] alamatemail = new String[100];
        String PIL = "";
        String n = "";
        String yatidak = "";
        int no;
        int jumlah=0;
        
        do{
            try{   
                System.out.println("Menu Buku Alamat:");
                System.out.println("1. Memasukkan data");
                System.out.println("2. Menghapus data");
                System.out.println("3. Menampilkan seluruh data");
                System.out.println("4. Update data");
                System.out.println("5. Keluar");
                System.out.print("Masukkan pilihan anda: ");
                
                try{
                    PIL = dataIn.readLine();
                } catch (IOException e){
                    System.out.println("Error!");
                }
                
                
                //menampilkan nama
                switch(Integer.parseInt(PIL)){
                    case 1:
                        System.out.print("Masukkan jumlah orang:");
                        try{
                            n=dataIn.readLine();
                        }catch (IOException e){
                            System.out.println("Error!");
                        }
                        jumlah = Integer.parseInt(n);
                        
                        for(int i=0; i<jumlah; i++){
                            System.out.println("Data ke: "+(i+1));
                            
                            System.out.print("Masukkan Nama: ");
                            try{
                                name[i] = dataIn.readLine();
                            }catch(IOException e){
                                System.out.println("Error!");
                            }
                            
                            System.out.print("Masukkan Alamat: ");
                            try{
                                address[i] = dataIn.readLine();
                            }catch(IOException e){
                                System.out.println("Error!");
                            }
                            
                            System.out.print("Masukkan Nomor Telpon: ");
                            try{
                                notelp[i] = dataIn.readLine();
                            }catch(IOException e){
                                System.out.println("Error!");
                            }
                            
                            System.out.print("Masukkan Alamat Email: ");
                            try{
                                alamatemail[i] = dataIn.readLine();
                            }catch(IOException e){
                                System.out.println("Error!");
                            }
                            
                        }
                        
                        for(int i=0; i<jumlah; i++){
                            namaRecord.setName(name[i],address[i], notelp[i],alamatemail[i]);
                            System.out.println("Nama        :"+namaRecord.getName(i));
                            System.out.println("Alamat      :"+namaRecord.getAddress(i));
                            System.out.println("Nomor telpon:"+namaRecord.getNotelp(i));
                            System.out.println("Alamat Email:"+namaRecord.getAlamatemail(i));   
                        }
                        
                        System.out.println("Data Berhasil dimasukkan");
                        break;
                        
                        
                    case 2:
                        System.out.println("Menghapus Data");
                        System.out.print("Input banyak yang akan di hapus: input (1-"+jumlah+"):");
                    
                        try{
                            n=dataIn.readLine();
                        } catch(IOException e){
                            System.out.println("Error");
                        }
                    
                        no=Integer.parseInt(n);
                        System.out.println("Ditemukan Data ke- "+no);
                        no=no-1;
                        namaRecord.setName(name[no],address[no], notelp[no],alamatemail[no]);
                        System.out.println("Nama        :"+namaRecord.getName(no));
                        System.out.println("Alamat      :"+namaRecord.getAddress(no));
                        System.out.println("Nomor telpon:"+namaRecord.getNotelp(no));
                        System.out.println("Alamat Email:"+namaRecord.getAlamatemail(no));
                        System.out.print("Data akan dihapus? y/t :");
                        try{
                            yatidak=dataIn.readLine();
                        } catch(IOException e){
                            System.out.println("Error");
                        }
                    
                        if((yatidak=="tidak")||(yatidak=="t")||(yatidak=="T")){
                            System.out.println("Data Tidak Jadi di hapus");
                        } else{
                            name[no]="";
                            address[no]="";
                            notelp[no]="";
                            alamatemail[no]="";
                        
                            namaRecord.setName(name[no],address[no], notelp[no],alamatemail[no]);
                            System.out.println("Nama        :"+namaRecord.getName(no));
                            System.out.println("Alamat      :"+namaRecord.getAddress(no));
                            System.out.println("Nomor telpon:"+namaRecord.getNotelp(no));
                            System.out.println("Alamat Email:"+namaRecord.getAlamatemail(no));
                        
                            System.out.println("Data Berhasil Dihapus");
                        }
                        break;
                    
                    case 3:
                        System.out.println("Daftar semua data orang");
                        for(int i=0; i<jumlah; i++){
                            namaRecord.setName(name[i],address[i], notelp[i],alamatemail[i]);
                            System.out.println("Nama        :"+namaRecord.getName(i));
                            System.out.println("Alamat      :"+namaRecord.getAddress(i));
                            System.out.println("Nomor telpon:"+namaRecord.getNotelp(i));
                            System.out.println("Alamat Email:"+namaRecord.getAlamatemail(i));   
                        }
                        break;
                    
                    case 4:
                        System.out.println("Mengubah Data");
                        System.out.print("Input nomor orang yang dirubah datanya: ");
                        
                        try{
                            n=dataIn.readLine();
                        } catch(IOException e){
                            System.out.println("Error!");
                        }
                        
                        no=Integer.parseInt(n);
                        System.out.println("Ditemukan Data ke- "+no);
                        no=no-1;
                        namaRecord.setName(name[no],address[no], notelp[no],alamatemail[no]);
                        System.out.println("Nama        :"+namaRecord.getName(no));
                        System.out.println("Alamat      :"+namaRecord.getAddress(no));
                        System.out.println("Nomor telpon:"+namaRecord.getNotelp(no));
                        System.out.println("Alamat Email:"+namaRecord.getAlamatemail(no));
                        
                        System.out.print("Lanjutkan Proses ubah data? y/t:");
                        try{
                            yatidak=dataIn.readLine();
                        } catch(IOException e){
                            System.out.println("Error");
                        }
                        if((yatidak=="tidak")||(yatidak=="t")||(yatidak=="T")){
                            System.out.println("Data Tidak Jadi di hapus");
                        } else{
                            System.out.println("Proses ubah data ke:"+ (no+1));
                            
                            System.out.print("input Nama: ");
                            try{
                            name[no]=dataIn.readLine();
                            } catch(IOException e){
                            System.out.println("Error!");
                            }
                            
                            System.out.print("input Alamat: ");
                            try{
                            address[no]=dataIn.readLine();
                            } catch(IOException e){
                            System.out.println("Error!");
                            }
                            
                            System.out.print("input nomor telpon: ");
                            try{
                            notelp[no]=dataIn.readLine();
                            } catch(IOException e){
                            System.out.println("Error!");
                            }
                            
                            System.out.print("input Alamat: ");
                            try{
                            address[no]=dataIn.readLine();
                            } catch(IOException e){
                            System.out.println("Error!");
                            }
                            
                            System.out.print("input Alamat email: ");
                            try{
                            alamatemail[no]=dataIn.readLine();
                            } catch(IOException e){
                            System.out.println("Error!");
                            }
                            
                            namaRecord.setName(name[no],address[no], notelp[no],alamatemail[no]);
                            System.out.println("Nama        :"+namaRecord.getName(no));
                            System.out.println("Alamat      :"+namaRecord.getAddress(no));
                            System.out.println("Nomor telpon:"+namaRecord.getNotelp(no));
                            System.out.println("Alamat Email:"+namaRecord.getAlamatemail(no));
                            System.out.println("Data Berhasil dirubah");    
                        }
                        break;
                        
                    default:
                        System.out.println("terima kasih");       
                    }
                }catch(Exception e){
                    System.out.println("input tidak valid");
                    }  
            } while (Integer.parseInt(PIL)!=5);
        }
                
    }
    