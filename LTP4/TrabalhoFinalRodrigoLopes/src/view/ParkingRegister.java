package view;

import static Controller.ControllPark.consultCnpjCtr;
import static Controller.ControllPark.deleteParkingCtr;
import static Controller.ControllPark.editParkingCtr;
import static Controller.ControllPark.insertParkingCtr;
import static Controller.ControllPark.parkReturnObjectCtr;
import static Controller.ControllPark.searchAllParkingCtr;
import static Controller.ControllPark.searchParkCodeCtr;
import static Utils.Generic.verifyObject;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Parking;
import utilitarios.LtpUtil;
import utilitarios.LtpUtilException;

/**
 *
 * @author rodrigo.martins
 */
public class ParkingRegister extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    static Parking park;

    public ParkingRegister() {
        initComponents();
        showAllParkings();
        setLocationRelativeTo(null);
        //setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//        try {
//
//            MaskFormatter maskDate;
//            MaskFormatter maskCnpj;
//
//            maskDate = new MaskFormatter("##/##/####");
//            maskCnpj = new MaskFormatter("##.###.###/####-##");
//            maskDate.install(jTextDate);
//            maskCnpj.install(jTextCnpj);
//
//        } catch (ParseException ex) {
//            Logger.getLogger(ParkingRegister.class.getName()).log(Level.SEVERE, null, ex);
//        }
        URL url = this.getClass().getResource("/images/Parking-32.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jTextCounty = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        JtextAddress = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        JtextCity = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextSlots = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextPriceMonths = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextDate = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextCode = new javax.swing.JTextField();
        jBtnClear2 = new javax.swing.JButton();
        jBtnEdit2 = new javax.swing.JButton();
        jBtnDelete2 = new javax.swing.JButton();
        jBtnRegister2 = new javax.swing.JButton();
        jBtnOpenPark2 = new javax.swing.JButton();
        jTextCnpj = new javax.swing.JFormattedTextField();
        jTextPricePerHour = new javax.swing.JFormattedTextField();
        jBtnSearchParking = new javax.swing.JButton();
        jScrollPaneHome = new javax.swing.JScrollPane();
        jTableHome = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Estacionamento - Cadastro");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Parking-100.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setText("Eagle SGE");

        jLabel11.setText("Sistema de gerenciamento de estacionamentos");

        jLabel13.setText("Versão 1.0");

        jLabel14.setText("Eagle softwares");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Falcon-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));
        jPanel8.setAutoscrolls(true);
        jPanel8.setFocusCycleRoot(true);

        jLabel26.setText("Cnpj:");

        jLabel27.setText("Nome:");

        jLabel28.setText("Endereço");

        jLabel29.setText("Cidade:");

        jLabel30.setText("Uf:");

        jLabel31.setText("Número de vagas:");

        jLabel32.setText("Tarifa por hora:");

        jLabel33.setText("Tarifa por mês:");

        jLabel34.setText("Data do registro:");

        jTextDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jTextDate.setToolTipText("");

        jLabel35.setText("Codigo:");

        jBtnClear2.setForeground(new java.awt.Color(0, 153, 255));
        jBtnClear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eraser-24.png"))); // NOI18N
        jBtnClear2.setText("Limpar e Refazer");
        jBtnClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });

        jBtnEdit2.setForeground(new java.awt.Color(153, 0, 153));
        jBtnEdit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Process-24.png"))); // NOI18N
        jBtnEdit2.setText("Atualizar Registros");
        jBtnEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnDelete2.setForeground(new java.awt.Color(153, 153, 153));
        jBtnDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete-24.png"))); // NOI18N
        jBtnDelete2.setText("Excluir Estacionamento");
        jBtnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnRegister2.setForeground(new java.awt.Color(0, 153, 51));
        jBtnRegister2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Plus-24.png"))); // NOI18N
        jBtnRegister2.setText("Registar Estacionamento");
        jBtnRegister2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegisterActionPerformed(evt);
            }
        });

        jBtnOpenPark2.setForeground(new java.awt.Color(153, 153, 0));
        jBtnOpenPark2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Unlock-24.png"))); // NOI18N
        jBtnOpenPark2.setText("Abrir estacionamento");
        jBtnOpenPark2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOpenParkActionPerformed(evt);
            }
        });

        jBtnSearchParking.setForeground(new java.awt.Color(0, 153, 204));
        jBtnSearchParking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-24.png"))); // NOI18N
        jBtnSearchParking.setText("Pesquisar Estacionamento");
        jBtnSearchParking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchParkingjBtnOpenParkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBtnClear2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEdit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDelete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRegister2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextCounty, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextCode, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel30)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(28, 28, 28)))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JtextAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(JtextCity))
                            .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPriceMonths, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextSlots, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPricePerHour, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBtnSearchParking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnOpenPark2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextSlots, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31)
                                .addComponent(jLabel35)
                                .addComponent(jTextCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(JtextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(jTextCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(jTextPriceMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(JtextCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)
                                    .addComponent(jTextPricePerHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTextCounty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30))))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnClear2)
                    .addComponent(jBtnEdit2)
                    .addComponent(jBtnDelete2)
                    .addComponent(jBtnRegister2)
                    .addComponent(jBtnOpenPark2)
                    .addComponent(jBtnSearchParking))
                .addContainerGap())
        );

        jScrollPaneHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTableHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Cnpj", "Endereço", "Cidade", "Uf", "Vagas", "Preço /D", "Preço /M", "Dat Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHomeMouseClicked(evt);
            }
        });
        jScrollPaneHome.setViewportView(jTableHome);
        if (jTableHome.getColumnModel().getColumnCount() > 0) {
            jTableHome.getColumnModel().getColumn(0).setResizable(false);
            jTableHome.getColumnModel().getColumn(1).setResizable(false);
            jTableHome.getColumnModel().getColumn(2).setResizable(false);
            jTableHome.getColumnModel().getColumn(3).setResizable(false);
            jTableHome.getColumnModel().getColumn(4).setResizable(false);
            jTableHome.getColumnModel().getColumn(5).setResizable(false);
            jTableHome.getColumnModel().getColumn(6).setResizable(false);
            jTableHome.getColumnModel().getColumn(7).setResizable(false);
            jTableHome.getColumnModel().getColumn(8).setResizable(false);
            jTableHome.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Estacionamentos cadastrados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(552, 552, 552)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(532, 532, 532)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneHome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addComponent(jScrollPaneHome, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Sair");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1232, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHomeMouseClicked

        int row = jTableHome.getSelectedRow();

        String codeStr = (String) jTableHome.getValueAt(row, 0);
        int code = (Integer) Integer.parseInt((String) jTableHome.getValueAt(row, 0));

        park = parkReturnObjectCtr(code);
        jTextCode.setText(codeStr);
        jTextName.setText(park.getNome());
        jTextCnpj.setText(park.getCnpj());
        JtextAddress.setText(park.getEndereco());
        JtextCity.setText(park.getCidade());
        jTextCounty.setText(park.getUf());
        jTextSlots.setText(String.valueOf(jTableHome.getValueAt(row, 6)));
        jTextPricePerHour.setText(String.valueOf(jTableHome.getValueAt(row, 7)));
        jTextPriceMonths.setText(String.valueOf(jTableHome.getValueAt(row, 8)));
        jTextDate.setText(String.valueOf(jTableHome.getValueAt(row, 9)));
    }//GEN-LAST:event_jTableHomeMouseClicked

    private void jBtnSearchParkingjBtnOpenParkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchParkingjBtnOpenParkActionPerformed

        if (!(jTextCode.getText().isEmpty())) {
            int code = (Integer) Integer.parseInt(jTextCode.getText());

            try {
                ResultSet resp = (ResultSet) searchParkCodeCtr(code);
                LtpUtil.loadFormatJTable(jScrollPaneHome, resp);
            } catch (SQLException | LtpUtilException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Informe o codigo para efetuar a pesquisa!");
        }

    }//GEN-LAST:event_jBtnSearchParkingjBtnOpenParkActionPerformed

    private void jBtnOpenParkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOpenParkActionPerformed

        if (verifyObject(park)) {
            new OpenParkMenu().setVisible(true);
        }
    }//GEN-LAST:event_jBtnOpenParkActionPerformed

    private void jBtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegisterActionPerformed

        if (!(jTextName.getText().isEmpty() && jTextCnpj.getText().isEmpty() && JtextCity.getText().isEmpty() && JtextAddress.getText().isEmpty()
                && jTextCounty.getText().isEmpty() && jTextDate.getText().isEmpty() && jTextPriceMonths.getText().isEmpty()
                && jTextPricePerHour.getText().isEmpty() && jTextSlots.getText().isEmpty())) {

            try {

                String name = jTextName.getText();
                String cnpj = jTextCnpj.getText();

                cnpj = cnpj.replaceAll("\\.", "");
                cnpj = cnpj.replaceAll("/", "");
                cnpj = cnpj.replaceAll("-", "");

                if (verifyCnpj(cnpj)) {

                    if (consultCnpj(cnpj)) {

                        String address = JtextAddress.getText();
                        String city = JtextCity.getText();
                        String coutry = jTextCounty.getText();
                        int numVagas = (int) Integer.parseInt(jTextSlots.getText());
                        float priceHour = (float) Float.parseFloat(jTextPricePerHour.getText());
                        float priceMoths = (float) Float.parseFloat(jTextPriceMonths.getText());

                        SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy");
                        java.util.Date invoiceDate = formatDate.parse(jTextDate.getText());
                        Date sqlDate = new java.sql.Date(invoiceDate.getTime());

                        park = new Parking(0, name, cnpj, address, city, coutry, numVagas, priceHour, priceMoths, sqlDate);

                        insertParkingCtr(park);
                        showAllParkings();
                        clearField();

                        JOptionPane.showMessageDialog(this, "Estacionamento cadastrado!");

                    }
                }

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de fazer o registro!");
        }
    }//GEN-LAST:event_jBtnRegisterActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed

        int reply = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o estacionameto?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            if (verifyObject(park)) {
                int code = park.getCod();
                deleteParkingCtr(code);
                showAllParkings();
                JOptionPane.showMessageDialog(this, "Estacionamento removido!");
                clearField();
            }
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed

        if (verifyObject(park)) {

            int row = jTableHome.getSelectedRow();

            String codeStr = (String) jTableHome.getValueAt(row, 0);
            int code = (Integer) Integer.parseInt((String) jTableHome.getValueAt(row, 0));

            try {
                park = database.ParkingSQL.parkReturnObject(code);

                String name = jTextName.getText();
                park.setNome(name);
                String cnpj = jTextCnpj.getText();

                cnpj = cnpj.replaceAll("\\.", "");
                cnpj = cnpj.replaceAll("/", "");
                cnpj = cnpj.replaceAll("-", "");

                if (consultCnpj(cnpj)) {

                    if (verifyCnpj(cnpj)) {

                        park.setCnpj(cnpj);
                        String address = JtextAddress.getText();
                        park.setEndereco(address);
                        String city = JtextCity.getText();
                        park.setCidade(city);
                        String coutry = jTextCounty.getText();
                        park.setUf(coutry);

                        int numVagas = (int) Integer.parseInt(jTextSlots.getText());
                        park.setNum_vagas(numVagas);

                        String priceHourStr = jTextPricePerHour.getText();
                        String priceMonthStr = jTextPriceMonths.getText();
                        priceHourStr = priceHourStr.replaceAll(",", ".");
                        priceMonthStr = priceMonthStr.replaceAll(",", ".");

                        float priceHour = (float) Float.parseFloat(priceHourStr);
                        float priceMoths = (float) Float.parseFloat(priceMonthStr);

                        editParkingCtr(park);
                        showAllParkings();
                        clearField();
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(ParkingRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        clearField();
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void clearField() {

        jTextCnpj.setText("");
        jTextCode.setText("");
        jTextCounty.setText("");
        jTextDate.setText("");
        jTextName.setText("");
        jTextPriceMonths.setText("");
        jTextPricePerHour.setText("");
        jTextSlots.setText("");
        JtextCity.setText("");
        JtextAddress.setText("");
        showAllParkings();
        park = null;
    }

    private void showAllParkings() {
        try {
            ResultSet resp = (ResultSet) searchAllParkingCtr();
            LtpUtil.loadFormatJTable(jScrollPaneHome, resp);
        } catch (SQLException | LtpUtilException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public boolean consultCnpj(String cnpj) {

        if (consultCnpjCtr(cnpj)) {
            JOptionPane.showMessageDialog(this, "Ja existe um estacionamento com o cnpj informado!");
            return false;
        }
        return true;
    }

    public boolean verifyCnpj(String cnpj) {

        if (LtpUtil.validarCNPJ(cnpj)) {
            return true;
        }
        JOptionPane.showMessageDialog(this, "Cnpj informado invalido!");
        return false;
    }

    public static Parking returnObject() {
        return park;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParkingRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParkingRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextAddress;
    private javax.swing.JTextField JtextCity;
    private javax.swing.JButton jBtnClear2;
    private javax.swing.JButton jBtnDelete2;
    private javax.swing.JButton jBtnEdit2;
    private javax.swing.JButton jBtnOpenPark2;
    private javax.swing.JButton jBtnRegister2;
    private javax.swing.JButton jBtnSearchParking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPaneHome;
    private javax.swing.JTable jTableHome;
    private javax.swing.JFormattedTextField jTextCnpj;
    private javax.swing.JTextField jTextCode;
    private javax.swing.JTextField jTextCounty;
    private javax.swing.JFormattedTextField jTextDate;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextPriceMonths;
    private javax.swing.JFormattedTextField jTextPricePerHour;
    private javax.swing.JTextField jTextSlots;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
