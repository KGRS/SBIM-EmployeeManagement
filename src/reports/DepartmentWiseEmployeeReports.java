/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import MainFiles.IndexPage;
import static MainFiles.IndexPage.departmentWiseEmployeeReports;
import db.ConnectSql;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ravindu
 */
public class DepartmentWiseEmployeeReports extends javax.swing.JInternalFrame {

    private final String select = "--Select--";
    private final String spliter = "--";
    private final String projectPath = System.getProperty("user.dir");
    private final String menuName = "Department wise employee reports";

    /**
     * Creates new form StockReports
     */
    public DepartmentWiseEmployeeReports() {
        initComponents();
        Refresh();
        loadEmployeesToCombo();
        loadDepartmetns();

        this.setTitle(menuName);
        ImageIcon DefaultBackGround = new ImageIcon(projectPath + "/pictures/InternalFrameIcons/Reports/StockReports.jpg");
        labelIcon.setIcon(DefaultBackGround);

        ImageIcon internalBackGround = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/InternalFrames/GrayGradient.png");
        backgroundLabel.setIcon(internalBackGround);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        ButtonPreview = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cmbEmployees = new javax.swing.JComboBox();
        rBtnItemType = new javax.swing.JRadioButton();
        comboDepartment = new javax.swing.JComboBox();
        rBtnMainCategory = new javax.swing.JRadioButton();
        CheckBoxAllItems = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        rBtnItemOrderCode = new javax.swing.JRadioButton();
        rBtnItemOrderName = new javax.swing.JRadioButton();
        labelIcon = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1061, 542));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        panel1.setForeground(new java.awt.Color(255, 255, 255));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setMnemonic('d');
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        panel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 80, -1));

        btnExit.setMnemonic('e');
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        btnExit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExitKeyPressed(evt);
            }
        });
        panel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, 80, -1));

        ButtonPreview.setText("Preview");
        ButtonPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPreviewActionPerformed(evt);
            }
        });
        panel1.add(ButtonPreview, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 470, 80, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbEmployees.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        cmbEmployees.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbEmployeesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbEmployees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbEmployeesKeyPressed(evt);
            }
        });
        jPanel1.add(cmbEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 280, 20));

        rBtnItemType.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtnItemType);
        rBtnItemType.setForeground(new java.awt.Color(102, 102, 102));
        rBtnItemType.setText("Department");
        rBtnItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnItemTypeActionPerformed(evt);
            }
        });
        jPanel1.add(rBtnItemType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, -1));

        comboDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        comboDepartment.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboDepartmentPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboDepartment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboDepartmentKeyPressed(evt);
            }
        });
        jPanel1.add(comboDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 280, 20));

        rBtnMainCategory.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtnMainCategory);
        rBtnMainCategory.setForeground(new java.awt.Color(102, 102, 102));
        rBtnMainCategory.setText("Employee");
        rBtnMainCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnMainCategoryActionPerformed(evt);
            }
        });
        jPanel1.add(rBtnMainCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, -1));

        CheckBoxAllItems.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxAllItems.setForeground(new java.awt.Color(102, 102, 102));
        CheckBoxAllItems.setText("All items");
        CheckBoxAllItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxAllItemsActionPerformed(evt);
            }
        });
        jPanel1.add(CheckBoxAllItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, -1));

        panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 490, 430));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(480, 380));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rBtnItemOrderCode.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rBtnItemOrderCode);
        rBtnItemOrderCode.setForeground(new java.awt.Color(102, 102, 102));
        rBtnItemOrderCode.setText("Total raw item wastage - Employee wise");
        rBtnItemOrderCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnItemOrderCodeActionPerformed(evt);
            }
        });
        jPanel2.add(rBtnItemOrderCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 360, -1));

        rBtnItemOrderName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rBtnItemOrderName);
        rBtnItemOrderName.setForeground(new java.awt.Color(102, 102, 102));
        rBtnItemOrderName.setText("Total raw item wastage - Department wise");
        rBtnItemOrderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnItemOrderNameActionPerformed(evt);
            }
        });
        jPanel2.add(rBtnItemOrderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 360, -1));
        jPanel2.add(labelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 440, 290));

        panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 480, 430));
        panel1.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1020, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadEmployeesToCombo() {
        try {
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select FIRST_NAME, SUR_NAME, EMPLOYEE_CODE From Employees order by FIRST_NAME";
            ResultSet rset = stmt.executeQuery(query);

            cmbEmployees.removeAllItems();
            cmbEmployees.insertItemAt("--Select--", 0);
            int position = 1;
            if (rset.next()) {
                do {
                    cmbEmployees.insertItemAt(rset.getString("FIRST_NAME") + "--" + rset.getString("SUR_NAME") + "--" + rset.getString("EMPLOYEE_CODE"), position); // 
                    position++;
                } while (rset.next());
            }
            cmbEmployees.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", ERROR);
        }
    }

    private void loadDepartmetns() {
        try {
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select DepartmentCode, DepartmentName From Departments order by DepartmentName";
            ResultSet rset = stmt.executeQuery(query);

            comboDepartment.removeAllItems();
            comboDepartment.insertItemAt(select, 0);
            int position = 1;
            if (rset.next()) {
                do {
                    comboDepartment.insertItemAt(rset.getString("DepartmentName") + spliter + rset.getString("DepartmentCode"), position); // 
                    position++;
                } while (rset.next());
            }
            comboDepartment.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void Refresh() {
        cmbEmployees.setSelectedItem(select);
        comboDepartment.setSelectedItem(select);

        CheckBoxAllItems.setSelected(true);
        CheckBoxAllItems.setEnabled(true);

        rBtnMainCategory.setEnabled(false);
        rBtnItemType.setEnabled(false);

        cmbEmployees.setEnabled(false);
        comboDepartment.setEnabled(false);

        buttonGroup1.clearSelection();
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            exit();
        }
    }//GEN-LAST:event_btnExitKeyPressed

    private void exit() {
        if (departmentWiseEmployeeReports != null) {
            departmentWiseEmployeeReports = null;
        }
        this.dispose();
    }

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt) || evt.isControlDown()) {
            Refresh();
        }
    }//GEN-LAST:event_panel1MouseClicked

    private void cmbEmployeesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbEmployeesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmployeesPopupMenuWillBecomeInvisible

    private void cmbEmployeesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbEmployeesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmployeesKeyPressed

    private void rBtnItemOrderCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnItemOrderCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnItemOrderCodeActionPerformed

    private void rBtnItemOrderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnItemOrderNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnItemOrderNameActionPerformed

    private void rBtnItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnItemTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnItemTypeActionPerformed

    private void comboDepartmentPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboDepartmentPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepartmentPopupMenuWillBecomeInvisible

    private void comboDepartmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboDepartmentKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepartmentKeyPressed

    private void rBtnMainCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnMainCategoryActionPerformed
        RefreshCombo();
        CheckBoxAllItems.setSelected(false);
        CheckBoxAllItems.setEnabled(false);
    }//GEN-LAST:event_rBtnMainCategoryActionPerformed

    private void CheckBoxAllItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxAllItemsActionPerformed
        if (CheckBoxAllItems.isSelected()) {
            cmbEmployees.setSelectedItem(select);
            comboDepartment.setSelectedItem(select);

            cmbEmployees.setEnabled(false);
            comboDepartment.setEnabled(false);

//            rBtnMainCategory.setSelected(false);
            rBtnMainCategory.setEnabled(false);
            rBtnItemType.setEnabled(false);

        } else if (!CheckBoxAllItems.isSelected()) {
            cmbEmployees.setSelectedItem(select);
            comboDepartment.setSelectedItem(select);

            cmbEmployees.setEnabled(true);
            comboDepartment.setEnabled(true);
            rBtnMainCategory.setEnabled(true);
            rBtnItemType.setEnabled(true);

        }
    }//GEN-LAST:event_CheckBoxAllItemsActionPerformed

    private void RefreshCombo() {
        cmbEmployees.setSelectedItem(select);
        comboDepartment.setSelectedItem(select);
    }

    private void ButtonPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPreviewActionPerformed
//        if (!rBtnItemOrderName.isSelected() || !rBtnItemOrderCode.isSelected() || !rBtnItemMinium.isSelected() || !rBtnItemMaximum.isSelected() || !rBtnItemZeroQtyName.isSelected() || !rBtnItemZeroQtyCode.isSelected() || !rBtnItemNotVisible.isSelected()) {
//            JOptionPane.showMessageDialog(this, "please select a report.", "Not seleted", JOptionPane.OK_OPTION);
//        } else 
        if (rBtnItemOrderName.isSelected() || rBtnItemOrderCode.isSelected()) {
            PrintStockReport();
        }
    }//GEN-LAST:event_ButtonPreviewActionPerformed

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        departmentWiseEmployeeReports.toFront();
    }//GEN-LAST:event_formInternalFrameIconified

    private void PrintStockReport() {
        Connection sqlcon = ConnectSql.conn;
//        String Date = IndexPage.LabelDate.getText();
        String departmentID[] = comboDepartment.getSelectedItem().toString().split(spliter);
        String PathToLogo = projectPath + "/pictures/Logo/ClientLogo.jpg";
        if (rBtnItemOrderName.isSelected()) {
            try {
                Map map = new HashMap();
                map.put("User", IndexPage.user.trim());
                map.put("Logo", PathToLogo);
                map.put("Code", departmentID[1]);

                String Report = "Item list order by name - Department wise.jrxml";
                JasperDesign jasperdesigns = JRXmlLoader.load(projectPath + "/Reports/Stock Reports/All items/" + Report);
                JasperReport jasperreport = JasperCompileManager.compileReport(jasperdesigns);
                JasperPrint jasperprint = JasperFillManager.fillReport(jasperreport, map, sqlcon);
                JasperViewer.viewReport(jasperprint, false);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (rBtnItemOrderCode.isSelected()) {
            try {
                Map map = new HashMap();
                map.put("User", IndexPage.user.trim());
                map.put("Logo", PathToLogo);
                map.put("Code", departmentID[1]);

                String Report = "Item list order by code - Department wise.jrxml";
                JasperDesign jasperdesigns = JRXmlLoader.load(projectPath + "/Reports/Stock Reports/All items/" + Report);
                JasperReport jasperreport = JasperCompileManager.compileReport(jasperdesigns);
                JasperPrint jasperprint = JasperFillManager.fillReport(jasperreport, map, sqlcon);
                JasperViewer.viewReport(jasperprint, false);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonPreview;
    private javax.swing.JCheckBox CheckBoxAllItems;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cmbEmployees;
    private javax.swing.JComboBox comboDepartment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelIcon;
    private javax.swing.JPanel panel1;
    private javax.swing.JRadioButton rBtnItemOrderCode;
    private javax.swing.JRadioButton rBtnItemOrderName;
    private javax.swing.JRadioButton rBtnItemType;
    private javax.swing.JRadioButton rBtnMainCategory;
    // End of variables declaration//GEN-END:variables
}
