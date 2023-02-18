package views;

import controllers.LoginController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

/**
 *
 * @author Hai
 */
public class LoginUI extends javax.swing.JFrame {
    
    private LoginController cont = new  LoginController();
    
    public LoginUI() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LoginUI.class.getResource("/Icons/Login1.png")));
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Login");
        keyListenner(txbUserName);
        keyListenner(txbPasswd);
    }
    
    // xu ly su kien nhan enter
    private void keyListenner(JTextField jtf) {
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // neu keycode == 10 ~ enter
                if (e.getKeyCode() == 10) {
                    login();
                }
            }
        }); 
    }

    // dang nhap
    private void login() {
        String userName = txbUserName.getText();
        String password = String.valueOf(txbPasswd.getPassword());
        try {
            if (this.cont.login(userName, password)) {
                dispose();
                MainFrame mainFrame = new MainFrame();
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setResizable(false);
                mainFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sai thong tin dang nhap", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!! Vui lòng kiểm tra lại!", "Warning!!", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnLogin = new javax.swing.JPanel();
        txbUserName = new javax.swing.JTextField();
        txbPasswd = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnLogin.setForeground(new Color(128, 0, 255));
        btnLogin.setText("OK");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setIcon(new ImageIcon(LoginUI.class.getResource("/Icons/Login2.png")));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnLogin.setBackground(new Color(128, 0, 255));
        jpnLogin.setForeground(new Color(64, 128, 128));

        txbUserName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txbUserName.setName("txtUserName"); // NOI18N
        txbUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbUserNameActionPerformed(evt);
            }
        });

        txbPasswd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txbPasswd.setName("txtPasswd"); // NOI18N

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new Font("Freestyle Script", Font.BOLD, 14));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Arial", Font.ITALIC, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name:");

        jLabel2.setFont(new Font("Arial", Font.ITALIC, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");

        jLabel3.setFont(new Font("Bodoni MT Black", Font.ITALIC, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(LoginUI.class.getResource("/Icons/Login1.png")));
        
        JLabel lblNewLabel_1 = new JLabel("Ứng dụng phát triển bởi nhóm @Vozer");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Monospaced", Font.ITALIC, 10));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout jpnLoginLayout = new javax.swing.GroupLayout(jpnLogin);
        jpnLoginLayout.setHorizontalGroup(
        	jpnLoginLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jpnLoginLayout.createSequentialGroup()
        			.addGap(34)
        			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(431, Short.MAX_VALUE))
        		.addGroup(jpnLoginLayout.createSequentialGroup()
        			.addGroup(jpnLoginLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jpnLoginLayout.createSequentialGroup()
        					.addGap(177)
        					.addGroup(jpnLoginLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel2))
        					.addGap(18)
        					.addGroup(jpnLoginLayout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(txbPasswd, Alignment.LEADING)
        						.addComponent(txbUserName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
        					.addComponent(lblNewLabel)
        					.addGap(20))
        				.addGroup(jpnLoginLayout.createSequentialGroup()
        					.addGap(320)
        					.addComponent(jLabel3))
        				.addGroup(jpnLoginLayout.createSequentialGroup()
        					.addGap(589)
        					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addGap(62))
        );
        jpnLoginLayout.setVerticalGroup(
        	jpnLoginLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnLoginLayout.createSequentialGroup()
        			.addGap(23)
        			.addComponent(jLabel3)
        			.addGap(18)
        			.addGroup(jpnLoginLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jpnLoginLayout.createSequentialGroup()
        					.addGap(76)
        					.addGroup(jpnLoginLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(txbPasswd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jpnLoginLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jLabel1)
        					.addComponent(txbUserName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
        			.addGap(38)
        			.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
        			.addGap(16))
        );
        jpnLogin.setLayout(jpnLoginLayout);

        txbUserName.getAccessibleContext().setAccessibleName("txtPasswod");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jpnLogin, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jpnLogin, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txbUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbUserNameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       this.login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        
    }//GEN-LAST:event_btnLoginMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jpnLogin;
    private javax.swing.JPasswordField txbPasswd;
    private javax.swing.JTextField txbUserName;
}
