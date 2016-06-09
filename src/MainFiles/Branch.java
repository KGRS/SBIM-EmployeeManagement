/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFiles;

import static MainFiles.IndexPage.bran;
import db.ConnectSql;
import functions.ValidateFields;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ravindu
 */
public class Branch extends javax.swing.JInternalFrame {

    private final String select = "--Select--";
    private final DefaultTableModel model_categoryTable;
    private final String spliter = "--";

    /**
     * Creates new form Department
     */
    public Branch() {
        initComponents();

        buttonGroup1.add(rBtnCode);
        buttonGroup1.add(rBtnName);
        rBtnCode.setSelected(true);
        txtCode.requestFocus();
        model_categoryTable = (DefaultTableModel) TableCategory.getModel();
        panel1.setToolTipText("Press right mouse click to refresh.");

        LoadCategories();
    }

    private void LoadCategories() {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            query = "SELECT * FROM Branches ORDER BY BranchName";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {
                model_categoryTable.addRow(new Object[model_categoryTable.getColumnCount()]);
                TableCategory.setValueAt(reset.getString("BranchCode"), rowCount, 0);
                TableCategory.setValueAt(reset.getString("BranchName"), rowCount, 1);
                TableCategory.setValueAt(reset.getString("Telephone1"), rowCount, 2);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
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
        panel1 = new javax.swing.JPanel();
        lbl_category = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtCategoryName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lbl_description = new javax.swing.JLabel();
        lbl_subAccount = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        rBtnCode = new javax.swing.JRadioButton();
        rBtnName = new javax.swing.JRadioButton();
        lbl_accountType = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCategory = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtTelephone = new javax.swing.JTextField();

        setIconifiable(true);
        setTitle("Branch");
        setPreferredSize(new java.awt.Dimension(895, 365));
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

        lbl_category.setForeground(new java.awt.Color(102, 102, 102));
        lbl_category.setText("Branch code");
        panel1.add(lbl_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 110, 20));

        txtCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodeFocusGained(evt);
            }
        });
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodeKeyReleased(evt);
            }
        });
        panel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 170, 20));

        txtCategoryName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCategoryNameFocusGained(evt);
            }
        });
        txtCategoryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoryNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryNameKeyReleased(evt);
            }
        });
        panel1.add(txtCategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 210, 20));

        btnSave.setMnemonic('s');
        btnSave.setText("Save");
        btnSave.setActionCommand("Delete");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 80, -1));

        btnDelete.setMnemonic('d');
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 80, -1));

        lbl_description.setForeground(new java.awt.Color(102, 102, 102));
        lbl_description.setText("Branch name");
        panel1.add(lbl_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 110, 20));

        lbl_subAccount.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount.setText("Search branch by");
        panel1.add(lbl_subAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 20));

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
        panel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 80, -1));

        rBtnCode.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtnCode);
        rBtnCode.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        rBtnCode.setText("Code");
        rBtnCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnCodeActionPerformed(evt);
            }
        });
        panel1.add(rBtnCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, -1));

        rBtnName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtnName);
        rBtnName.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
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
        panel1.add(rBtnName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 60, -1));

        lbl_accountType.setForeground(new java.awt.Color(102, 102, 102));
        lbl_accountType.setText("Telephone");
        panel1.add(lbl_accountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 110, 20));

        TableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Telephone"
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
        TableCategory.getTableHeader().setReorderingAllowed(false);
        TableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCategory);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 250));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        panel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 170, -1));
        panel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 350, -1));

        txtTelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelephoneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelephoneKeyReleased(evt);
            }
        });
        panel1.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodeFocusGained
        txtCode.selectAll();
    }//GEN-LAST:event_txtCodeFocusGained

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = txtCode.getText();
            if (!text.isEmpty()) {
                txtCategoryName.requestFocus();
                LoadAtCodes();
            }
        }
    }//GEN-LAST:event_txtCodeKeyPressed

    private void LoadAtCodes() {
        String CategoryCode = txtCode.getText();
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            query = "SELECT * FROM Branches where BranchCode = '" + CategoryCode + "'";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            if (reset.next()) {
                txtCategoryName.setText(reset.getString("BranchName"));
                txtTelephone.setText(reset.getString("Telephone1"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void txtCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyReleased
        ValidateFields.CheckForCodes(txtCode);
    }//GEN-LAST:event_txtCodeKeyReleased

    private void txtCategoryNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCategoryNameFocusGained
        txtCategoryName.selectAll();
    }//GEN-LAST:event_txtCategoryNameFocusGained

    private void txtCategoryNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = txtCategoryName.getText();
            if (!text.isEmpty()) {
                txtTelephone.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCategoryNameKeyPressed

    private void txtCategoryNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryNameKeyReleased
        ValidateFields.CheckForOtherFields(txtCategoryName);
    }//GEN-LAST:event_txtCategoryNameKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        CheckBeforeSave();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void CheckBeforeSave() {
        String CategoryCode = txtCode.getText();
        String CategoryName = txtCategoryName.getText();
        String Type = txtTelephone.getText();
        if (!CategoryCode.isEmpty() && !CategoryName.isEmpty() && !Type.equals(select)) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select BranchCode From Branches where BranchCode = '" + CategoryCode + "'";
                ResultSet rset = stmt.executeQuery(query);

                if (rset.next()) {
                    int x = JOptionPane.showConfirmDialog(this, "Are you sure to change the '" + CategoryCode + "' branch details?", "Update branch?", JOptionPane.YES_NO_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        String UpdateQuery = "update Branches set BranchName = '" + CategoryName + "', Telephone1 = '" + Type + "' where BranchCode = '" + CategoryCode + "'";
                        stmt.execute(UpdateQuery);
                        JOptionPane.showMessageDialog(this, "Branche details are updated.");
                        Refresh();
                    } else if (x == JOptionPane.NO_OPTION) {
                        txtCode.requestFocus();
                    }

                } else if (!rset.next()) {
                    String UpdateQuery = "insert into Branches (BranchCode, BranchName, Telephone1) values ( '" + CategoryCode + "','" + CategoryName + "', '" + Type + "') ";
                    stmt.execute(UpdateQuery);
                    JOptionPane.showMessageDialog(this, "New branch is saved.");
                    Refresh();
                }
                rset.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (CategoryCode.isEmpty() || CategoryName.isEmpty() || Type.equals(select)) {
            JOptionPane.showMessageDialog(this, "Please fill all fields before save.", "Empty fields", JOptionPane.OK_OPTION);
            txtCode.requestFocus();
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        CheckBeforeDelete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void CheckBeforeDelete() {
        String CategoryCode = txtCode.getText();
        if (!CategoryCode.isEmpty()) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select TakeFrom, TransferTo From ItemTransferMain where TakeFrom = '" + CategoryCode + "' or TransferTo = '" + CategoryCode + "'";
                ResultSet rset = stmt.executeQuery(query);
                
                java.sql.Statement stmt1 = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query1 = "select BranchCode From Departments where BranchCode = '" + CategoryCode + "'";
                ResultSet rset1 = stmt1.executeQuery(query1);

                if (rset.next() || rset1.next()) {
                    JOptionPane.showMessageDialog(this, "This branch is already used. Can't delete.", "Can't delete", JOptionPane.ERROR_MESSAGE);
                } else if (!rset.next()) {
                    DeleteDepartment();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (CategoryCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please insert a valid branch code before delete.", "Empty branch code", JOptionPane.OK_OPTION);
            txtCode.requestFocus();
        }
    }

    private void DeleteDepartment() {
        String Code = txtCode.getText();
        int x = JOptionPane.showConfirmDialog(this, "Are you sure To delete this?", "Delete branch?", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                java.sql.Statement Checkstmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                String Checkquery = "select BranchCode From Branches where BranchCode = '" + Code + "'";
                ResultSet Checkrset = Checkstmt.executeQuery(Checkquery);

                if (Checkrset.next()) {
                    String query = "delete From Branches where BranchCode = '" + Code + "'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(this, "Branch is deleted.");
                    Refresh();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid branch code. Please insert a valid branch code.", "Invalid branch code", JOptionPane.OK_OPTION);
                    txtCode.requestFocus();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }

        } else if (x == JOptionPane.NO_OPTION) {
            txtCode.requestFocus();
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

    private void rBtnCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnCodeActionPerformed
        if (rBtnCode.isSelected()) {
            txtSearch.requestFocus();
            txtSearch.selectAll();
        }
    }//GEN-LAST:event_rBtnCodeActionPerformed

    private void rBtnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnNameActionPerformed
        if (rBtnName.isSelected()) {
            txtSearch.requestFocus();
            txtSearch.selectAll();
        }
    }//GEN-LAST:event_rBtnNameActionPerformed

    private void rBtnNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rBtnNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            rBtnCode.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            rBtnName.setSelected(true);
            btnSave.requestFocus();
        }
    }//GEN-LAST:event_rBtnNameKeyPressed

    private void TableCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCategoryMouseClicked
        String Code, Name, Telephone;

        Code = TableCategory.getValueAt(TableCategory.getSelectedRow(), 0).toString();
        Name = TableCategory.getValueAt(TableCategory.getSelectedRow(), 1).toString();
        Telephone = TableCategory.getValueAt(TableCategory.getSelectedRow(), 2).toString();

        txtCode.setText(Code);
        txtCategoryName.setText(Name);
        txtTelephone.setText(Telephone);
    }//GEN-LAST:event_TableCategoryMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (rBtnCode.isSelected()) {
            SearchCategoryByCode(txtSearch.getText());
        } else if (rBtnName.isSelected()) {
            SearchCategoryByName(txtSearch.getText());
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void SearchCategoryByCode(String CategoryCode) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            RefreshTable();

            if (!CategoryCode.equals("")) {
                query = "SELECT * FROM Branches WHERE BranchCode LIKE '" + CategoryCode + "%'";
            } else {
                query = "SELECT * FROM Branches  WHERE BranchCode LIKE '" + CategoryCode + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_categoryTable.addRow(new Object[model_categoryTable.getColumnCount()]);
                TableCategory.setValueAt(reset.getString("BranchCode"), rowCount, 0);
                TableCategory.setValueAt(reset.getString("BranchName"), rowCount, 1);
                TableCategory.setValueAt(reset.getString("Telephone1"), rowCount, 2);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void SearchCategoryByName(String CategoryName) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            RefreshTable();

            if (!CategoryName.equals("")) {
                query = "SELECT * FROM Branches WHERE BranchName LIKE '%" + CategoryName + "%'";
            } else {
                query = "SELECT * FROM Branches  WHERE BranchName LIKE '%" + CategoryName + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_categoryTable.addRow(new Object[model_categoryTable.getColumnCount()]);
                TableCategory.setValueAt(reset.getString("BranchCode"), rowCount, 0);
                TableCategory.setValueAt(reset.getString("BranchName"), rowCount, 1);
                TableCategory.setValueAt(reset.getString("Telephone1"), rowCount, 2);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void RefreshTable() {
        try {
            int row = model_categoryTable.getRowCount();
            for (int j = 0; j < row; j++) {
                model_categoryTable.removeRow(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt) || evt.isControlDown()) {
            Refresh();
        }
    }//GEN-LAST:event_panel1MouseClicked

    private void txtTelephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneKeyReleased
        ValidateFields.CheckForOtherFields(txtCategoryName);
    }//GEN-LAST:event_txtTelephoneKeyReleased

    private void txtTelephoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSave.requestFocus();
        }
    }//GEN-LAST:event_txtTelephoneKeyPressed

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        bran.toFront();
    }//GEN-LAST:event_formInternalFrameIconified

    private void Refresh() {
        RefreshTableAndLoadAgain();
        txtCode.setText("");
        txtCategoryName.setText("");
        txtTelephone.setText("");
        txtSearch.setText("");
    }

    private void RefreshTableAndLoadAgain() {
        try {
            int row = model_categoryTable.getRowCount();
            for (int j = 0; j < row; j++) {
                model_categoryTable.removeRow(0);
            }
            LoadCategories();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCategory;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_accountType;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_subAccount;
    private javax.swing.JPanel panel1;
    private javax.swing.JRadioButton rBtnCode;
    private javax.swing.JRadioButton rBtnName;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables

    private void exit() {
         if (bran != null) {
            bran = null;
        }
        this.dispose();
    }

}
