package Javaproje;

import java.util.Objects;

public class Urun {
    private String isim;
    private double fiyat;
    private int stok;

     Urun(String isim, double fiyat, int stok) {
        this.isim = isim;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return isim + " - Fiyat: " + fiyat + " - Stok: " + stok;
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Urun other = (Urun) obj;
        return Objects.equals(this.isim, other.isim) &&
               Double.compare(this.fiyat, other.fiyat) == 0 &&
               this.stok == other.stok;
    }

    
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	
}
