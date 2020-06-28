/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhHieu
 */
public class Messager {

    public Messager() {
    }

    public void insertshowSuccess() {
        JOptionPane.showMessageDialog(null, "Thêm mới thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/ss.png"));
    }

    public void upshowSuccess() {
        JOptionPane.showMessageDialog(null, "Sửa  thành công thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/ss.png"));
    }

    public void insertshowFail() {
        JOptionPane.showMessageDialog(null, "Thêm mới không thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/k.png"));
    }

    public void upshowFail() {
        JOptionPane.showMessageDialog(null, "Sửa không thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/k.png"));
    }

    public void deleteshowSuccess() {
        JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/ss.png"));
    }

    public void deleteshowFail() {
        JOptionPane.showMessageDialog(null, "Xóa không thành công", "Thông báo", JOptionPane.OK_OPTION, new ImageIcon("src/image/k.png"));
    }
}
