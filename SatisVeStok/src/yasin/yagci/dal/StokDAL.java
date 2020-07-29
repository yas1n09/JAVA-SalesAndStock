package yasin.yagci.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yasin.yagci.complex.types.StokContractComplex;
import yasin.yagci.complex.types.StokContractTotalComplex;
import yasin.yagci.core.ObectHelper;
import yasin.yagci.interfaces.DALInterfaces;
import yasin.yagci.types.StokContract;

public class StokDAL extends ObectHelper implements DALInterfaces<StokContract> {

	@Override
	public void Insert(StokContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Stok (PersonelId, UrunId, Adet) VALUES(" + entity.getPersonelId()
					+ "," + entity.getUrunId() + "," + entity.getAdet() + ")");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	  SELECT stok.Id, AdiSoyadi, Adi, Adet FROM stok 
	  LEFT JOIN urunler ON stok.UrunId = urunler.Id 
	  LEFT JOIN personel on stok.PersonelId = personel.Id 
	 *
	 */

	public List<StokContractComplex> GetAllStok(){
		
		List<StokContractComplex> datacontract = new ArrayList<StokContractComplex>();
		Connection connection = getConnection();
		StokContractComplex contract;
		try {
			Statement statement =connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT stok.Id, AdiSoyadi, Adi, Adet FROM stok" 
			+ "	 LEFT JOIN urunler ON stok.UrunId = urunler.Id" 
			+ "	 LEFT JOIN personel on stok.PersonelId = personel.Id ORDER BY stok.Id DESC");
			while (resultSet.next()) {
				contract = new StokContractComplex();
				contract.setId(resultSet.getInt("Id"));
				contract.setPersonelAdi(resultSet.getString("AdiSoyadi"));
				contract.setUrunAdi(resultSet.getString("Adi"));
				contract.setAdet(resultSet.getInt("Adet"));
				
				datacontract.add(contract);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
				
	}
	
public List<StokContractTotalComplex> getTotalStok(){
		
		List<StokContractTotalComplex> datacontract = new ArrayList<StokContractTotalComplex>();
		Connection connection = getConnection();
		StokContractTotalComplex contract;
		try {
			Statement statement =connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT SUM(Adet) as toplam , stok.Id, AdiSoyadi, Adi, Adet FROM stok LEFT JOIN urunler ON stok.UrunId = urunler.Id LEFT JOIN personel ON stok.PersonelId = personel.Id GROUP BY UrunId");
			while (resultSet.next()) {
				contract = new StokContractTotalComplex();
				contract.setId(resultSet.getInt("Id"));
				contract.setPersonelAdi(resultSet.getString("AdiSoyadi"));
				contract.setUrunAdi(resultSet.getString("Adi"));
				contract.setAdet(resultSet.getInt("Adet"));
				contract.setToplam(resultSet.getInt("toplam"));
				
				datacontract.add(contract);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
				
	}

	@Override
	public List<StokContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StokContract Delete(StokContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(StokContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StokContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
