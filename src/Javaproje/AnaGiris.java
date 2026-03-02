package Javaproje;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AnaGiris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lbl_baskan;
    private JLabel lbl_sistemG;
    private JButton btnYgirisi;
    private JButton btnPersonelGiris;	
	AnaGiris() {
		setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		getContentPane().setBackground(new Color(0, 0, 160));
		getContentPane().setForeground(new Color(255, 255, 255));
        setTitle("BaskanApp");
        setSize(500, 366);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JLabel lbl_baskan = new JLabel("  BAŞKAN YAPI");
        lbl_baskan.setBounds(115, 30, 229, 41);
        lbl_baskan.setForeground(new Color(255, 128, 64));
        lbl_baskan.setFont(new Font("Serif", Font.BOLD, 30));
        getContentPane().add(lbl_baskan);
        
        JLabel lbl_sistemG = new JLabel("    Sisteme Giriş");
        lbl_sistemG.setForeground(new Color(255, 128, 0));
        lbl_sistemG.setFont(new Font("Serif", Font.BOLD, 22));
        lbl_sistemG.setBounds(149, 117, 195, 39);
        getContentPane().add(lbl_sistemG);
        
        JButton btnYgirisi = new JButton("Yönetici Girişi");
        btnYgirisi.setBackground(new Color(255, 255, 255));
        btnYgirisi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginManager lgn=new LoginManager();
        		lgn.show();
        		dispose();
        		
        	}
        });
        btnYgirisi.setForeground(new Color(255, 128, 64));
        btnYgirisi.setFont(new Font("Serif", Font.BOLD, 15));
        btnYgirisi.setBounds(51, 199, 140, 66);
        getContentPane().add(btnYgirisi);
        
        JButton btnPersonelGiris = new JButton("Personel Girişi");
        btnPersonelGiris.setBackground(new Color(255, 255, 255));
        btnPersonelGiris.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginPersonel lgp=new LoginPersonel();
        		lgp.show();
        		dispose();
        	}
        });
        btnPersonelGiris.setForeground(new Color(255, 128, 0));
        btnPersonelGiris.setFont(new Font("Serif", Font.BOLD, 15));
        btnPersonelGiris.setBounds(293, 199, 140, 66);
        getContentPane().add(btnPersonelGiris);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnaGiris();
    }
}
