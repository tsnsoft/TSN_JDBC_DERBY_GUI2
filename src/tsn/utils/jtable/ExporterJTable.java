package tsn.utils.jtable;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Экспорт таблиц JTable в HTML или Excel
 *
 * @author Талипов С.Н.
 */
public class ExporterJTable {

    /**
     * Экспорт таблиц JTable в HTML или Excel
     *
     * @param table таблица JTable
     * @param title заголовок отчета (например: "Отчет по дискам")
     * @param filename имя файла отчета (без расширения, например:
     * "Report_disk")
     * @param ext расширение файла (например: "html")
     * @param header верхний колонтитул отчета (например: "ОТЧЕТ")
     * @param footer нижний колонтитул отчета (например: "Подпись")
     */
    public static void exportTableToHTML(JTable table, String title, String filename, String ext,
            String[] header, String[] footer) {
        File temp_directory = new File("Reports");
        File fname = null;
        try {
            if (temp_directory.exists() && temp_directory.isDirectory()) {
                fname = new File(temp_directory.getName() + System.getProperty("file.separator")
                        + filename + (temp_directory.list().length + 1) + "." + ext);
            } else {
                temp_directory.mkdir();
                fname = new File(temp_directory.getName() + System.getProperty("file.separator")
                        + filename + (temp_directory.list().length + 1) + "." + ext);
            }
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fname), "utf8"));

            pw.write("<head>"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />"
                    + "<title>" + title + "</title>" + "</head>" + "<body>");

            pw.write("<b><center>");
            for (String header1 : header) {
                pw.write(header1 + "<br>");
            }
            pw.write("</b><br>");

            pw.write("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">" + "<tr>");

            for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
                pw.write("<td bgcolor=\"#EEEECC\" align=\"center\" width=\""
                        + table.getColumnModel().getColumn(i).getWidth() + "\"><B>"
                        + table.getColumnModel().getColumn(i).getHeaderValue()
                        + "</B></td>");
            }

            pw.write("</tr>");

            for (int i = 0; i < table.getRowCount(); i++) {
                pw.write("<tr>");

                for (int j = 0; j < table.getColumnModel().getColumnCount(); j++) {
                    if (table.getValueAt(i, j) != null) {
                        int k = table.getColumnModel().getColumn(j).getModelIndex();
                        if (table.getModel().getColumnClass(k).equals(String.class)) {
                            pw.write("<td align=\"left\">" + table.getValueAt(i, j).toString() + "&nbsp;</td>");
                        } else {
                            pw.write("<td align=\"right\">" + table.getValueAt(i, j).toString() + "&nbsp;</td>");
                        }

                    } else {
                        pw.write("<td>&nbsp;</td>");
                    }
                }

                pw.write("</tr>");
            }

            pw.write("</table></center>");

            pw.write("<b><p align=\"right\"><br>");
            for (String footer1 : footer) {
                pw.write(footer1 + "<br>");
            }
            pw.write("</p></b><br>");

            pw.write("</body></html>");
            pw.flush();
            pw.close();
            Desktop desk = Desktop.getDesktop();
            desk.open(fname);
            fname.deleteOnExit();
        } catch (IOException ex) {
            fname.deleteOnExit();
            JOptionPane.showMessageDialog(null, ex.toString(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
