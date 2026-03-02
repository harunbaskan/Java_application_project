package Javaproje;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class borcEkranı extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private List<BorcBilgi> borçListesi;

 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    borcEkranı borcE = new borcEkranı();
                    borcE.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public borcEkranı() {
    	setTitle("Borç Görüntüleme Ekranı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 849, 668);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 884, 301);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Serif", Font.PLAIN, 13));
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Firma Adı", "Borç Tutarı", "Son Ödeme Tarihi", "Ödeme Türü"
            }
        );
        table.setModel(model);
        scrollPane.setViewportView(table);

      
        JComboBox<String> comboBoxOdemeTuru = new JComboBox<>();
        comboBoxOdemeTuru.addItem("Kredi Kartı");
        comboBoxOdemeTuru.addItem("Nakit");
        comboBoxOdemeTuru.addItem("Çek");

        TableColumnModel columnModel = table.getColumnModel();
        TableColumn odemeTuruColumn = columnModel.getColumn(3);
        odemeTuruColumn.setCellEditor(new DefaultCellEditor(comboBoxOdemeTuru));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 160));
        panel.setBounds(0, 301, 882, 399);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnCikar = new JButton("Çıkar");
        btnCikar.setBounds(648, 135, 160, 29);
        btnCikar.setForeground(new Color(255, 108, 0));
        btnCikar.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(btnCikar);

        JButton btnekleborc = new JButton("Ekle");
        btnekleborc.setBounds(648, 58, 160, 29);
        btnekleborc.setForeground(new Color(255, 108, 0));
        btnekleborc.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(btnekleborc);

        JButton btnGuncelle = new JButton("Güncelle");
        btnGuncelle.setBounds(648, 210, 160, 29);
        btnGuncelle.setForeground(new Color(255, 108, 0));
        btnGuncelle.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(btnGuncelle);
        
        JButton btnGeri = new JButton("Geri Dön");
        btnGeri.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	ManagerEkran yntciekran=new ManagerEkran();
        	yntciekran.show();
       		dispose();
        		
        		
        	}
        });
        btnGeri.setForeground(new Color(255, 108, 0));
        btnGeri.setFont(new Font("Serif", Font.BOLD, 20));
        btnGeri.setBounds(56, 146, 160, 29);
        panel.add(btnGeri);
        
        JButton btnkYap = new JButton("Çıkış Yap\r\n");
        btnkYap.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		
        		
        	}
        });
        btnkYap.setForeground(new Color(255, 108, 0));
        btnkYap.setFont(new Font("Serif", Font.BOLD, 20));
        btnkYap.setBounds(56, 217, 160, 29);
        panel.add(btnkYap);

 
        borçListesi = VeriYonetici.borcVerileriniOku();
        borçListesi.forEach(borç -> model.addRow(new Object[] { borç.getFirmaAdı(), borç.getMiktar(), borç.getTarih(), borç.getÖdemeŞekli() }));

      
        btnekleborc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firmaAdi = JOptionPane.showInputDialog("Firma Adı:");
                double borçTutari = Double.parseDouble(JOptionPane.showInputDialog("Borç Tutarı:"));
                String sonOdemeTarihi = JOptionPane.showInputDialog("Son Ödeme Tarihi:");
                String odemeTuru = (String) JOptionPane.showInputDialog(null, "Ödeme Türü Seçin", "Ödeme Türü", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Kredi Kartı", "Nakit", "Banka Havalesi"}, "Kredi Kartı");
                  BorcBilgi yeniBorç = new BorcBilgi(firmaAdi, borçTutari, sonOdemeTarihi, odemeTuru);
                  borçListesi.add(yeniBorç);
                  model.addRow(new Object[] { firmaAdi, borçTutari, sonOdemeTarihi, odemeTuru });
                 VeriYonetici.borcVerileriniYaz(borçListesi);
            }
        });

       
        btnCikar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seciliSatir = table.getSelectedRow();
                if (seciliSatir >= 0) {
                    borçListesi.remove(seciliSatir);
                    model.removeRow(seciliSatir);
                    VeriYonetici.borcVerileriniYaz(borçListesi);
                } else {
                    JOptionPane.showMessageDialog(null, "Lütfen silmek istediğiniz satırı seçin.");
                }
            }
        });

        
        btnGuncelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seciliSatir = table.getSelectedRow();
                if (seciliSatir >= 0) {
                    String firmaAdi = JOptionPane.showInputDialog("Firma Adı:", model.getValueAt(seciliSatir, 0));
                    double borçTutari = Double.parseDouble(JOptionPane.showInputDialog("Borç Tutarı:", model.getValueAt(seciliSatir, 1)));
                    String sonOdemeTarihi = JOptionPane.showInputDialog("Son Ödeme Tarihi:", model.getValueAt(seciliSatir, 2));
                    String odemeTuru = (String) JOptionPane.showInputDialog(null, "Ödeme Türü Seçin", "Ödeme Türü", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Kredi Kartı", "Nakit", "Banka Havalesi"}, model.getValueAt(seciliSatir, 3));
                    BorcBilgi guncellenmisBorç = new BorcBilgi(firmaAdi, borçTutari, sonOdemeTarihi, odemeTuru);
                    borçListesi.set(seciliSatir, guncellenmisBorç);
                    model.setValueAt(firmaAdi, seciliSatir, 0);
                    model.setValueAt(borçTutari, seciliSatir, 1);
                    model.setValueAt(sonOdemeTarihi, seciliSatir, 2);
                    model.setValueAt(odemeTuru, seciliSatir, 3);
                    VeriYonetici.borcVerileriniYaz(borçListesi);
         } else {
                    JOptionPane.showMessageDialog(null, "Lütfen güncellemek istediğiniz satırı seçin.");
                }
            }
        });
    }
}
