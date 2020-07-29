package yasin.yagci.complex.types;

public class StokContractTotalComplex {
	
	private int id;
	private String urunAdi;
	private String personelAdi;
	private int adet;
	private int toplam;

	public int getToplam() {
		return toplam;
	}

	public void setToplam(int toplam) {
		this.toplam = toplam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}
	
	public Object[] getVeriler() {
		
		Object[] veriler = {id,urunAdi,personelAdi,toplam,adet};
		return veriler;
	}
@Override
	public String toString() {
		// TODO Auto-generated method stub
	return personelAdi + " " + urunAdi;
}
}



