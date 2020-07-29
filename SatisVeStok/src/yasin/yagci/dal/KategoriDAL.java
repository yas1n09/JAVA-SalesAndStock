package yasin.yagci.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.ResultsetRow;

import yasin.yagci.core.ObectHelper;
import yasin.yagci.interfaces.DALInterfaces;
import yasin.yagci.types.KategoriContract;

public class KategoriDAL extends ObectHelper implements DALInterfaces<KategoriContract> {

	public void Insert(KategoriContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Kategori (Adi,ParentId) VALUES('" + entity.getAdi() + "',"
					+ entity.getParentId() + ")");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<KategoriContract> GetAllParentId() {

		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori WHERE parentId=0");
			while (resultSet.next()) {
				contract = new KategoriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public KategoriContract Delete(KategoriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(KategoriContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("UPDATE Kategori SET Adi='" + entity.getAdi() + "', ParentId="
					+ entity.getParentId() + " WHERE id=" + entity.getId() + "");
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	@Override
	public List<KategoriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public List<KategoriContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<KategoriContract> GetSearchKategori(String kategoriAdi){
		
		List<KategoriContract> dataContract = new ArrayList<KategoriContract>();
		
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Kategori WHERE Adi LIKE '%"+kategoriAdi+"%'");
			while(rs.next()) {
				
				KategoriContract contract = new KategoriContract();
				
				contract.setAdi(rs.getString("Adi"));
				contract.setParentId(rs.getInt("ParentId"));
				
				dataContract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataContract;
	}

}