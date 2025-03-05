package Y1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class t2 extends JFrame {
	List list = new List();
	Choice choice = new Choice();
	TextField txt1 = new TextField();
	
	
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t2 frame = new t2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public t2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String muc = list.getSelectedItem();
				txt1.setText(muc);
			}
		});
		
		
		list.setBounds(113, 93, 181, 114);
		contentPane.add(list);
		
		
		choice.setBounds(113, 67, 181, 20);
		contentPane.add(choice);
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					list.add(txt1.getText());
					choice.add(txt1.getText());
				}
			}
		});
		
		
		txt1.setBounds(113, 39, 181, 22);
		contentPane.add(txt1);
	}

}
