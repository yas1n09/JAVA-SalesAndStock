package yasin.yagci.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import yasin.yagci.dal.KategoriDAL;
import yasin.yagci.interfaces.FeInterfaces;

public class KategoriDuzenleFE extends JDialog implements FeInterfaces{

	public KategoriDuzenleFE() {
		
		initPencere();
		
	}

	@Override
	public void initPencere() {
		
		JPanel panel = initPanel();
		add(panel);
		setTitle("Edit Categorie");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Edit"));
		JPanel ustPanel = new JPanel(new GridLayout(3,2));
		ustPanel.setBorder(BorderFactory.createTitledBorder("Categorie Edit"));
		JLabel kategoriAdiLabel = new JLabel("Categorie Name",JLabel.RIGHT);
		ustPanel.add(kategoriAdiLabel);
		JTextField kategoriAdiField = new JTextField(10);
		ustPanel.add(kategoriAdiField);
		JLabel ustKategoriLabel = new JLabel("Parent Categorie:",JLabel.RIGHT);
		ustPanel.add(ustKategoriLabel);
		JComboBox ustKategoriBox = new JComboBox(new KategoriDAL().GetAllParentId().toArray());
		ustPanel.add(ustKategoriBox);
		
		
		
		JList kategoriList = new JList();
		kategoriList.setListData(new KategoriDAL().GetAllParentId().toArray());
		JScrollPane pane = new JScrollPane(kategoriList);
		pane.setBorder(BorderFactory.createTitledBorder(" Editable List"));
		kategoriList.setSelectedIndex(0);
		kategoriAdiField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				kategoriList.setListData(new KategoriDAL().GetSearchKategori(kategoriAdiField.getText()).toArray());
				kategoriList.setSelectedIndex(0);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
				);
				panel.add(ustPanel,BorderLayout.NORTH);
				panel.add(pane, BorderLayout.CENTER);
		
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
