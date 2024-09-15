/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DBConnect;
import entities.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRAN QUOC KHANH
 */
public class NhanVienRepository {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<NhanVien> findAll(){
        sql="select id,name from NhanVien";
        List<NhanVien> lst = new ArrayList<>(); 
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
              
                lst.add(new NhanVien(rs.getLong(1), rs.getString(2)));
                
            }
            
            return lst;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
   public int create(NhanVien nv) {
        sql="insert into NhanVien values(?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getName());           
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
   
   public int delete(Long id) {
        sql="delete from NhanVien where id =?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
   
   public int update(NhanVien nv, Long id) {
        sql="update NhanVien set name where id=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getName());
            ps.setObject(3, id);
            
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
   
    public NhanVien findById(String id){
        sql="select id, name from NhanVien where id=?";
        NhanVien nv = null;
        try {
            
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
              
               nv = new NhanVien(rs.getLong(1), rs.getString(2));
                
            }
            
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
