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

public class EditorForm_FIRM_2 extends javax.swing.JDialog {
    private JTable table;
    private ResultSet rs;
    private DbTable dbTable_CITY_3;
    private DbComboBox DbComboBox_CITY_3;
    public boolean save_data;
    public boolean delete_record;

    public EditorForm_FIRM_2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.save_data = false;
        this.delete_record = false;

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

        jTextField_NAME_DIRECTOR = new javax.swing.JTextField();
        jComboBox_CITY = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_NAME_FIRM = new javax.swing.JTextField();
        jTextField_AGENT_TEL = new javax.swing.JTextField();
        jTextField_DIRECTOR_TEL = new javax.swing.JTextField();
        jTextField_NAME_AGENT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Редактирование записи");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jTextField_NAME_DIRECTOR);
        jTextField_NAME_DIRECTOR.setBounds(30, 270, 510, 30);

        jComboBox_CITY.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_CITY);
        jComboBox_CITY.setBounds(30, 330, 510, 30);

        jButton1.setText("Сохранить и выйти");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 390, 220, 30);

        jButton2.setText("Отменить и выйти");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 390, 170, 30);

        jLabel1.setText("Наименование фирмы:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 10, 260, 17);

        jLabel2.setText("Телефон агента:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 70, 250, 17);

        jLabel3.setText("Телефон директора:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 130, 300, 17);

        jLabel4.setText("ФИО агента:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 190, 370, 17);

        jLabel5.setText("Город:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 310, 220, 17);

        jLabel6.setText("ФИО директора:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 250, 360, 17);
        getContentPane().add(jTextField_NAME_FIRM);
        jTextField_NAME_FIRM.setBounds(30, 30, 510, 30);
        getContentPane().add(jTextField_AGENT_TEL);
        jTextField_AGENT_TEL.setBounds(30, 90, 510, 30);
        getContentPane().add(jTextField_DIRECTOR_TEL);
        jTextField_DIRECTOR_TEL.setBounds(30, 150, 510, 30);
        getContentPane().add(jTextField_NAME_AGENT);
        jTextField_NAME_AGENT.setBounds(30, 210, 510, 30);

        setSize(new java.awt.Dimension(580, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void initData(JTable jTable, DbTable dbTable, DbTable dbTable_CITY_3) throws SQLException {
        // Инициализация данных
        this.table = jTable;
        this.rs = dbTable.data;
        this.dbTable_CITY_3 = dbTable_CITY_3;
        loadData();
    }

   private void loadData() throws SQLException {
        // ЗАГРУЗКА ДАННЫХ С ТАБЛИЦЫ БД
        int rowIndex = table.convertRowIndexToModel(table.getSelectedRow());
        rs.absolute(rowIndex + 1);
        jTextField_NAME_FIRM.setText(rs.getString("NAME_FIRM"));
        jTextField_AGENT_TEL.setText(rs.getString("AGENT_TEL"));
        jTextField_DIRECTOR_TEL.setText(rs.getString("DIRECTOR_TEL"));
        jTextField_NAME_AGENT.setText(rs.getString("NAME_AGENT"));
        jTextField_NAME_DIRECTOR.setText(rs.getString("NAME_DIRECTOR"));
        DbComboBox_CITY_3 = new DbComboBox(jComboBox_CITY, dbTable_CITY_3, "ID", "NAME_CITY");
        jComboBox_CITY.setSelectedIndex(DbComboBox_CITY_3.getRowNumberForId(rs.getInt("ID_CITY")));
        save_data = false; delete_record = false;
    }

    private void updateData() throws SQLException {
        // СОХРАНЕНИЕ ДАННЫХ В ТАБЛИЦУ БД
        rs.updateString("NAME_FIRM", jTextField_NAME_FIRM.getText());
        rs.updateString("AGENT_TEL", jTextField_AGENT_TEL.getText());
        rs.updateString("DIRECTOR_TEL", jTextField_DIRECTOR_TEL.getText());
        rs.updateString("NAME_AGENT", jTextField_NAME_AGENT.getText());
        rs.updateString("NAME_DIRECTOR", jTextField_NAME_DIRECTOR.getText());
        rs.updateInt("ID_CITY", DbComboBox_CITY_3.getIdForSelectedRow());
        rs.updateRow();
        save_data = true; delete_record = false;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Кнопка отмены и выхода
        try {
            if (rs.getString("NAME_FIRM").isEmpty()) { delete_record = true; }
        } catch (Exception ex) { delete_record = true; }
        save_data = false; dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Кнопка сохранения данных в таблицу БД
        try {
            if (!jTextField_NAME_FIRM.getText().equals("")) {
                updateData(); dispose();
            } else {
                jTextField_NAME_FIRM.requestFocus();
                JOptionPane.showMessageDialog(rootPane, "Задайтие название фирмы!");
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
    private javax.swing.JComboBox jComboBox_CITY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField_AGENT_TEL;
    private javax.swing.JTextField jTextField_DIRECTOR_TEL;
    private javax.swing.JTextField jTextField_NAME_AGENT;
    private javax.swing.JTextField jTextField_NAME_DIRECTOR;
    private javax.swing.JTextField jTextField_NAME_FIRM;
    // End of variables declaration//GEN-END:variables
}
