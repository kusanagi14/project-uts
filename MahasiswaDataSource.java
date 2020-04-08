/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.APP.UTS045;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tsabit Alifudin
 */
public class MahasiswaDataSource {
    private Connection connection;
    
    //berisi fungsi atau method bisa melakukan operasi database
    public MahasiswaDataSource(){
        connection = ConnectionUtil.getConnection();
    }
    
    public List<pelanggan> getALL(){
        List<pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            pelanggan mhs;
            while (rs.next()) {                
                mhs = new pelanggan();
                mhs.setIdPart(rs.getString("idPart"));
                mhs.setNamaPart(rs.getString("namaPart"));
                mhs.setMerkPart(rs.getString("merkPart"));
                mhs.setHarga(rs.getString("harga"));
                mhs.setJumlah(rs.getString("jumlah"));
                
                list.add(mhs);
            }
        } catch (Exception e) {
            System.out.println("Error get All"+e.getMessage());
        }
        return list;
    }
    
    //mengambil data tunggal / 1 id saja
    public pelanggan getByID(String nim){
        //? adalah parameter yang di berikan sebagai ganti isi
        String sql = "SELECT * FROM sparepart WHERE idPart = ?";
        pelanggan mhs = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pengisian parameter ?
            statement.setString(1, nim);
            //ditampung dalam resutset
            ResultSet rs = statement.executeQuery();
            //Pengecekan data rs
            //pakai if karena data tunggal, tidak perlu pakai while
            if (rs.next()) {
               mhs = new pelanggan();
                mhs.setIdPart(rs.getString("idPart"));
                mhs.setNamaPart(rs.getString("namaPart"));
                mhs.setMerkPart(rs.getString("merkPart"));
                mhs.setHarga(rs.getString("harga"));
                mhs.setJumlah(rs.getString("jumlah"));
            }
        } catch (Exception e) {
        }
        return mhs;
    }
    
    //Pembuatan Kelas Manipulasi database Insert
    public boolean insert(pelanggan mhs){
        boolean status = false;
        String sql = "INSERT INTO mahasiswa VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            statement.setString(1, mhs.getIdPart());
            statement.setString(2, mhs.getNamaPart());
            statement.setString(3, mhs.getMerkPart());
            statement.setString(4, mhs.getHarga());
            statement.setString(5, mhs.getJumlah());
            
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Update
    public boolean update(pelanggan mhs){
        boolean status = false;
        String sql = "UPDATE sparepart SET namaPart=?, merkPart=?, harga=?, jumlah=? " +
                "WHERE idPart=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Update, nim jadi dipaling akhir
            statement.setString(1, mhs.getNamaPart());
            statement.setString(2, mhs.getMerkPart());
            statement.setString(3, mhs.getHarga());
            statement.setString(4, mhs.getJumlah());
            statement.setString(5, mhs.getIdPart());
           
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Delete
    public boolean delete(pelanggan mhs){
        boolean status = false;
        String sql = "DELETE FROM sparepart WHERE idPart=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Delete, hanya 1 parameter saja
            statement.setString(5, mhs.getIdPart());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
}
