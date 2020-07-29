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
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import yasin.yagci.dal.AccountsDAL;
import yasin.yagci.dal.PersonelDAL;
import yasin.yagci.dal.YetkilerDAL;
import yasin.yagci.interfaces.FeInterfaces;
import yasin.yagci.types.AccountsContract;
import yasin.yagci.types.PersonelContract;
import yasin.yagci.types.YetkilerContract;

public class SifreIslemleriFE extends JDialog implements FeInterfaces{

	public SifreIslemleriFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Set Password"));
		
		add(panel);
		setTitle("Set Password");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));
		JLabel personelLabel = new JLabel("Choose Staff:",JLabel.RIGHT);
		panel.add(personelLabel);
		JComboBox personelBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(personelBox);
		JLabel yetkiLabel = new JLabel("Choose Permission:",JLabel.RIGHT);
		panel.add(yetkiLabel);
		JComboBox yetkiBox = new JComboBox(new YetkilerDAL().GetAll().toArray());
		panel.add(yetkiBox);
		JLabel passwordLabel = new JLabel("Choose Password:",JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passField = new JPasswordField(10);
		panel.add(passField);
		JLabel passTekrarLabel = new JLabel("Comfirim Password",JLabel.RIGHT);
		panel.add(passTekrarLabel);
		JPasswordField passTekrar = new JPasswordField(10);
		panel.add(passTekrar);
		
		JButton kaydetButton = new JButton("Save");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Cancel");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AccountsContract contract = new AccountsContract();
				PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
				YetkilerContract yContract = (YetkilerContract) yetkiBox.getSelectedItem();
				
				
				if (passField.getText().equals(passTekrar.getText())) {
					
					
					contract.setPersonelId(pContract.getId());
					contract.setYetkiId(yContract.getId());
					contract.setSifre(passField.getText());
				
					new AccountsDAL().Insert(contract);
					JOptionPane.showMessageDialog(null, "Password Changed Successfully");
					
										
				}else {
					JOptionPane.showMessageDialog(null, "Passwords do not match.");
					
				}
				
				
				
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
