/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parfumproject;

import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author talitha_husna_s
 */
public class Data {
    private String idbrg;
    private String namabrg;
    private String jenisbrg;
    private int jumlahbrg;
    private int hargabrg;

    public Data() {
    }

    public Data(String idbrg, String namabrg, String jenisbrg, int jumlahbrg, int hargabrg) {
        this.idbrg = idbrg;
        this.namabrg = namabrg;
        this.jenisbrg = jenisbrg;
        this.jumlahbrg = jumlahbrg;
        this.hargabrg = hargabrg;
    }

    public String getIdbrg() {
        return idbrg;
    }

    public void setIdbrg(String idbrg) {
        this.idbrg = idbrg;
    }

    public String getNamabrg() {
        return namabrg;
    }

    public void setNamabrg(String namabrg) {
        this.namabrg = namabrg;
    }

    public String getJenisbrg() {
        return jenisbrg;
    }

    public void setJenisbrg(String jenisbrg) {
        this.jenisbrg = jenisbrg;
    }

    public int getJumlahbrg() {
        return jumlahbrg;
    }

    public void setJumlahbrg(int jumlahbrg) {
        this.jumlahbrg = jumlahbrg;
    }

    public int getHargabrg() {
        return hargabrg;
    }

    public void setHargabrg(int hargabrg) {
        this.hargabrg = hargabrg;
    }

    @Override
    public String toString() {
        return "# " + "Id: " + idbrg + ", Nama: " + namabrg + ", Jenis: " + jenisbrg 
                + ", jumlah: " + jumlahbrg + ", harga: Rp." + hargabrg ;
    }
    
    public void create(){
        idbrg = JOptionPane.showInputDialog("Masukan ID Barang yang akan disimpan");
        namabrg = JOptionPane.showInputDialog("Masukan Nama Barang yang akan disimpan");
        jenisbrg = JOptionPane.showInputDialog("Masukan Jenis Barang yang akan disimpan");
        jumlahbrg = Integer.parseInt(JOptionPane.showInputDialog("Masukan Jumlah yang akan disimpan"));
        hargabrg = Integer.parseInt(JOptionPane.showInputDialog("Masukan Harga Satuan yang akan disimpan"));
        
        Controller manCon = new Controller();
        int hasil = manCon.createData(idbrg, namabrg, jenisbrg, jumlahbrg, hargabrg);
        System.out.println("Hasil input data: " + hasil);
        read();
    }
    
    public void read(){
        Controller manCon = new Controller();
        List<Data> allData = manCon.getAllData();
        System.out.println("Data Parfum Terbaru: ");
        for(Data d1 : allData){
            System.out.println(d1);
        }
    }
    
    public void update(){
        idbrg = JOptionPane.showInputDialog("Masukan ID Barang yang akan diubah");
        jumlahbrg = Integer.parseInt(JOptionPane.showInputDialog("Masukan Jumlah yang akan diubah"));
        hargabrg = Integer.parseInt(JOptionPane.showInputDialog("Masukan Harga Satuan yang akan diubah"));
        
        Controller manCon = new Controller();
        int hasil = manCon.updateData(idbrg, jumlahbrg, hargabrg);
        System.out.println("Hasil update data: " + hasil);
        read();
    }
    
    public void delete(){
        idbrg = JOptionPane.showInputDialog("Masukan ID Barang yang akan dihapus");
        
        Controller manCon = new Controller();
        int hasil = manCon.deleteData(idbrg);
        System.out.println("Hasil hapus data: " + hasil);
        read();      
    }  
}
