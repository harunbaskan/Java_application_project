package Javaproje;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;

public class LoginPersonel extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JLabel personelKullancıLabel, personelsifrelabel;
    private JTextField kullaniciAdiText;
    private JPasswordField sifreText;
    private JButton girisButtonprsnl;
    private JButton btnGeriprsnl;

    LoginPersonel() {
        getContentPane().setBackground(new Color(0, 0, 160));
        setTitle("Personel Giriş Ekranı");
        setSize(396, 301);
        getContentPane().setLayout(null);

        personelKullancıLabel = new JLabel("Kullanıcı Adı:");
        personelKullancıLabel.setForeground(new Color(255, 128, 64));
        personelKullancıLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        personelKullancıLabel.setBounds(20, 84, 113, 25);
        getContentPane().add(personelKullancıLabel);

        kullaniciAdiText = new JTextField();
        kullaniciAdiText.setBounds(143, 84, 160, 25);
        getContentPane().add(kullaniciAdiText);

        personelsifrelabel = new JLabel("Şifre:");
        personelsifrelabel.setForeground(new Color(255, 128, 64));
        personelsifrelabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        personelsifrelabel.setBounds(53, 138, 80, 25);
        getContentPane().add(personelsifrelabel);

        sifreText = new JPasswordField();
        sifreText.setBounds(143, 142, 160, 25);
        getContentPane().add(sifreText);

        girisButtonprsnl = new JButton("Giriş YAP");
        girisButtonprsnl.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
        girisButtonprsnl.setForeground(new Color(255, 128, 64));
        girisButtonprsnl.setBounds(215, 209, 113, 42);
        girisButtonprsnl.addActionListener(this);
        getContentPane().add(girisButtonprsnl);
        
        btnGeriprsnl = new JButton("Geri Dön");
        btnGeriprsnl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnaGiris anag=new AnaGiris();
                anag.show();
                dispose();    }
        });
        btnGeriprsnl.setForeground(new Color(255, 128, 64));
        btnGeriprsnl.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
        btnGeriprsnl.setBounds(37, 209, 113, 42);
        getContentPane().add(btnGeriprsnl);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == girisButtonprsnl) {
            String kullaniciAdi = kullaniciAdiText.getText();
            String sifre = new String(sifreText.getPassword());
            boolean dogruKullanici = kontrolEt(kullaniciAdi, sifre);
            if (dogruKullanici) {
                dispose(); 
                new StokBilgi(); 
            } else {
                JOptionPane.showMessageDialog(this, "Kullanıcı adı veya şifre yanlış Lütfen Kontrol Edin!");
            }
        }
    }

    private boolean kontrolEt(String kullaniciAdi, String sifre) {
        String dosyapersonel = "personel.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosyapersonel));
            String satir;

            while ((satir = reader.readLine()) != null) {
             
                String[] veri = satir.split(",");
                String dosyaKullaniciAdi = veri[0];
                String dosyaSifre = veri[1];
                if (kullaniciAdi.equals(dosyaKullaniciAdi) && sifre.equals(dosyaSifre)) {
                    reader.close();
                    return true; 
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false; }

    public static void main(String[] args) {
        new LoginPersonel();
    }
}
