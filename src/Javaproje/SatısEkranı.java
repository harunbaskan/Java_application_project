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

public class SatısEkranı extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private List<SatısBilgi> alacakListesi;

   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SatısEkranı frame = new SatısEkranı();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SatısEkranı() {
    	setTitle("Satıs Ekranı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 719);
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
                "Firma Adı", "Alınacak Tutar", "Satış Tarihi", "Ödeme Türü"
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
        panel.setBounds(0, 301, 882, 399);
        panel.setBackground(new Color(0, 0, 160));
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnCikar = new JButton("Çıkar");
        btnCikar.setBounds(648, 135, 160, 29);
        btnCikar.setForeground(new Color(255, 108, 0));
        btnCikar.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(btnCikar);

        JButton btnNewButton = new JButton("Ekle");
        btnNewButton.setBounds(648, 58, 160, 29);
        btnNewButton.setForeground(new Color(255, 108, 0));
        btnNewButton.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(btnNewButton);

        JButton btnGuncelle = new JButton("Güncelle");
        btnGuncelle.setBounds(648, 210, 160, 29);
        btnGuncelle.setForeground(new Color(255, 108, 0));
        btnGuncelle.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(btnGuncelle);
        
        JButton btnGeri = new JButton("Geri Dön");
        btnGeri.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ManagerEkran yöneticiE=new ManagerEkran();
        		yöneticiE.show();
        		dispose();
        		
        		
        		
        	}
        });
        btnGeri.setForeground(new Color(255, 108, 0));
        btnGeri.setFont(new Font("Serif", Font.BOLD, 20));
        btnGeri.setBounds(39, 142, 160, 29);
        panel.add(btnGeri);
        
        JButton btnkYap = new JButton("Çıkış Yap\r\n");
        btnkYap.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		
        		
        	}
        });
        btnkYap.setForeground(new Color(255, 108, 0));
        btnkYap.setFont(new Font("Serif", Font.BOLD, 20));
        btnkYap.setBounds(39, 217, 160, 29);
        panel.add(btnkYap);

 
        alacakListesi = VeriYonetici.alacakVerileriniOku();
        alacakListesi.forEach(alacak -> model.addRow(new Object[] { alacak.getFirmaAdı(), alacak.getMiktar(), alacak.getTarih(), alacak.getÖdemeŞekli() }));

        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firmaAdi = JOptionPane.showInputDialog("Firma Adı:");
                double alacakTutari = Double.parseDouble(JOptionPane.showInputDialog("Alacak Tutarı:"));
                String satisTarihi = JOptionPane.showInputDialog("Satış Tarihi:");
                String odemeTuru = (String) JOptionPane.showInputDialog(null, "Ödeme Türü Seçin", "Ödeme Türü", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Kredi Kartı", "Nakit", "Banka Havalesi"}, "Kredi Kartı");
                SatısBilgi yeniAlacak = new SatısBilgi(firmaAdi, alacakTutari, satisTarihi, odemeTuru);
                alacakListesi.add(yeniAlacak);
                model.addRow(new Object[] { firmaAdi, alacakTutari, satisTarihi, odemeTuru });
                VeriYonetici.alacakVerileriniYaz(alacakListesi);
            }
        });

  
        btnCikar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        int seciliSatir = table.getSelectedRow();
        if (seciliSatir >= 0) {
        alacakListesi.remove(seciliSatir);
        model.removeRow(seciliSatir);
         VeriYonetici.alacakVerileriniYaz(alacakListesi);
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
        double alacakTutari = Double.parseDouble(JOptionPane.showInputDialog("Alacak Tutarı:", model.getValueAt(seciliSatir, 1)));
        String satisTarihi = JOptionPane.showInputDialog("Satış Tarihi:", model.getValueAt(seciliSatir, 2));
        String odemeTuru = (String) JOptionPane.showInputDialog(null, "Ödeme Türü Seçin", "Ödeme Türü", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Kredi Kartı", "Nakit", "Banka Havalesi"}, model.getValueAt(seciliSatir, 3));
        SatısBilgi guncellenmisAlacak = new SatısBilgi(firmaAdi, alacakTutari, satisTarihi, odemeTuru);
        alacakListesi.set(seciliSatir, guncellenmisAlacak);
        model.setValueAt(firmaAdi, seciliSatir, 0);
        model.setValueAt(alacakTutari, seciliSatir, 1);
        model.setValueAt(satisTarihi, seciliSatir, 2);
        model.setValueAt(odemeTuru, seciliSatir, 3);
        VeriYonetici.alacakVerileriniYaz(alacakListesi);
        } else {
          JOptionPane.showMessageDialog(null, "Lütfen güncellemek istediğiniz satırı seçin.");
                }
            }
        });
    }
}
