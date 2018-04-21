package tsn.jdbc.gui2;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tsn.jdbc.DbComboBox;
import tsn.jdbc.DbTableModel;
import tsn.jdbc.DbTableNavigator;
import tsn.jdbc.DbTable;
import tsn.jdbc.DbConnection;
import tsn.utils.jtable.ExporterViewJTable;

/**
 * Работа с базой данных Derby в Java
 *
 * @author Талипов С.Н.
 */
public class MainForm extends javax.swing.JFrame {

    // Соединение с базой данных
    DbConnection dbConnection;

    // Таблицы БД
    DbTable dbTable_DISK_1;
    DbTable dbTable_FIRM_2;
    DbTable dbTable_CITY_3;
    DbTable dbTable_TDISK_4;

    // Модели таблиц БД
    DbTableModel dbModel_DISK_1;
    DbTableModel dbModel_FIRM_2;
    DbTableModel dbModel_CITY_3;
    DbTableModel dbModel_TDISK_4;

    // Навигаторы по таблицам БД
    DbTableNavigator dbTableNavigator_DISK_1;
    DbTableNavigator dbTableNavigator_FIRM_2;
    DbTableNavigator dbTableNavigator_CITY_3;
    DbTableNavigator dbTableNavigator_TDISK_4;

    // Окна редактирования записей таблиц БД
    EditorForm_DISK_1 editorForm_DISK_1 = new EditorForm_DISK_1(new javax.swing.JFrame(), true);
    EditorForm_FIRM_2 editorForm_FIRM_2 = new EditorForm_FIRM_2(new javax.swing.JFrame(), true);

    public MainForm() {

        initComponents();

        initializationDB();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton12 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Navigator_DISK_1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField_DISK1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_DISK_1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_FIRM_2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_Navigator_FIRM_2 = new javax.swing.JTable();
        jTextField_FIRM_2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_TDISK_4 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_Navigator_TDISK_4 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_CITY_3 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable_Navigator_CITY_3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel_DISK_1 = new javax.swing.JLabel();
        jLabel_FIRM_2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel_TS = new javax.swing.JPanel();
        jLabel_TS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Работа с базой данных Derby в Java");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton12.setText("Выход");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(870, 450, 100, 30);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel2.setLayout(null);

        jTable_Navigator_DISK_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "           <<", "            <", "            >", "          >>", "         добавить", "         удалить", "        обновить", "    редактир."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Navigator_DISK_1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable_Navigator_DISK_1);
        if (jTable_Navigator_DISK_1.getColumnModel().getColumnCount() > 0) {
            jTable_Navigator_DISK_1.getColumnModel().getColumn(0).setResizable(false);
            jTable_Navigator_DISK_1.getColumnModel().getColumn(1).setResizable(false);
            jTable_Navigator_DISK_1.getColumnModel().getColumn(2).setResizable(false);
            jTable_Navigator_DISK_1.getColumnModel().getColumn(3).setResizable(false);
            jTable_Navigator_DISK_1.getColumnModel().getColumn(4).setResizable(false);
            jTable_Navigator_DISK_1.getColumnModel().getColumn(5).setResizable(false);
            jTable_Navigator_DISK_1.getColumnModel().getColumn(6).setResizable(false);
            jTable_Navigator_DISK_1.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel2.add(jScrollPane5);
        jScrollPane5.setBounds(10, 290, 940, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);
        jPanel1.add(jTextField_DISK1);
        jTextField_DISK1.setBounds(210, 10, 100, 30);

        jLabel3.setText("Фильтр по названию диска:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 14, 200, 20);

        jButton7.setText("Включить");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(320, 10, 110, 30);

        jButton8.setText("Выключить");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(450, 10, 110, 30);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(630, 10, 140, 30);

        jLabel6.setText("Поиск:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(570, 14, 50, 20);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(10, 340, 780, 50);

        jScrollPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable_DISK_1.setAutoCreateRowSorter(true);
        jTable_DISK_1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_DISK_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_DISK_1.setFillsViewportHeight(true);
        jTable_DISK_1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable_DISK_1.setName("777"); // NOI18N
        jTable_DISK_1.setRowHeight(20);
        jTable_DISK_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DISK_1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_DISK_1);
        jTable_DISK_1.getAccessibleContext().setAccessibleName("tsn");

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 940, 270);

        jButton2.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        jButton2.setText("Увеличить цену");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(810, 330, 130, 30);

        jButton3.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        jButton3.setText("Уменьшить цену");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(810, 360, 130, 31);

        jTabbedPane1.addTab("Диски", jPanel2);

        jPanel3.setLayout(null);

        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable_FIRM_2.setAutoCreateRowSorter(true);
        jTable_FIRM_2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_FIRM_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_FIRM_2.setFillsViewportHeight(true);
        jTable_FIRM_2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable_FIRM_2.setName("777"); // NOI18N
        jTable_FIRM_2.setRowHeight(20);
        jTable_FIRM_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_FIRM_2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_FIRM_2);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(10, 10, 940, 320);

        jTable_Navigator_FIRM_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "       <<", "       <", "       >", "       >>", "    добавить", "     удалить", "     обнов.", "     редакт."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Navigator_FIRM_2.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTable_Navigator_FIRM_2);
        if (jTable_Navigator_FIRM_2.getColumnModel().getColumnCount() > 0) {
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(0).setResizable(false);
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(1).setResizable(false);
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(2).setResizable(false);
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(3).setResizable(false);
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(4).setResizable(false);
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(5).setResizable(false);
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(6).setResizable(false);
            jTable_Navigator_FIRM_2.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel3.add(jScrollPane6);
        jScrollPane6.setBounds(210, 350, 740, 30);

        jTextField_FIRM_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_FIRM_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_FIRM_2KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField_FIRM_2);
        jTextField_FIRM_2.setBounds(20, 360, 170, 24);

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        jLabel7.setText("Быстрый фильтр по названию:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(20, 340, 190, 20);

        jTabbedPane1.addTab("Фирмы", jPanel3);

        jPanel6.setLayout(null);

        jScrollPane4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable_TDISK_4.setAutoCreateRowSorter(true);
        jTable_TDISK_4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_TDISK_4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_TDISK_4.setFillsViewportHeight(true);
        jTable_TDISK_4.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable_TDISK_4.setName("777"); // NOI18N
        jTable_TDISK_4.setRowHeight(20);
        jScrollPane4.setViewportView(jTable_TDISK_4);

        jPanel6.add(jScrollPane4);
        jScrollPane4.setBounds(520, 30, 420, 320);

        jTable_Navigator_TDISK_4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "       <<", "       <", "       >", "       >>", "        +", "         -", "        O"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Navigator_TDISK_4.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable_Navigator_TDISK_4);
        if (jTable_Navigator_TDISK_4.getColumnModel().getColumnCount() > 0) {
            jTable_Navigator_TDISK_4.getColumnModel().getColumn(0).setResizable(false);
            jTable_Navigator_TDISK_4.getColumnModel().getColumn(1).setResizable(false);
            jTable_Navigator_TDISK_4.getColumnModel().getColumn(2).setResizable(false);
            jTable_Navigator_TDISK_4.getColumnModel().getColumn(3).setResizable(false);
            jTable_Navigator_TDISK_4.getColumnModel().getColumn(4).setResizable(false);
            jTable_Navigator_TDISK_4.getColumnModel().getColumn(5).setResizable(false);
            jTable_Navigator_TDISK_4.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel6.add(jScrollPane7);
        jScrollPane7.setBounds(520, 360, 420, 30);

        jScrollPane8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable_CITY_3.setAutoCreateRowSorter(true);
        jTable_CITY_3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable_CITY_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_CITY_3.setFillsViewportHeight(true);
        jTable_CITY_3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable_CITY_3.setName("777"); // NOI18N
        jTable_CITY_3.setRowHeight(20);
        jScrollPane8.setViewportView(jTable_CITY_3);

        jPanel6.add(jScrollPane8);
        jScrollPane8.setBounds(20, 30, 480, 320);

        jTable_Navigator_CITY_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "       <<", "       <", "       >", "       >>", "        +", "        -", "        O"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Navigator_CITY_3.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jTable_Navigator_CITY_3);
        if (jTable_Navigator_CITY_3.getColumnModel().getColumnCount() > 0) {
            jTable_Navigator_CITY_3.getColumnModel().getColumn(0).setResizable(false);
            jTable_Navigator_CITY_3.getColumnModel().getColumn(1).setResizable(false);
            jTable_Navigator_CITY_3.getColumnModel().getColumn(2).setResizable(false);
            jTable_Navigator_CITY_3.getColumnModel().getColumn(3).setResizable(false);
            jTable_Navigator_CITY_3.getColumnModel().getColumn(4).setResizable(false);
            jTable_Navigator_CITY_3.getColumnModel().getColumn(5).setResizable(false);
            jTable_Navigator_CITY_3.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel6.add(jScrollPane9);
        jScrollPane9.setBounds(20, 360, 480, 30);

        jLabel1.setText("Города:");
        jPanel6.add(jLabel1);
        jLabel1.setBounds(150, 10, 70, 17);

        jLabel2.setText("Типы дисков:");
        jPanel6.add(jLabel2);
        jLabel2.setBounds(660, 10, 90, 17);

        jTabbedPane1.addTab("Города и типы дисков", jPanel6);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 10, 960, 430);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Средняя продажная цена"));
        jPanel4.setLayout(null);

        jButton4.setText("Найти");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(20, 30, 80, 30);

        jTextField3.setEditable(false);
        jPanel4.add(jTextField3);
        jTextField3.setBounds(110, 30, 130, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(140, 440, 260, 80);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tsn/jdbc/gui2/jdbc.png"))); // NOI18N
        jLabel4.setText(" ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 440, 80, 70);

        jProgressBar1.setIndeterminate(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(20, 510, 76, 10);

        jButton5.setText("ОТЧЕТ ПО ДИСКАМ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(440, 440, 150, 30);

        jButton6.setText("ОТЧЕТ ПО ФИРМАМ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(630, 440, 150, 30);

        jLabel_DISK_1.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        jLabel_DISK_1.setText("???");
        getContentPane().add(jLabel_DISK_1);
        jLabel_DISK_1.setBounds(420, 480, 270, 16);

        jLabel_FIRM_2.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        jLabel_FIRM_2.setText("???");
        getContentPane().add(jLabel_FIRM_2);
        jLabel_FIRM_2.setBounds(420, 500, 270, 16);

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(null);

        jPanel_TS.setLayout(null);

        jLabel_TS.setFont(new java.awt.Font("Noto Sans", 0, 11)); // NOI18N
        jLabel_TS.setText("Java DB technology by Talipov S.N., 2018");
        jPanel_TS.add(jLabel_TS);
        jLabel_TS.setBounds(260, 4, 250, 16);

        jPanel5.add(jPanel_TS);
        jPanel_TS.setBounds(10, 4, 250, 20);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(700, 490, 270, 30);

        setSize(new java.awt.Dimension(990, 555));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Инициализация подсистемы доступа к БД
    void initializationDB() {
        try {
            // Подключение к базе данных
            for (int port = 1527; port <= 1535; port++) {
                try {
                    dbConnection = new DbConnection("MyBase2", "disks", "tsn", "tsn", port);
                    break;
                } catch (Exception e) {
                }
            }
            // Подключение к таблицам БД
            dbTable_DISK_1 = new DbTable(dbConnection, "DISK_1") {
                @Override
                public void afterUpdateFromDB() {
                    try {
                        clearLookupField();
                        addLookupField("ID_FIRM", dbTable_FIRM_2.getLookupList("ID", "NAME_FIRM"));
                        addLookupField("ID_TYPE_DISK", dbTable_TDISK_4.getLookupList("ID", "NAME_TYPE_DISK"));
                    } catch (Exception ex) {
                    }
                }

                @Override
                public void beforeAppendNewRecord() {
                    try {
                        clearLookupField();
                        addLookupField("ID_FIRM", new DbComboBox(dbTable_FIRM_2, "ID", "NAME_FIRM").getIdForSelectedRow());
                        addLookupField("ID_TYPE_DISK", new DbComboBox(dbTable_TDISK_4, "ID", "NAME_TYPE_DISK").getIdForSelectedRow());
                    } catch (Exception ex) {
                    }
                }

                @Override
                public String getFilter() {
                    String s = jTextField_DISK1.getText().trim().toUpperCase();
                    if (s.equals("")) {
                        return "";
                    } else {
                        return "UPPER(NAME_DISK) LIKE '" + s + "%'";
                    }
                }
            };

            dbTable_FIRM_2 = new DbTable(dbConnection, "FIRM_2") {
                @Override
                public void afterUpdateFromDB() {
                    try {
                        dbTable_FIRM_2.clearLookupField();
                        dbTable_FIRM_2.addLookupField("ID_CITY", dbTable_CITY_3.getLookupList("ID", "NAME_CITY"));
                    } catch (Exception ex) {
                    }
                }

                @Override
                public void beforeAppendNewRecord() {
                    try {
                        dbTable_FIRM_2.clearLookupField();
                        dbTable_FIRM_2.addLookupField("ID_CITY", new DbComboBox(dbTable_CITY_3, "ID", "NAME_CITY").getIdForSelectedRow());
                    } catch (Exception ex) {
                    }
                }

                @Override
                public String getFilter() {
                    String s = jTextField_FIRM_2.getText().trim().toUpperCase();
                    if (s.equals("")) {
                        return "";
                    } else {
                        return "UPPER(NAME_FIRM) LIKE '" + s + "%'";
                    }
                }
            };

            dbTable_CITY_3 = new DbTable(dbConnection, "CITY_3") {
                @Override
                public void beforeAppendNewRecord() {
                    try {
                        data.updateString("NAME_CITY", "<новый город>");
                    } catch (Exception ex) {
                    }
                }
            };
            dbTable_TDISK_4 = new DbTable(dbConnection, "TDISK_4") {
                @Override
                public void beforeAppendNewRecord() {
                    try {
                        data.updateString("NAME_TYPE_DISK", "<новый тип диска>");
                    } catch (Exception ex) {
                    }
                }
            };

            // Создаем навигаторы по записям для таблиц БД
            dbTableNavigator_DISK_1 = new DbTableNavigator(jTable_DISK_1, dbTable_DISK_1, false);
            dbTableNavigator_DISK_1.initColumnTable(new int[]{0},
                    new String[]{"Наименование диска", "Цена покуп.", "Цена прод.", "Фирма", "Тип диска", "Дисков в комп."},
                    new int[]{230, 90, 90, 200, 200, 100});

            dbTableNavigator_FIRM_2 = new DbTableNavigator(jTable_FIRM_2, dbTable_FIRM_2, false);
            dbTableNavigator_FIRM_2.initColumnTable(new int[]{0},
                    new String[]{"Название фирмы", "Город", "Телефон агента", "Телефон дирек.", "ФИО агента", "ФИО директора"},
                    new int[]{175, 175, 110, 110, 175, 175});

            dbTableNavigator_CITY_3 = new DbTableNavigator(jTable_CITY_3, dbTable_CITY_3, true);
            dbTableNavigator_CITY_3.initColumnTable(new int[]{0},
                    new String[]{"Название города", "Тел. код"}, new int[]{360, 100});

            dbTableNavigator_TDISK_4 = new DbTableNavigator(jTable_TDISK_4, dbTable_TDISK_4, true);
            dbTableNavigator_TDISK_4.initColumnTable(new int[]{0},
                    new String[]{"Название типа диска"}, new int[]{400
                    });

            // Настройка визуальых навигаторов
            jTable_Navigator_DISK_1.getTableHeader()
                    .addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            int act = jTable_Navigator_DISK_1.columnAtPoint(new Point(evt.getX(), evt.getY()));
                            boolean success = dbTableNavigator_DISK_1.execAction(act);
                            switch (act) {
                                case 4: {
                                    // Добавить запись
                                    if (success) {
                                        jTable_DISK_1MouseClicked(null);
                                    }
                                    break;
                                }
                                case 7: {
                                    // Редактирование данных записи
                                    jTable_DISK_1MouseClicked(null);
                                    break;
                                }
                            }
                        }
                    });

            jTable_Navigator_FIRM_2.getTableHeader()
                    .addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            int act = jTable_Navigator_FIRM_2.columnAtPoint(new Point(evt.getX(), evt.getY()));
                            boolean success = dbTableNavigator_FIRM_2.execAction(act);
                            switch (act) {
                                case 4: {
                                    // Добавить запись
                                    if (success) {
                                        jTable_FIRM_2MouseClicked(null);
                                    }
                                    break;
                                }
                                case 7: {
                                    // Редактирование данных записи
                                    jTable_FIRM_2MouseClicked(null);
                                    break;
                                }
                            }
                        }
                    });

            jTable_Navigator_CITY_3.getTableHeader()
                    .addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            int act = jTable_Navigator_CITY_3.columnAtPoint(new Point(evt.getX(), evt.getY()));
                            dbTableNavigator_CITY_3.execAction(act);
                        }
                    });

            jTable_Navigator_TDISK_4.getTableHeader()
                    .addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            int act = jTable_Navigator_TDISK_4.columnAtPoint(new Point(evt.getX(), evt.getY()));
                            dbTableNavigator_TDISK_4.execAction(act);
                        }
                    });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Нет доступа к данным!\n Аварийное завершение работы",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            jButton12ActionPerformed(null);
        }

        // Таймеры для показа количества записей в таблицах ДБ
        final javax.swing.Timer jTimer1 = new javax.swing.Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) { // МЕТОД ТАЙМЕРА 1
                try {
                    jLabel_DISK_1.setText("Всего доступных записей в табл. дисков: " + dbTableNavigator_DISK_1.getRecordCountTable());
                } catch (Exception e) {
                    jLabel_DISK_1.setText("");
                }
                try {
                    jLabel_FIRM_2.setText("Всего доступных записей в табл. фирм: " + dbTableNavigator_FIRM_2.getRecordCountTable());
                } catch (Exception e) {
                    jLabel_FIRM_2.setText("");
                }
                try {
                    Point p = jLabel_TS.getLocation();
                    p.x--;
                    if (p.x <= -jLabel_TS.getWidth()) {
                        p.x = jPanel_TS.getWidth();
                    }
                    jLabel_TS.setLocation(p);
                } catch (Exception e) {
                }
            }
        });
        jTimer1.start();

    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Фильтрация данных
        dbTableNavigator_DISK_1.updateFromDbTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // Выход
        formWindowClosing(null);
        System.exit(0);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Выход
        try {
            // Закрытие таблиц БД
            dbTable_DISK_1.close();
            dbTable_FIRM_2.close();
            dbTable_CITY_3.close();
            dbTable_TDISK_4.close();
            // Закрытие соединения к БД
            dbConnection.close();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTable_DISK_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DISK_1MouseClicked
        // РЕДАКТИРОВАНИЕ ЗАПИСИ ТАБЛИЦЫ БД ПО ДИСКАМ
        try {
            // Если не добавление новой записи или одинарный щелчок мышью, то выход
            if (evt != null) { if (evt.getClickCount() == 1) { return; } }
            editorForm_DISK_1.initData(jTable_DISK_1, dbTable_DISK_1, dbTable_FIRM_2, dbTable_TDISK_4);
            editorForm_DISK_1.setVisible(true); // Вызвать окно редактора таблицы DISK_1
            if (editorForm_DISK_1.delete_record == true) { // Если нужно удалить запись
                dbTableNavigator_DISK_1.delete();
            } else {
                if (editorForm_DISK_1.save_data == true) { // Если данные изменились
                    dbTableNavigator_DISK_1.updateFromDbTable();
                }
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jTable_DISK_1MouseClicked

    private void jTable_FIRM_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_FIRM_2MouseClicked
        // РЕДАКТИРОВАНИЕ ЗАПИСИ ТАБЛИЦЫ БД ПО ФИРМАМ
        try {
            // Если не добавление новой записи или одинарный щелчок мышью, то выход
            if (evt != null) { if (evt.getClickCount() == 1) { return; } }
            editorForm_FIRM_2.initData(jTable_FIRM_2, dbTable_FIRM_2, dbTable_CITY_3);
            editorForm_FIRM_2.setVisible(true); // Вызвать окно редактора таблицы DISK_1
            if (editorForm_FIRM_2.delete_record == true) { // Если нужно удалить запись
                dbTableNavigator_FIRM_2.delete();
            } else {
                if (editorForm_FIRM_2.save_data == true) { // Если данные изменились
                    dbTableNavigator_FIRM_2.updateFromDbTable();
                }
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jTable_FIRM_2MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // Обновление данных при переключении вкладок
        try {
            switch (jTabbedPane1.getSelectedIndex()) {
                case 0: {
                    dbTableNavigator_TDISK_4.updateFromDbTable();
                    dbTableNavigator_FIRM_2.updateFromDbTable();
                    dbTableNavigator_DISK_1.updateFromDbTable();
                    break;
                }
                case 1: {
                    dbTableNavigator_CITY_3.updateFromDbTable();
                    dbTableNavigator_FIRM_2.updateFromDbTable();
                    break;
                }
                case 2: {
                    dbTableNavigator_CITY_3.updateFromDbTable();
                    dbTableNavigator_TDISK_4.updateFromDbTable();
                    break;
                }
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Выключение фильтра
        jTextField_DISK1.setText("");
        dbTableNavigator_DISK_1.updateFromDbTable();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // Поиск записи
        dbTableNavigator_DISK_1.find(0, jTextField2.getText());
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Увеличение цены
        try {
            String filter = dbTable_DISK_1.getFilter();
            if (filter.equals("")) {
                dbTable_DISK_1.ExecSql("UPDATE DISK_1 SET PRICE_SEL = PRICE_SEL + 1.00");
            } else {
                dbTable_DISK_1.ExecSql("UPDATE DISK_1 SET PRICE_SEL = PRICE_SEL + 1.00 WHERE " + dbTable_DISK_1.getFilter());
            }
            dbTableNavigator_DISK_1.updateFromDbTable();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Уменьшиние цены
        try {
            String filter = dbTable_DISK_1.getFilter();
            if (filter.equals("")) {
                dbTable_DISK_1.ExecSql("UPDATE DISK_1 SET PRICE_SEL = PRICE_SEL - 1.00");
            } else {
                dbTable_DISK_1.ExecSql("UPDATE DISK_1 SET PRICE_SEL = PRICE_SEL - 1.00 WHERE " + dbTable_DISK_1.getFilter());
            }
            dbTableNavigator_DISK_1.updateFromDbTable();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Расчет средней продажной цены
        try {
            float s = 0;
            int colRow;
            dbTable_DISK_1.data.beforeFirst();
            while (dbTable_DISK_1.data.next()) {
                s += dbTable_DISK_1.data.getFloat("PRICE_SEL");
            }
            dbTable_DISK_1.data.last();
            colRow = dbTable_DISK_1.data.getRow();
            s /= colRow;
            jTextField3.setText(String.format("%.2f", s));
        } catch (Exception ex) {
            jTextField3.setText("<нет данных>");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // ОТЧЕТ ПО ДИСКАМ
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ExporterViewJTable(jTable_DISK_1,
                        "Отчет по дискам", "Report_disk", new String[]{"ОТЧЕТ", "по дискам"},
                        new String[]{"___________", "Подпись"});
            }
        }).start();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // ОТЧЕТ ПО ФИРМАМ
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ExporterViewJTable(jTable_FIRM_2,
                        "Отчет по фирмам", "Report_firm", new String[]{"ОТЧЕТ", "по фирмам"},
                        new String[]{"___________", "Подпись"});
            }
        }).start();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField_FIRM_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_FIRM_2KeyReleased
        // Фильтр по названию фирмы
        dbTableNavigator_FIRM_2.updateFromDbTable();
    }//GEN-LAST:event_jTextField_FIRM_2KeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MainForm().setVisible(true);
                } catch (Exception ex) {
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_DISK_1;
    private javax.swing.JLabel jLabel_FIRM_2;
    private javax.swing.JLabel jLabel_TS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_TS;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_CITY_3;
    private javax.swing.JTable jTable_DISK_1;
    private javax.swing.JTable jTable_FIRM_2;
    private javax.swing.JTable jTable_Navigator_CITY_3;
    private javax.swing.JTable jTable_Navigator_DISK_1;
    private javax.swing.JTable jTable_Navigator_FIRM_2;
    private javax.swing.JTable jTable_Navigator_TDISK_4;
    private javax.swing.JTable jTable_TDISK_4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField_DISK1;
    private javax.swing.JTextField jTextField_FIRM_2;
    // End of variables declaration//GEN-END:variables
}
