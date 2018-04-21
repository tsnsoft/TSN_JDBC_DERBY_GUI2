package tsn.utils.jtable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

/**
 * Оконный менеджер экспорта таблиц JTable в HTML или Excel
 *
 * @author Талипов С.Н.
 */
public class ExporterViewJTable extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable jt;

    /**
     * Оконный менеджер экспорта таблиц JTable в HTML или Excel
     *
     * @param table таблица JTable
     * @param title заголовок отчета (например: "Отчет по дискам")
     * @param filename имя файла отчета (без расширения, например: "Report_disk")
     * @param header верхний колонтитул отчета (например: "ОТЧЕТ")
     * @param footer нижний колонтитул отчета (например: "Подпись")
     */
    public ExporterViewJTable(JTable table, final String title, final String filename,
            final String[] header, final String[] footer) {
        setTitle("Экспорт данных");
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        jt = table;
        setBounds(100, 100, 123, 105);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JButton btnIe = new JButton("HTML");
        btnIe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPanel.add(btnIe, BorderLayout.NORTH);
        btnIe.setFocusable(false);
        setLocationRelativeTo(null);
        btnIe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ExporterJTable.exportTableToHTML(jt, title, filename, "html", header, footer);
                    }
                }).start();

                dispose();
            }
        });
        btnIe.setIcon(
                new ImageIcon(getClass().getResource("firefox.png")));
        btnIe.setFont(
                new Font("Times New Roman", Font.BOLD, 12));

        JButton btnExcel = new JButton("EXCEL");

        btnExcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPanel.add(btnExcel, BorderLayout.SOUTH);

        btnExcel.setFocusable(
                false);
        btnExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ExporterJTable.exportTableToHTML(jt, title, filename, "xls", header, footer);
                    }
                }).start();
                dispose();
            }
        });
        btnExcel.setIcon(new ImageIcon(ExporterViewJTable.class.getResource("excel.png")));
        btnExcel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        this.setVisible(true);
    }
}
