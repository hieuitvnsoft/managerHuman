/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlns_da;

import Entity.Deparment;
import Entity.DisciplineReward;
import Entity.District;
import Entity.Employee;
import Entity.EmployeeRe;
import Entity.Ethnic;
import Entity.LevelEdu;
import Entity.Position;
import Entity.Province;
import Entity.Religion;
import Entity.Role;
import Entity.Wards;
import Mannager.ManagerDeparment;
import Mannager.ManagerEmployeeRe;
import Mannager.ManagerPosition;
import Mannager.ManagerRole;
import Mannager.Manager_Province_District_Wards_Religion_Ethnic;
import Mannager.MangerLevelEdu;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Path;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static qlns_da.FormAddEmloyee.copyFile;

/**
 *
 * @author AnhHieu
 */
public class frEmpReInfor extends javax.swing.JInternalFrame {

    DefaultComboBoxModel<Province> modelProvince;
    DefaultComboBoxModel<District> modelDistrict;
    DefaultComboBoxModel<Wards> modelWards;
    DefaultComboBoxModel<Religion> modelReligion;
    DefaultComboBoxModel<Ethnic> modelEthnic;
    Manager_Province_District_Wards_Religion_Ethnic manager = new Manager_Province_District_Wards_Religion_Ethnic();
    //Trình độ học vấn
    DefaultComboBoxModel<LevelEdu> modelEdu;
    MangerLevelEdu mnEdu = new MangerLevelEdu();
    //Cấp quyền
    DefaultComboBoxModel<Role> modelRole;
    ManagerRole mnRole = new ManagerRole();
    DefaultTableModel tblModel = new DefaultTableModel();
//    //Khen thưởng, kỷ luật
//    DefaultComboBoxModel<DisciplineReward> modelDR;
//    ManagerDisciplineReward mnDR = new ManagerDisciplineReward();
    //Phòng ban
    DefaultComboBoxModel<Deparment> modelDepar;
    ManagerDeparment mnDepar = new ManagerDeparment();
    //Chức vụ
    DefaultComboBoxModel<Position> modelPos;
    ManagerPosition mnPos = new ManagerPosition();
    //Thông tin nhân viên
    ManagerEmployeeRe mnEmpRe = new ManagerEmployeeRe();

    String id;

    /**
     * Creates new form frAddEmployee
     */
    public frEmpReInfor(String id) {
        try {

            initComponents();
            try {

                loadProvince();
                loadDis();
                loadWard();
                loadReligion();
                loadEthnic();
                loadLevelEdu();
                loadDepar();
                loadPos();
        
                this.id = id;
                

            } catch (SQLException ex) {
                Logger.getLogger(frEmpReInfor.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadInfoEmp(id);

        } catch (SQLException ex) {
            Logger.getLogger(frEmpReInfor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public frEmpReInfor() {
        initComponents();
        try {
            loadProvince();
            loadDis();
            loadWard();
            loadReligion();
            loadEthnic();
            loadLevelEdu();
            loadDepar();
            loadPos();
         
        } catch (SQLException ex) {
            Logger.getLogger(frEmpReInfor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadInfoEmp(String id) throws SQLException {
        ManagerEmployeeRe mn = new ManagerEmployeeRe();
        EmployeeRe ls = new EmployeeRe();
        ls = mn.getEmpRebyId(id);
        if (ls.getAvataRe() != null || ls.getAvataRe() != "") {
            ImageIcon icon = new ImageIcon("src/image/" + ls.getAvataRe());
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(99, 129, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(newImg);
            lblavatar.setIcon(img);
        } else if (ls.getAvataRe() == null || ls.getAvataRe() == "") {
            ImageIcon icon = new ImageIcon("src/image/_avatar.jpg");
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(99, 129, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(newImg);
            lblavatar.setIcon(img);
        }
        lblavatar.setText(ls.getAvataRe());
        txtIDEmp.setText(ls.getIdEmpRe());
        txtName.setText(ls.getNameEmpRe());
        txtAddress.setText(ls.getAddressEmpRe());
        DateChooser.setDate(ls.getBirthdayEmpRe());
        String idpv = ls.getIdProvinceRe();
        ComboBoxModel<Province> pv = cboProvince.getModel();
        for (int j = 0; j < cboProvince.getItemCount(); j++) {
            String n = pv.getElementAt(j).getIdCity();
            if (n.equalsIgnoreCase(idpv)) {
                cboProvince.setSelectedIndex(j);
            }
        }

        String idds = ls.getIdDistrictRe();
        ComboBoxModel<District> ds = cboDistrict.getModel();
        for (int j = 0; j < cboDistrict.getItemCount(); j++) {
            String n = ds.getElementAt(j).getIdDistrict();
            if (n.equalsIgnoreCase(idds)) {
                cboDistrict.setSelectedIndex(j);
            }
        }
        String idwa = ls.getIdWardRe();
        ComboBoxModel<Wards> war = cboWards.getModel();
        for (int j = 0; j < cboWards.getItemCount(); j++) {
            String n = war.getElementAt(j).getIdWard();
            if (n.equalsIgnoreCase(idwa)) {
                cboWards.setSelectedIndex(j);
            }
        }
        String idre = ls.getIdReligionRe();
        ComboBoxModel<Religion> res = cboReligion.getModel();
        for (int j = 0; j < cboReligion.getItemCount(); j++) {
            String n = res.getElementAt(j).getIdReligion();
            if (n.equalsIgnoreCase(idre)) {
                cboReligion.setSelectedIndex(j);
            }
        }
        String ideth = ls.getIdEthnicRe();
        ComboBoxModel<Ethnic> eth = cboEthnic.getModel();
        for (int j = 0; j < cboEthnic.getItemCount(); j++) {
            String n = eth.getElementAt(j).getIdEthnic();
            if (n.equalsIgnoreCase(ideth)) {
                cboEthnic.setSelectedIndex(j);
            }
        }
        txtPhone.setText(ls.getPhoneEmpRe());
        if (ls.isSexRe() == true) {
            radMale.setSelected(true);
        } else {
            radFemale.setSelected(true);
        }
        txtIdentity.setText(ls.getIdentityEmpRe());
        String idepar = ls.getIdDepartmentRe();
        ComboBoxModel<Deparment> depar = cboDeparment.getModel();
        for (int j = 0; j < cboDeparment.getItemCount(); j++) {
            String n = depar.getElementAt(j).getIdDepartment();
            if (n.equalsIgnoreCase(idepar)) {
                cboDeparment.setSelectedIndex(j);
            }
        }
        String idpos = ls.getIdPositionRe();
        ComboBoxModel<Position> pos = cboPosition.getModel();
        for (int j = 0; j < cboPosition.getItemCount(); j++) {
            String n = pos.getElementAt(j).getIdPosition();
            if (n.equalsIgnoreCase(idpos)) {
                cboPosition.setSelectedIndex(j);
            }
        }
        int idedu = ls.getLevelEduRe();
        ComboBoxModel<LevelEdu> edu = cboEdu.getModel();
        for (int j = 0; j < cboEdu.getItemCount(); j++) {
            int n = edu.getElementAt(j).getId();
            if (n == (idedu)) {
                cboEdu.setSelectedIndex(j);
            }
        }

        if (ls.getStatusMarriageRe() == 0) {
            radMarry.setSelected(true);
        } else if (ls.getStatusMarriageRe() == 1) {
            radDivorce.setSelected(true);
        } else {
            radFA.setSelected(true);
        }
        cboEdu.setSelectedItem(ls.getLevelEduRe());
        txtLanguage.setText(ls.getLanguageMasterRe());
        txtNote.setText(ls.getNoteEmpRe());
       
        
        if (ls.isStatusEmp() == true) {
            rdWork.setSelected(true);
        } else {
            rdWb.setSelected(true);

        }

    }

    private void loadProvince() throws SQLException {
        Vector<Province> lstProc = manager.getAllProvince();
        modelProvince = new DefaultComboBoxModel<>(lstProc);
        cboProvince.setModel(modelProvince);

    }

    private void loadDis() throws SQLException {
        Province pr = (Province) cboProvince.getSelectedItem();
        String id = pr.getIdCity();
        Vector<District> lstDis = manager.getDistrictDF("01");
        modelDistrict = new DefaultComboBoxModel<>(lstDis);
        cboDistrict.setModel(modelDistrict);
    }

    private void loadWard() throws SQLException {
        District dis = (District) cboDistrict.getSelectedItem();
        String ia = dis.getIdDistrict();
        Vector<Wards> lstWard = manager.getWardsDF(ia);
        modelWards = new DefaultComboBoxModel<>(lstWard);
        cboWards.setModel(modelWards);
    }

    private void loadReligion() throws SQLException {
        Vector<Religion> lstReligion = manager.getAllReligion();
        modelReligion = new DefaultComboBoxModel<>(lstReligion);
        cboReligion.setModel(modelReligion);
    }

    private void loadEthnic() throws SQLException {
        Vector<Ethnic> lstEthnic = manager.getAllEthnic();
        modelEthnic = new DefaultComboBoxModel<>(lstEthnic);
        cboEthnic.setModel(modelEthnic);
    }

    private void loadLevelEdu() throws SQLException {
        Vector<LevelEdu> lstEdu = mnEdu.getAllEdu();
        modelEdu = new DefaultComboBoxModel<>(lstEdu);
        cboEdu.setModel(modelEdu);
    }

    

    private void loadDepar() throws SQLException {
        Vector<Deparment> lstDepar = mnDepar.getAllDeparment();
        modelDepar = new DefaultComboBoxModel<>(lstDepar);
        cboDeparment.setModel(modelDepar);

    }

    private void loadPos() throws SQLException {
        Vector<Position> lstPos = mnPos.getAllPosition();
        modelPos = new DefaultComboBoxModel<>(lstPos);
        cboPosition.setModel(modelPos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupMarry = new javax.swing.ButtonGroup();
        GroupBtnSex = new javax.swing.ButtonGroup();
        btnGroupInsurance = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDEmp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdentity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtLanguage = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        lblavatar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cboReligion = new javax.swing.JComboBox();
        cboEthnic = new javax.swing.JComboBox();
        txtPhone = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cboProvince = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        cboDistrict = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cboWards = new javax.swing.JComboBox();
        radMarry = new javax.swing.JRadioButton();
        radDivorce = new javax.swing.JRadioButton();
        radFA = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        radYes = new javax.swing.JRadioButton();
        radNo = new javax.swing.JRadioButton();
        cboEdu = new javax.swing.JComboBox();
        DateChooser = new com.toedter.calendar.JDateChooser();
        cboDeparment = new javax.swing.JComboBox();
        cboPosition = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtContract = new javax.swing.JTextField();
        rdWork = new javax.swing.JRadioButton();
        rdWb = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nhân viên thực tập");

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Mã nhân viên :");

        jLabel2.setText("Họ tên :");

        jLabel3.setText("Ngày sinh :");

        jLabel4.setText("Địa chỉ :");

        jLabel5.setText("Dân tộc :");

        jLabel6.setText("Tôn giáo :");

        jLabel7.setText("CMTND :");

        jLabel8.setText("Tình trạng hôn nhân:");

        jLabel9.setText(" Phòng ban :");

        jLabel10.setText("Chức vụ :");

        jLabel11.setText("Trình độ học vấn :");

        jLabel12.setText("Ngoại ngữ :");

        jLabel16.setText("Số điện thoại :");

        jLabel17.setText("Ghi chú :");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        lblavatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_avatar.jpg"))); // NOI18N
        lblavatar.setPreferredSize(new java.awt.Dimension(352, 349));

        jButton1.setText("Chọn hình ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboReligion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboEthnic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########"))));

        jLabel20.setText("Giới tính:");

        GroupBtnSex.add(radMale);
        radMale.setSelected(true);

        GroupBtnSex.add(radFemale);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconnam.png"))); // NOI18N

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconnu.png"))); // NOI18N

        jLabel26.setText("Tỉnh/Thành phố:");

        cboProvince.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboProvince.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProvinceItemStateChanged(evt);
            }
        });
        cboProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProvinceActionPerformed(evt);
            }
        });

        jLabel27.setText("Quận/Huyện:");

        cboDistrict.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDistrict.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDistrictItemStateChanged(evt);
            }
        });

        jLabel28.setText("Phường/Xã:");

        cboWards.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboWards.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboWardsItemStateChanged(evt);
            }
        });

        btnGroupMarry.add(radMarry);
        radMarry.setSelected(true);
        radMarry.setText("Kết hôn");

        btnGroupMarry.add(radDivorce);
        radDivorce.setText("Ly hôn");

        btnGroupMarry.add(radFA);
        radFA.setText("Độc thân");

        jLabel13.setText("Bảo hiểm :");

        btnGroupInsurance.add(radYes);
        radYes.setSelected(true);
        radYes.setText("Có");

        btnGroupInsurance.add(radNo);
        radNo.setText("Không");

        cboEdu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DateChooser.setDateFormatString("yyyy-MM-dd");

        cboDeparment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboPosition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Hợp đồng :");

        buttonGroup1.add(rdWork);
        rdWork.setText("Làm việc");

        buttonGroup1.add(rdWb);
        rdWb.setSelected(true);
        rdWb.setText("Nghỉ làm");

        jLabel18.setText("Tình trạng nhân viên :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDEmp)
                            .addComponent(txtName)
                            .addComponent(txtAddress)
                            .addComponent(cboProvince, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDistrict, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboWards, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboReligion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboEthnic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPhone)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radNo)
                                .addGap(0, 80, Short.MAX_VALUE))
                            .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContract))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(60, 60, 60))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(radMale)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radFemale)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel22)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radMarry)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radDivorce)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radFA))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboPosition, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboDeparment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(txtLanguage, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboEdu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdWork)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdWb)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radFemale)
                            .addComponent(jLabel21)
                            .addComponent(radMale)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtIDEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radMarry)
                                    .addComponent(radDivorce)
                                    .addComponent(radFA)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cboDeparment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(cboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel27)
                                            .addComponent(cboDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel28)
                                            .addComponent(cboWards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(cboEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(cboProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cboReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cboEthnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(radYes)
                                    .addComponent(radNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdWork)
                    .addComponent(rdWb)
                    .addComponent(jLabel18)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi không ?", "Lưu", JOptionPane.YES_NO_OPTION);
        if (p == JOptionPane.OK_OPTION) {
            EmployeeRe empRe = new EmployeeRe();
            empRe.setIdEmpRe(txtIDEmp.getText());
            empRe.setNameEmpRe(txtName.getText());
            empRe.setBirthdayEmpRe(DateChooser.getDate());
            empRe.setAddressEmpRe(txtAddress.getText());
            Province pr = (Province) cboProvince.getSelectedItem();
            empRe.setIdProvinceRe(pr.getIdCity());

            District dis = (District) cboDistrict.getSelectedItem();
            empRe.setIdDistrictRe(dis.getIdDistrict());

            Wards wd = (Wards) cboWards.getSelectedItem();
            empRe.setIdWardRe(wd.getIdWard());

            Religion re = (Religion) cboReligion.getSelectedItem();
            empRe.setIdReligionRe(re.getIdReligion());

            Ethnic eth = (Ethnic) cboEthnic.getSelectedItem();
            empRe.setIdEthnicRe(eth.getIdEthnic());

            empRe.setPhoneEmpRe(txtPhone.getText());
            if (radMale.isSelected()) {
                empRe.setSexRe(true);
            } else {
                empRe.setSexRe(false);
            }
               if (rdWork.isSelected()) {
                empRe.setStatusEmp(true);
            } else {
                empRe.setStatusEmp(false);
            }
            empRe.setIdentityEmpRe(txtIdentity.getText());
            if (radMarry.isSelected()) {
                empRe.setStatusMarriageRe(0);
            } else if (radDivorce.isSelected()) {
                empRe.setStatusMarriageRe(1);
            } else {
                empRe.setStatusMarriageRe(2);
            }
            Deparment depar = (Deparment) cboDeparment.getSelectedItem();
            empRe.setIdDepartmentRe(depar.getIdDepartment());

            Position pos = (Position) cboPosition.getSelectedItem();
            empRe.setIdPositionRe(pos.getIdPosition());

            LevelEdu edu = (LevelEdu) cboEdu.getSelectedItem();
            empRe.setLevelEduRe(edu.getId());

            empRe.setLanguageMasterRe(txtLanguage.getText());
            empRe.setNoteEmpRe(txtNote.getText());
            empRe.setAvataRe(lblavatar.getText());
            try {
                mnEmpRe.updateEmpRe(empRe);
            } catch (SQLException ex) {
                Logger.getLogger(frEmpReInfor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cboProvinceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProvinceItemStateChanged
        try {
            Province pr = (Province) cboProvince.getSelectedItem();
            String id = pr.getIdCity();
            Vector<District> lstDis = manager.getAllDistrict(id);
            modelDistrict = new DefaultComboBoxModel<>(lstDis);
            cboDistrict.setModel(modelDistrict);
        } catch (SQLException ex) {
            Logger.getLogger(frEmpReInfor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboProvinceItemStateChanged

    private void cboProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProvinceActionPerformed

    private void cboDistrictItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDistrictItemStateChanged
        try {
            District pr = (District) cboDistrict.getSelectedItem();
            String ia = pr.getIdDistrict();
            Vector<Wards> lstWards = manager.getAllWards(ia);
            modelWards = new DefaultComboBoxModel<>(lstWards);
            cboWards.setModel(modelWards);
        } catch (SQLException ex) {
            Logger.getLogger(frEmpReInfor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboDistrictItemStateChanged

    private void cboWardsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboWardsItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboWardsItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image(*.png,*.jpeg)", "png", "jpeg", "jpg"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedFile.getPath());
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(lblavatar.getWidth(), lblavatar.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(newImg);
            lblavatar.setIcon(img);
            lblavatar.setText(selectedFile.getName());
            java.nio.file.Path destination = Paths.get("src/image/" + selectedFile.getName());
            java.nio.file.Path source = Paths.get(selectedFile.getPath());
            try {
                copyFile(source, destination);
            } catch (IOException ex) {
                Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(lblavatar.getWidth());
        System.out.println(lblavatar.getHeight());
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.ButtonGroup GroupBtnSex;
    private javax.swing.JButton btnCancel;
    private javax.swing.ButtonGroup btnGroupInsurance;
    private javax.swing.ButtonGroup btnGroupMarry;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboDeparment;
    private javax.swing.JComboBox cboDistrict;
    private javax.swing.JComboBox cboEdu;
    private javax.swing.JComboBox cboEthnic;
    private javax.swing.JComboBox cboPosition;
    private javax.swing.JComboBox cboProvince;
    private javax.swing.JComboBox cboReligion;
    private javax.swing.JComboBox cboWards;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblavatar;
    private javax.swing.JRadioButton radDivorce;
    private javax.swing.JRadioButton radFA;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JRadioButton radMarry;
    private javax.swing.JRadioButton radNo;
    private javax.swing.JRadioButton radYes;
    private javax.swing.JRadioButton rdWb;
    private javax.swing.JRadioButton rdWork;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContract;
    private javax.swing.JTextField txtIDEmp;
    private javax.swing.JTextField txtIdentity;
    private javax.swing.JTextField txtLanguage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JFormattedTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
