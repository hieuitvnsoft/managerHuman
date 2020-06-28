/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlns_da;

import Entity.Employee;
import Entity.EmployeeRe;
import Mannager.ManagerEmployee;
import Mannager.ManagerEmployeeRe;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THUY
 */
public class FormStatusEmp extends javax.swing.JInternalFrame {

    DefaultTableModel modeltblEmp;
    DefaultTableModel modeltblEmpRe;
    ManagerEmployee mnEmp = new ManagerEmployee();
    ManagerEmployeeRe mnEmpRe = new ManagerEmployeeRe();
    MainFrame parent;

    IEmployeDetailBreak ied;

    public interface IEmployeDetailBreak {

        public void openDetailbr(String id);

        public void openDetailbrre(String id);
    }

    /**
     * Creates new form FormStatusEmp
     */
    public FormStatusEmp() {
        initComponents();
        addColumntblEmp();
        addColumntblEmpRe();
        try {
            loadEmp();
            loadEmployeeRe();
        } catch (SQLException ex) {
            Logger.getLogger(FormStatusEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FormStatusEmp(MainFrame parent) {
        this.ied = parent;
        initComponents();
        addColumntblEmp();
        addColumntblEmpRe();
        try {
            loadEmp();
            loadEmployeeRe();
        } catch (SQLException ex) {
            Logger.getLogger(FormStatusEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addColumntblEmp() {
        modeltblEmp = new DefaultTableModel();
        modeltblEmp.addColumn("Mã nhân viên");
        modeltblEmp.addColumn("Họ tên");
        modeltblEmp.addColumn("Giới tính");
        modeltblEmp.addColumn("Số điện thoại");
        modeltblEmp.addColumn("Địa chỉ");
        modeltblEmp.addColumn("Phòng ban");
        modeltblEmp.addColumn("Trạng thái");
        modeltblEmp.addColumn("Ghi chú");
        tblEmp.setModel(modeltblEmp);
    }

    private void addColumntblEmpRe() {
        modeltblEmpRe = new DefaultTableModel();
        modeltblEmpRe.addColumn("Mã nhân viên");
        modeltblEmpRe.addColumn("Họ tên");
        modeltblEmpRe.addColumn("Giới tính");
        modeltblEmpRe.addColumn("Số điện thoại");
        modeltblEmpRe.addColumn("Địa chỉ");
        modeltblEmpRe.addColumn("Phòng ban");
        modeltblEmpRe.addColumn("Ghi chú");
        tblEmpRe.setModel(modeltblEmpRe);
    }

    private void loadEmp() throws SQLException {
        Vector<Employee> lstEmp = mnEmp.getStatusEmp();
        for (int i = 0; i < lstEmp.size(); i++) {
            Vector<String> row = new Vector<>();
            Employee empAt = lstEmp.elementAt(i);
            String id = empAt.getIdEmp();
            String name = empAt.getNameEmp();                        //Tên nhân viên
            boolean sex = empAt.isSex();                             //Giới tính
            String phone = empAt.getPhoneEmp();                     //sđt              
            String address = empAt.getAddressEmp();                  //Địa chỉ                       
            String deparment = empAt.getIdDeparment();              //Phòng ban
            String note = empAt.getNoteEmp();
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
            row.add(note);
            modeltblEmp.addRow(row);
        }
    }

    private void loadEmployeeRe() throws SQLException {
        Vector<EmployeeRe> lstEmpRe = mnEmpRe.getStatusEmpRe();
        for (int i = 0; i < lstEmpRe.size(); i++) {
            Vector<String> row = new Vector<>();
            EmployeeRe empReAt = lstEmpRe.elementAt(i);
            String id = empReAt.getIdEmpRe();                            //Mã nhân viên
            String name = empReAt.getNameEmpRe();                        //Tên nhân viên
            boolean sex = empReAt.isSexRe();                             //Giới tính
            String phone = empReAt.getPhoneEmpRe();                     //sđt              
            String address = empReAt.getAddressEmpRe();                  //Địa chỉ                       
            String deparment = empReAt.getIdDepartmentRe();              //Phòng ban               
            String note = empReAt.getNoteEmpRe();                        //Ghi chú
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
            row.add(note);
            modeltblEmpRe.addRow(row);
        }
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
        btnView = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        btnView2 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpRe = new javax.swing.JTable();

        btnView.setText("Thay đổi thông tin nhân viên");
        btnView.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                btnViewComponentMoved(evt);
            }
        });
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPopupMenu1.add(btnView);

        btnView2.setText("Thay đổi thông tin nhân viên");
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(btnView2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Danh sách nhân viên nghỉ làm");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEmpMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân viên chính thức", jPanel1);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEmpReMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpRe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhân viên thực tập", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnViewComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewComponentMoved

    private void tblEmpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            int row = evt.getY() / tblEmp.getRowHeight();
            if (row > -1 && row < tblEmp.getColumnCount()) {
                tblEmp.setRowSelectionInterval(row, row);

            } else {
                tblEmp.clearSelection();
            }
        }
    }//GEN-LAST:event_tblEmpMouseReleased

    private void tblEmpReMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpReMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
            jPopupMenu2.show(evt.getComponent(), evt.getX(), evt.getY());
            int row = evt.getY() / tblEmpRe.getRowHeight();
            if (row > -1 && row < tblEmpRe.getColumnCount()) {
                tblEmpRe.setRowSelectionInterval(row, row);

            } else {
                tblEmpRe.clearSelection();
            }
        }
    }//GEN-LAST:event_tblEmpReMouseReleased

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int r = tblEmp.getSelectedRow();
        String idre = (String) tblEmp.getValueAt(r, 0);
        System.out.println(idre);
        this.ied.openDetailbr(idre);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView2ActionPerformed
        int r = tblEmpRe.getSelectedRow();
        String idre = (String) tblEmpRe.getValueAt(r, 0);
        System.out.println(idre);
        this.ied.openDetailbrre(idre);
    }//GEN-LAST:event_btnView2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnView;
    private javax.swing.JMenuItem btnView2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmp;
    private javax.swing.JTable tblEmpRe;
    // End of variables declaration//GEN-END:variables
}
