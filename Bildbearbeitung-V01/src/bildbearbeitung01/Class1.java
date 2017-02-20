import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Class1 {

	private JFrame frmClass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class1 window = new Class1();
					window.frmClass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Class1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClass = new JFrame();
		frmClass.setTitle("Class1");
		frmClass.setBounds(100, 100, 360, 214);
		frmClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClass.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//double click the button, after that there is available
				Class2 nw = new Class2();
				nw.NewScreen();
			}
		});
		btnNewButton.setBounds(10, 11, 102, 31);
		frmClass.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("open editor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Class3 nw1 = new Class3();
				nw1.NewScreen1();
			}
		});
		btnNewButton_1.setBounds(143, 11, 102, 31);
		frmClass.getContentPane().add(btnNewButton_1);
	}

}
