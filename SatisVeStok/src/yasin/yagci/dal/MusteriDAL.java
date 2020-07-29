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
import yasin.yagci.types.MusteriContract;
import yasin.yagci.types.UrunlerContract;

public class MusteriDAL extends ObectHelper implements DALInterfaces<MusteriContract> {

	@Override
	public void Insert(MusteriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement =connection.createStatement();
			
			statement.executeUpdate("INSERT INTO Musteri (AdiSoyadi, Telefon, Adres, SehirId) VALUES('"
			+entity.getAdiSoyadi()+"','"+entity.getTelefon()+"','"+entity.getAdres()+"',"+entity.getSehirId() +")");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<MusteriContract> GetAll() {
		List<MusteriContract> datacontract = new ArrayList<MusteriContract>();
		Connection connection = getConnection();
		MusteriContract contract;
		try {
			Statement statement =connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Musteri");
			while (resultSet.next()) {
				contract = new MusteriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setAdres(resultSet.getString("Adres"));
				contract.setSehirId(resultSet.getInt("SehirId"));
				contract.setTelefon(resultSet.getString("Telefon"));
				
				datacontract.add(contract);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
	}

	@Override
	public MusteriContract Delete(MusteriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(MusteriContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MusteriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
