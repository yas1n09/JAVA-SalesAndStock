package yasin.yagci.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import yasin.yagci.dal.AccountsDAL;
import yasin.yagci.fe.KategoriDuzenleFE;
import yasin.yagci.fe.PersonelEkleFE;
import yasin.yagci.fe.SifreIslemleriFE;
import yasin.yagci.fe.YetkiEkleFE;
import yasin.yagci.fe.kategororiEkleFE;
import yasin.yagci.fe.loginFE;
import yasin.yagci.fe.musteriEkleFE;
import yasin.yagci.fe.urunEkleFE;
import yasin.yagci.types.PersonelContract;

public class MenulerCom {

	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();

		JMenu dosyaMenu = new JMenu("File");
		bar.add(dosyaMenu);
		JMenuItem cikisItem = new JMenuItem("Exit");
		dosyaMenu.add(cikisItem);

		/* Products Menu */
		JMenu urunlerMenu = new JMenu("Products");
		bar.add(urunlerMenu);
		JMenuItem urunEkleItem = new JMenuItem("Add Product");
		urunlerMenu.add(urunEkleItem);
		JMenuItem kategoriEkleItem = new JMenuItem("Add Categorie");
		urunlerMenu.add(kategoriEkleItem);
		urunlerMenu.addSeparator();
		JMenuItem urunuDuzenleItem = new JMenuItem("Edit Product");
		urunlerMenu.add(urunuDuzenleItem);
		JMenuItem kategoriDuzenleItem = new JMenuItem("Edit Categorie");
		urunlerMenu.add(kategoriDuzenleItem);
		kategoriDuzenleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new KategoriDuzenleFE();
						
					}
				});
				
			}
		});
		
		/* Staff Menu */
		JMenu personellerMenu = new JMenu("Staff operations");
		bar.add(personellerMenu);
		JMenuItem personelEkleItem = new JMenuItem("Add staff");
		personellerMenu.add(personelEkleItem);
		JMenuItem yetkiEkleItem = new JMenuItem("Add Permission");
		personellerMenu.add(yetkiEkleItem);
		JMenuItem sifreBelirleItem = new JMenuItem("Set Password");
		personellerMenu.add(sifreBelirleItem);
		personellerMenu.addSeparator();

		JMenuItem personelDuzenleItem = new JMenuItem("Edit staff");
		personellerMenu.add(personelDuzenleItem);
		JMenuItem yetkiDuzenleItem = new JMenuItem("Edit Permissions");
		personellerMenu.add(yetkiDuzenleItem);
		JMenuItem sifreDuzenleItem = new JMenuItem("Edit Password");
		personellerMenu.add(sifreDuzenleItem);
		/*MusteriMenu*/
		JMenu musterilerMenu = new JMenu("Customers");
		bar.add(musterilerMenu);
		JMenuItem musteriEkleItem = new JMenuItem("Add Customer");
		musterilerMenu.add(musteriEkleItem);
		JMenuItem sehirEkleItem = new JMenuItem("Add City");
		musterilerMenu.add(sehirEkleItem);
		musterilerMenu.addSeparator();
		
		JMenuItem musteriDuzenleItem = new JMenuItem("Edit Customer");
		musterilerMenu.add(musteriDuzenleItem);
		JMenuItem sehirDuzenleItem = new JMenuItem("Edit City");
		musterilerMenu.add(sehirDuzenleItem);
		PersonelContract contract = (PersonelContract) loginFE.emailBox.getSelectedItem();

		if (new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==2) {
			
			personellerMenu.hide();
			
		}else if (new AccountsDAL().GetYetkiId(contract.getId()).getYetkiId()==3) {
			
			musterilerMenu.hide();
			personellerMenu.hide();
			urunlerMenu.hide();
			
		}
		
		
		urunEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {

						new urunEkleFE();

					}
				});

			}
		});

		kategoriEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new kategororiEkleFE();

			}
		});

		personelEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {

						new PersonelEkleFE();

					}
				});

			}
		});

		yetkiEkleItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new YetkiEkleFE();

					}
				});

			}
		});
		
		sifreBelirleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SifreIslemleriFE();
				
			}
		});
		
		musteriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {

						new musteriEkleFE();
						
					}
				});
				
			}
		});

		return bar;
	}
}
