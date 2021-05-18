package window;
import route.*;
import function.*;
//
public class Login extends javax.swing.JFrame {
    //
    private LoginFunc login_func = new LoginFunc();
    private int port_number;
    //
    public Login() {
        initComponents();
        login_func.showLobby(log_ta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backg = new javax.swing.JPanel();
        create_btn = new javax.swing.JButton();
        join_btn = new javax.swing.JButton();
        log_sp_ta = new javax.swing.JScrollPane();
        log_ta = new javax.swing.JTextArea();
        log_sp_ta1 = new javax.swing.JScrollPane();
        room_ta = new javax.swing.JTextArea();
        leave_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        message_ta = new javax.swing.JTextArea();
        refresh_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        username_ta = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        lobbychat_ta = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        roomid_ta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sbinning Sgill");
        setResizable(false);

        backg.setBackground(new java.awt.Color(68, 71, 90));
        backg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(139, 233, 253), 3));

        create_btn.setBackground(new java.awt.Color(153, 255, 153));
        create_btn.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        create_btn.setText("CREATE");
        create_btn.setToolTipText("");
        create_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_btnMouseClicked(evt);
            }
        });

        join_btn.setBackground(new java.awt.Color(255, 255, 153));
        join_btn.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        join_btn.setText("JOIN");
        join_btn.setToolTipText("");
        join_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        join_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                join_btnMouseClicked(evt);
            }
        });

        log_ta.setColumns(20);
        log_ta.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        log_ta.setRows(5);
        log_ta.setTabSize(4);
        log_ta.setBorder(null);
        log_sp_ta.setViewportView(log_ta);

        room_ta.setColumns(20);
        room_ta.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        room_ta.setRows(1);
        room_ta.setTabSize(4);
        room_ta.setBorder(null);
        log_sp_ta1.setViewportView(room_ta);

        leave_btn.setBackground(new java.awt.Color(255, 153, 153));
        leave_btn.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        leave_btn.setText("LEAVE");
        leave_btn.setToolTipText("");
        leave_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        message_ta.setColumns(20);
        message_ta.setRows(3);
        jScrollPane1.setViewportView(message_ta);

        refresh_btn.setBackground(new java.awt.Color(204, 153, 255));
        refresh_btn.setFont(new java.awt.Font("JetBrains Mono", 1, 12)); // NOI18N
        refresh_btn.setText("REFRESH");
        refresh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh_btnMouseClicked(evt);
            }
        });

        username_ta.setColumns(2);
        username_ta.setRows(1);
        username_ta.setTabSize(1);
        jScrollPane2.setViewportView(username_ta);

        lobbychat_ta.setColumns(20);
        lobbychat_ta.setRows(5);
        jScrollPane3.setViewportView(lobbychat_ta);

        roomid_ta.setColumns(2);
        roomid_ta.setRows(1);
        roomid_ta.setTabSize(1);
        jScrollPane5.setViewportView(roomid_ta);

        javax.swing.GroupLayout backgLayout = new javax.swing.GroupLayout(backg);
        backg.setLayout(backgLayout);
        backgLayout.setHorizontalGroup(
            backgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(log_sp_ta)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(log_sp_ta1)
                    .addGroup(backgLayout.createSequentialGroup()
                        .addComponent(create_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leave_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(refresh_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(backgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(join_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                .addContainerGap())
        );
        backgLayout.setVerticalGroup(
            backgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(backgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(join_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leave_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane2)
                    .addComponent(log_sp_ta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgLayout.createSequentialGroup()
                        .addComponent(refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(log_sp_ta, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_btnMouseClicked
        // TODO add your handling code here:
        login_func.showLobby(log_ta);
    }//GEN-LAST:event_refresh_btnMouseClicked

    private void create_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_btnMouseClicked
        // TODO add your handling code here:
        this.port_number = login_func.execListener(log_ta);
        room_ta.setText(" #" + this.port_number);

    }//GEN-LAST:event_create_btnMouseClicked

    private void join_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_join_btnMouseClicked
        // TODO add your handling code here:
        login_func.execResponmder(roomid_ta, username_ta, lobbychat_ta);
    }//GEN-LAST:event_join_btnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backg;
    private javax.swing.JButton create_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton join_btn;
    private javax.swing.JButton leave_btn;
    private javax.swing.JTextArea lobbychat_ta;
    private javax.swing.JScrollPane log_sp_ta;
    private javax.swing.JScrollPane log_sp_ta1;
    private javax.swing.JTextArea log_ta;
    private javax.swing.JTextArea message_ta;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JTextArea room_ta;
    private javax.swing.JTextArea roomid_ta;
    private javax.swing.JTextArea username_ta;
    // End of variables declaration//GEN-END:variables
}
