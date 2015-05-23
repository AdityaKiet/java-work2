import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class MainTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		MainTest frame = new MainTest();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public MainTest() {
		GraphicsEnvironment env = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		setResizable(false);
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
	}

}
