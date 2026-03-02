package Javaproje;

abstract class islem {
  protected String firmaAdı;
  protected double miktar;
  protected String tarih;
  protected String ödemeŞekli;

    public islem(String firmaAdı, double miktar, String tarih, String ödemeŞekli) {
        this.firmaAdı = firmaAdı;
        this.miktar = miktar;
        this.tarih = tarih;
        this.ödemeŞekli = ödemeŞekli;
    }

    public String getFirmaAdı() {
        return firmaAdı;
    }

    public double getMiktar() {
        return miktar;
    }

    public String getTarih() {
        return tarih;
    }

    public String getÖdemeŞekli() {
        return ödemeŞekli;
    }

    public abstract void detaylarıYazdır();
}

