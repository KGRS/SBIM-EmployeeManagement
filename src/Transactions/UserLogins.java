/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transactions;

import static MainFiles.IndexPage.userLogins;
import db.ConnectSql;
import functions.ValidateFields;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class UserLogins extends javax.swing.JInternalFrame {

    private final DefaultTableModel model_TableEmployee;
    private final String menuName = "User login";
    private final String select = "--Select--";
    private final String spliter = "--";
    String departmentCode, subDepartmentCode, userName, designationCode, designationName, empCode, empFirstName, empCallingName, password, retypePassword, oldPassword, typedOldpassword;
    int rowCountOfTableEmployee, selectedRowOfTableEmployee, selectedRowCountOfTableEmployee;

    /**
     * Creates new form UserLogins
     */
    public UserLogins() {
        initComponents();

        buttonGroup1.add(rBtCode);
        buttonGroup1.add(rBtnName);
        rBtCode.setSelected(true);
        txtSearchStudent.requestFocus();
        model_TableEmployee = (DefaultTableModel) tableEmployee.getModel();
        panel1.setToolTipText("Press right mouse click to refresh.");
        this.setTitle(menuName);

        loadDepartmentsToCombo();
    }

    private void loadDepartmentsToCombo() {
        try {
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select DepartmentCode, DepartmentName From Departments order by DepartmentName";
            ResultSet rset = stmt.executeQuery(query);

            comboDepartment.removeAllItems();
            comboDepartment.insertItemAt("--Select--", 0);
            int position = 1;
            if (rset.next()) {
                do {
                    comboDepartment.insertItemAt(rset.getString("DepartmentName") + "--" + rset.getString("DepartmentCode"), position); // 
                    position++;
                } while (rset.next());
            }
            comboDepartment.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", ERROR);
        }
    }

    private void loadSubDepartmentsToCombo() {
        try {
            String departmentCodeByArray[] = comboDepartment.getSelectedItem().toString().split(spliter);
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select SUB_DEPARTMENT_CODE, SUB_DEPARTMENT_NAME From SubDepartments WHERE DepartmentCode = '" + departmentCodeByArray[1] + "' order by SUB_DEPARTMENT_NAME";
            ResultSet rset = stmt.executeQuery(query);

            comboSubDepartment.removeAllItems();
            comboSubDepartment.insertItemAt("--Select--", 0);
            int position = 1;
            if (rset.next()) {
                do {
                    comboSubDepartment.insertItemAt(rset.getString("SUB_DEPARTMENT_NAME") + "--" + rset.getString("SUB_DEPARTMENT_CODE"), position); // 
                    position++;
                } while (rset.next());
            }
            comboSubDepartment.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", ERROR);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        rBtCode = new javax.swing.JRadioButton();
        rBtnName = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        txtSearchStudent = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_subAccount1 = new javax.swing.JLabel();
        lbl_subAccount2 = new javax.swing.JLabel();
        lbl_subAccount3 = new javax.swing.JLabel();
        lbl_subAccount4 = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        textNewPassword = new javax.swing.JPasswordField();
        textRetypeNewPassword = new javax.swing.JPasswordField();
        lbl_accountType1 = new javax.swing.JLabel();
        comboDepartment = new javax.swing.JComboBox();
        lbl_subAccount5 = new javax.swing.JLabel();
        comboSubDepartment = new javax.swing.JComboBox();
        lbl_subAccount6 = new javax.swing.JLabel();
        textNumberOfEmpAtSubDepartment = new javax.swing.JTextField();
        textOldPassword = new javax.swing.JPasswordField();
        buttonRefresh = new javax.swing.JButton();
        buttonView = new javax.swing.JButton();

        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1024, 560));
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

        btnSave.setMnemonic('s');
        btnSave.setText("Save");
        btnSave.setActionCommand("Delete");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 80, -1));

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
        panel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 80, -1));

        rBtCode.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtCode);
        rBtCode.setText("Code");
        rBtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtCodeActionPerformed(evt);
            }
        });
        panel1.add(rBtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 60, -1));

        rBtnName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtnName);
        rBtnName.setText("Name");
        rBtnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnNameActionPerformed(evt);
            }
        });
        rBtnName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rBtnNameKeyPressed(evt);
            }
        });
        panel1.add(rBtnName, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 60, -1));

        tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee code", "First name", "Name with initials", "Call name", "User name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmployee.getTableHeader().setReorderingAllowed(false);
        tableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmployee);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 970, 300));

        txtSearchStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStudentKeyReleased(evt);
            }
        });
        panel1.add(txtSearchStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 230, -1));
        panel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 260, 10));

        lbl_subAccount1.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount1.setText("Retype new password");
        panel1.add(lbl_subAccount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 110, 20));

        lbl_subAccount2.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount2.setText("Search employee by");
        panel1.add(lbl_subAccount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 110, 20));

        lbl_subAccount3.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount3.setText("User name");
        panel1.add(lbl_subAccount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 70, 20));

        lbl_subAccount4.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount4.setText("Old password");
        panel1.add(lbl_subAccount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, 20));

        textUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textUserNameKeyReleased(evt);
            }
        });
        panel1.add(textUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 200, -1));

        textNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textNewPasswordKeyReleased(evt);
            }
        });
        panel1.add(textNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 200, -1));

        textRetypeNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textRetypeNewPasswordKeyReleased(evt);
            }
        });
        panel1.add(textRetypeNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 200, -1));

        lbl_accountType1.setForeground(new java.awt.Color(102, 102, 102));
        lbl_accountType1.setText("Department *");
        panel1.add(lbl_accountType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 20));

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
        panel1.add(comboDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 290, 20));

        lbl_subAccount5.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount5.setText("Sub department *");
        panel1.add(lbl_subAccount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 20));

        comboSubDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        panel1.add(comboSubDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 290, -1));

        lbl_subAccount6.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount6.setText("New password");
        panel1.add(lbl_subAccount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 110, 20));

        textNumberOfEmpAtSubDepartment.setEditable(false);
        textNumberOfEmpAtSubDepartment.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textNumberOfEmpAtSubDepartment.setText("0");
        panel1.add(textNumberOfEmpAtSubDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 80, -1));
        panel1.add(textOldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 200, -1));

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        panel1.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 80, -1));

        buttonView.setText("View");
        buttonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewActionPerformed(evt);
            }
        });
        panel1.add(buttonView, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 60, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        selectedRowCountOfTableEmployee = tableEmployee.getSelectedRowCount();
        if (selectedRowCountOfTableEmployee == 1) {
            password = textNewPassword.getText();
            retypePassword = textRetypeNewPassword.getText();
            typedOldpassword = textOldPassword.getText();
            if (!password.isEmpty() && !retypePassword.isEmpty() && !typedOldpassword.isEmpty()) {
                if (password.equals(retypePassword)) {
                    try {
                        selectedRowOfTableEmployee = tableEmployee.getSelectedRow();
                        empCode = tableEmployee.getValueAt(selectedRowOfTableEmployee, 0).toString();
                        ResultSet reset;
                        Statement stmt;
                        String query;
                        query = "SELECT [USER_OLD_PASSWORD]\n"
                                + "      ,[USER_NAME]\n"
                                + "  FROM [UnAndPw] WHERE EMPLOYEE_CODE = '" + empCode + "'";
                        stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        reset = stmt.executeQuery(query);

                        if (reset.next()) {
                            oldPassword = reset.getString("USER_OLD_PASSWORD");
                            if (oldPassword.equals(typedOldpassword)) {
                                int x = JOptionPane.showConfirmDialog(this, "Are you sure to change the password of '" + empCode + "'?", "Change password?", JOptionPane.YES_NO_OPTION);
                                if (x == JOptionPane.YES_OPTION) {
                                    saveData(password, oldPassword);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Old password is not correct.", "Not correct.", JOptionPane.OK_OPTION);
                                textOldPassword.requestFocus();
                            }
                        }
                        reset.close();
                        stmt.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(this, "Please contact for support.");
                    }
                } else if (!password.equals(retypePassword)) {
                    JOptionPane.showMessageDialog(this, "Retyping of password is not correct.\nPlease type again.", "Not correct", JOptionPane.OK_OPTION);
                }
            } else if (password.isEmpty() || retypePassword.isEmpty() || typedOldpassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the password fields.", "Empty fields", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void saveData(String password, String oldPassword) {
        try {
            selectedRowCountOfTableEmployee = tableEmployee.getSelectedRow();
            java.sql.Statement stmtItems = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            empCode = tableEmployee.getValueAt(selectedRowCountOfTableEmployee, 0).toString();

            String ItemInsertQuery = "UPDATE [UnAndPw] SET\n"
                    + "           [USER_PASSWORD] = '" + password + "'\n"
                    + "           ,[USER_OLD_PASSWORD] = '" + oldPassword + "'\n"
                    + "     WHERE EMPLOYEE_CODE = '" + empCode + "'";
            stmtItems.execute(ItemInsertQuery);

            JOptionPane.showMessageDialog(this, "'" + menuName + "' is updated.");
            Refresh();
            stmtItems.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            exit();
        }
    }//GEN-LAST:event_btnExitKeyPressed

    private void rBtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtCodeActionPerformed
        if (rBtCode.isSelected()) {
            txtSearchStudent.requestFocus();
            txtSearchStudent.selectAll();
        }
    }//GEN-LAST:event_rBtCodeActionPerformed

    private void rBtnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnNameActionPerformed
        if (rBtnName.isSelected()) {
            txtSearchStudent.requestFocus();
            txtSearchStudent.selectAll();
        }
    }//GEN-LAST:event_rBtnNameActionPerformed

    private void rBtnNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rBtnNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            rBtCode.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            rBtnName.setSelected(true);
            btnSave.requestFocus();
        }
    }//GEN-LAST:event_rBtnNameKeyPressed

    private void tableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseClicked
        UNLoadAtTableInMouseClick();
//        tableViewStaffMem.remove
    }//GEN-LAST:event_tableEmployeeMouseClicked

    private void UNLoadAtTableInMouseClick() {
        selectedRowCountOfTableEmployee = tableEmployee.getSelectedRowCount();
        if (selectedRowCountOfTableEmployee == 1) {
            selectedRowOfTableEmployee = tableEmployee.getSelectedRow();
            userName = tableEmployee.getValueAt(selectedRowOfTableEmployee, 4).toString();
            textUserName.setText(userName);
            textNewPassword.requestFocus();
        }
    }


    private void txtSearchStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStudentKeyReleased
        if (rBtCode.isSelected()) {
//            SearchStudentByCode(txtSearchStudent.getText());
        } else if (rBtnName.isSelected()) {
//            SearchStudentByName(txtSearchStudent.getText());
        }
    }//GEN-LAST:event_txtSearchStudentKeyReleased

    private void SearchStudentByCode(String studentCode) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            model_TableEmployee.setRowCount(rowCount);

            if (!studentCode.equals("")) {
                query = "SELECT STUDENT_ID, STUDENT_FIRST_NAME, student_batch_BATCH_WITH_DEPARTMENT_CODE FROM students WHERE STUDENT_ID LIKE '" + studentCode + "%'";
            } else {
                query = "SELECT STUDENT_ID, STUDENT_FIRST_NAME, student_batch_BATCH_WITH_DEPARTMENT_CODE FROM students WHERE STUDENT_ID LIKE '" + studentCode + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_TableEmployee.addRow(new Object[model_TableEmployee.getColumnCount()]);
                tableEmployee.setValueAt(reset.getString("STUDENT_ID"), rowCount, 0);
                tableEmployee.setValueAt(reset.getString("STUDENT_FIRST_NAME"), rowCount, 1);
                tableEmployee.setValueAt(reset.getString("student_batch_BATCH_WITH_DEPARTMENT_CODE"), rowCount, 2);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void SearchStudentByName(String studentName) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            model_TableEmployee.setRowCount(rowCount);

            if (!studentName.equals("")) {
                query = "SELECT STUDENT_ID, STUDENT_FIRST_NAME, student_batch_BATCH_WITH_DEPARTMENT_CODE FROM students WHERE STUDENT_FIRST_NAME LIKE '%" + studentName + "%'";
            } else {
                query = "SELECT STUDENT_ID, STUDENT_FIRST_NAME, student_batch_BATCH_WITH_DEPARTMENT_CODE FROM students WHERE STUDENT_FIRST_NAME LIKE '%" + studentName + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_TableEmployee.addRow(new Object[model_TableEmployee.getColumnCount()]);
                tableEmployee.setValueAt(reset.getString("STUDENT_ID"), rowCount, 0);
                tableEmployee.setValueAt(reset.getString("STUDENT_FIRST_NAME"), rowCount, 1);
                tableEmployee.setValueAt(reset.getString("student_batch_BATCH_WITH_DEPARTMENT_CODE"), rowCount, 2);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt) || evt.isControlDown()) {
            Refresh();
        }
    }//GEN-LAST:event_panel1MouseClicked

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        userLogins.toFront();
    }//GEN-LAST:event_formInternalFrameIconified

    private void textUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textUserNameKeyReleased
        ValidateFields.CheckForOtherFields(textUserName);
    }//GEN-LAST:event_textUserNameKeyReleased

    private void textNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNewPasswordKeyReleased
        ValidateFields.CheckForOtherFields(textNewPassword);
    }//GEN-LAST:event_textNewPasswordKeyReleased

    private void textRetypeNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRetypeNewPasswordKeyReleased
        ValidateFields.CheckForOtherFields(textRetypeNewPassword);
    }//GEN-LAST:event_textRetypeNewPasswordKeyReleased

    private void comboDepartmentPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboDepartmentPopupMenuWillBecomeInvisible
        String text = comboDepartment.getSelectedItem().toString();
        if (!text.equals(select)) {
            loadSubDepartmentsToCombo();
            btnSave.requestFocus();
        }
    }//GEN-LAST:event_comboDepartmentPopupMenuWillBecomeInvisible

    private void comboDepartmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboDepartmentKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = comboDepartment.getSelectedItem().toString();
            if (!text.equals(select)) {
                loadSubDepartmentsToCombo();
                btnSave.requestFocus();
            }
        }
    }//GEN-LAST:event_comboDepartmentKeyPressed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonViewActionPerformed
        subDepartmentCode = comboSubDepartment.getSelectedItem().toString();
        if (!subDepartmentCode.equals(select)) {
            String subDepartmentCodeByArray[] = comboSubDepartment.getSelectedItem().toString().split(spliter);
            loadSelectedSubDepartmentEmployeesToTable(subDepartmentCodeByArray[1]);
        } else if (subDepartmentCode.equals(select)) {
            JOptionPane.showMessageDialog(this, "Sub department is not selected.", "Not selected", JOptionPane.OK_OPTION);
            comboSubDepartment.requestFocus();
        }
    }//GEN-LAST:event_buttonViewActionPerformed

    private void loadSelectedSubDepartmentEmployeesToTable(String subDepartmentCode) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            model_TableEmployee.setRowCount(0);

            query = "SELECT\n"
                    + "     Employees.\"FIRST_NAME\" AS Employees_FIRST_NAME,\n"
                    + "     Employees.\"CALL_NAME\" AS Employees_CALL_NAME,\n"
                    + "     Employees.\"EMPLOYEE_CODE\" AS Employees_EMPLOYEE_CODE,\n"
                    + "     Employees.\"INITIALS\" AS Employees_INITIALS,\n"
                    + "     Employees.\"SUB_DEPARTMENT_CODE\" AS Employees_SUB_DEPARTMENT_CODE,\n"
                    + "     Employees.\"DepartmentCode\" AS Employees_DepartmentCode,\n"
                    + "     UnAndPw.\"USER_NAME\" AS UnAndPw_USER_NAME,\n"
                    + "     UnAndPw.\"USER_PASSWORD\" AS UnAndPw_USER_PASSWORD\n"
                    + "FROM\n"
                    + "     \"dbo\".\"UnAndPw\" UnAndPw INNER JOIN \"dbo\".\"Employees\" Employees ON UnAndPw.\"EMPLOYEE_CODE\" = Employees.\"EMPLOYEE_CODE\"\n"
                    + "WHERE Employees.\"SUB_DEPARTMENT_CODE\" = '" + subDepartmentCode + "'\n"
                    + "ORDER BY Employees.\"CALL_NAME\"";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {
                model_TableEmployee.addRow(new Object[model_TableEmployee.getColumnCount()]);
                tableEmployee.setValueAt(reset.getString("Employees_EMPLOYEE_CODE"), rowCount, 0);
                tableEmployee.setValueAt(reset.getString("Employees_FIRST_NAME"), rowCount, 1);
                tableEmployee.setValueAt(reset.getString("Employees_INITIALS"), rowCount, 2);
                tableEmployee.setValueAt(reset.getString("Employees_CALL_NAME"), rowCount, 3);
                tableEmployee.setValueAt(reset.getString("UnAndPw_USER_NAME"), rowCount, 4);
                rowCount++;
            }
            textNumberOfEmpAtSubDepartment.setText(String.valueOf(rowCount));
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void Refresh() {
        model_TableEmployee.setRowCount(0);
        textUserName.setText("");
        textNewPassword.setText("");
        textRetypeNewPassword.setText("");
        txtSearchStudent.setText("");
        textOldPassword.setText("");
        comboDepartment.setSelectedIndex(0);
        comboSubDepartment.setSelectedIndex(0);
        textNumberOfEmpAtSubDepartment.setText("0");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonView;
    private javax.swing.JComboBox comboDepartment;
    private javax.swing.JComboBox comboSubDepartment;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_accountType1;
    private javax.swing.JLabel lbl_subAccount1;
    private javax.swing.JLabel lbl_subAccount2;
    private javax.swing.JLabel lbl_subAccount3;
    private javax.swing.JLabel lbl_subAccount4;
    private javax.swing.JLabel lbl_subAccount5;
    private javax.swing.JLabel lbl_subAccount6;
    private javax.swing.JPanel panel1;
    private javax.swing.JRadioButton rBtCode;
    private javax.swing.JRadioButton rBtnName;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JPasswordField textNewPassword;
    private javax.swing.JTextField textNumberOfEmpAtSubDepartment;
    private javax.swing.JPasswordField textOldPassword;
    private javax.swing.JPasswordField textRetypeNewPassword;
    private javax.swing.JTextField textUserName;
    private javax.swing.JTextField txtSearchStudent;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        if (userLogins != null) {
            userLogins = null;
        }
        this.dispose();
    }

}
