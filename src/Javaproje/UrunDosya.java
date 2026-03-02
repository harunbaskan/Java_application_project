package Javaproje;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UrunDosya {
    private static  String dosyaurunler = "urunler.txt";


    public static List<Urun> urunleriOku() {
        List<Urun> urunler = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaurunler))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] urunBilgileri = satir.split(",");
                String isim = urunBilgileri[0];
                double fiyat = Double.parseDouble(urunBilgileri[1]);
                int stok = Integer.parseInt(urunBilgileri[2]);
                urunler.add(new Urun(isim, fiyat, stok));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urunler;
    }


    public static void urunleriYaz(List<Urun> urunler) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dosyaurunler))) {
            for (Urun urun : urunler) {
                bw.write(urun.getIsim() + "," + urun.getFiyat() + "," + urun.getStok() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void urunEkle(Urun urun) {
        List<Urun> urunler = urunleriOku();
        urunler.add(urun);
        urunleriYaz(urunler);
    }


    public static void urunSil(Urun urun) {
        List<Urun> urunler = urunleriOku();
        urunler.remove(urun);
        urunleriYaz(urunler);
    }
    public static void urunGuncelle(Urun eskiUrun, Urun yeniUrun) {
        List<Urun> urunler = urunleriOku();
        int index = urunler.indexOf(eskiUrun);
        if (index != -1) {
            urunler.set(index, yeniUrun);
            urunleriYaz(urunler);
        }
    }
}