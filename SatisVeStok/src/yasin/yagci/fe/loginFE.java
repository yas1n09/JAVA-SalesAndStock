package yasin.yagci.fe;

import java.awt.GridLayout;import java.awt.event.ActionEvent;
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
import yasin.yagci.interfaces.FeInterfaces;
import yasin.yagci.types.PersonelContract;

public class loginFE extends JDialog implements FeInterfaces{

	public static JComboBox emailBox;
	public loginFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Please Login"));
		add(panel);
		setTitle("Login");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 2));
		
		JLabel emailLabel = new JLabel("Email",JLabel.RIGHT);
		panel.add(emailLabel);
		emailBox = new JComboBox(new PersonelDAL().GetAll().toArray());
		panel.add(emailBox);
		JLabel passwordLabel =new JLabel("Password", JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passwordField = new JPasswordField(15);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		panel.add(loginButton);
		JButton iptalButton = new JButton("Cancel");
		panel.add(iptalButton);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PersonelContract contract =(PersonelContract) emailBox.getSelectedItem();
				String sifre = passwordField.getText();
				if (new AccountsDAL().GetPersonelIdVeSifre(contract.getId(), sifre).getId()!=0) {
					
					new AnaPencereFE();
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Login failed");
				}
				// TODO Auto-generated method stub
				
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
