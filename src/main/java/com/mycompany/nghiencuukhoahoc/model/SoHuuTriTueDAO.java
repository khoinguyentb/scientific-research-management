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
public class SoHuuTriTueDAO {
    List<SoHuuTriTue> soHuuTriTues;
    FileUtils fileUtils;
    private final String SOHUUTRITUE_FILE_NAME ="sohuutritue.dat";

    public SoHuuTriTueDAO() {
        soHuuTriTues = new ArrayList<>();
        fileUtils = new FileUtils();
        readSoHuuTriTue();
    }
    
    public void readSoHuuTriTue(){
        Object o = fileUtils.readObjectFromFile(SOHUUTRITUE_FILE_NAME);
        if(o instanceof Collection){
            soHuuTriTues.clear();
            soHuuTriTues.addAll((Collection) o);
        }
    }
    
    public void AddSoHuuTriTue(SoHuuTriTue s){
        soHuuTriTues.add(s);
        UpdateFile();
    }
    
    public void Delete(String MaSo){
        int mSo = Integer.parseInt(MaSo);
        for(int i = 0; i < soHuuTriTues.size(); i++){
            if(mSo == soHuuTriTues.get(i).getMaSo()){
                soHuuTriTues.remove(i);
            }
        }
    }
    
    public void UpdateFile(){
        fileUtils.writeObjectToFile(soHuuTriTues, SOHUUTRITUE_FILE_NAME);
    }

    public List<SoHuuTriTue> getSoHuuTriTues() {
        return soHuuTriTues;
    }
    
    
}
