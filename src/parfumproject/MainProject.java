/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parfumproject;

import java.sql.Connection;
import java.util.Scanner;
/**
 *
 * @author talitha_husna_s
 */
public class MainProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        System.out.println("Koneksi : " + conn);
        
        Data data = new Data();
        System.out.println("\nSelamat Datang Admin Deez! Ada yang perlu diperiksa?");
        System.out.println("1. Input Data Parfum Baru");
        System.out.println("2. Tampil Data Parfum Terbaru");
        System.out.println("3. Ubah Data Parfum");
        System.out.println("4. Hapus Data Parfum");
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan opsi untuk mulai memeriksa: ");
        int a = input.nextInt();
        if (a == 1){
            data.create();
        }
        if (a == 2){
            data.read();
        }
        if (a == 3){
            data.update();
        }
        if (a == 4){
            data.delete();
        }
    }  
}
