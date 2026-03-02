package Javaproje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DosyaPersonel {

    public static void veriYaz(String dosyapersonel, String kullaniciAdi, String sifre) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dosyapersonel, true));
            writer.write(kullaniciAdi + "," + sifre); 
            writer.newLine();
            writer.close();
            System.out.println("Veri başarıyla dosyaya yazıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void veriOku(String dosyapersonel) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosyapersonel));
            String satir;

            while ((satir = reader.readLine()) != null) {
              
                String[] veri = satir.split(",");
                String kullaniciAdi = veri[0];
                String sifre = veri[1];
                System.out.println("Kullanıcı Adı: " + kullaniciAdi + ", Şifre: " + sifre);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String dosyapersonel = "personel.txt";
        

        veriOku(dosyapersonel);
    }
}
