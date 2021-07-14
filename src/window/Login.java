package window;
import route.*;
import function.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
//
public class Login extends javax.swing.JFrame {
    //
    public String username;
    //
    
    public Login() {
        initComponents();
        warning_username_lbl.setVisible(false);
        warning_password_lbl.setVisible(false);        
        header_div.setBorder(new MatteBorder(0, 0, 4, 0, Color.decode("#99A7FF")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        main_div = new javax.swing.JPanel();
        header_div = new javax.swing.JPanel();
        head_1_lbl = new javax.swing.JLabel();
        head_2_lbl = new javax.swing.JLabel();
        login_btn = new javax.swing.JButton();
        body_div = new javax.swing.JPanel();
        username_border = new javax.swing.JPanel();
        password_border = new javax.swing.JPanel();
        warning_username_lbl = new javax.swing.JLabel();
        warning_password_lbl = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        username_in = new javax.swing.JTextField();
        password_in = new javax.swing.JPasswordField();
        image_center = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sbinning Sgill");
        setResizable(false);

        main_div.setBackground(new java.awt.Color(255, 255, 255));
        main_div.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));

        header_div.setBackground(new java.awt.Color(207, 253, 255));
        header_div.setBorder(null);
        header_div.setPreferredSize(new java.awt.Dimension(454, 80));

        head_1_lbl.setFont(new java.awt.Font("JetBrains Mono", 3, 24)); // NOI18N
        head_1_lbl.setForeground(new java.awt.Color(102, 124, 255));
        head_1_lbl.setText("SBINNING");

        head_2_lbl.setFont(new java.awt.Font("JetBrains Mono", 2, 24)); // NOI18N
        head_2_lbl.setForeground(new java.awt.Color(102, 124, 255));
        head_2_lbl.setText("SGILL.");

        login_btn.setBackground(new java.awt.Color(255, 255, 255));
        login_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-play-64.png"))); // NOI18N
        login_btn.setBorderPainted(false);
        login_btn.setContentAreaFilled(false);
        login_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_btn.setFocusPainted(false);
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout header_divLayout = new javax.swing.GroupLayout(header_div);
        header_div.setLayout(header_divLayout);
        header_divLayout.setHorizontalGroup(
            header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_divLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(head_2_lbl)
                    .addGroup(header_divLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(head_1_lbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        header_divLayout.setVerticalGroup(
            header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_divLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_divLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(head_2_lbl))
                    .addComponent(head_1_lbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(header_divLayout.createSequentialGroup()
                .addComponent(login_btn)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        body_div.setBackground(new java.awt.Color(255, 255, 255));
        body_div.setLayout(null);

        username_border.setBackground(new java.awt.Color(153, 167, 255));

        javax.swing.GroupLayout username_borderLayout = new javax.swing.GroupLayout(username_border);
        username_border.setLayout(username_borderLayout);
        username_borderLayout.setHorizontalGroup(
            username_borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        username_borderLayout.setVerticalGroup(
            username_borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        body_div.add(username_border);
        username_border.setBounds(10, 120, 210, 4);

        password_border.setBackground(new java.awt.Color(153, 167, 255));

        javax.swing.GroupLayout password_borderLayout = new javax.swing.GroupLayout(password_border);
        password_border.setLayout(password_borderLayout);
        password_borderLayout.setHorizontalGroup(
            password_borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        password_borderLayout.setVerticalGroup(
            password_borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        body_div.add(password_border);
        password_border.setBounds(10, 50, 210, 4);

        warning_username_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-information-24.png"))); // NOI18N
        warning_username_lbl.setToolTipText("");
        warning_username_lbl.setFocusable(false);
        body_div.add(warning_username_lbl);
        warning_username_lbl.setBounds(220, 30, 24, 24);

        warning_password_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-information-24.png"))); // NOI18N
        warning_password_lbl.setToolTipText("");
        warning_password_lbl.setFocusable(false);
        body_div.add(warning_password_lbl);
        warning_password_lbl.setBounds(220, 100, 24, 24);

        username_lbl.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        username_lbl.setForeground(new java.awt.Color(153, 150, 245));
        username_lbl.setText("USERNAME");
        body_div.add(username_lbl);
        username_lbl.setBounds(10, 10, 110, 20);

        password_lbl.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        password_lbl.setForeground(new java.awt.Color(153, 150, 245));
        password_lbl.setText("PASSWORD");
        body_div.add(password_lbl);
        password_lbl.setBounds(10, 80, 80, 20);

        username_in.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        username_in.setForeground(new java.awt.Color(153, 123, 250));
        username_in.setBorder(null);
        username_in.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                username_inFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                username_inFocusLost(evt);
            }
        });
        username_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                username_inKeyPressed(evt);
            }
        });
        body_div.add(username_in);
        username_in.setBounds(10, 30, 210, 17);

        password_in.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        password_in.setForeground(new java.awt.Color(153, 123, 250));
        password_in.setBorder(null);
        password_in.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_inFocusLost(evt);
            }
        });
        password_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_inActionPerformed(evt);
            }
        });
        body_div.add(password_in);
        password_in.setBounds(10, 100, 210, 17);

        image_center.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/undraw_old_day_6x25.png"))); // NOI18N
        body_div.add(image_center);
        image_center.setBounds(10, 10, 380, 300);

        javax.swing.GroupLayout main_divLayout = new javax.swing.GroupLayout(main_div);
        main_div.setLayout(main_divLayout);
        main_divLayout.setHorizontalGroup(
            main_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_div, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
            .addComponent(body_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        main_divLayout.setVerticalGroup(
            main_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_divLayout.createSequentialGroup()
                .addComponent(header_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body_div, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(431, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void execLogin() {
        boolean pass_check = false;
        DatabaseConn db = new DatabaseConn();
        InfoHandler info = new InfoHandler();
        if (username_in.getText().isEmpty() || username_in.getText().length() < 6 || username_in.getText().equals("SYSTEM")) {
            info.manageTip(warning_username_lbl, "<html>\nPlease insert the username properly !<br>\nit's about 6 - 11 characters\n</html>");
            pass_check = false;
        } else {info.manageTip(warning_username_lbl); pass_check = true;}
        
        if (String.valueOf(password_in.getPassword()).equals("") || String.valueOf(password_in.getPassword()).length() < 6) {
            info.manageTip(warning_password_lbl, "<html>\nPlease insert the password properly !<br>\nit's about 6 - 11 characters\n</html>");
            pass_check = false;
        } else {info.manageTip(warning_password_lbl); pass_check = true;}
        
        if (pass_check) {
            switch(db.playerAvailabilty(username_in, password_in)) {
                case 'F':
                    info.manageTip(warning_password_lbl, "<html>\nYou have inserted incorrect password<br>\nfor account '"+username_in.getText()+"'\n</html>");                    
                    break;
                case 'N':
                    String msg = "<html>The re are no issued player to be found yet ...\nCreate new one as "+username_in.getText()+" ?";
                    String head = "Detecting Newcomers";
                    int dialog = info.manageDialog(JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, msg, head);
                    if (dialog == JOptionPane.YES_OPTION) {
                    try {
                        System.out.println("Oke, buat akun");
                        db.createNewPlayer(username_in, password_in);
                        this.username = username_in.getText().toUpperCase();
                        this.dispose();
                        Lobby lobby = new Lobby();
                        lobby.username = this.username;
                        lobby.fetchInfo(username);
                        lobby.setVisible(true);
                        db.setLobby(lobby);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SocketException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    break;
                case 'T':
                    try {
                        this.username = username_in.getText().toUpperCase();                    
                        this.dispose();
                        Lobby lobby = new Lobby(); 
                        lobby.username = this.username;                        
                        lobby.fetchInfo(username);
                        lobby.setVisible(true);
                        db.setLobby(lobby);                                         
                        Thread.currentThread().getContextClassLoader();                        
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SocketException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }        
    }
    
    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        // TODO add your handling code here:
        this.execLogin();
    }//GEN-LAST:event_login_btnActionPerformed

    
    private void username_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_inKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (username_in.getText().length() == 1) {username_in.setText(" ");}
        } 
    }//GEN-LAST:event_username_inKeyPressed

    private void username_inFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_inFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_username_inFocusGained

    private void username_inFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_inFocusLost
        // TODO add your handling code here:
        if (username_in.getText().length() > 11) {
            username_in.setText(username_in.getText().substring(0, 11));
        }
    }//GEN-LAST:event_username_inFocusLost

    private void password_inFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_inFocusLost
        // TODO add your handling code here:
        if (String.valueOf(password_in.getPassword()).length() > 11) {
            password_in.setText(String.valueOf(password_in.getPassword()).substring(0, 11));
        }
    }//GEN-LAST:event_password_inFocusLost

    private void password_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_inActionPerformed
        // TODO add your handling code here:
        this.execLogin();
    }//GEN-LAST:event_password_inActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body_div;
    private javax.swing.JLabel head_1_lbl;
    private javax.swing.JLabel head_2_lbl;
    private javax.swing.JPanel header_div;
    private javax.swing.JLabel image_center;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton login_btn;
    private javax.swing.JPanel main_div;
    private javax.swing.JPanel password_border;
    private javax.swing.JPasswordField password_in;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JPanel username_border;
    private javax.swing.JTextField username_in;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JLabel warning_password_lbl;
    private javax.swing.JLabel warning_username_lbl;
    // End of variables declaration//GEN-END:variables
}
