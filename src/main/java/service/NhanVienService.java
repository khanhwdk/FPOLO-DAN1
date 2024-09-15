/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entities.NhanVien;
import java.util.List;

/**
 *
 * @author TRAN QUOC KHANH
 */
public interface NhanVienService {
    
    public List<NhanVien> findAll();
    
    public int create(NhanVien nv);
    
    public int delete(Long id);
    
    public int update(NhanVien nv,Long id);
    
    public NhanVien findById(Long id);
    
}
