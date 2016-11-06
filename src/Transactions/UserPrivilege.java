/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transactions;

import static MainFiles.IndexPage.userPrivilege;
import db.ConnectSql;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class UserPrivilege extends javax.swing.JInternalFrame {

    private final DefaultTableModel model_TableEmployee, model_TableModules, model_TablePrivilleges;
    private final String menuName = "User privilege";
    private final String select = "--Select--";
    private final String spliter = "--";
    String departmentCode, subDepartmentCode, userName, designationCode, designationName, empCode, empFirstName, empInitials, empCallingName, password, retypePassword, oldPassword, typedOldpassword, moduleVersion, moduleName;
    int rowCountOfTableEmployee, rowCountOfTablePrivilege, selectedRowOfTableEmployee, selectedRowCountOfTableEmployee, selectedRowCountOftablePrivilleges, selectedRowOftablePrivilleges, selectedRowCountOftableModule, selectedRowOftableModule, moduleCode;

    /**
     * Creates new form UserLogins
     */
    public UserPrivilege() {
        initComponents();
        model_TableEmployee = (DefaultTableModel) tableEmployee.getModel();
        model_TableModules = (DefaultTableModel) tableModule.getModel();
        model_TablePrivilleges = (DefaultTableModel) tablePrivilleges.getModel();
        panel1.setToolTipText("Press right mouse click to refresh.");
        this.setTitle(menuName);

        loadDepartmentsToCombo();
        loadModules();
        loadPrivillegesToTable();
    }

    private void loadModules() {
        try {
            model_TableModules.setRowCount(0);
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;

            query = "SELECT [MODULE_CODE]\n"
                    + "      ,[MODULE_NAME]\n"
                    + "      ,[VERSION]\n"
                    + "  FROM [Modules] ORDER BY MODULE_CODE";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {
                model_TableModules.addRow(new Object[model_TableModules.getColumnCount()]);
                tableModule.setValueAt(reset.getString("MODULE_CODE"), rowCount, 0);
                tableModule.setValueAt(reset.getString("MODULE_NAME"), rowCount, 1);
                tableModule.setValueAt(reset.getString("VERSION"), rowCount, 2);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        lbl_accountType1 = new javax.swing.JLabel();
        comboDepartment = new javax.swing.JComboBox();
        lbl_subAccount5 = new javax.swing.JLabel();
        comboSubDepartment = new javax.swing.JComboBox();
        textNumberOfEmpAtSubDepartment = new javax.swing.JTextField();
        buttonRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableModule = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePrivilleges = new javax.swing.JTable();
        ButtonRemoveSelected = new javax.swing.JButton();
        ButtonAddSelected = new javax.swing.JButton();
        lbl_subAccount = new javax.swing.JLabel();
        lbl_subAccount1 = new javax.swing.JLabel();
        textNumberOfEmpAtSecondTable = new javax.swing.JTextField();
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

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 620, 180));

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
        panel1.add(lbl_subAccount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 100, 20));

        comboSubDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        panel1.add(comboSubDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 280, -1));

        textNumberOfEmpAtSubDepartment.setEditable(false);
        textNumberOfEmpAtSubDepartment.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textNumberOfEmpAtSubDepartment.setText("0");
        panel1.add(textNumberOfEmpAtSubDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 80, -1));

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        panel1.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 80, -1));

        tableModule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module code", "Module name", "Version"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableModule);
        if (tableModule.getColumnModel().getColumnCount() > 0) {
            tableModule.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 330, 180));

        tablePrivilleges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee code", "First name", "Name with initials", "Call name", "User name", "Module code", "Module name", "Version"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePrivilleges);

        panel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 307, 970, 160));

        ButtonRemoveSelected.setText("Remove selected");
        ButtonRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoveSelectedActionPerformed(evt);
            }
        });
        panel1.add(ButtonRemoveSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 120, -1));

        ButtonAddSelected.setText("Add selected");
        ButtonAddSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddSelectedActionPerformed(evt);
            }
        });
        panel1.add(ButtonAddSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 130, -1));

        lbl_subAccount.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount.setText("Number of employees given privilleges");
        panel1.add(lbl_subAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 240, 20));

        lbl_subAccount1.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount1.setText("Number of employees at selected sub department");
        panel1.add(lbl_subAccount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 20));

        textNumberOfEmpAtSecondTable.setEditable(false);
        textNumberOfEmpAtSecondTable.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textNumberOfEmpAtSecondTable.setText("0");
        panel1.add(textNumberOfEmpAtSecondTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 80, -1));

        buttonView.setText("View");
        buttonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewActionPerformed(evt);
            }
        });
        panel1.add(buttonView, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 20, 130, -1));

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
        CheckBeforeSave();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void CheckBeforeSave() {
        int RowCount = tablePrivilleges.getRowCount();
        if (RowCount <= 0) {
            JOptionPane.showMessageDialog(this, "Privileges are not available at table.", "No employees", JOptionPane.OK_OPTION);
        } else if (RowCount > 0) {
            int x = JOptionPane.showConfirmDialog(this, "Are you sure to update privileges?", "Update?", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                deleteExsistsRecordsBeforeSave();
            }
        }
    }

    private void deleteExsistsRecordsBeforeSave() {
        try {
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "delete From UserPrivilegeForModules";
            stmt.execute(query);
            stmt.close();
            saveData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void saveData() {
        try {
            rowCountOfTablePrivilege = tablePrivilleges.getRowCount();
            java.sql.Statement stmtItems = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for (int i = 0; i < rowCountOfTablePrivilege; i++) {
                empCode = tablePrivilleges.getValueAt(i, 0).toString();
                moduleCode = Integer.parseInt(tablePrivilleges.getValueAt(i, 5).toString());

                String ItemInsertQuery = "INSERT INTO [UserPrivilegeForModules]\n"
                        + "           ([MODULE_CODE]\n"
                        + "           ,[EMPLOYEE_CODE])\n"
                        + "     VALUES\n"
                        + "           ('" + moduleCode + "'\n"
                        + "           ,'" + empCode + "')";
                stmtItems.execute(ItemInsertQuery);
            }
            JOptionPane.showMessageDialog(this, "'" + menuName + "' is updated.");
            Refresh();
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

    private void tableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseClicked
        UNLoadAtTableInMouseClick();
//        tableViewStaffMem.remove
    }//GEN-LAST:event_tableEmployeeMouseClicked

    private void UNLoadAtTableInMouseClick() {
        selectedRowCountOfTableEmployee = tableEmployee.getSelectedRowCount();
        if (selectedRowCountOfTableEmployee == 1) {
            selectedRowOfTableEmployee = tableEmployee.getSelectedRow();
            userName = tableEmployee.getValueAt(selectedRowOfTableEmployee, 4).toString();
        }
    }

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt) || evt.isControlDown()) {
            Refresh();
        }
    }//GEN-LAST:event_panel1MouseClicked

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        userPrivilege.toFront();
    }//GEN-LAST:event_formInternalFrameIconified

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

    private void loadPrivillegesToTable() {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            model_TablePrivilleges.setRowCount(0);

            query = "SELECT\n"
                    + "     Employees.\"FIRST_NAME\" AS Employees_FIRST_NAME,\n"
                    + "     Employees.\"CALL_NAME\" AS Employees_CALL_NAME,\n"
                    + "     Employees.\"INITIALS\" AS Employees_INITIALS,\n"
                    + "     UnAndPw.\"USER_NAME\" AS UnAndPw_USER_NAME,\n"
                    + "     UserPrivilegeForModules.\"MODULE_CODE\" AS UserPrivilegeForModules_MODULE_CODE,\n"
                    + "     UserPrivilegeForModules.\"EMPLOYEE_CODE\" AS UserPrivilegeForModules_EMPLOYEE_CODE,\n"
                    + "     Modules.\"MODULE_NAME\" AS Modules_MODULE_NAME,\n"
                    + "     Modules.\"VERSION\" AS Modules_VERSION,\n"
                    + "     Employees.\"ACTIVE\" AS Employees_ACTIVE\n"
                    + "FROM\n"
                    + "     \"dbo\".\"UnAndPw\" UnAndPw INNER JOIN \"dbo\".\"Employees\" Employees ON UnAndPw.\"EMPLOYEE_CODE\" = Employees.\"EMPLOYEE_CODE\"\n"
                    + "     INNER JOIN \"dbo\".\"UserPrivilegeForModules\" UserPrivilegeForModules ON Employees.\"EMPLOYEE_CODE\" = UserPrivilegeForModules.\"EMPLOYEE_CODE\"\n"
                    + "     INNER JOIN \"dbo\".\"Modules\" Modules ON UserPrivilegeForModules.\"MODULE_CODE\" = Modules.\"MODULE_CODE\"\n"
                    + "WHERE\n"
                    + "     Employees.\"ACTIVE\" = 'Yes'\n"
                    + "ORDER BY\n"
                    + "     Employees.\"CALL_NAME\" ASC";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {
                model_TablePrivilleges.addRow(new Object[model_TablePrivilleges.getColumnCount()]);
                tablePrivilleges.setValueAt(reset.getString("UserPrivilegeForModules_EMPLOYEE_CODE"), rowCount, 0);
                tablePrivilleges.setValueAt(reset.getString("Employees_FIRST_NAME"), rowCount, 1);
                tablePrivilleges.setValueAt(reset.getString("Employees_INITIALS"), rowCount, 2);
                tablePrivilleges.setValueAt(reset.getString("Employees_CALL_NAME"), rowCount, 3);
                tablePrivilleges.setValueAt(reset.getString("UnAndPw_USER_NAME"), rowCount, 4);
                tablePrivilleges.setValueAt(reset.getString("UserPrivilegeForModules_MODULE_CODE"), rowCount, 5);
                tablePrivilleges.setValueAt(reset.getString("Modules_MODULE_NAME"), rowCount, 6);
                tablePrivilleges.setValueAt(reset.getString("Modules_VERSION"), rowCount, 7);
                rowCount++;
            }
            textNumberOfEmpAtSecondTable.setText(String.valueOf(rowCount));
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void ButtonRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoveSelectedActionPerformed
        selectedRowCountOftablePrivilleges = tablePrivilleges.getSelectedRowCount();
        if (selectedRowCountOftablePrivilleges == 1) {
            int x = JOptionPane.showConfirmDialog(this, "Are you sure To remove this user privillege?", "Remove employee?", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                selectedRowOftablePrivilleges = tablePrivilleges.getSelectedRow();
                model_TablePrivilleges.removeRow(selectedRowOftablePrivilleges);
                countItemsInSecondTable();
            }
        } else if (selectedRowCountOftablePrivilleges != 1) {
            JOptionPane.showMessageDialog(this, "Privillege is not selected.", "Not selected.", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_ButtonRemoveSelectedActionPerformed

    private void countItemsInSecondTable() {
        textNumberOfEmpAtSecondTable.setText(model_TablePrivilleges.getRowCount() + "");
    }

    private void ButtonAddSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddSelectedActionPerformed
        selectedRowCountOfTableEmployee = tableEmployee.getSelectedRowCount();
        selectedRowCountOftableModule = tableModule.getSelectedRowCount();
        if (selectedRowCountOfTableEmployee == 1 && selectedRowCountOftableModule == 1) {
            FirstCheckBeforeAddToSecondTable();
        }
    }//GEN-LAST:event_ButtonAddSelectedActionPerformed

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

    private void FirstCheckBeforeAddToSecondTable() {
        selectedRowOfTableEmployee = tableEmployee.getSelectedRow();
        empCode = tableEmployee.getValueAt(selectedRowOfTableEmployee, 0).toString();
        selectedRowOftableModule = tableModule.getSelectedRow();
        moduleCode = Integer.parseInt(tableModule.getValueAt(selectedRowOftableModule, 0).toString());
        Object[] CheckItemAlreadyAdded = CheckItemAlreadyAdded(empCode, moduleCode);
        if ((Boolean) CheckItemAlreadyAdded[0]) {
            JOptionPane.showMessageDialog(this, "Employee is already added.", "Already added.", JOptionPane.OK_OPTION);
        } else {
            AddToSecondTable(empCode, moduleCode);
        }
    }

    private void AddToSecondTable(String empCode, int moduleCode) {
        selectedRowOfTableEmployee = tableEmployee.getSelectedRow();
        selectedRowOftableModule = tableModule.getSelectedRow();
        try {
            empFirstName = tableEmployee.getValueAt(selectedRowOfTableEmployee, 1).toString();
            empInitials = tableEmployee.getValueAt(selectedRowOfTableEmployee, 2).toString();
            empCallingName = tableEmployee.getValueAt(selectedRowOfTableEmployee, 3).toString();
            userName = tableEmployee.getValueAt(selectedRowOfTableEmployee, 4).toString();

            moduleName = tableModule.getValueAt(selectedRowOftableModule, 1).toString();
            moduleVersion = tableModule.getValueAt(selectedRowOftableModule, 2).toString();

            model_TablePrivilleges.addRow(new Object[]{empCode, empFirstName, empInitials, empCallingName, userName, moduleCode, moduleName, moduleVersion});
            countItemsInSecondTable();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    protected Object[] CheckItemAlreadyAdded(String ItemFromFirstTable, int moduleCode) {
        int rowCount = model_TablePrivilleges.getRowCount();
        Object[] data = new Object[2];
        data[0] = false;
        data[1] = -1;

        for (int i = 0; i < rowCount; i++) {
            String Item1AtSecondTable = model_TablePrivilleges.getValueAt(i, 0).toString();
            int Item2AtSecondTable = Integer.parseInt(model_TablePrivilleges.getValueAt(i, 5).toString());
            if (ItemFromFirstTable.equals(Item1AtSecondTable) && Item2AtSecondTable == moduleCode) {
                data[0] = true;
                data[1] = i;
            }
        }
        return data;
    }

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
                    + "     Employees.\"ACTIVE\" AS Employees_ACTIVE,\n"
                    + "     UnAndPw.\"USER_NAME\" AS UnAndPw_USER_NAME,\n"
                    + "     UnAndPw.\"USER_PASSWORD\" AS UnAndPw_USER_PASSWORD\n"
                    + "FROM\n"
                    + "     \"dbo\".\"UnAndPw\" UnAndPw INNER JOIN \"dbo\".\"Employees\" Employees ON UnAndPw.\"EMPLOYEE_CODE\" = Employees.\"EMPLOYEE_CODE\"\n"
                    + "WHERE Employees.\"SUB_DEPARTMENT_CODE\" = '" + subDepartmentCode + "' AND Employees.\"ACTIVE\" = 'Yes'\n"
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
        comboDepartment.setSelectedIndex(0);
        comboSubDepartment.setSelectedIndex(0);
        textNumberOfEmpAtSubDepartment.setText("0");
        loadDepartmentsToCombo();
        loadModules();
        loadPrivillegesToTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddSelected;
    private javax.swing.JButton ButtonRemoveSelected;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonView;
    private javax.swing.JComboBox comboDepartment;
    private javax.swing.JComboBox comboSubDepartment;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_accountType1;
    private javax.swing.JLabel lbl_subAccount;
    private javax.swing.JLabel lbl_subAccount1;
    private javax.swing.JLabel lbl_subAccount5;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTable tableModule;
    private javax.swing.JTable tablePrivilleges;
    private javax.swing.JTextField textNumberOfEmpAtSecondTable;
    private javax.swing.JTextField textNumberOfEmpAtSubDepartment;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        if (userPrivilege != null) {
            userPrivilege = null;
        }
        this.dispose();
    }

}
