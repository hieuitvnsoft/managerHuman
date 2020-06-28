/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlns_da;

import Entity.Deparment;
import Entity.EmployeeRe;
import Mannager.ManagerDeparment;
import Mannager.ManagerEmployee;
import Mannager.ManagerEmployeeRe;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author THUY
 */
public class FormEmployeeRe extends javax.swing.JInternalFrame {

    ManagerEmployeeRe managerEmpRe = new ManagerEmployeeRe();
    DefaultTableModel modelTable = new DefaultTableModel();
    DefaultComboBoxModel<Deparment> modelDeparment;
    ManagerDeparment mnDeparment = new ManagerDeparment();
    IEmployeDetailRE ied;
    MainFrame parent;

    public interface IEmployeDetailRE {

        public void openDetailre(String id);
    }

    /**
     * Creates new form FromEmployeeRe
     */
    public FormEmployeeRe() {

        initComponents();
        addColumn();
        try {
            loadEmployeeRe();
            loadDeparment();
        } catch (SQLException ex) {
            Logger.getLogger(FormEmployeeRe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public FormEmployeeRe(MainFrame parent) {

        try {

            initComponents();
            this.ied = parent;
            addColumn();
            try {

                loadDeparment();
            } catch (SQLException ex) {
                Logger.getLogger(FormEmployeeRe.class.getName()).log(Level.SEVERE, null, ex);
            }
            loadEmployeeRe();
        } catch (SQLException ex) {
            Logger.getLogger(FormEmployeeRe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public interface IEmp {
//
//        public void ListEmp(EmployeeRe k);
//
//    }
    private void addColumn() {
        modelTable = new DefaultTableModel();
        modelTable.addColumn("Mã nhân viên");
        modelTable.addColumn("Họ tên");
        modelTable.addColumn("Giới tính");
        modelTable.addColumn("Số điện thoại");
        modelTable.addColumn("Địa chỉ");
        modelTable.addColumn("Phòng ban");
        modelTable.addColumn("Chức vụ");
        modelTable.addColumn("Ghi chú");
        tblEmpRe.setModel(modelTable);
    }

    private void loadEmployeeRe() throws SQLException {
        Vector<EmployeeRe> lstEmpRe = managerEmpRe.getEmpRe();
        for (int i = 0; i < lstEmpRe.size(); i++) {
            Vector<String> row = new Vector<>();
            EmployeeRe empReAt = lstEmpRe.elementAt(i);
            String id = empReAt.getIdEmpRe();                            //Mã nhân viên
            String name = empReAt.getNameEmpRe();                        //Tên nhân viên
            boolean sex = empReAt.isSexRe();                             //Giới tính
            String phone = empReAt.getPhoneEmpRe();                     //sđt              
            String address = empReAt.getAddressEmpRe();                  //Địa chỉ                       
            String deparment = empReAt.getIdDepartmentRe();              //Phòng ban
            String position = empReAt.getIdPositionRe();                 //Chức vụ
            String note = empReAt.getNoteEmpRe();                        //Ghi chú
            //Thêm dữ liệu từ form vào CSDL
            row.add(id);
            row.add(name);
            if (sex == true) {
                row.add("Nam");
            } else {
                row.add("Nữ");
            }
            row.add(phone);
            row.add(address);
            row.add(deparment);
            row.add(position);
            row.add(note);
            modelTable.addRow(row);
        }
    }

    private void loadDeparment() throws SQLException {
        Vector<Deparment> lstDeparment = mnDeparment.getAllDeparment();
        modelDeparment = new DefaultComboBoxModel<>(lstDeparment);
        cboDeparmentRe.setModel(modelDeparment);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        MenuView = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnSearchEmpRe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemRe = new javax.swing.JTextField();
        cboDeparmentRe = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpRe = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        MenuView.setText("Xem thông tin chi tiết");
        MenuView.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                MenuViewAncestorRemoved(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        MenuView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuViewActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MenuView);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Danh sách nhân viên thử việc");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearchEmpRe.setText("Tìm kiếm");
        btnSearchEmpRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEmpReActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên nhân viên: ");

        cboDeparmentRe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDeparmentRe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDeparmentReItemStateChanged(evt);
            }
        });
        cboDeparmentRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDeparmentReActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiemRe, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboDeparmentRe, 0, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchEmpRe)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchEmpRe)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiemRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDeparmentRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblEmpRe.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmpRe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpReMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEmpReMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpRe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnDelete.setText("Xóa");

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchEmpReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEmpReActionPerformed
        try {
            String name = txtTimKiemRe.getText();
            Deparment dp = (Deparment) cboDeparmentRe.getSelectedItem();
            String iddp = dp.getIdDepartment();
            ManagerEmployee mn = new ManagerEmployee();
            Vector<ManagerEmployee.Empx> ls = new Vector<>();
            ls = mn.search(name, iddp);
            while (modelTable.getRowCount() > 0) {
                modelTable.removeRow(0);
            }
            for (int i = 0; i < ls.size(); i++) {
                ManagerEmployee.Empx elementAt = ls.elementAt(i);
                Vector<String> ep = new Vector<>();
                ep.add(elementAt.getId());
                ep.add(elementAt.getName());
                if (elementAt.isSex() == true) {
                    ep.add("Nam");
                } else {
                    ep.add("Nữ");
                }
                ep.add(elementAt.getPhone());
                ep.add(elementAt.getAddress());
                ep.add(elementAt.getDepar());
                ep.add(elementAt.getPos());
                ep.add(elementAt.getNote());
                modelTable.addRow(ep);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormEmployeeRe.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchEmpReActionPerformed

    private void cboDeparmentReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDeparmentReActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDeparmentReActionPerformed

    private void tblEmpReMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpReMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEmpReMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void MenuViewAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MenuViewAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuViewAncestorRemoved

    private void MenuViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuViewActionPerformed
        // TODO add your handling code here:
        int r = tblEmpRe.getSelectedRow();
        String idre = (String) tblEmpRe.getValueAt(r, 0);
        System.out.println(idre);
        this.ied.openDetailre(idre);
    }//GEN-LAST:event_MenuViewActionPerformed

    private void tblEmpReMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpReMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            int row = evt.getY() / tblEmpRe.getRowHeight();
            if (row > -1 && row < tblEmpRe.getColumnCount()) {
                tblEmpRe.setRowSelectionInterval(row, row);

            } else {
                tblEmpRe.clearSelection();
            }
        }
    }//GEN-LAST:event_tblEmpReMouseReleased

    private void cboDeparmentReItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDeparmentReItemStateChanged
        // TODO add your handling code here:
        Deparment dp = (Deparment) cboDeparmentRe.getSelectedItem();
        String iddp = dp.getIdDepartment();
        ManagerEmployeeRe mn = new ManagerEmployeeRe();
        Vector<ManagerEmployeeRe.Empx> ls = new Vector<>();
        try {
            ls = mn.searchDeparRe(iddp);
        } catch (SQLException ex) {
            Logger.getLogger(FormEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (modelTable.getRowCount() > 0) {
            modelTable.removeRow(0);
        }
        for (int i = 0; i < ls.size(); i++) {
            ManagerEmployeeRe.Empx elementAt = ls.elementAt(i);
            Vector<String> ep = new Vector<>();
            ep.add(elementAt.getId());
            ep.add(elementAt.getName());
            if (elementAt.isSex() == true) {
                ep.add("Nam");
            } else {
                ep.add("Nữ");
            }
            ep.add(elementAt.getPhone());
            ep.add(elementAt.getAddress());
            ep.add(elementAt.getDepar());
            ep.add(elementAt.getPos());
            ep.add(elementAt.getNote());
            modelTable.addRow(ep);
        }
    }//GEN-LAST:event_cboDeparmentReItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuView;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearchEmpRe;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboDeparmentRe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEmpRe;
    private javax.swing.JTextField txtTimKiemRe;
    // End of variables declaration//GEN-END:variables
}
