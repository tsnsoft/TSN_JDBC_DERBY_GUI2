package tsn.jdbc.gui2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import tsn.jdbc.DbComboBox;
import tsn.jdbc.DbTable;

public class EditorForm_DISK_1 extends javax.swing.JDialog {
    private JTable table;
    private ResultSet rs;
    private DbTable dbTable_FIRM_2;
    private DbTable dbTable_TDISK_4;
    private DbComboBox DbComboBox_FIRM_2;
    private DbComboBox DbComboBox_TDISK_4;
    public boolean save_data;
    public boolean delete_record;

    public EditorForm_DISK_1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.delete_record = false;
        this.save_data = false;

        initComponents();

        // Обработчик формы на клавишу "ESC"
        ActionListener escListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(null);
            }
        };
        // Обработчик формы на клавишу "Enter"
        ActionListener enterListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(null);
            }
        };

        // Активизация обработчика формы на клавишу "ESC"
        getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        // Активизация обработчик формы на клавишу "Enter"
        getRootPane().registerKeyboardAction(enterListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_NAME_DISK = new javax.swing.JTextField();
        jComboBox_FIRM = new javax.swing.JComboBox();
        jComboBox_TYPE_DISK = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpinner_PRICE_PUR = new javax.swing.JSpinner();
        jSpinner_DISKS_SET = new javax.swing.JSpinner();
        jSpinner_PRICE_SEL = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Редактирование записи");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jTextField_NAME_DISK);
        jTextField_NAME_DISK.setBounds(30, 30, 510, 30);

        jComboBox_FIRM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_FIRM);
        jComboBox_FIRM.setBounds(230, 90, 310, 30);

        jComboBox_TYPE_DISK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_TYPE_DISK);
        jComboBox_TYPE_DISK.setBounds(230, 150, 310, 30);

        jButton1.setText("Сохранить и выйти");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 283, 240, 30);

        jButton2.setText("Отменить и выйти");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 280, 190, 30);

        jLabel1.setText("Наименование диска:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 10, 300, 17);

        jLabel2.setText("Цена покупная:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 140, 17);

        jLabel3.setText("Цена продажная:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 150, 17);

        jLabel4.setText("Количество дисков в комплекте:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 200, 240, 17);

        jLabel5.setText("Фирма:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 70, 90, 17);

        jLabel6.setText("Тип диска:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(240, 130, 120, 17);

        jSpinner_PRICE_PUR.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        getContentPane().add(jSpinner_PRICE_PUR);
        jSpinner_PRICE_PUR.setBounds(30, 90, 110, 30);

        jSpinner_DISKS_SET.setModel(new javax.swing.SpinnerNumberModel());
        getContentPane().add(jSpinner_DISKS_SET);
        jSpinner_DISKS_SET.setBounds(30, 220, 110, 30);

        jSpinner_PRICE_SEL.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        getContentPane().add(jSpinner_PRICE_SEL);
        jSpinner_PRICE_SEL.setBounds(30, 150, 110, 30);

        setSize(new java.awt.Dimension(580, 376));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void initData(JTable jTable, DbTable dbTable, DbTable dbTable_FIRM_2, DbTable dbTable_TDISK_5) throws SQLException {
        // Инициализация данных 
        this.table = jTable;
        this.rs = dbTable.data;
        this.dbTable_FIRM_2 = dbTable_FIRM_2;
        this.dbTable_TDISK_4 = dbTable_TDISK_5;
        loadData();
    }

    private void loadData() throws SQLException {
        // ЗАГРУЗКА ДАННЫХ С ТАБЛИЦЫ БД
        int rowIndex = table.convertRowIndexToModel(table.getSelectedRow());
        rs.absolute(rowIndex + 1);
        jTextField_NAME_DISK.setText(rs.getString("NAME_DISK"));
        jSpinner_PRICE_PUR.setValue(rs.getDouble("PRICE_PUR"));
        jSpinner_PRICE_SEL.setValue(rs.getDouble("PRICE_SEL"));
        jSpinner_DISKS_SET.setValue(rs.getInt("NUM_DISKS_SET"));
        DbComboBox_FIRM_2 = new DbComboBox(jComboBox_FIRM, dbTable_FIRM_2, "ID", "NAME_FIRM");
        DbComboBox_TDISK_4 = new DbComboBox(jComboBox_TYPE_DISK, dbTable_TDISK_4, "ID", "NAME_TYPE_DISK");
        jComboBox_FIRM.setSelectedIndex(DbComboBox_FIRM_2.getRowNumberForId(rs.getInt("ID_FIRM")));
        jComboBox_TYPE_DISK.setSelectedIndex(DbComboBox_TDISK_4.getRowNumberForId(rs.getInt("ID_TYPE_DISK")));
        save_data = false; delete_record = false;
    }

    private void updateData() throws SQLException {
        // СОХРАНЕНИЕ ДАННЫХ В ТАБЛИЦУ БД
        rs.updateString("NAME_DISK", jTextField_NAME_DISK.getText());
        rs.updateDouble("PRICE_PUR", (double) jSpinner_PRICE_PUR.getValue());
        rs.updateDouble("PRICE_SEL", (double) jSpinner_PRICE_SEL.getValue());
        rs.updateInt("NUM_DISKS_SET", (int) jSpinner_DISKS_SET.getValue());
        rs.updateInt("ID_FIRM", DbComboBox_FIRM_2.getIdForSelectedRow());
        rs.updateInt("ID_TYPE_DISK", DbComboBox_TDISK_4.getIdForSelectedRow());
        rs.updateRow();
        save_data = true; delete_record = false;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Кнопка отмены и выхода        
        try { 
            if (rs.getString("NAME_DISK").isEmpty()) { delete_record = true; }
        } catch (Exception ex) { delete_record = true; }
        save_data = false; dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Кнопка сохранения данных в таблицу БД
        try { 
            if (!jTextField_NAME_DISK.getText().equals("")) {
                updateData(); dispose();
            } else {
                jTextField_NAME_DISK.requestFocus();
                JOptionPane.showMessageDialog(rootPane, "Задайтие название диска!");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Закрытие окна
        jButton2ActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox_FIRM;
    private javax.swing.JComboBox jComboBox_TYPE_DISK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jSpinner_DISKS_SET;
    private javax.swing.JSpinner jSpinner_PRICE_PUR;
    private javax.swing.JSpinner jSpinner_PRICE_SEL;
    private javax.swing.JTextField jTextField_NAME_DISK;
    // End of variables declaration//GEN-END:variables
}
