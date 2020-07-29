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
import yasin.yagci.interfaces.FeInterfaces;
import yasin.yagci.types.KategoriContract;

public class kategororiEkleFE extends JDialog implements FeInterfaces{

	public kategororiEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Add Categorie"));
		
		add(panel);
		setTitle("Add Categorie");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
				
	}

	@Override
	public JPanel initPanel() {
		
		
		JPanel panel = new JPanel(new GridLayout(3, 2));
		
		
		
		JLabel adiLabel = new JLabel("Categorie Name:", JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);
		JLabel kategoriLabel = new JLabel("Choose Categorie:", JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new KategoriDAL().GetAllParentId().toArray());
		panel.add(kategoriBox);
		kategoriBox.insertItemAt("-Choose Categorie-", 0);
		kategoriBox.setSelectedIndex(0);
		JButton kaydetButton = new JButton("Save");
		panel.add(kaydetButton);
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KategoriContract contract = new KategoriContract();
				
				
			if (kategoriBox.getSelectedIndex()!=0) {
				KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem(); 
				contract.setAdi(adiField.getText());
				contract.setParentId(casContract.getId());
				
				
				new KategoriDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+" Categorie Added successfully.");
			}
			else {
				
				
				contract.setAdi(adiField.getText());
				contract.setParentId(kategoriBox.getSelectedIndex());
				
				
				new KategoriDAL().Insert(contract);
				
				JOptionPane.showMessageDialog(null, contract.getAdi()+" Categorie Added successfully.");
				
			}}
		});
		
		JButton iptalButton = new JButton("Cancel");
		panel.add(iptalButton);
		
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
