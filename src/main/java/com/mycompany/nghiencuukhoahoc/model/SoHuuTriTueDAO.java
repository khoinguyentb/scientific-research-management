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
        ReadFile();
    }
    
    public void ReadFile(){
        Object o = fileUtils.readObjectFromFile(SOHUUTRITUE_FILE_NAME);
		if(o instanceof Collection) {
                    soHuuTriTues.clear();
                    soHuuTriTues.addAll((Collection) o);
			
		}
    }
    public void UpdateFile(){
        fileUtils.writeObjectToFile(soHuuTriTues, SOHUUTRITUE_FILE_NAME);
    }
    
    public void AddSoHuuTriTue(SoHuuTriTue s){
        SoHuuTriTue soHuuTriTue = s;
        soHuuTriTues.add(soHuuTriTue);
        UpdateFile();
    }
    
    public void Delete(int MaSo){
       
        for(int i = 0; i < soHuuTriTues.size(); i++){
            if(MaSo == soHuuTriTues.get(i).getMaSo()){
                soHuuTriTues.remove(i);
            }
        }
        UpdateFile();
    }
    
    

    public List<SoHuuTriTue> getSoHuuTriTues() {
        return soHuuTriTues;
    }
    
    
}
