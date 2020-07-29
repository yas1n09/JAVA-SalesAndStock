package yasin.yagci.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import yasin.yagci.dal.KategoriDAL;
import yasin.yagci.dal.UrunlerDAL;
import yasin.yagci.interfaces.FeInterfaces;
import yasin.yagci.types.KategoriContract;
import yasin.yagci.types.UrunlerContract;

public class urunEkleFE extends JDialog implements FeInterfaces {

	public urunEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Product Register"));
		add(panel);
		setTitle("Add Product");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(4, 2));
		JLabel adiLabel = new JLabel("Name:", JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);
		JLabel kategoriLabel = new JLabel("Categorie:", JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new KategoriDAL().GetAllParentId().toArray());
		panel.add(kategoriBox);
		JLabel fiyatLabel = new JLabel("Price:", JLabel.RIGHT);
		panel.add(fiyatLabel);
		JTextField fiyatField = new JTextField(10);
		panel.add(fiyatField);

		JButton kaydetButton = new JButton("Save");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Cancel");
		panel.add(iptalButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UrunlerContract contract = new UrunlerContract();
				KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
				
				contract.setAdi(adiField.getText());
				contract.setKategoriId(casContract.getId());
				contract.setFiyat(Float.parseFloat(fiyatField.getText()));
				new UrunlerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+"Product Added Succesfully");
			}
		});

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
