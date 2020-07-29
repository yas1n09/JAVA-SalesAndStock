package yasin.yagci.types;

public class StokContract {

	private int id;
	private int personelId;
	private int urunId;
	private int adet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public int getUrunId() {
		return urunId;
	}

	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + personelId + " " + urunId + " " + adet;
	}

}
