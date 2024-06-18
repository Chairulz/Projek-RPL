/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpl;

/**
 *
 * @author LENOVO
 */
public class Laporan {
    private String nama;
    private String nip;
    private String divisi;
    private String file;
    
    public Laporan() {}
    
    public Laporan(String nama, String nip, String divisi, String file) {
        this.nama = nama;
        this.nip = nip;
        this.divisi = divisi;
        this.file = file;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNIP() {
        return nip;
    }

    public void setNIP(String nip) {
        this.nip = nip;
    }
    
    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
    
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
