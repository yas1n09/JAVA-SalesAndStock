package yasin.yagci.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Attributes.Name;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import yasin.yagci.dal.MusteriDAL;
import yasin.yagci.dal.PersonelDAL;
import yasin.yagci.interfaces.FeInterfaces;
import yasin.yagci.types.MusteriContract;
import yasin.yagci.types.PersonelContract;

public class musteriEkleFE extends JDialog implements FeInterfaces{

	public musteriEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Add Customer"));
		
		add(panel);
		setTitle("Add Customer");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);				
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel fieldPanel = new JPanel(new GridLayout(5, 2));
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		JLabel adiSoyadiLabel = new JLabel("Name Surname:",JLabel.RIGHT);
		fieldPanel.add(adiSoyadiLabel);
		JTextField adiSoyadiField = new JTextField(15);
		fieldPanel.add(adiSoyadiField);
		JLabel telefonLabel = new JLabel("Phone Number:",JLabel.RIGHT);
		fieldPanel.add(telefonLabel);
		JTextField telefonField = new JTextField(15);
		fieldPanel.add(telefonField);
		JLabel sehirSecLabel = new JLabel("Choose City:",JLabel.RIGHT);
		fieldPanel.add(sehirSecLabel);
		JComboBox sehirlerBox = new JComboBox();
		fieldPanel.add(sehirlerBox);
		JLabel adresLabel = new JLabel("Adress:");
		fieldPanel.add(adresLabel);
		
		
		JTextArea adresArea = new JTextArea(7,1);
		JScrollPane pane = new JScrollPane(adresArea);
		pane.setBorder(BorderFactory.createTitledBorder("Adress Information"));
		JButton kaydetButton = new JButton("Save");
		buttonPanel.add(kaydetButton);
		JButton iptalButton = new JButton("Cancel");
		buttonPanel.add(iptalButton);
		panel.add(fieldPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusteriContract contract = new MusteriContract();
				contract.setAdiSoyadi(adiSoyadiField.getText());
				contract.setAdres(adresArea.getText());
				contract.setTelefon(telefonField.getText());
				//contract.setSehirId(sehirlerBox.getSelectedItem().get);
				
				new MusteriDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi() +"Customer Added");
				
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
