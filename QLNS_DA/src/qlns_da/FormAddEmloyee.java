/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlns_da;

import Entity.Contracts;
import Entity.Deparment;
import Entity.District;
import Entity.Employee;
import Entity.Ethnic;
import Entity.LevelEdu;
import Entity.Position;
import Mannager.Manager_Province_District_Wards_Religion_Ethnic;
import Mannager.MangerLevelEdu;
import Entity.Province;
import Entity.Religion;
import Entity.Role;
import Entity.Wards;
import Mannager.ManagerDeparment;
import Mannager.ManagerEmployee;
import Mannager.ManagerPosition;
import Mannager.ManagerRole;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author AnhHieu
 */
public class FormAddEmloyee extends javax.swing.JInternalFrame {

    DefaultComboBoxModel<Province> modelProvince;
    DefaultComboBoxModel<District> modelDistrict;
    DefaultComboBoxModel<Wards> modelWards;
    DefaultComboBoxModel<Religion> modelReligion;
    DefaultComboBoxModel<Ethnic> modelEthnic;
    Manager_Province_District_Wards_Religion_Ethnic manager = new Manager_Province_District_Wards_Religion_Ethnic();
    DefaultComboBoxModel<LevelEdu> modelEdu;
    MangerLevelEdu mnEdu = new MangerLevelEdu();
    DefaultComboBoxModel<Role> modelRole;
    ManagerRole mnRole = new ManagerRole();
    DefaultComboBoxModel<Deparment> modelDepar;
    ManagerDeparment mnDepar = new ManagerDeparment();
    DefaultComboBoxModel<Position> modelPos;
    ManagerPosition mnPos = new ManagerPosition();
    //Thông tin nhân viên
    ManagerEmployee mnEmp = new ManagerEmployee();
    MainFrame parent;

    public FormAddEmloyee() {
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
            loadRole();
        } catch (SQLException ex) {
            Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
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
        Vector<Wards> lstWard = manager.getWardsDF("001");
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

    private void loadRole() throws SQLException {
        Vector<Role> lstRole = mnRole.getAllRole();
        modelRole = new DefaultComboBoxModel<>(lstRole);
        cboRole.setModel(modelRole);
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        GroupStatusEmp = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        avatar = new javax.swing.JLabel();
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
        cboDeparment = new javax.swing.JComboBox();
        cboPosition = new javax.swing.JComboBox();
        DateChooser = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txtContract = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        radWork = new javax.swing.JRadioButton();
        radNoWork = new javax.swing.JRadioButton();
        txtIDEmp = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nhân viên hợp đồng");

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

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/_avatar.jpg"))); // NOI18N
        avatar.setText("_avatar.jpg");
        avatar.setPreferredSize(new java.awt.Dimension(352, 349));

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
        radMarry.setText("Kết hôn");

        btnGroupMarry.add(radDivorce);
        radDivorce.setText("Ly hôn");

        btnGroupMarry.add(radFA);
        radFA.setSelected(true);
        radFA.setText("Độc thân");

        jLabel13.setText("Bảo hiểm :");

        buttonGroup1.add(radYes);
        radYes.setSelected(true);
        radYes.setText("Có");

        buttonGroup1.add(radNo);
        radNo.setText("Không");

        cboEdu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboDeparment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboPosition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Mã hợp đồng:");

        txtContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractActionPerformed(evt);
            }
        });

        jLabel18.setText("Trạng thái nhân viên :");

        GroupStatusEmp.add(radWork);
        radWork.setText("Làm việc");

        GroupStatusEmp.add(radNoWork);
        radNoWork.setSelected(true);
        radNoWork.setText("Nghỉ việc");

        try {
            txtIDEmp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtIDEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGap(0, 122, Short.MAX_VALUE))
                            .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDEmp))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContract, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radWork)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radNoWork)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radFemale)
                            .addComponent(jLabel21)
                            .addComponent(radMale)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel20)
                                .addComponent(txtIDEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(cboProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel17)
                                    .addComponent(cboEthnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cboReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(radYes)
                                    .addComponent(radNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(radWork)
                    .addComponent(radNoWork))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel25.setText("Chức năng quyền:");

        cboRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(59, 59, 59)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName)
                    .addComponent(txtPass)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82))))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboProvinceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboProvinceItemStateChanged
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

    private void cboDistrictItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDistrictItemStateChanged
        try {
            District pr = (District) cboDistrict.getSelectedItem();
            String ia = pr.getIdDistrict();
            Vector<Wards> lstWards = manager.getAllWards(ia);
            modelWards = new DefaultComboBoxModel<>(lstWards);
            cboWards.setModel(modelWards);
        } catch (SQLException ex) {
            Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboDistrictItemStateChanged

    private void cboWardsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboWardsItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboWardsItemStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cboProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProvinceActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try {
            String avt = avatar.getText();
            String id = txtIDEmp.getText();
            String username = txtUserName.getText();
            String idContract = txtContract.getText();
            Vector<Employee> i = mnEmp.checkIdEmp(id);
            Vector<Contracts> k = mnEmp.checkContracts(idContract);
            Vector<Employee> m = mnEmp.checkContractsEmp(idContract);
            Vector<Employee> g = mnEmp.checkUsernameEmp(username);
            if (i.size() > 0) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại ,không thể thêm mới !", "Thông báo", JOptionPane.OK_OPTION);
            } else if (k.size() == 0) {
                JOptionPane.showMessageDialog(null, "Mã hợp đồng không tồn tại. Mời bạn thêm hợp đồng hoặc kiểm tra lại mã hợp đồng !", "Thông báo", JOptionPane.OK_OPTION);
            } else if (m.size() == 1) {
                JOptionPane.showMessageDialog(null, "Mã hợp đồng đã có nhân viên sử dụng !", "Thông báo", JOptionPane.OK_OPTION);
            } else if (g.size() > 0) {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại , không thể thêm mới !", "Thông báo", JOptionPane.OK_OPTION);
            } else {
                Employee emp = new Employee();
                emp.setIdEmp(id);
                emp.setUsername(username);

                emp.setAddressEmp(txtAddress.getText());
                String n = encryptMD5(txtPass.getText());
                emp.setPass(n);
                emp.setNameEmp(txtName.getText());

                Date date = DateChooser.getDate();
                emp.setBirthdayEmp(date);

                Province pr = (Province) cboProvince.getSelectedItem();
                emp.setIdProvince(pr.getIdCity());

                District dis = (District) cboDistrict.getSelectedItem();
                emp.setIdDistrict(dis.getIdDistrict());

                Wards wd = (Wards) cboWards.getSelectedItem();
                emp.setIdWard(wd.getIdWard());

                Religion re = (Religion) cboReligion.getSelectedItem();
                emp.setIdReligion(re.getIdReligion());

                Ethnic eth = (Ethnic) cboEthnic.getSelectedItem();
                emp.setIdEthnic(eth.getIdEthnic());

                if (radYes.isSelected()) {
                    emp.setInsurance(true);
                } else {
                    emp.setInsurance(false);
                }
                emp.setPhoneEmp(txtPhone.getText());
                if (radMale.isSelected()) {
                    emp.setSex(true);
                } else {
                    emp.setSex(false);
                }
                emp.setIdContract(txtContract.getText());
                emp.setIdentityEmp(txtIdentity.getText());
                if (radMarry.isSelected()) {
                    emp.setStatusMarriage(0);
                } else if (radDivorce.isSelected()) {
                    emp.setStatusMarriage(1);
                } else {
                    emp.setStatusMarriage(2);
                }
                Deparment depar = (Deparment) cboDeparment.getSelectedItem();
                emp.setIdDeparment(depar.getIdDepartment());

                Position pos = (Position) cboPosition.getSelectedItem();
                emp.setIdPosition(pos.getIdPosition());

                LevelEdu edu = (LevelEdu) cboEdu.getSelectedItem();
                emp.setLevelEdu(edu.getId());
                Role role = (Role) cboRole.getSelectedItem();
                emp.setIdRole(role.getId());
                emp.setLanguageMaster(txtLanguage.getText());
                emp.setNoteEmp(txtNote.getText());
                emp.setAvarta(avt);
                 if (radWork.isSelected()) {
                    emp.setStatusEmp(true);
                } else {
                    emp.setStatusEmp(false);
                }
                try {
                    if (n.equals("") || txtName.getText().equals("") || date.equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("")
                            || txtIdentity.getText().equals("") || txtLanguage.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Bạn cần điền đầy đủ thông tin !", "Thông báo", JOptionPane.OK_OPTION);
                        if (n.equals("")) {
                            JOptionPane.showMessageDialog(null, "Bạn chưa điền mật khẩu !", "Thông báo", JOptionPane.OK_OPTION);
                        } else if (txtName.getText().equals("")) {
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
                        JOptionPane.showMessageDialog(null, "Đăng kí thành công !", "Thông báo", JOptionPane.OK_OPTION);
                    }
                    mnEmp.Add(emp);
                } catch (SQLException ex) {
                    Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        cboRole.setSelectedItem(0);
        txtUserName.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractActionPerformed

    }//GEN-LAST:event_txtContractActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image(*.png,*.jpeg)", "png", "jpeg", "jpg"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedFile.getPath());
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(avatar.getWidth(), avatar.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(newImg);
            avatar.setIcon(img);
            avatar.setText(selectedFile.getName());
            Path destination = Paths.get("src/image/" + selectedFile.getName());
            Path source = Paths.get(selectedFile.getPath());
            try {
                copyFile(source, destination);
            } catch (IOException ex) {
                Logger.getLogger(FormAddEmloyee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(avatar.getWidth());
        System.out.println(avatar.getHeight());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRoleActionPerformed

    private void txtIDEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDEmpActionPerformed
    public static void copyFile(Path source, Path destination) throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    public static String encryptMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            System.out.println("Số lượng ký tự: " + hashtext.length());
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e
            );
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.ButtonGroup GroupBtnSex;
    private javax.swing.ButtonGroup GroupStatusEmp;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnCancel;
    private javax.swing.ButtonGroup btnGroupMarry;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboDeparment;
    private javax.swing.JComboBox cboDistrict;
    private javax.swing.JComboBox cboEdu;
    private javax.swing.JComboBox cboEthnic;
    private javax.swing.JComboBox cboPosition;
    private javax.swing.JComboBox cboProvince;
    private javax.swing.JComboBox cboReligion;
    private javax.swing.JComboBox cboRole;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radDivorce;
    private javax.swing.JRadioButton radFA;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JRadioButton radMarry;
    private javax.swing.JRadioButton radNo;
    private javax.swing.JRadioButton radNoWork;
    private javax.swing.JRadioButton radWork;
    private javax.swing.JRadioButton radYes;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContract;
    private javax.swing.JFormattedTextField txtIDEmp;
    private javax.swing.JTextField txtIdentity;
    private javax.swing.JTextField txtLanguage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JFormattedTextField txtPhone;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
