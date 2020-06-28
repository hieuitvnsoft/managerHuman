/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlns_da;

import Entity.Deparment;
import Entity.District;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AnhHieu
 */
public class FormAddEmloyeeRe extends javax.swing.JInternalFrame {

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
    //Phòng ban
    DefaultComboBoxModel<Deparment> modelDepar;
    ManagerDeparment mnDepar = new ManagerDeparment();
    //Chức vụ
    DefaultComboBoxModel<Position> modelPos;
    ManagerPosition mnPos = new ManagerPosition();
    //Thông tin nhân viên
    ManagerEmployeeRe mnEmpRe = new ManagerEmployeeRe();

    /**
     * Creates new form frAddEmployee
     */
    public FormAddEmloyeeRe() {
        try {
            initComponents();
            loadProvince();
            loadDis();
            loadWard();
            loadReligion();
            loadEthnic();
            loadLevelEdu();
            loadDepar();
            loadPos();
            loadRole();
        } catch (SQLException ex) {
            Logger.getLogger(FormAddEmloyeeRe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadProvince() throws SQLException {
        Vector<Province> lstProc = manager.getAllProvince();
        modelProvince = new DefaultComboBoxModel<>(lstProc);
        cboProvince.setModel(modelProvince);

    }

    public void loadDis() throws SQLException {
        Province pr = (Province) cboProvince.getSelectedItem();
        String id = pr.getIdCity();
        Vector<District> lstDis = manager.getDistrictDF("01");
        modelDistrict = new DefaultComboBoxModel<>(lstDis);
        cboDistrict.setModel(modelDistrict);
    }

    public void loadWard() throws SQLException {
        District dis = (District) cboDistrict.getSelectedItem();
        String ia = dis.getIdDistrict();
        Vector<Wards> lstWard = manager.getWardsDF("001");
        modelWards = new DefaultComboBoxModel<>(lstWard);
        cboWard.setModel(modelWards);
    }

    public void loadReligion() throws SQLException {
        Vector<Religion> lstReligion = manager.getAllReligion();
        modelReligion = new DefaultComboBoxModel<>(lstReligion);
        cboReligion.setModel(modelReligion);
    }

    public void loadEthnic() throws SQLException {
        Vector<Ethnic> lstEthnic = manager.getAllEthnic();
        modelEthnic = new DefaultComboBoxModel<>(lstEthnic);
        cboEthnic.setModel(modelEthnic);
    }

    public void loadLevelEdu() throws SQLException {
        Vector<LevelEdu> lstEdu = mnEdu.getAllEdu();
        modelEdu = new DefaultComboBoxModel<>(lstEdu);
        cboEdu.setModel(modelEdu);
    }

    public void loadDepar() throws SQLException {
        Vector<Deparment> lstDepar = mnDepar.getAllDeparment();
        modelDepar = new DefaultComboBoxModel<>(lstDepar);
        cboDepar.setModel(modelDepar);

    }

    public void loadPos() throws SQLException {
        Position ps = new Position();
        Vector<Position> lstPos = mnPos.getAllPosition();
        modelPos = new DefaultComboBoxModel<>(lstPos);
        cboPosition.setModel(modelPos);
    }

    private void loadRole() throws SQLException {
        Vector<Role> lstRole = mnRole.getAllRole();
        modelRole = new DefaultComboBoxModel<>(lstRole);
        cboRole.setModel(modelRole);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupGender = new javax.swing.ButtonGroup();
        GroupMarry = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNameEmpRe = new javax.swing.JTextField();
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
        lblAvata = new javax.swing.JLabel();
        btnAvata = new javax.swing.JButton();
        cboReligion = new javax.swing.JComboBox();
        cboEthnic = new javax.swing.JComboBox();
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
        cboWard = new javax.swing.JComboBox();
        cboEdu = new javax.swing.JComboBox();
        dateChooser = new com.toedter.calendar.JDateChooser();
        txtPhone = new javax.swing.JTextField();
        radMarry = new javax.swing.JRadioButton();
        radDivorce = new javax.swing.JRadioButton();
        radFA = new javax.swing.JRadioButton();
        cboDepar = new javax.swing.JComboBox();
        cboPosition = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        radWork = new javax.swing.JRadioButton();
        radNoWork = new javax.swing.JRadioButton();
        txtIDEmpRE = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nhân viên thử việc");

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

        jLabel9.setText("Mã phòng ban :");

        jLabel10.setText("Mã chức vụ :");

        jLabel11.setText("Trình độ học vấn :");

        jLabel12.setText("Ngoại ngữ :");

        jLabel16.setText("Số điện thoại :");

        jLabel17.setText("Ghi chú :");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        lblAvata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_avatar.jpg"))); // NOI18N
        lblAvata.setPreferredSize(new java.awt.Dimension(352, 349));

        btnAvata.setText("Chọn hình ảnh");
        btnAvata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvataActionPerformed(evt);
            }
        });

        cboReligion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboEthnic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setText("Giới tính:");

        GroupGender.add(radMale);
        radMale.setSelected(true);

        GroupGender.add(radFemale);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconnam.png"))); // NOI18N

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconnu.png"))); // NOI18N

        jLabel26.setText("Tỉnh/Thành phố:");

        cboProvince.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboProvince.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboProvinceItemStateChanged(evt);
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

        cboWard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboEdu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dateChooser.setDateFormatString("yyyy-MM-dd");

        GroupMarry.add(radMarry);
        radMarry.setSelected(true);
        radMarry.setText("Kết hôn");

        GroupMarry.add(radDivorce);
        radDivorce.setText("Ly hôn");

        GroupMarry.add(radFA);
        radFA.setText("Độc thân");

        cboDepar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboPosition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Trạng thái nhân viên :");

        buttonGroup1.add(radWork);
        radWork.setSelected(true);
        radWork.setText("Làm việc");

        buttonGroup1.add(radNoWork);
        radNoWork.setText("Nghỉ làm");

        try {
            txtIDEmpRE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAvata, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvata))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel5)
                    .addComponent(jLabel26)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboEthnic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboReligion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboWard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDistrict, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboProvince, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress)
                            .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(txtNameEmpRe)
                            .addComponent(txtPhone)
                            .addComponent(txtIDEmpRE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(63, 63, 63))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(49, 49, 49))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(63, 63, 63))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radWork)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radNoWork)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLanguage, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radFemale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(cboEdu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radMarry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radDivorce)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radFA))
                    .addComponent(cboDepar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdentity))
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
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel20)
                                .addComponent(radMale)
                                .addComponent(txtIDEmpRE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(radMarry)
                                    .addComponent(radDivorce)
                                    .addComponent(radFA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cboDepar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel27)
                                    .addComponent(cboDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboEdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(cboWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNameEmpRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(cboProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cboReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cboEthnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(radWork)
                                    .addComponent(radNoWork))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblAvata, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAvata))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Phân quyền"));

        jLabel23.setText("Tài khoản:");

        jLabel24.setText("Mật khẩu:");

        txtUserName.setEditable(false);

        txtPass.setEditable(false);

        btnReset.setText("Làm lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel25.setText("Phân cấp quyền:");

        cboRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName)
                    .addComponent(txtPass)
                    .addComponent(cboRole, 0, 213, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1343, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String id = txtIDEmpRE.getText();
            Vector<EmployeeRe> i = mnEmpRe.checkIdEmpRe(id);
            if (i.size() > 0) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại ,không thể thêm mới !", "Thông báo", JOptionPane.OK_OPTION);
            } else {

                EmployeeRe empRe = new EmployeeRe();
                empRe.setIdEmpRe(id);
                empRe.setAddressEmpRe(txtAddress.getText());
                empRe.setNameEmpRe(txtNameEmpRe.getText());

                Date date = dateChooser.getDate();
                empRe.setBirthdayEmpRe(date);

                Province pr = (Province) cboProvince.getSelectedItem();
                empRe.setIdProvinceRe(pr.getIdCity());

                District dis = (District) cboDistrict.getSelectedItem();
                empRe.setIdDistrictRe(dis.getIdDistrict());

                Wards wd = (Wards) cboWard.getSelectedItem();
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
                empRe.setIdentityEmpRe(txtIdentity.getText());
                if (radMarry.isSelected()) {
                    empRe.setStatusMarriageRe(0);
                } else if (radDivorce.isSelected()) {
                    empRe.setStatusMarriageRe(1);
                } else {
                    empRe.setStatusMarriageRe(2);
                }
                Deparment depar = (Deparment) cboDepar.getSelectedItem();
                empRe.setIdDepartmentRe(depar.getIdDepartment());

                Position pos = (Position) cboPosition.getSelectedItem();
                empRe.setIdPositionRe(pos.getIdPosition());

                LevelEdu edu = (LevelEdu) cboEdu.getSelectedItem();
                empRe.setLevelEduRe(edu.getId());

                empRe.setLanguageMasterRe(txtLanguage.getText());
                empRe.setNoteEmpRe(txtNote.getText());
                empRe.setAvataRe(lblAvata.getText());
                if (radWork.isSelected()) {
                    empRe.setStatusEmp(true);
                } else {
                    empRe.setStatusEmp(false);
                }
                if (txtNameEmpRe.getText().equals("") || date.equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("")
                        || txtIdentity.getText().equals("") || txtLanguage.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Bạn cần điền đầy đủ thông tin !", "Thông báo", JOptionPane.OK_OPTION);
                    if (txtNameEmpRe.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên nhân viên !", "Thông báo", JOptionPane.OK_OPTION);
                    } else if (date.equals("")) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa điền ngày sinh !", "Thông báo", JOptionPane.OK_OPTION);
                    } else if (txtAddress.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa điền địa chỉ !", "Thông báo", JOptionPane.OK_OPTION);
                    } else if (txtPhone.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa điền số điện thoại !", "Thông báo", JOptionPane.OK_OPTION);
                    } else if (txtIdentity.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa điền số CMTND !", "Thông báo", JOptionPane.OK_OPTION);
                    } else if (txtLanguage.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Bạn chưa điền ngôn ngữ !", "Thông báo", JOptionPane.OK_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                mnEmpRe.AddRe(empRe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormAddEmloyeeRe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void copyFile(Path source, Path destination) throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        cboRole.setSelectedItem(0);
        txtUserName.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void cboDistrictItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDistrictItemStateChanged
        // TODO add your handling code here:
        try {
            District pr = (District) cboDistrict.getSelectedItem();
            String ia = pr.getIdDistrict();
            Vector<Wards> lstWards = manager.getAllWards(ia);
            modelWards = new DefaultComboBoxModel<>(lstWards);
            cboWard.setModel(modelWards);
        } catch (SQLException ex) {
            Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboDistrictItemStateChanged

    private void cboProvinceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProvinceItemStateChanged
        // TODO add your handling code here:
        try {
            Province pr = (Province) cboProvince.getSelectedItem();
            String id = pr.getIdCity();
            Vector<District> lstDis = manager.getAllDistrict(id);
            modelDistrict = new DefaultComboBoxModel<>(lstDis);
            cboDistrict.setModel(modelDistrict);
        } catch (SQLException ex) {
            Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboProvinceItemStateChanged

    private void btnAvataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvataActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image(*.png,*.jpeg)", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            String filePath = path.substring(0, path.lastIndexOf(File.separator));
            //            System.out.println(selectedFile.getAbsolutePath());
            lblAvata.setIcon(image(path));
            lblAvata.setText(selectedFile.getName());
            Path destination = Paths.get("src/image/" + selectedFile.getName());
            Path source = Paths.get(selectedFile.getPath());
            try {
                copyFile(source, destination);
            } catch (IOException ex) {
                Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("Erro");
            }
        }
    }//GEN-LAST:event_btnAvataActionPerformed

    public ImageIcon image(String imagePath) {
        ImageIcon myIma = new ImageIcon(imagePath);
        Image img = myIma.getImage();
        Image newIma = img.getScaledInstance(lblAvata.getWidth(), lblAvata.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newIma);
        return image;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupGender;
    private javax.swing.ButtonGroup GroupMarry;
    private javax.swing.JButton btnAvata;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboDepar;
    private javax.swing.JComboBox cboDistrict;
    private javax.swing.JComboBox cboEdu;
    private javax.swing.JComboBox cboEthnic;
    private javax.swing.JComboBox cboPosition;
    private javax.swing.JComboBox cboProvince;
    private javax.swing.JComboBox cboReligion;
    private javax.swing.JComboBox cboRole;
    private javax.swing.JComboBox cboWard;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvata;
    private javax.swing.JRadioButton radDivorce;
    private javax.swing.JRadioButton radFA;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JRadioButton radMarry;
    private javax.swing.JRadioButton radNoWork;
    private javax.swing.JRadioButton radWork;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JFormattedTextField txtIDEmpRE;
    private javax.swing.JTextField txtIdentity;
    private javax.swing.JTextField txtLanguage;
    private javax.swing.JTextField txtNameEmpRe;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
