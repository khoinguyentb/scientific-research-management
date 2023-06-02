/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nghiencuukhoahoc.UI;

import com.mycompany.nghiencuukhoahoc.model.GiaiThuongNCKHDAO;
import com.mycompany.nghiencuukhoahoc.model.SoHuuTriTueDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author vankh
 */
public class Controller {

    MainFrame mainFrame;
    
    DialogNCKH dialogNCKH;
    SoHuuTriTueDAO soHuuTriTueDAO;
    GiaiThuongNCKHDAO giaiThuongNCKHDAO;
    public Controller() {
        mainFrame = new MainFrame();
        
        dialogNCKH = new DialogNCKH(mainFrame, true);
        soHuuTriTueDAO = new SoHuuTriTueDAO();
        giaiThuongNCKHDAO = new GiaiThuongNCKHDAO();
        
        
    }
    
    
    
}
