package yasin.yagci.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yasin.yagci.core.ObectHelper;
import yasin.yagci.interfaces.DALInterfaces;
import yasin.yagci.types.AccountsContract;

public class AccountsDAL extends ObectHelper implements DALInterfaces<AccountsContract> {

	@Override
	public void Insert(AccountsContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement =connection.createStatement();
			
			statement.executeUpdate("INSERT INTO Accounts (PersonelId, YetkiId, Sifre) VALUES("
			+entity.getPersonelId()
			+","
			+entity.getYetkiId()
			+",'"
			+entity.getSifre()
			+"')");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public AccountsContract GetPersonelIdVeSifre(int personelId,String sifre){
		
		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		Connection connection =getConnection();
		try {
			Statement sorgu = connection.createStatement();
			ResultSet rs = sorgu.executeQuery("SELECT * FROM accounts WHERE PersonelId ="+personelId+" AND Sifre='"+sifre.trim()+"'");
		
		while (rs.next()) {
			contract.setId(rs.getInt("Id"));
			contract.setPersonelId(rs.getInt("PersonelId"));
			contract.setSifre(rs.getString("Sifre"));
			contract.setYetkiId(rs.getInt("YetkiId"));
		}
		
		sorgu.close();
		connection.close();
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return contract;
		
		
	}
public AccountsContract GetYetkiId(int personelId){
		
		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		Connection connection =getConnection();
		try {
			Statement sorgu = connection.createStatement();
			ResultSet rs = sorgu.executeQuery("SELECT * FROM accounts WHERE PersonelId ="+ personelId +"");
		
		while (rs.next()) {
			contract.setId(rs.getInt("Id"));
			contract.setPersonelId(rs.getInt("PersonelId"));
			contract.setYetkiId(rs.getInt("YetkiId"));
		}
		
		sorgu.close();
		connection.close();
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return contract;
		
		
	}
	@Override
	public List<AccountsContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountsContract Delete(AccountsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AccountsContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AccountsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
