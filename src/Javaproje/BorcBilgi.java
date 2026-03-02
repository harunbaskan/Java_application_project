package Javaproje;

public class BorcBilgi extends islem {
    public BorcBilgi(String firmaAdı, double miktar, String tarih, String ödemeŞekli) {
        super(firmaAdı, miktar, tarih, ödemeŞekli);
    }

    @Override
    public void detaylarıYazdır() {
        System.out.println("Borç - Firma: " + firmaAdı + ", Miktar: " + miktar + ", Tarih: " + tarih + ", Ödeme Şekli: " + ödemeŞekli);
    }
}
