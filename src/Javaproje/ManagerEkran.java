package Javaproje;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerEkran extends JFrame {
	
	private static final long serialVersionUID = 1L;

	ManagerEkran() {
		getContentPane().setFont(new Font("Serif", Font.BOLD, 11));
		getContentPane().setBackground(new Color(0, 0, 160));
		getContentPane().setLayout(null);
		
		JLabel lblyöneticiekran = new JLabel("Sayın Yönetici Hoşgeldiniz");
		lblyöneticiekran.setFont(new Font("Serif", Font.BOLD, 22));
		lblyöneticiekran.setForeground(new Color(255, 128, 0));
		lblyöneticiekran.setBounds(10, 31, 264, 27);
		getContentPane().add(lblyöneticiekran);
		
		JLabel lbl_yöneticimsj = new JLabel("Lütfen aşağıdan yapmak istediğiniz işlemi seçin.");
		lbl_yöneticimsj.setForeground(new Color(255, 128, 0));
		lbl_yöneticimsj.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_yöneticimsj.setBounds(76, 166, 425, 32);
		getContentPane().add(lbl_yöneticimsj);
		
		JButton btnBorEkran = new JButton("Borç Ekranı\r\n");
		btnBorEkran.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				borcEkranı brcekran=new borcEkranı();
				brcekran.show();
				dispose();
				
			}
		});
		btnBorEkran.setForeground(new Color(255, 128, 0));
		btnBorEkran.setFont(new Font("Serif", Font.BOLD, 14));
		btnBorEkran.setBounds(222, 268, 146, 57);
		getContentPane().add(btnBorEkran);
		
		JButton btnSatBorEkran = new JButton("Satış Ekranı\r\n");
		btnSatBorEkran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SatısEkranı stsekran=new SatısEkranı();
				stsekran.show();
				dispose();
				
			}
		});
		btnSatBorEkran.setForeground(new Color(255, 128, 0));
		btnSatBorEkran.setFont(new Font("Serif", Font.BOLD, 14));
		btnSatBorEkran.setBounds(401, 268, 146, 57);
		getContentPane().add(btnSatBorEkran);
		
		JButton btnStokEkran = new JButton("Stok Ekranı");
		btnStokEkran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StokBilgi prsnle= new StokBilgi();
				prsnle.show();
				dispose();
				
			}
		});
		btnStokEkran.setForeground(new Color(255, 128, 0));
		btnStokEkran.setFont(new Font("Serif", Font.BOLD, 14));
		btnStokEkran.setBounds(34, 268, 146, 57);
		getContentPane().add(btnStokEkran);
		setBackground(new Color(0, 128, 255));
        setTitle("Yönetici Ekranı");
        setSize(600, 476);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerEkran();
    }
}