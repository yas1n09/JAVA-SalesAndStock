package yasin.yagci.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;

import yasin.yagci.complex.types.SatisContractComplex;
import yasin.yagci.complex.types.StokContractComplex;
import yasin.yagci.complex.types.StokContractTotalComplex;
import yasin.yagci.dal.MusteriDAL;
import yasin.yagci.dal.SatisDAL;
import yasin.yagci.dal.StokDAL;
import yasin.yagci.dal.UrunlerDAL;
import yasin.yagci.interfaces.FeInterfaces;
import yasin.yagci.types.MusteriContract;
import yasin.yagci.types.PersonelContract;
import yasin.yagci.types.SatisContract;
import yasin.yagci.types.StokContract;
import yasin.yagci.types.UrunlerContract;
import yasin.yagci.utilities.MenulerCom;

@SuppressWarnings("serial")
public class AnaPencereFE extends JFrame implements FeInterfaces {

	public AnaPencereFE() {
		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		JMenuBar bar = initBar();

		add(panel);
		setJMenuBar(bar);
		setTitle("Sales And Stock");
		setSize(600, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		JTabbedPane pane = initTabs();
		panel.add(pane, BorderLayout.CENTER);

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		JMenuBar bar = new MenulerCom().initBar();

		return bar;
	}

	@Override
	public JTabbedPane initTabs() {
		JTabbedPane pane = new JTabbedPane();

		JPanel stokPanel = new JPanel(new BorderLayout());
		JPanel satisPanel = new JPanel(new BorderLayout());

		/* stok itemleri */
		JPanel stokSolPanel = new JPanel(new BorderLayout());
		JPanel stokSolUstPanel = new JPanel(new GridLayout(5, 2));
		JPanel stokSolAltPanel = new JPanel();

		stokSolPanel.setBorder(BorderFactory.createTitledBorder("stock transactions"));
		Object[] stokKolonlar = { "Id", "Product Name", "Staff Name", "Piece" };
		DefaultTableModel model = new DefaultTableModel(stokKolonlar, 0);
		JTable table = new JTable(model);
		JScrollPane stokTablePane = new JScrollPane(table);

		for (StokContractComplex contract : new StokDAL().GetAllStok()) {

			model.addRow(contract.getVeriler());
		}

		JLabel stokUrunAdiLabel = new JLabel("Product Name:", JLabel.RIGHT);
		stokSolUstPanel.add(stokUrunAdiLabel);
		JComboBox stokUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		stokSolUstPanel.add(stokUrunAdiBox);
		JLabel stokAdetLabel = new JLabel("Piece(s)", JLabel.RIGHT);
		stokSolUstPanel.add(stokAdetLabel);
		JTextField stokAdetField = new JTextField(10);
		stokSolUstPanel.add(stokAdetField);

		JButton stokEkleButton = new JButton("Add Stock");
		stokSolUstPanel.add(stokEkleButton);
		JButton stokYenileButton = new JButton("Stock Refresh");
		stokSolUstPanel.add(stokYenileButton);
		JButton stokTotalButton = new JButton("Total product in stock");
		stokSolUstPanel.add(stokTotalButton);
		stokTotalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {

					model.removeRow(0);

				}

				for (StokContractTotalComplex total : new StokDAL().getTotalStok()) {

					model.addRow(total.getVeriler());

				}

			}
		});

		stokYenileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {

					model.removeRow(0);
				}

				for (StokContractComplex compContract : new StokDAL().GetAllStok()) {

					model.addRow(compContract.getVeriler());
				}

			}
		});
		stokEkleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				StokContract contract = new StokContract();
				UrunlerContract uContract = (UrunlerContract) stokUrunAdiBox.getSelectedItem();
				PersonelContract pContract = (PersonelContract) loginFE.emailBox.getSelectedItem();

				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setAdet(Integer.parseInt(stokAdetField.getText()));
				new StokDAL().Insert(contract);

				JOptionPane.showMessageDialog(null, uContract.getAdi() + "Product Added");

				int satir = model.getRowCount();
				for (int i = 0; i < satir; i++) {

					model.removeRow(0);
				}

				for (StokContractComplex compContract : new StokDAL().GetAllStok()) {

					model.addRow(compContract.getVeriler());
				}
			}
		});

		/* satis itemleri */
		JPanel satisSagPanel = new JPanel(new BorderLayout());
		satisSagPanel.setBorder(BorderFactory.createTitledBorder("Sales"));
		JPanel satisSagUstPanel = new JPanel(new GridLayout(6, 2));
		JPanel satisSagAltPanel = new JPanel();

		Object[] satisKolonlar = { "Id", "Customer Name", "Staff Name", "Product Name", "Piece" };
		DefaultTableModel satisModel = new DefaultTableModel(satisKolonlar, 0);
		JTable satisTable = new JTable(satisModel);
		JScrollPane satisTablePane = new JScrollPane(satisTable);
		JLabel musteriLabel = new JLabel("Customer Name", JLabel.RIGHT);
		satisSagUstPanel.add(musteriLabel);
		JComboBox musteriAdiBox = new JComboBox(new MusteriDAL().GetAll().toArray());
		satisSagUstPanel.add(musteriAdiBox);
		JLabel satisUrunAdiLabel = new JLabel("Product Name:", JLabel.RIGHT);
		satisSagUstPanel.add(satisUrunAdiLabel);
		JComboBox satisUrunAdiBox = new JComboBox(new UrunlerDAL().GetAll().toArray());
		satisSagUstPanel.add(satisUrunAdiBox);
		JLabel satisAdetLabel = new JLabel("Piece(s)", JLabel.RIGHT);
		satisSagUstPanel.add(satisAdetLabel);
		JTextField satisAdetField = new JTextField(10);
		satisSagUstPanel.add(satisAdetField);

		JButton satisEkleButton = new JButton("Add Sale");
		satisSagUstPanel.add(satisEkleButton);
		for (SatisContractComplex yenileContract : new SatisDAL().GetAllSatis()) {

			satisModel.addRow(yenileContract.getVeriler());

		}
		satisEkleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PersonelContract pContract = (PersonelContract) loginFE.emailBox.getSelectedItem();
				UrunlerContract uContract = (UrunlerContract) satisUrunAdiBox.getSelectedItem();
				MusteriContract mContract = (MusteriContract) musteriAdiBox.getSelectedItem();
				SatisContract contract = new SatisContract();

				contract.setMusteriId(mContract.getId());
				contract.setPersonelId(pContract.getId());
				contract.setUrunId(uContract.getId());
				contract.setAdet(Integer.parseInt(satisAdetField.getText()));

				new SatisDAL().Insert(contract);
				StokContract stokContract = new StokContract();

				stokContract.setPersonelId(pContract.getId());
				stokContract.setUrunId(uContract.getId());
				stokContract.setAdet(-Integer.parseInt(satisAdetField.getText()));

				new StokDAL().Insert(stokContract);

				JOptionPane.showMessageDialog(null, "Sale successful");
				int satir = satisModel.getRowCount();
				for (int i = 0; i < satir; i++) {

					satisModel.removeRow(0);
				}

				for (SatisContractComplex yenileContract : new SatisDAL().GetAllSatis()) {

					satisModel.addRow(yenileContract.getVeriler());

				}
			}
		});
		JButton satisYenileButton = new JButton("Sale Refresh");
		satisSagUstPanel.add(satisYenileButton);
		satisYenileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int satir = satisModel.getRowCount();
				for (int i = 0; i < satir; i++) {

					satisModel.removeRow(0);
				}

				for (SatisContractComplex contract : new SatisDAL().GetAllSatis()) {

					satisModel.addRow(contract.getVeriler());

				}

			}
		});

		stokPanel.add(stokSolPanel, BorderLayout.WEST);
		stokPanel.add(stokTablePane, BorderLayout.CENTER);

		satisPanel.add(satisSagPanel, BorderLayout.EAST);
		satisPanel.add(satisTablePane, BorderLayout.CENTER);

		satisSagPanel.add(satisSagUstPanel, BorderLayout.NORTH);
		satisSagPanel.add(satisSagAltPanel, BorderLayout.SOUTH);

		stokSolPanel.add(stokSolUstPanel, BorderLayout.NORTH);
		stokSolPanel.add(stokSolAltPanel, BorderLayout.SOUTH);
		pane.addTab("Stocks", null, stokPanel);
		pane.addTab("Sales", null, satisPanel);
		return pane;
	}

}
