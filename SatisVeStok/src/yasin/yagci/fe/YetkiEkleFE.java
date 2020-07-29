package yasin.yagci.fe;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import yasin.yagci.dal.YetkilerDAL;
import yasin.yagci.interfaces.FeInterfaces;
import yasin.yagci.types.YetkilerContract;

public class YetkiEkleFE extends JDialog implements FeInterfaces{

	public YetkiEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel =initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Add Permisson"));
		add(panel);
		setTitle("Add Permission");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel =new JPanel(new GridLayout(2, 2));
		JLabel adiLabel = new JLabel("Permisson Name:",JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);
		
		JButton kaydetButton = new JButton("Save");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Cancel");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				YetkilerContract contract = new YetkilerContract();
				
				contract.setAdi(adiField.getText());
				new YetkilerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+"Permission Added");
				
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
