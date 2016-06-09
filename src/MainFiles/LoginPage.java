/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginPage.java
 *
 * Created on Feb 24, 2011, 4:03:49 PM
 */
package MainFiles;

import db.ConnectSql;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ravindu
 */
public class LoginPage extends javax.swing.JFrame {

    public static String SysDate; //[1011, 599]
    private final String projectPath = System.getProperty("user.dir");

    public LoginPage() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        //[255,255,255] , [0,204,255]
        initComponents();

        int PanelX = jPanel1.getWidth();
        int PanelY = jPanel1.getHeight();
        LabelImage.setSize(PanelX, PanelY);

        LoadHeading();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(projectPath + "/pictures/frameIcon/titleIcon.png"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        textPassword = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        LabelImage = new javax.swing.JLabel();
        labelGradient = new javax.swing.JLabel();
        labelBusinessTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit() 
            .getImage("images/inv1.png"));
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hi, please insert your login details...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Password   :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 20));

        jLabel2.setText("User name :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 70, 20));

        textUserName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        textUserName.setOpaque(false);
        textUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textUserNameFocusGained(evt);
            }
        });
        textUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textUserNameKeyPressed(evt);
            }
        });
        jPanel2.add(textUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 190, 20));

        textPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        textPassword.setOpaque(false);
        textPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textPasswordFocusGained(evt);
            }
        });
        textPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textPasswordKeyPressed(evt);
            }
        });
        jPanel2.add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, 20));

        buttonLogin.setText("Login");
        buttonLogin.setMaximumSize(new java.awt.Dimension(65, 23));
        buttonLogin.setMinimumSize(new java.awt.Dimension(65, 23));
        buttonLogin.setOpaque(false);
        buttonLogin.setPreferredSize(new java.awt.Dimension(65, 23));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        jPanel2.add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 80, -1));

        buttonExit.setText("Exit");
        buttonExit.setOpaque(false);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        jPanel2.add(buttonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 80, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 420, 190));

        LabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginBackground.jpg"))); // NOI18N
        LabelImage.setMaximumSize(new java.awt.Dimension(700, 400));
        LabelImage.setMinimumSize(new java.awt.Dimension(700, 400));
        LabelImage.setName(""); // NOI18N
        LabelImage.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.add(LabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 530));

        labelGradient.setFont(new java.awt.Font("Impact", 2, 36)); // NOI18N
        labelGradient.setForeground(new java.awt.Color(255, 255, 255));
        labelGradient.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLabel labelGradient = new JLabel() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Color color1 = Color.white;
                Color color2 = Color.black;
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0,
                    color1.brighter().brighter().brighter(), getWidth(), getHeight(),
                    color2.darker());
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        labelGradient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGradientMouseClicked(evt);
            }
        });
        jPanel1.add(labelGradient, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 554, 610, 40));

        labelBusinessTitle.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        labelBusinessTitle.setForeground(new java.awt.Color(153, 153, 153));
        labelBusinessTitle.setText("SBIM Tools");
        jPanel1.add(labelBusinessTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 554, 170, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoadHeading() {
        try {
            Statement stmt;
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rset = stmt.executeQuery("SELECT MODULE_NAME, VERSION, BUSINESS_NAME FROM Modules where MODULE_CODE = '1'");
            if (rset.next()) {
                String MODULE_NAME = rset.getString("MODULE_NAME");
                String VERSION = rset.getString("VERSION");
                String BUSINESS_NAME = rset.getString("BUSINESS_NAME");

                String heading = MODULE_NAME + " " + VERSION + " - " + BUSINESS_NAME;
                this.setTitle(heading);

                labelBusinessTitle.setText(BUSINESS_NAME);
            }
            rset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void textUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textUserNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            textPassword.requestFocus();
        }
    }//GEN-LAST:event_textUserNameKeyPressed

    private void textUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textUserNameFocusGained
        textUserName.selectAll();
    }//GEN-LAST:event_textUserNameFocusGained

    private void textPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textPasswordFocusGained
        textPassword.selectAll();
    }//GEN-LAST:event_textPasswordFocusGained

    private void textPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkIfModuleIsAuthorized();
        }
    }//GEN-LAST:event_textPasswordKeyPressed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        checkIfModuleIsAuthorized();
}//GEN-LAST:event_buttonLoginActionPerformed

    private void labelGradientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGradientMouseClicked
        int x = evt.getX();
        int y = evt.getY();
        System.out.println(x + "," + y);
    }//GEN-LAST:event_labelGradientMouseClicked

    private void checkIfModuleIsAuthorized() {
        boolean checkModule = this.isCheckModule();
        if (checkModule) {
            checkExpireDate();
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, this system is not authorized to you.");
        }
    }

    private boolean isCheckModule() {
        boolean value = false;
        try {
            String userName = textUserName.getText();
            Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rset1 = stmt.executeQuery("SELECT\n"
                    + "     UnAndPw.\"EMPLOYEE_CODE\" AS UnAndPw_EMPLOYEE_CODE,\n"
                    + "     UnAndPw.\"USER_NAME\" AS UnAndPw_USER_NAME,\n"
                    + "     UnAndPw.\"USER_PASSWORD\" AS UnAndPw_USER_PASSWORD,\n"
                    + "     UserPrivilegeForModules.\"MODULE_CODE\" AS UserPrivilegeForModules_MODULE_CODE,\n"
                    + "     UserPrivilegeForModules.\"EMPLOYEE_CODE\" AS UserPrivilegeForModules_EMPLOYEE_CODE\n"
                    + "FROM\n"
                    + "     \"dbo\".\"UserPrivilegeForModules\" UserPrivilegeForModules INNER JOIN \"dbo\".\"UnAndPw\" UnAndPw ON UserPrivilegeForModules.\"EMPLOYEE_CODE\" = UnAndPw.\"EMPLOYEE_CODE\"\n"
                    + "WHERE\n"
                    + "     UserPrivilegeForModules.\"MODULE_CODE\" = '1'\n"
                    + " AND UnAndPw.\"USER_NAME\" = '" + userName + "'");
            if (rset1.next()) {
                String getCode = rset1.getString("UserPrivilegeForModules_MODULE_CODE");
                if (getCode.equals("1")) {
                    value = true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
        return value;
    }

    private void checkExpireDate() {
        try {
            Statement stmt3 = ConnectSql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rset3 = stmt3.executeQuery("Select * from SystemDate");

            if (rset3.next()) {
                Date date = rset3.getDate("sysDate");
                SysDate = rset3.getDate("sysDate").toString();
                if (date != null) {
                    Statement stmt1 = ConnectSql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rset1 = stmt1.executeQuery("Select * from SystemDate");
                    if (rset1.next()) {
                        Date dbdate = rset1.getDate("ExpiredDate");
                        Date dbSysdate = rset1.getDate("sysDate");
                        long dbExpiredate = dbdate.getTime();
                        long dbCurSysdate = dbSysdate.getTime();
                        if (dbExpiredate >= dbCurSysdate) {
                            login();
                        } else {
                            JOptionPane.showMessageDialog(this, "Your license is expired. Please contact your software vendor.", "", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void login() {
        try {
            String userName = textUserName.getText();
            Statement stmtGetLoginDetails = ConnectSql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rsetGetLoginDetails = stmtGetLoginDetails.executeQuery("SELECT\n"
                    + "     UnAndPw.\"EMPLOYEE_CODE\" AS UnAndPw_EMPLOYEE_CODE,\n"
                    + "     UnAndPw.\"USER_NAME\" AS UnAndPw_USER_NAME,\n"
                    + "     UnAndPw.\"USER_PASSWORD\" AS UnAndPw_USER_PASSWORD,\n"
                    + "     Departments.\"DepartmentName\" AS Departments_DepartmentName,\n"
                    + "     SubDepartments.\"SUB_DEPARTMENT_NAME\" AS SubDepartments_SUB_DEPARTMENT_NAME,\n"
                    + "     SubDepartments.\"DepartmentCode\" AS SubDepartments_DepartmentCode,\n"
                    + "     Employees.\"SUB_DEPARTMENT_CODE\" AS Employees_SUB_DEPARTMENT_CODE,\n"
                    + "     Departments.\"BranchCode\" AS Departments_BranchCode,\n"
                    + "     Branches.\"BranchName\" AS Branches_BranchName\n"
                    + "FROM\n"
                    + "     \"dbo\".\"Employees\" Employees INNER JOIN \"dbo\".\"UnAndPw\" UnAndPw ON Employees.\"EMPLOYEE_CODE\" = UnAndPw.\"EMPLOYEE_CODE\"\n"
                    + "     INNER JOIN \"dbo\".\"SubDepartments\" SubDepartments ON Employees.\"SUB_DEPARTMENT_CODE\" = SubDepartments.\"SUB_DEPARTMENT_CODE\"\n"
                    + "     INNER JOIN \"dbo\".\"Departments\" Departments ON SubDepartments.\"DepartmentCode\" = Departments.\"DepartmentCode\"\n"
                    + "     INNER JOIN \"dbo\".\"Branches\" Branches ON Departments.\"BranchCode\" = Branches.\"BranchCode\"\n"
                    + "WHERE UnAndPw.\"USER_NAME\" = '"+userName+"'");

            if (rsetGetLoginDetails.next()) {
                String password = new String(textPassword.getPassword());
                String dbPassword = rsetGetLoginDetails.getString("UnAndPw_USER_PASSWORD");
                String departmentCode = rsetGetLoginDetails.getString("SubDepartments_DepartmentCode");
                String subDepartmentCode = rsetGetLoginDetails.getString("Employees_SUB_DEPARTMENT_CODE");
                String departmentName = rsetGetLoginDetails.getString("Departments_DepartmentName");
                String subDepartmentName = rsetGetLoginDetails.getString("SubDepartments_SUB_DEPARTMENT_NAME");
                if (dbPassword.equals(password)) {
                    IndexPage.user = textUserName.getText().trim();
                    IndexPage.departmentCode = departmentCode;
                    IndexPage.subDepartmentCode = subDepartmentCode;
                    IndexPage.departmentName = departmentName;
                    IndexPage.subDepartmentName = subDepartmentName;
                    IndexPage mainpage = new IndexPage();
                    mainpage.setExtendedState(Frame.MAXIMIZED_BOTH);
                    mainpage.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Password is not correct.", "Incorrect password", JOptionPane.ERROR_MESSAGE);
                    textPassword.requestFocus();
                    textPassword.selectAll();
                }
            } else {
                JOptionPane.showMessageDialog(this, "User name is not exsist.", "Not exsist", JOptionPane.ERROR_MESSAGE);
                textUserName.requestFocus();
                textUserName.selectAll();
            }

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelImage;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelBusinessTitle;
    private javax.swing.JLabel labelGradient;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUserName;
    // End of variables declaration//GEN-END:variables
}
