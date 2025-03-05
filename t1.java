package Y1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class t1 extends JFrame {
	TextField txta = new TextField();
	TextField txtb = new TextField();
	TextField txtkq = new TextField();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t1 frame = new t1();
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
	public t1() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txta.setText("0");
				txtb.setText("0");
				txtkq.setText("0");
				JOptionPane.showMessageDialog(null, "Chao nguoi dep");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_2 = new Label("kq =");
		label_2.setBounds(10, 100, 62, 22);
		contentPane.add(label_2);
		
		Label label_1 = new Label("b =");
		label_1.setBounds(10, 60, 62, 22);
		contentPane.add(label_1);
		
		Label label = new Label("a =");
		label.setBounds(10, 20, 62, 22);
		contentPane.add(label);
		
		
		txta.setBounds(76, 20, 268, 22);
		contentPane.add(txta);
		txtb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txta.getText() == "0") {
					txta.setText("");
				}
				if(e.getKeyCode() == 10) {
					int a = Integer.parseInt(txta.getText());
					int b = Integer.parseInt(txtb.getText());
					Integer s = a + b;
					txtkq.setText(s.toString());
				}
				if(e.getKeyCode() == 27) {
					System.exit(1);
				}
			}
		});
		
		
		txtb.setBounds(76, 60, 268, 22);
		contentPane.add(txtb);
		
		
		txtkq.setBounds(76, 100, 268, 22);
		contentPane.add(txtkq);
		
		Button button = new Button("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				Integer s = a + b;
				txtkq.setText(s.toString());
			}
		});
		button.setBounds(10, 140, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				Integer s = a - b;
				txtkq.setText(s.toString());
			}
		});
		button_1.setBounds(100, 140, 70, 22);
		contentPane.add(button_1);
		
		Button button_2 = new Button("x");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				Integer s = a * b;
				txtkq.setText(s.toString());
			}
		});
		button_2.setBounds(196, 140, 70, 22);
		contentPane.add(button_2);
		
		Button button_3 = new Button("/");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				if(b != 0) {
					Double s = (double)a / b;
					txtkq.setText(s.toString());
				}
				else JOptionPane.showMessageDialog(null, "Về lớp 1 mà học");
			}
		});
		button_3.setBounds(293, 140, 70, 22);
		contentPane.add(button_3);
		
		Button button_4 = new Button("OK");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(226, 229, 70, 22);
		contentPane.add(button_4);
		
		Button button_5 = new Button("Cancel");
		button_5.setBounds(315, 229, 70, 22);
		contentPane.add(button_5);
	}
}
