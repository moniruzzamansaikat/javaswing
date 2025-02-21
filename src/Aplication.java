import javax.swing.SwingUtilities;

import ui.PasswordGenerator;

public class Aplication {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new PasswordGenerator();
			}
		});
	}
}
