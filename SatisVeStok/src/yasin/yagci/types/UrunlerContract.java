package yasin.yagci.types;

public class UrunlerContract {
	private int id;
	private String adi;
	private int kategoriId;
	private float fiyat;

	public float getFiyat() {
		return fiyat;
	}

	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public int getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adi;
	}

}
