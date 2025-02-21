import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Aplication {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame main = new JFrame();
				main.setSize(400, 400);
				main.setVisible(true);
			}
		});
	}
}
