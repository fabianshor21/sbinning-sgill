package window;
import route.*;
import function.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
//
public class Lobby extends javax.swing.JFrame {
    //
    private DatabaseConn db = new DatabaseConn();
    private InfoHandler tip = new InfoHandler();
    public String username;
    public String opp_username;
    //
    
    public Lobby() {
        initComponents();
        header_div.setBorder(new MatteBorder(0, 0, 4, 0, Color.decode("#99A7FF")));       
        chatroom_ta.setBorder(BorderFactory.createCompoundBorder(chatroom_ta.getBorder(), BorderFactory.createEmptyBorder(3, 3, 3, 3)));
    }
    public void fetchInfo(String username) throws UnknownHostException, SocketException {
        System.out.println(this.username);
        db.showPlayerInfo(username_head_val,winrate_val,total_win_lost_val,leaderboard_val,total_race_val,max_rank_val,current_rank_val,elo_rating_val,playtime_val,this.username);
        db.setChatRoomTa(chatroom_ta);
        db.setUsernameVal(username_head_val);
        db.initChatLobby(chatroom_ta,username_head_val);
        db.setLobby(this);
        db.start();
        System.out.println("info loaded");        
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
        profile_icon_lbl = new javax.swing.JLabel();
        username_head_val = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        body_div = new javax.swing.JPanel();
        container_div = new javax.swing.JPanel();
        personal_info_div = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        winrate_val = new javax.swing.JLabel();
        total_win_lost_val = new javax.swing.JLabel();
        leaderboard_val = new javax.swing.JLabel();
        total_race_val = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        max_rank_val = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        current_rank_val = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        elo_rating_val = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        playtime_val = new javax.swing.JLabel();
        game_mode_div = new javax.swing.JPanel();
        mode_classic_div = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mode_overpower_div = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mode_rapid_div = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        info_mode_div = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        game_mode_status_val = new javax.swing.JLabel();
        game_mode_info_val = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatroom_ta = new javax.swing.JTextArea();
        chat_in = new javax.swing.JTextField();
        password_border = new javax.swing.JPanel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sbinning Sgill");
        setAutoRequestFocus(false);
        setFocusable(false);
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

        profile_icon_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-face-id-64.png"))); // NOI18N

        username_head_val.setFont(new java.awt.Font("JetBrains Mono", 3, 17)); // NOI18N
        username_head_val.setForeground(new java.awt.Color(153, 150, 245));
        username_head_val.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username_head_val.setText("--");

        logout_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-exit-sign-28.png"))); // NOI18N
        logout_btn.setBorderPainted(false);
        logout_btn.setContentAreaFilled(false);
        logout_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_btn.setFocusPainted(false);
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addGroup(header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username_head_val, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(header_divLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(profile_icon_lbl)
                .addContainerGap())
        );
        header_divLayout.setVerticalGroup(
            header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_divLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_divLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(header_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_head_val)
                            .addGroup(header_divLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(profile_icon_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(header_divLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(head_2_lbl))
                    .addComponent(head_1_lbl))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        body_div.setBackground(new java.awt.Color(255, 255, 255));

        container_div.setBackground(new java.awt.Color(255, 255, 255));

        personal_info_div.setBackground(new java.awt.Color(255, 255, 255));
        personal_info_div.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 124, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("TOTAL RACE");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 124, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("LEADERBOARD");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 124, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("WINRATE");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 124, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("WIN / LOST");

        winrate_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        winrate_val.setForeground(new java.awt.Color(102, 102, 102));
        winrate_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        winrate_val.setText("--");

        total_win_lost_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        total_win_lost_val.setForeground(new java.awt.Color(102, 102, 102));
        total_win_lost_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total_win_lost_val.setText("--");

        leaderboard_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        leaderboard_val.setForeground(new java.awt.Color(102, 102, 102));
        leaderboard_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        leaderboard_val.setText("--");

        total_race_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        total_race_val.setForeground(new java.awt.Color(102, 102, 102));
        total_race_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total_race_val.setText("--");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 124, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("MAX RANK");

        max_rank_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        max_rank_val.setForeground(new java.awt.Color(102, 102, 102));
        max_rank_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        max_rank_val.setText("--");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 124, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("CURRENT RANK");

        current_rank_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        current_rank_val.setForeground(new java.awt.Color(102, 102, 102));
        current_rank_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        current_rank_val.setText("--");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 124, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("RATING");

        elo_rating_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        elo_rating_val.setForeground(new java.awt.Color(102, 102, 102));
        elo_rating_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        elo_rating_val.setText("--");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 124, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("PLAYTIME");

        playtime_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        playtime_val.setForeground(new java.awt.Color(102, 102, 102));
        playtime_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        playtime_val.setText("--");

        javax.swing.GroupLayout personal_info_divLayout = new javax.swing.GroupLayout(personal_info_div);
        personal_info_div.setLayout(personal_info_divLayout);
        personal_info_divLayout.setHorizontalGroup(
            personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personal_info_divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(total_win_lost_val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(winrate_val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_race_val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leaderboard_val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(elo_rating_val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(current_rank_val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(max_rank_val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playtime_val, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        personal_info_divLayout.setVerticalGroup(
            personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personal_info_divLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personal_info_divLayout.createSequentialGroup()
                        .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(max_rank_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(current_rank_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elo_rating_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personal_info_divLayout.createSequentialGroup()
                        .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total_race_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(winrate_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_win_lost_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leaderboard_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personal_info_divLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personal_info_divLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(personal_info_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playtime_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(personal_info_divLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        game_mode_div.setBackground(new java.awt.Color(255, 255, 255));
        game_mode_div.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));

        mode_classic_div.setBackground(new java.awt.Color(255, 255, 153));
        mode_classic_div.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));
        mode_classic_div.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mode_classic_div.setPreferredSize(new java.awt.Dimension(131, 130));
        mode_classic_div.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mode_classic_divMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mode_classic_divMouseEntered(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-flag-2-96.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 124, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RANKED");

        javax.swing.GroupLayout mode_classic_divLayout = new javax.swing.GroupLayout(mode_classic_div);
        mode_classic_div.setLayout(mode_classic_divLayout);
        mode_classic_divLayout.setHorizontalGroup(
            mode_classic_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_classic_divLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(mode_classic_divLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mode_classic_divLayout.setVerticalGroup(
            mode_classic_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_classic_divLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mode_overpower_div.setBackground(new java.awt.Color(228, 228, 228));
        mode_overpower_div.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));
        mode_overpower_div.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mode_overpower_div.setPreferredSize(new java.awt.Dimension(131, 130));
        mode_overpower_div.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mode_overpower_divMouseEntered(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-poison-96.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 124, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GODLIKE");

        javax.swing.GroupLayout mode_overpower_divLayout = new javax.swing.GroupLayout(mode_overpower_div);
        mode_overpower_div.setLayout(mode_overpower_divLayout);
        mode_overpower_divLayout.setHorizontalGroup(
            mode_overpower_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_overpower_divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mode_overpower_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addContainerGap())
        );
        mode_overpower_divLayout.setVerticalGroup(
            mode_overpower_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_overpower_divLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        mode_rapid_div.setBackground(new java.awt.Color(228, 228, 228));
        mode_rapid_div.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));
        mode_rapid_div.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mode_rapid_div.setPreferredSize(new java.awt.Dimension(131, 130));
        mode_rapid_div.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mode_rapid_divMouseEntered(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-time-96.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 124, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("RAPID");

        javax.swing.GroupLayout mode_rapid_divLayout = new javax.swing.GroupLayout(mode_rapid_div);
        mode_rapid_div.setLayout(mode_rapid_divLayout);
        mode_rapid_divLayout.setHorizontalGroup(
            mode_rapid_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_rapid_divLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mode_rapid_divLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        mode_rapid_divLayout.setVerticalGroup(
            mode_rapid_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_rapid_divLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout game_mode_divLayout = new javax.swing.GroupLayout(game_mode_div);
        game_mode_div.setLayout(game_mode_divLayout);
        game_mode_divLayout.setHorizontalGroup(
            game_mode_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, game_mode_divLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mode_classic_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mode_overpower_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mode_rapid_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        game_mode_divLayout.setVerticalGroup(
            game_mode_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(game_mode_divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(game_mode_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mode_rapid_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mode_overpower_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mode_classic_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        info_mode_div.setBackground(new java.awt.Color(255, 255, 255));
        info_mode_div.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));

        jLabel23.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 124, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("MODE :");

        game_mode_status_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        game_mode_status_val.setForeground(new java.awt.Color(102, 102, 102));
        game_mode_status_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        game_mode_status_val.setText("RANKED");

        game_mode_info_val.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        game_mode_info_val.setForeground(new java.awt.Color(102, 102, 102));
        game_mode_info_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        game_mode_info_val.setText("RANKED PVP THAT AFFECT YOUR RATING WITH 2000 HP AT START");

        javax.swing.GroupLayout info_mode_divLayout = new javax.swing.GroupLayout(info_mode_div);
        info_mode_div.setLayout(info_mode_divLayout);
        info_mode_divLayout.setHorizontalGroup(
            info_mode_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_mode_divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info_mode_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(game_mode_info_val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(info_mode_divLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(game_mode_status_val, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        info_mode_divLayout.setVerticalGroup(
            info_mode_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_mode_divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info_mode_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(game_mode_status_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(game_mode_info_val, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 167, 255), 4));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);

        chatroom_ta.setEditable(false);
        chatroom_ta.setColumns(20);
        chatroom_ta.setFont(new java.awt.Font("JetBrains Mono", 0, 10)); // NOI18N
        chatroom_ta.setForeground(new java.awt.Color(102, 102, 102));
        chatroom_ta.setLineWrap(true);
        chatroom_ta.setRows(5);
        chatroom_ta.setWrapStyleWord(true);
        chatroom_ta.setBorder(null);
        chatroom_ta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(chatroom_ta);

        chat_in.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        chat_in.setForeground(new java.awt.Color(102, 102, 102));
        chat_in.setText("Chat goes here ...");
        chat_in.setBorder(null);
        chat_in.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        chat_in.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                chat_inFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                chat_inFocusLost(evt);
            }
        });
        chat_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chat_inActionPerformed(evt);
            }
        });

        password_border.setBackground(new java.awt.Color(153, 167, 255));
        password_border.setPreferredSize(new java.awt.Dimension(0, 8));

        javax.swing.GroupLayout password_borderLayout = new javax.swing.GroupLayout(password_border);
        password_border.setLayout(password_borderLayout);
        password_borderLayout.setHorizontalGroup(
            password_borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        password_borderLayout.setVerticalGroup(
            password_borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout container_divLayout = new javax.swing.GroupLayout(container_div);
        container_div.setLayout(container_divLayout);
        container_divLayout.setHorizontalGroup(
            container_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container_divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(info_mode_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(game_mode_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(personal_info_div, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(container_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(password_border, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(chat_in, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap())
        );
        container_divLayout.setVerticalGroup(
            container_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container_divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(container_divLayout.createSequentialGroup()
                        .addComponent(personal_info_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(game_mode_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(info_mode_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(container_divLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chat_in, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password_border, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout body_divLayout = new javax.swing.GroupLayout(body_div);
        body_div.setLayout(body_divLayout);
        body_divLayout.setHorizontalGroup(
            body_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_divLayout.createSequentialGroup()
                .addComponent(container_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        body_divLayout.setVerticalGroup(
            body_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout main_divLayout = new javax.swing.GroupLayout(main_div);
        main_div.setLayout(main_divLayout);
        main_divLayout.setHorizontalGroup(
            main_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_div, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(main_divLayout.createSequentialGroup()
                .addComponent(body_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        main_divLayout.setVerticalGroup(
            main_divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_divLayout.createSequentialGroup()
                .addComponent(header_div, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JTextArea getChatLobbyComp() {return chatroom_ta;}
    
    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        // TODO add your handling code here:
        // lgoout ke login
        Login login = new Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void mode_classic_divMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mode_classic_divMouseEntered
        // TODO add your handling code here:
        tip.manageModeInfo(game_mode_status_val, game_mode_info_val, "RANKED", "RANKED PVP THAT AFFECT YOUR RATING WITH 2000 HP AT START");
    }//GEN-LAST:event_mode_classic_divMouseEntered

    private void mode_overpower_divMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mode_overpower_divMouseEntered
        // TODO add your handling code here:
        tip.manageModeInfo(game_mode_status_val, game_mode_info_val, "GODLIKE", "POWERFUL SKILLS THAT MAKE THE RACE BECOME EVEN MORE BROKEN");        
    }//GEN-LAST:event_mode_overpower_divMouseEntered

    private void mode_rapid_divMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mode_rapid_divMouseEntered
        // TODO add your handling code here:
        tip.manageModeInfo(game_mode_status_val, game_mode_info_val, "RAPID", "TRY TO DAMAGE AS MUCH AS YOU CAN IN SUCH 3 MINUTES PACE");
    }//GEN-LAST:event_mode_rapid_divMouseEntered
    
    private void mode_classic_divMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mode_classic_divMouseClicked
        // TODO add your handling code here:
        this.opp_username = tip.sendChallenge();
        if (!this.opp_username.isEmpty() && !this.opp_username.toUpperCase().equals(username_head_val.getText())) {
            db.manageReqChallenge(username_head_val, this.opp_username);
        }
    }//GEN-LAST:event_mode_classic_divMouseClicked

    private void chat_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chat_inActionPerformed
        // TODO add your handling code here:
        db.appendChatLobby(chat_in, username_head_val);
        chat_in.setText("");
    }//GEN-LAST:event_chat_inActionPerformed

    private void chat_inFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chat_inFocusGained
        // TODO add your handling code here:
        if (chat_in.getText().equals("Chat goes here ...")) {
            chat_in.setText("");
        }
    }//GEN-LAST:event_chat_inFocusGained

    private void chat_inFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_chat_inFocusLost
        // TODO add your handling code here:
        if (chat_in.getText().isEmpty()) {
           chat_in.setText("Chat goes here ...");                    
        }
    }//GEN-LAST:event_chat_inFocusLost

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body_div;
    private javax.swing.JTextField chat_in;
    private javax.swing.JTextArea chatroom_ta;
    private javax.swing.JPanel container_div;
    private javax.swing.JLabel current_rank_val;
    private javax.swing.JLabel elo_rating_val;
    private javax.swing.JPanel game_mode_div;
    private javax.swing.JLabel game_mode_info_val;
    private javax.swing.JLabel game_mode_status_val;
    private javax.swing.JLabel head_1_lbl;
    private javax.swing.JLabel head_2_lbl;
    private javax.swing.JPanel header_div;
    private javax.swing.JPanel info_mode_div;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel leaderboard_val;
    private javax.swing.JButton logout_btn;
    private javax.swing.JPanel main_div;
    private javax.swing.JLabel max_rank_val;
    private javax.swing.JPanel mode_classic_div;
    private javax.swing.JPanel mode_overpower_div;
    private javax.swing.JPanel mode_rapid_div;
    private javax.swing.JPanel password_border;
    private javax.swing.JPanel personal_info_div;
    private javax.swing.JLabel playtime_val;
    private javax.swing.JLabel profile_icon_lbl;
    private javax.swing.JLabel total_race_val;
    private javax.swing.JLabel total_win_lost_val;
    private javax.swing.JLabel username_head_val;
    private javax.swing.JLabel winrate_val;
    // End of variables declaration//GEN-END:variables
}
