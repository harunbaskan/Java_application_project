package Javaproje;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StokBilgi extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel tableModel;

    StokBilgi() {
        setForeground(new Color(0, 128, 255));
        getContentPane().setForeground(new Color(0, 128, 255));
        getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
        setTitle("Ürün Ekranı");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 574, 218);
        getContentPane().add(scrollPane);

        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "İsim", "Fiyat", "Stok" }
        );
        table = new JTable(tableModel);
        table.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 11));
        table.setForeground(new Color(0, 0, 0));
        scrollPane.setViewportView(table);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 160));
        panel.setBounds(0, 217, 584, 194);
        getContentPane().add(panel);
                panel.setLayout(null);
        
       JButton btnGuncelle = new JButton("Güncelle");
       
   	   btnGuncelle.setForeground(new Color(255, 108, 0));
   	   
   	   btnGuncelle.setBounds(414, 128, 160, 29);
       panel.add(btnGuncelle);
       btnGuncelle.setFont(new Font("Serif", Font.BOLD, 20));
       JButton btnNewButton = new JButton("Ekle");
       btnNewButton.setForeground(new Color(255, 108, 0));
       btnNewButton.setBounds(414, 22, 160, 29);
       panel.add(btnNewButton);
       btnNewButton.setFont(new Font("Serif", Font.BOLD, 20));
       JButton btnCikar = new JButton("Çıkar");
       btnCikar.setForeground(new Color(255, 108, 0));
       btnCikar.setBounds(414, 75, 160, 29);
        panel.add(btnCikar);
        btnCikar.setFont(new Font("Serif", Font.BOLD, 20));
                                
                                       
        btnCikar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         int selectedRow = table.getSelectedRow();
         if (selectedRow != -1) {
           String isim = (String) tableModel.getValueAt(selectedRow, 0);
           double fiyat = (Double) tableModel.getValueAt(selectedRow, 1);
           int stok = (Integer) tableModel.getValueAt(selectedRow, 2);
        Urun urun = new Urun(isim, fiyat, stok);
         UrunDosya.urunSil(urun);
          urunleriGuncelle();
        } else {
          JOptionPane.showMessageDialog(StokBilgi.this, "Lütfen silmek istediğiniz ürünü seçin.");
                                                }
           }
           });
                        
                              
         btnNewButton.addActionListener(new ActionListener() {
       
         public void actionPerformed(ActionEvent e) {
             String isim = JOptionPane.showInputDialog(StokBilgi.this, "Ürün İsmi:");
             double fiyat = Double.parseDouble(JOptionPane.showInputDialog(StokBilgi.this, "Ürün Fiyatı:"));
             int stok = Integer.parseInt(JOptionPane.showInputDialog(StokBilgi.this, "Ürün Stok Miktarı:"));
         Urun yeniUrun = new Urun(isim, fiyat, stok);
         UrunDosya.urunEkle(yeniUrun);
         urunleriGuncelle();
                                    }
                                });
                
                  
          btnGuncelle.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          int selectedRow = table.getSelectedRow();
           if (selectedRow != -1) {
                String eskiIsim = (String) tableModel.getValueAt(selectedRow, 0);
               double eskiFiyat = (Double) tableModel.getValueAt(selectedRow, 1);
               int eskiStok = (Integer) tableModel.getValueAt(selectedRow, 2);
               Urun eskiUrun = new Urun(eskiIsim, eskiFiyat, eskiStok);
               String yeniIsim = JOptionPane.showInputDialog(StokBilgi.this, "Yeni Ürün İsmi:", eskiIsim);
               double yeniFiyat = Double.parseDouble(JOptionPane.showInputDialog(StokBilgi.this, "Yeni Ürün Fiyatı:", eskiFiyat));
               int yeniStok = Integer.parseInt(JOptionPane.showInputDialog(StokBilgi.this, "Yeni Ürün Stok Miktarı:", eskiStok));
               Urun yeniUrun = new Urun(yeniIsim, yeniFiyat, yeniStok);
                  UrunDosya.urunGuncelle(eskiUrun, yeniUrun);
                  urunleriGuncelle();
           } else {
             JOptionPane.showMessageDialog(StokBilgi.this, "Lütfen güncellemek istediğiniz ürünü seçin.");
                                }
                            }
                        });

        
        urunleriGuncelle();

        setVisible(true);
    }


    private void urunleriGuncelle() {
        tableModel.setRowCount(0);
        List<Urun> urunler = UrunDosya.urunleriOku();
            for (Urun urun : urunler) {
                tableModel.addRow(new Object[]{urun.getIsim(), urun.getFiyat(), urun.getStok()});
        }
    }

    public static void main(String[] args) {
        new StokBilgi();
    }
}
