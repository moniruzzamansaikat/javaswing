import javax.swing.SwingUtilities;

import ui.PasswordGenerator;

public class Application {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new PasswordGenerator();
			}
		});
	}
}