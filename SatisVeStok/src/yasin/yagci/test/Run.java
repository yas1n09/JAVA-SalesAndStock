package yasin.yagci.test;

import javax.swing.SwingUtilities;

import yasin.yagci.dal.UrunlerDAL;
import yasin.yagci.fe.AnaPencereFE;
import yasin.yagci.fe.loginFE;

public class Run {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				//new AnaPencere();
				new loginFE();
				//new UrunlerDAL().GetAll();
				
			}
		});

	}

}
