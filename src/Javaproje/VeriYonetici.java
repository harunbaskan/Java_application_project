package Javaproje;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VeriYonetici {

    private static final String BORC_DOSYA = "borc_data.txt";
    private static final String ALACAK_DOSYA = "alacak_data.txt";

    public static List<BorcBilgi> borcVerileriniOku() {
        List<BorcBilgi> borcListesi = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BORC_DOSYA))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] veriler = satir.split(",");
                borcListesi.add(new BorcBilgi(veriler[0], Double.parseDouble(veriler[1]), veriler[2], veriler[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return borcListesi;
    }

    public static void borcVerileriniYaz(List<BorcBilgi> borcListesi) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BORC_DOSYA))) {
            for (BorcBilgi borc : borcListesi) {
                bw.write(String.join(",", borc.getFirmaAdı(), String.valueOf(borc.getMiktar()), borc.getTarih(), borc.getÖdemeŞekli()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SatısBilgi> alacakVerileriniOku() {
        List<SatısBilgi> alacakListesi = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ALACAK_DOSYA))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] veriler = satir.split(",");
                alacakListesi.add(new SatısBilgi(veriler[0], Double.parseDouble(veriler[1]), veriler[2], veriler[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alacakListesi;
    }

    public static void alacakVerileriniYaz(List<SatısBilgi> alacakListesi) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ALACAK_DOSYA))) {
            for (SatısBilgi alacak : alacakListesi) {
                bw.write(String.join(",", alacak.getFirmaAdı(), String.valueOf(alacak.getMiktar()), alacak.getTarih(), alacak.getÖdemeŞekli()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
