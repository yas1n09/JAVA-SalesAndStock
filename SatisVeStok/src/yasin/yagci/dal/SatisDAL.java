package yasin.yagci.dal;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yasin.yagci.complex.types.SatisContractComplex;
import yasin.yagci.complex.types.StokContractComplex;
import yasin.yagci.core.ObectHelper;
import yasin.yagci.interfaces.DALInterfaces;
import yasin.yagci.types.KategoriContract;
import yasin.yagci.types.SatisContract;
import yasin.yagci.types.StokContract;

public class SatisDAL extends ObectHelper implements DALInterfaces<SatisContract> {

	@Override
	public void Insert(SatisContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(
					"INSERT INTO Satis (UrunId, MusteriId, Adet, PersonelId) VALUES(" + entity.getUrunId() + ","
							+ entity.getMusteriId() + "," + entity.getAdet() + "," + entity.getPersonelId() + ")");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<SatisContractComplex> GetAllSatis() {
		List<SatisContractComplex> dataContract = new ArrayList<SatisContractComplex>();

		Connection connection = getConnection();
		SatisContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT satis.Id, personel.AdiSoyadi, musteri.AdiSoyadi, Adi, Adet FROM satis LEFT JOIN musteri ON satis.MusteriId = musteri.Id LEFT JOIN urunler ON satis.UrunId = urunler.Id LEFT JOIN personel on satis.PersonelId = personel.Id ORDER BY satis.Id DESC ");

			while (rs.next()) {

				contract = new SatisContractComplex();
				contract.setId(rs.getInt("satis.Id"));
				contract.setMusteriAdi(rs.getString("musteri.AdiSoyadi"));
				contract.setPersonelAdi(rs.getString("personel.AdiSoyadi"));
				contract.setUrunAdi(rs.getString("Adi"));
				contract.setAdet(rs.getInt("Adet"));

				dataContract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataContract;
	}

	@Override
	public List<SatisContract> GetAll() {

		return null;
	}

	@Override
	public SatisContract Delete(SatisContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(SatisContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SatisContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
