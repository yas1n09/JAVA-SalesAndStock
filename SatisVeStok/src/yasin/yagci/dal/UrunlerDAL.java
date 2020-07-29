package yasin.yagci.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yasin.yagci.core.ObectHelper;
import yasin.yagci.interfaces.DALInterfaces;
import yasin.yagci.types.KategoriContract;
import yasin.yagci.types.UrunlerContract;

public class UrunlerDAL extends ObectHelper implements DALInterfaces<UrunlerContract> {

	@Override
	public void Insert(UrunlerContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Urunler(adi, kategoriId, fiyat) " 
			+ "VALUES('" + entity.getAdi() 
			+ "',"
			+ entity.getKategoriId() 
			+ "," 
			+ entity.getFiyat() 
			+ ") ");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> GetAll() {

		List<UrunlerContract> datacontract = new ArrayList<UrunlerContract>();
			Connection connection = getConnection();
			UrunlerContract contract;
			try {
				Statement statement =connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Urunler");
				while (resultSet.next()) {
					contract = new UrunlerContract();
					contract.setId(resultSet.getInt("Id"));
					contract.setAdi(resultSet.getString("Adi"));
					contract.setKategoriId(resultSet.getInt("KategoriId"));
					datacontract.add(contract);
					System.out.println(resultSet.getString("Adi"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return datacontract;
			
		
	}

	@Override
	public UrunlerContract Delete(UrunlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(UrunlerContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UrunlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
