package Javaproje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DosyaManager {

    public static void veriYaz(String dosyamanager, String kullaniciAdi, String sifre) {
        try {
            BufferedWriter yaz= new BufferedWriter(new FileWriter(dosyamanager, true));
            yaz.write(kullaniciAdi + "," + sifre); 
            yaz.newLine(); 
            yaz.close();
            System.out.println(" dosyaya yazıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void veriOku(String dosyamanager) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosyamanager));
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
        String dosyayönetici = "manager.txt";
        

        veriOku(dosyayönetici);
    }
}