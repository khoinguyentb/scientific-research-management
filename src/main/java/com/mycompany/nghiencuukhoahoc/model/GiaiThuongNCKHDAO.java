/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nghiencuukhoahoc.model;

import com.mycompany.nghiencuukhoahoc.FileUtils.FileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author vankh
 */
public class GiaiThuongNCKHDAO {
    List<GiaiThuongNCKH> giaiThuongNCKHs;
    FileUtils fileUtils;
    private final String NCKH_FILE_NAME ="NCKH.dat";

    public GiaiThuongNCKHDAO() {
        giaiThuongNCKHs = new ArrayList<>();
        fileUtils = new FileUtils();
        readNCKH();
    }
    
    public void readNCKH(){
        Object o = fileUtils.readObjectFromFile(NCKH_FILE_NAME);
        if(o instanceof Collection){
            giaiThuongNCKHs.clear();
            giaiThuongNCKHs.addAll((Collection) o);
        }
    }
    
    public void UpdateFile(){
        fileUtils.writeObjectToFile(giaiThuongNCKHs, NCKH_FILE_NAME);
    }
    
    public void AddNCKH(GiaiThuongNCKH nckh){
        giaiThuongNCKHs.add(nckh);
        UpdateFile();
    }

    public void Delete(String ten){
        for(int i = 0 ; i < giaiThuongNCKHs.size(); i++){
            if(ten.equals(giaiThuongNCKHs.get(i).getTenGiai())){
                giaiThuongNCKHs.remove(i);
            }
        }
        UpdateFile();
    }
    
    public List<GiaiThuongNCKH> getGiaiThuongNCKHs() {
        return giaiThuongNCKHs;
    }
    
}
