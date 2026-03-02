package Javaproje;

public class SatısBilgi extends islem {
    private String satışTarihi;

    public SatısBilgi(String firmaAdı, double miktar, String satışTarihi, String ödemeŞekli) {
        super(firmaAdı, miktar, satışTarihi, ödemeŞekli);
        this.satışTarihi = satışTarihi;
    }

    public String getSatışTarihi() {
        return satışTarihi;
    }

    @Override
    public void detaylarıYazdır() {
        System.out.println("Alacak - Firma: " + firmaAdı + ", Miktar: " + miktar + ", Satış Tarihi: " + satışTarihi + ", Ödeme Şekli: " + ödemeŞekli);
    }
}
