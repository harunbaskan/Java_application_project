package Javaproje;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class LoginManager extends JFrame implements ActionListener {
 
	private static final long serialVersionUID = 1L;
	private JLabel YkullaniciAdiLabel, YsifreLabel;
    private JTextField YkullaniciAdiText;
    private JPasswordField YsifreText;
    private  JButton YgirisButton;
    private JButton YbtnGeri;

    LoginManager() {
    	getContentPane().setBackground(new Color(0, 0, 160));
        setTitle("Yönetici Giriş Ekranı");
        setSize(396, 301);
        getContentPane().setLayout(null);

        YkullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
        YkullaniciAdiLabel.setForeground(new Color(255, 128, 64));
        YkullaniciAdiLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        YkullaniciAdiLabel.setBounds(20, 84, 113, 25);
        getContentPane().add(YkullaniciAdiLabel);

        YkullaniciAdiText = new JTextField();
        YkullaniciAdiText.setBounds(143, 84, 160, 25);
        getContentPane().add(YkullaniciAdiText);

        YsifreLabel = new JLabel("Şifre:");
        YsifreLabel.setForeground(new Color(255, 128, 64));
        YsifreLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        YsifreLabel.setBounds(53, 138, 80, 25);
        getContentPane().add(YsifreLabel);

        YsifreText = new JPasswordField();
        YsifreText.setBounds(143, 142, 160, 25);
        getContentPane().add(YsifreText);

        YgirisButton = new JButton("Giriş YAP");
        YgirisButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
        YgirisButton.setForeground(new Color(255, 128, 64));
        YgirisButton.setBounds(215, 209, 113, 42);
        YgirisButton.addActionListener(this);
        getContentPane().add(YgirisButton);
        
        YbtnGeri = new JButton("Geri Dön");
        YbtnGeri.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AnaGiris anag=new AnaGiris();
        		anag.show();
        		dispose();	}
        });
        YbtnGeri.setForeground(new Color(255, 128, 64));
        YbtnGeri.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
        YbtnGeri.setBounds(37, 209, 113, 42);
        getContentPane().add(YbtnGeri);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == YgirisButton) {
            String kullaniciAdi = YkullaniciAdiText.getText();
            String sifre = new String(YsifreText.getPassword());
            boolean dogruKullanici = kontrolEt(kullaniciAdi, sifre);
            if (dogruKullanici) {
                dispose(); 
                new ManagerEkran(); 
            } else {
                JOptionPane.showMessageDialog(this, "Kullanıcı adı veya şifre yanlış Lütfen Kontrol Edin!");
            }
        }
    }

    private boolean kontrolEt(String kullaniciAdi, String sifre) {
        String dosyamanager = "manager.txt";
        try {
        BufferedReader reader = new BufferedReader(new FileReader(dosyamanager));
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
        return false; 
    }

    public static void main(String[] args) {
        new LoginManager();
    }
}