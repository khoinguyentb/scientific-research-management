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
public class GiaiThuongNCKH implements Serializable{
    private String tenGiai;
    private String capGiayKhen;
    private String datGiai;
    private String linhVuc;
    private int nam;
    private String nguoiDuocCap;
    private String donViDuocCap;
    private String trangThai;
    private String xacNhan;

    public GiaiThuongNCKH() {
    }

    
    
    public GiaiThuongNCKH(String tenGiai, String capGiayKhen, String datGiai, String linhVuc, int nam, String nguoiDuocCap, String donViDuocCap, String trangThai, String xacNhan) {
        this.tenGiai = tenGiai;
        this.capGiayKhen = capGiayKhen;
        this.datGiai = datGiai;
        this.linhVuc = linhVuc;
        this.nam = nam;
        this.nguoiDuocCap = nguoiDuocCap;
        this.donViDuocCap = donViDuocCap;
        this.trangThai = trangThai;
        this.xacNhan = xacNhan;
    }

    public String getTenGiai() {
        return tenGiai;
    }

    public void setTenGiai(String tenGiai) {
        this.tenGiai = tenGiai;
    }

    public String getCapGiayKhen() {
        return capGiayKhen;
    }

    public void setCapGiayKhen(String capGiayKhen) {
        this.capGiayKhen = capGiayKhen;
    }

    public String getDatGiai() {
        return datGiai;
    }

    public void setDatGiai(String datGiai) {
        this.datGiai = datGiai;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getNguoiDuocCap() {
        return nguoiDuocCap;
    }

    public void setNguoiDuocCap(String nguoiDuocCap) {
        this.nguoiDuocCap = nguoiDuocCap;
    }

    public String getDonViDuocCap() {
        return donViDuocCap;
    }

    public void setDonViDuocCap(String donViDuocCap) {
        this.donViDuocCap = donViDuocCap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getXacNhan() {
        return xacNhan;
    }

    public void setXacNhan(String xacNhan) {
        this.xacNhan = xacNhan;
    }
    
}
