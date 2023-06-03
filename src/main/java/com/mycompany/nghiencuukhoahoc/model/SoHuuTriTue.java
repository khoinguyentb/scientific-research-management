/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nghiencuukhoahoc.model;

import java.io.Serializable;

/**
 *
 * @author vankh
 */
public class SoHuuTriTue implements Serializable{
    
    private String tenSHTT;
    private int maSo;
    private String loai;
    private String chuSoHuuDonVi;
    private String linhVuc;
    private int namCap;
    private String noiCap;
    private String xacNhan;

    public SoHuuTriTue() {
    }

    
    
    public SoHuuTriTue(String tenSHTT, int maSo, String loai, String chuSoHuuDonVi, String linhVuc, int namCap, String noiCap, String xacNhan) {
        this.tenSHTT = tenSHTT;
        this.maSo = maSo;
        this.loai = loai;
        this.chuSoHuuDonVi = chuSoHuuDonVi;
        this.linhVuc = linhVuc;
        this.namCap = namCap;
        this.noiCap = noiCap;
        this.xacNhan = xacNhan;
    }

    public String getTenSHTT() {
        return tenSHTT;
    }

    public void setTenSHTT(String tenSHTT) {
        this.tenSHTT = tenSHTT;
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getChuSoHuuDonVi() {
        return chuSoHuuDonVi;
    }

    public void setChuSoHuuDonVi(String chuSoHuuDonVi) {
        this.chuSoHuuDonVi = chuSoHuuDonVi;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public int getNamCap() {
        return namCap;
    }

    public void setNamCap(int namCap) {
        this.namCap = namCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public String getXacNhan() {
        return xacNhan;
    }

    public void setXacNhan(String xacNhan) {
        this.xacNhan = xacNhan;
    }
    
}
