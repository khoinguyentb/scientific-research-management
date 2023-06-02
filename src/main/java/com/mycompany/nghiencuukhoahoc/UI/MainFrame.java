
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.nghiencuukhoahoc.UI;

import com.mycompany.nghiencuukhoahoc.menu.MenuItem;
import com.mycompany.nghiencuukhoahoc.model.GiaiThuongNCKH;
import com.mycompany.nghiencuukhoahoc.model.GiaiThuongNCKHDAO;
import com.mycompany.nghiencuukhoahoc.model.SoHuuTriTue;
import com.mycompany.nghiencuukhoahoc.model.SoHuuTriTueDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vankh
 */
public class MainFrame extends javax.swing.JFrame {

    private String[] ColumsSHTT = {"STT", "TÊN SỞ HỮU TRÍ TUỆ", " MÃ SỐ", "LOẠI", "CHỦ SỞ HỮU", 
        "LĨNH VỰC", "NĂM CẤP", "NƠI CẤP", "TRẠNG THÁI", "XÁC NHẬN", "SỬA","XÓA"};
    private String[] ColumsKHCN = {"STT", "TÊN GIẢI", "CẤP KHEN THƯỞNG", "ĐẠT GIẢI", 
        "LĨNH VỰC", "NĂM", "NGƯỜI ĐƯỢC CẤP", "ĐƠN VỊ ĐƯỢC CẤP", "TRẠNG THÁI", "XÁC NHẬN", "SỬA","XÓA"};
    private Object[][] data;
    private SoHuuTriTueDAO soHuuTriTueDAO;
    public MainFrame() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        excute();
        
        
    }

    
    public void ShowMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public SoHuuTriTue setSoHuuTriTue(){
        SoHuuTriTue soHuuTriTue = new SoHuuTriTue();
        if(!"".equals(txtNameSHTT.getText()) || !"".equals(txtDonViSoHuu.getText())
                || !"".equals(txtLinhVuc.getText()) || !"".equals(txtLoai.getText()) || !"".equals(txtMaSo.getText())
                || !"".equals(txtNamCap.getText()) || !"".equals(txtNoiCap.getText()) || !"".equals(txtXacNhan.getText())){
            soHuuTriTue.setTenSHTT(txtNameSHTT.getText().trim());
            soHuuTriTue.setMaSo(Integer.parseInt(txtMaSo.getText().trim()));
            soHuuTriTue.setLoại(txtLoai.getText().trim());
            soHuuTriTue.setChuSoHuuDonVi(txtDonViSoHuu.getText().trim());
            soHuuTriTue.setNamCap(Integer.parseInt(txtNamCap.getText().trim()));
            soHuuTriTue.setNoiCap(txtNoiCap.getText().trim());
            soHuuTriTue.setXacNhan(txtXacNhan.getText().trim());
            return soHuuTriTue;
        }else ShowMessage("Không Được Để Trống!");
        return null;
    }
    
    private void excute(){
        ImageIcon iconBookmark = new ImageIcon("icon.png");
        MenuItem subMenu1 = new MenuItem(iconBookmark,"Kê Khai",null);
        MenuItem subMenu2 = new MenuItem(iconBookmark,"Trường đã duyệt",null);
        MenuItem subMenu3 = new MenuItem(iconBookmark,"Yêu Cầu Cập Nhật",null);
        MenuItem subMenu4 = new MenuItem(iconBookmark,"Không xác nhận",null);
        MenuItem menuBaiBaoKH = new MenuItem(iconBookmark, "Bài Báo Khoa Học",null,subMenu1,subMenu2,subMenu3,subMenu4);
        MenuItem subMenu11 = new MenuItem(iconBookmark,"Kê Khai",null);
        MenuItem subMenu22 = new MenuItem(iconBookmark,"Trường đã duyệt",null);
        MenuItem subMenu32 = new MenuItem(iconBookmark,"Yêu Cầu Cập Nhật",null);
        MenuItem subMenu42 = new MenuItem(iconBookmark,"Không xác nhận",null);
        MenuItem menuBaocaoKH = new MenuItem(iconBookmark, "Báo Cáo Khoa Học",null,subMenu11,subMenu22,subMenu32,subMenu42);
        MenuItem subMenu12 = new MenuItem(iconBookmark,"Kê Khai",null);
        MenuItem subMenu23 = new MenuItem(iconBookmark,"Trường đã duyệt",null);
        MenuItem subMenu33 = new MenuItem(iconBookmark,"Yêu Cầu Cập Nhật",null);
        MenuItem subMenu43 = new MenuItem(iconBookmark,"Không xác nhận",null);
        MenuItem menuBienSoanSach = new MenuItem(iconBookmark, "Biên Soạn Sách",null,subMenu12,subMenu23,subMenu33,subMenu43);
        MenuItem subMenu13 = new MenuItem(iconBookmark,"Kê Khai",null);
        MenuItem subMenu24 = new MenuItem(iconBookmark,"Trường đã duyệt",null);
        MenuItem subMenu34 = new MenuItem(iconBookmark,"Yêu Cầu Cập Nhật",null);
        MenuItem subMenu44 = new MenuItem(iconBookmark,"Không xác nhận",null);
        MenuItem menuChuyenGiaoKHCN = new MenuItem(iconBookmark, "Chuyển Giao Khoa Học Công Nghệ",null,subMenu13,subMenu24,subMenu34,subMenu44);
        MenuItem subMenu14 = new MenuItem(iconBookmark,"Kê Khai",null);
        MenuItem subMenu25 = new MenuItem(iconBookmark,"Trường đã duyệt",null);
        MenuItem subMenu35 = new MenuItem(iconBookmark,"Yêu Cầu Cập Nhật",null);
        MenuItem subMenu45 = new MenuItem(iconBookmark,"Không xác nhận",null);
        MenuItem menuKhoaHocCongNghe = new MenuItem(iconBookmark, "Nhiệm Vụ Khoa Học Công Nghệ",null,subMenu14,subMenu25,subMenu35,subMenu45);
        MenuItem subMenu15 = new MenuItem(iconBookmark,"Kê Khai",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelKHCN.setVisible(false);
                panelSHTT.setVisible(true);
            }
        });
        MenuItem subMenu26 = new MenuItem(iconBookmark,"Trường đã duyệt",null);
        MenuItem subMenu36 = new MenuItem(iconBookmark,"Yêu Cầu Cập Nhật",null);
        MenuItem subMenu46 = new MenuItem(iconBookmark,"Không xác nhận",null);
        MenuItem menuSoHuuTriTue = new MenuItem(iconBookmark, "Sở Hữu Trí Tuệ",null,subMenu15,subMenu26,subMenu36,subMenu46);
        MenuItem subMenu16 = new MenuItem(iconBookmark,"Kê Khai",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSHTT.setVisible(false);
                panelKHCN.setVisible(true);
                
            }
        });
        MenuItem subMenu27 = new MenuItem(iconBookmark,"Trường đã duyệt",null);
        MenuItem subMenu37 = new MenuItem(iconBookmark,"Yêu Cầu Cập Nhật",null);
        MenuItem subMenu47 = new MenuItem(iconBookmark,"Không xác nhận",null);
        MenuItem menuGiaiThuong = new MenuItem(iconBookmark, "Giải Thưởng Khoa Học Công Nghệ",null,subMenu16,subMenu27,subMenu37,subMenu47);
        addMenu(menuBaiBaoKH,menuBaocaoKH,menuBienSoanSach,menuChuyenGiaoKHCN,menuGiaiThuong,menuKhoaHocCongNghe,menuSoHuuTriTue);
    }
    
    private void addMenu(MenuItem... menu){
        for(int i = 0 ; i  < menu.length ; i++){
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getsubMenu();
            for(MenuItem m : subMenu){
                addMenu(m);
            }
        }
        menus.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNameSHTT = new javax.swing.JTextField();
        txtMaSo = new javax.swing.JTextField();
        txtLoai = new javax.swing.JTextField();
        txtDonViSoHuu = new javax.swing.JTextField();
        txtLinhVuc = new javax.swing.JTextField();
        txtNamCap = new javax.swing.JTextField();
        txtNoiCap = new javax.swing.JTextField();
        txtXacNhan = new javax.swing.JTextField();
        BtnThem = new javax.swing.JButton();
        panelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        scallPanelMenu = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();
        panelSHTT = new javax.swing.JPanel();
        titleSHTT = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        headerSHTT = new javax.swing.JPanel();
        cboSHTT = new javax.swing.JComboBox<>();
        lbDonViKeKhai = new javax.swing.JLabel();
        btnAddSHTT = new javax.swing.JButton();
        txtSeachSHTT = new javax.swing.JTextField();
        lbSeach = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSHTT = new javax.swing.JTable();
        panelKHCN = new javax.swing.JPanel();
        titleKHCN = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        headerSHTT1 = new javax.swing.JPanel();
        cboKHCN = new javax.swing.JComboBox<>();
        lbDonViKeKhai1 = new javax.swing.JLabel();
        btnAddKHCN = new javax.swing.JButton();
        txtSeachKHCN = new javax.swing.JTextField();
        lbSeach1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKHCN = new javax.swing.JTable();

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setModal(true);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thêm Sở Hữu Trí Tuệ");

        txtNameSHTT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNameSHTT.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tên Sở Hữu Trí Tuệ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        txtMaSo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtMaSo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mã Số", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        txtLoai.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtLoai.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        txtDonViSoHuu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtDonViSoHuu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chủ Sở Hữu Đơn Vị", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        txtLinhVuc.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtLinhVuc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Lĩnh Vực", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        txtNamCap.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNamCap.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Năm Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        txtNoiCap.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtNoiCap.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nơi Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        txtXacNhan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtXacNhan.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Xác Nhận", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        BtnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BtnThem.setText("Thêm");
        BtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameSHTT)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMaSo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLoai))
                    .addComponent(txtDonViSoHuu)
                    .addComponent(txtLinhVuc)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNamCap, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNoiCap))
                    .addComponent(txtXacNhan)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnThem)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNameSHTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtDonViSoHuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLinhVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamCap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoiCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnThem)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHeader.setBackground(new java.awt.Color(204, 255, 255));
        panelHeader.setPreferredSize(new java.awt.Dimension(521, 50));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Nguyên Cứu Khoa Học");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(255, 204, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(300, 388));

        scallPanelMenu.setBorder(null);

        menus.setPreferredSize(new java.awt.Dimension(20, 388));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        scallPanelMenu.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scallPanelMenu)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scallPanelMenu)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(204, 255, 204));
        panelBody.setLayout(new java.awt.CardLayout());

        panelSHTT.setBackground(new java.awt.Color(255, 255, 255));
        panelSHTT.setLayout(new java.awt.BorderLayout());

        titleSHTT.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titleSHTT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSHTT.setText("Sờ Hữu Trí Tuệ");
        panelSHTT.add(titleSHTT, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        headerSHTT.setPreferredSize(new java.awt.Dimension(415, 80));

        cboSHTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSHTT.setAutoscrolls(true);

        lbDonViKeKhai.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbDonViKeKhai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDonViKeKhai.setText("Chọn theo đơn vị kê khai :");
        lbDonViKeKhai.setAutoscrolls(true);

        btnAddSHTT.setBackground(new java.awt.Color(255, 255, 255));
        btnAddSHTT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddSHTT.setText("Thêm mới");
        btnAddSHTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSHTTActionPerformed(evt);
            }
        });

        txtSeachSHTT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lbSeach.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbSeach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSeach.setText("Seach :");

        javax.swing.GroupLayout headerSHTTLayout = new javax.swing.GroupLayout(headerSHTT);
        headerSHTT.setLayout(headerSHTTLayout);
        headerSHTTLayout.setHorizontalGroup(
            headerSHTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerSHTTLayout.createSequentialGroup()
                .addGroup(headerSHTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerSHTTLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAddSHTT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeachSHTT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerSHTTLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lbDonViKeKhai, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboSHTT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        headerSHTTLayout.setVerticalGroup(
            headerSHTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerSHTTLayout.createSequentialGroup()
                .addGroup(headerSHTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboSHTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDonViKeKhai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(headerSHTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSHTT)
                    .addComponent(txtSeachSHTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSeach))
                .addContainerGap())
        );

        jPanel1.add(headerSHTT, java.awt.BorderLayout.PAGE_START);

        tblSHTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblSHTT);
        tblSHTT.setModel(new DefaultTableModel(data,ColumsSHTT));

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelSHTT.add(jPanel1, java.awt.BorderLayout.CENTER);

        panelBody.add(panelSHTT, "card2");

        panelKHCN.setBackground(new java.awt.Color(255, 255, 255));
        panelKHCN.setLayout(new java.awt.BorderLayout());

        titleKHCN.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titleKHCN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleKHCN.setText("Khoa Học Công Nghệ");
        panelKHCN.add(titleKHCN, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        headerSHTT1.setPreferredSize(new java.awt.Dimension(415, 80));

        cboKHCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKHCN.setAutoscrolls(true);

        lbDonViKeKhai1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbDonViKeKhai1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDonViKeKhai1.setText("Chọn theo đơn vị kê khai :");
        lbDonViKeKhai1.setAutoscrolls(true);

        btnAddKHCN.setBackground(new java.awt.Color(255, 255, 255));
        btnAddKHCN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddKHCN.setText("Thêm mới");
        btnAddKHCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKHCNActionPerformed(evt);
            }
        });

        txtSeachKHCN.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lbSeach1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbSeach1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSeach1.setText("Seach :");

        javax.swing.GroupLayout headerSHTT1Layout = new javax.swing.GroupLayout(headerSHTT1);
        headerSHTT1.setLayout(headerSHTT1Layout);
        headerSHTT1Layout.setHorizontalGroup(
            headerSHTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerSHTT1Layout.createSequentialGroup()
                .addGroup(headerSHTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerSHTT1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAddKHCN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSeach1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeachKHCN, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerSHTT1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lbDonViKeKhai1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboKHCN, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        headerSHTT1Layout.setVerticalGroup(
            headerSHTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerSHTT1Layout.createSequentialGroup()
                .addGroup(headerSHTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboKHCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDonViKeKhai1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(headerSHTT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddKHCN)
                    .addComponent(txtSeachKHCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSeach1))
                .addContainerGap())
        );

        jPanel2.add(headerSHTT1, java.awt.BorderLayout.PAGE_START);

        tblKHCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblKHCN);
        tblKHCN.setModel(new DefaultTableModel(data,ColumsKHCN));

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelKHCN.add(jPanel2, java.awt.BorderLayout.CENTER);

        panelBody.add(panelKHCN, "card2");

        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(729, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSHTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSHTTActionPerformed
        jDialog1.setVisible(true);
    }//GEN-LAST:event_btnAddSHTTActionPerformed

    private void btnAddKHCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKHCNActionPerformed
        DialogNCKH dialogNCKH = new DialogNCKH(this, rootPaneCheckingEnabled);
        dialogNCKH.setVisible(true);
    }//GEN-LAST:event_btnAddKHCNActionPerformed

    private void BtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnThemActionPerformed
        setSoHuuTriTue();
        soHuuTriTueDAO = new SoHuuTriTueDAO();
        ShowSoHuuTriTues(soHuuTriTueDAO.getSoHuuTriTues());
        jDialog1.setVisible(false);
    }//GEN-LAST:event_BtnThemActionPerformed

    public void ShowSoHuuTriTues(List<SoHuuTriTue> s){
        int size = s.size();
        Object[][] objser = new Object[size][9];
        for(int i = 0 ; i < size ; i++){
            objser[i][0] = i+1;
            objser[i][1] = s.get(i).getTenSHTT();
            objser[i][2] = s.get(i).getMaSo();
            objser[i][3] = s.get(i).getLoại();
            objser[i][4] = s.get(i).getChuSoHuuDonVi();
            objser[i][5] = s.get(i).getLinhVuc();
            objser[i][6] = s.get(i).getNamCap();
            objser[i][7] = s.get(i).getNoiCap();
            objser[i][8] = s.get(i).getXacNhan();
        }
        tblSHTT.setModel(new DefaultTableModel(objser,ColumsSHTT));
    }
    
    public void ShowNCKH(List<GiaiThuongNCKH> NC){
        int size = NC.size();
        Object[][] objser = new Object[size][10];
        for(int i = 0 ; i < size ; i++){
            objser[i][0] = i+1;
            objser[i][1] = NC.get(i).getTenGiai();
            objser[i][2] = NC.get(i).getCapGiayKhen();
            objser[i][3] = NC.get(i).getDatGiai();
            objser[i][4] = NC.get(i).getLinhVuc();
            objser[i][5] = NC.get(i).getNam();
            objser[i][6] = NC.get(i).getNguoiDuocCap();
            objser[i][7] = NC.get(i).getDonViDuocCap();
            objser[i][8] = NC.get(i).getTrangThai();
            objser[i][9] = NC.get(i).getXacNhan();
        }
        tblKHCN.setModel(new DefaultTableModel(objser,ColumsKHCN));
    }
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnThem;
    private javax.swing.JButton btnAddKHCN;
    private javax.swing.JButton btnAddSHTT;
    private javax.swing.JComboBox<String> cboKHCN;
    private javax.swing.JComboBox<String> cboSHTT;
    private javax.swing.JPanel headerSHTT;
    private javax.swing.JPanel headerSHTT1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDonViKeKhai;
    private javax.swing.JLabel lbDonViKeKhai1;
    private javax.swing.JLabel lbSeach;
    private javax.swing.JLabel lbSeach1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelKHCN;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelSHTT;
    private javax.swing.JScrollPane scallPanelMenu;
    private javax.swing.JTable tblKHCN;
    private javax.swing.JTable tblSHTT;
    private javax.swing.JLabel titleKHCN;
    private javax.swing.JLabel titleSHTT;
    private javax.swing.JTextField txtDonViSoHuu;
    private javax.swing.JTextField txtLinhVuc;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtMaSo;
    private javax.swing.JTextField txtNamCap;
    private javax.swing.JTextField txtNameSHTT;
    private javax.swing.JTextField txtNoiCap;
    private javax.swing.JTextField txtSeachKHCN;
    private javax.swing.JTextField txtSeachSHTT;
    private javax.swing.JTextField txtXacNhan;
    // End of variables declaration//GEN-END:variables
}