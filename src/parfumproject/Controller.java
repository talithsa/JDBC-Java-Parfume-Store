/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parfumproject;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.*;
/**
 *
 * @author talitha_husna_s
 */
public class Controller {
     
    public int createData(String idbrg, String namabrg, String jenisbrg, int jumlahbrg, int hargabrg){
        int hasil = 0; // menentukan nilai hasil awal utk eksepsi
        ConnectionManager conMan = new ConnectionManager(); // membuat koneksi dgn database
        Connection conn = conMan.logOn(); // menyalakan koneksi dgn database
        // membuat perintah tambah data
        String query = "INSERT INTO barang(idbrg,namabrg,jenisbrg,jumlahbrg,hargabrg) values('"
                + idbrg + "','" + namabrg + "','" + jenisbrg + "','" + jumlahbrg + "','" + hargabrg +"')";
        // membuat blok try 
        try {
            // membuat statement koneksi ke database
            Statement stm = conn.createStatement(); 
            // menentukan eksekusi hasil statement query
            hasil = stm.executeUpdate(query);
        // membuat blok catch hasil eksepsi
        } catch (SQLException ex){  // eksepsi sql  
            System.out.println(ex.toString()); // cetak eksepsi to string
        }
        conMan.logOff(); // matikan koneksi dgn database
        return hasil; // balikan nilai hasil
     }

    public List<Data> getAllData(){
        // membuat perintah tampil data
        String query = "SELECT * from barang"; 
        // membuat perintah arraylist data data
        List<Data> allData = new ArrayList<Data>(); 
        ConnectionManager conMan = new ConnectionManager(); // membuat koneksi dgn database
        Connection conn = conMan.logOn();  // menyalakan koneksi dgn database
        // membuat blok try
        try {
            // membuat statement koneksi ke database
            Statement stm = conn.createStatement();
            // menyimpan hasil eksekusi statement query di rs
            ResultSet rs = stm.executeQuery(query);
            // membaca data setiap kolom dari setiap baris dalam objek ResultSet dan memasukkannya ke dalam kelas Data
            while (rs.next()){
                String idbrg = rs.getString("idbrg");
                String namabrg = rs.getString("namabrg");
                String jenisbrg = rs.getString("jenisbrg");
                int jumlahbrg = rs.getInt("jumlahbrg");
                int hargabrg = rs.getInt("hargabrg");
                Data dataRead = new Data(idbrg,namabrg,jenisbrg,jumlahbrg,hargabrg);
                allData.add(dataRead);
            }
        // membuat blok catch 
        } catch (SQLException ex){  // eksepsi sql
            System.out.println(ex.toString()); // cetak eksepsi to string
        }
        conMan.logOff(); // matikan koneksi dgn database
        return allData;  // balikan nilai tampil allData
    }
      
    public int updateData(String idbrg, int jumlahbrg, int hargabrg){
        int hasil = 0; // menentukan nilai hasil awal utk eksepsi
        ConnectionManager conMan = new ConnectionManager(); // membuat koneksi dgn database
        Connection conn = conMan.logOn(); // menyalakan koneksi dgn database
        // membuat perintah ubah data
        String query = "UPDATE barang SET idbrg='" + idbrg + "', jumlahbrg=" + jumlahbrg + ", hargabrg=" + hargabrg + " WHERE idbrg='"+ idbrg+"'";
        // membuat blok try
        try {
            // membuat statement koneksi ke database
            Statement stm = conn.createStatement();
            // menentukan eksekusi hasil statement query
            hasil = stm.executeUpdate(query);
        // membuat blok catch 
        } catch (SQLException ex){  // eksepsi sql
            System.out.println(ex.toString()); // cetak eksepsi to string
        }
        conMan.logOff(); // matikan koneksi dengan database
        return hasil;    // balikan nilai hasil
    }
  
    public int deleteData(String idbrg){
        int hasil = 0; // menentukan nilai hasil awal utk eksepsi
        ConnectionManager conMan = new ConnectionManager(); // membuat koneksi dgn database
        Connection conn = conMan.logOn();  // menyalakan koneksi dgn database
        // membuat perintah hapus data
        String query = "DELETE FROM barang where idbrg='"+ idbrg + "'";
        // membuat blok try
        try {
            // membuat statement koneksi ke database
            Statement stm = conn.createStatement();
            // menentukan eksekusi hasil statement query
            hasil = stm.executeUpdate(query);
        // membuat blok catch 
        } catch (SQLException ex){  // eksepsi sql
            System.out.println(ex.toString()); // cetak eksepsi to string
        }
        conMan.logOff(); // matikan koneksi dgn database
        return hasil;    // balikan nilai hasil
    }

}
