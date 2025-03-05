package Y1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormBanHang extends JFrame {
	Choice choice = new Choice();
	TextField txta = new TextField();
	TextField txtb = new TextField();
	TextField txtc = new TextField();
	Map<String , Integer> danhsachhanghoa = new HashMap<String, Integer>();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBanHang frame = new FormBanHang();
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
	
	public FormBanHang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader fr =new FileReader("hanghoa1.txt");
					BufferedReader br =new BufferedReader(fr);
					while(true) {
						String st = br.readLine();
						if(st == "" || st == null) break;
						String[] a = st.split(";");
						danhsachhanghoa.put(a[0], Integer.parseInt(a[1]));
						choice.add(a[0]);
					}
					br.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				String s = choice.getSelectedItem();
				txta.setText(danhsachhanghoa.get(s).toString());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_3 = new Label("Chon Hang:");
		label_3.setBounds(31, 31, 62, 22);
		contentPane.add(label_3);
		
		Label label_2 = new Label("Gia:");
		label_2.setBounds(31, 75, 62, 22);
		contentPane.add(label_2);
		
		Label label_1 = new Label("Nhap so luong:");
		label_1.setBounds(31, 114, 86, 22);
		contentPane.add(label_1);
		
		Label label = new Label("Thanh tien:");
		label.setBounds(31, 157, 62, 22);
		contentPane.add(label);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s = choice.getSelectedItem();
				txta.setText(danhsachhanghoa.get(s).toString());
			}
		});
		
		
		choice.setBounds(146, 31, 169, 20);
		contentPane.add(choice);
		
		
		txta.setBounds(146, 75, 169, 22);
		contentPane.add(txta);
		
		
		txtb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					Double c = (double) Integer.parseInt(txtb.getText());
					Double gia = c * Integer.parseInt(txta.getText());
					txtc.setText(gia.toString());
				}
			}
		});
		txtb.setBounds(146, 114, 169, 22);
		contentPane.add(txtb);
		
		
		txtc.setBounds(146, 157, 169, 22);
		contentPane.add(txtc);
	}
}
