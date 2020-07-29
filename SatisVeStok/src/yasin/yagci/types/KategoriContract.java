package yasin.yagci.types;

public class KategoriContract {
	private int id;
	private String adi;
	private int ParentId;

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

	public int getParentId() {
		return ParentId;
	}

	public void setParentId(int parentId) {
		ParentId = parentId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adi;
	}
}
