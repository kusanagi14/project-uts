/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.APP.UTS045;

/** 
 *
 * @author Tsabit Alifudin
 */
public class pelanggan {

    //pembuatan variable
    private String idPart;
    private String namaPart;
    private String merkPart;
    private String harga;
    private String jumlah;
    

    public pelanggan() {
    }

    //pembuatan constructor

    public pelanggan(String idPart, String namaPart, String merkPart, String harga, String jumlah) {
        this.idPart = idPart;
        this.namaPart = namaPart;
        this.merkPart = merkPart;
        this.harga = harga;
        this.jumlah = jumlah;
    }
    public String getIdPart() {   
        return idPart;
    }

    public void setIdPart(String idPart) {
        this.idPart = idPart;
    }

    public String getNamaPart() {
        return namaPart;
    }

    public void setNamaPart(String namaPart) {
        this.namaPart = namaPart;
    }

    public String getMerkPart() {
        return merkPart;
    }

    public void setMerkPart(String merkPart) {
        this.merkPart = merkPart;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    //pembuatan getter dan setter untuk variable yang sudah dibuat
    public void setJumlah(String jumlah) {    
        this.jumlah = jumlah;
    }

    //pembuatan object untuk tampil data
    public Object getValue(int index) {
        switch (index) {
            case 0:
                return idPart;
            case 1:
                return namaPart;
            case 2:
                return merkPart;
            case 3:
                return harga;
            case 4:
                return jumlah;
            
            default:
                return null;
        }
    }
}
