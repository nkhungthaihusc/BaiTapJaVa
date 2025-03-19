package MyFrame2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.Choice;
import java.awt.TextField;
import java.util.ArrayList;
import java.awt.Button;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDanhSach extends JFrame {
	List list1 = new List();
	Choice choice = new Choice();
	TextField txtmasv = new TextField();
	TextField txtht = new TextField();
	TextField txtdtb = new TextField();
	ArrayList ds = new ArrayList();
	int kt = 0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDanhSach frame = new FrmDanhSach();
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
	public FrmDanhSach() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader fr = new FileReader("ds.txt");
					BufferedReader bf = new BufferedReader(fr);
					ds.clear();
					while (true) {
						String msv = bf.readLine();
						if (msv == null)
							break;
						String ht = bf.readLine();
						String tenlop = bf.readLine();
						float dtb = Float.parseFloat(bf.readLine());
						SinhVien sv = new SinhVien(msv, ht, tenlop, dtb);
						ds.add(sv);
					}
					bf.close();
					FileReader fr1 = new FileReader("khoa.txt");
					BufferedReader bf1 = new BufferedReader(fr1);
					while (true) {
						String st = bf1.readLine();
						if (st == null) {
							break;
						}
						choice.add(st);
					}
					bf1.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
					choice.add("DA loi");
				}
				NapList(choice.getSelectedItem());
				kt = 1;
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label label = new Label("Chon 1 lop: ");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(23, 10, 87, 22);
		contentPane.add(label);

		Label label_1 = new Label("Ma Sinh Vien:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(23, 38, 87, 22);
		contentPane.add(label_1);

		Label label_2 = new Label("Ho Ten:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(23, 66, 87, 22);
		contentPane.add(label_2);

		Label label_3 = new Label("Diem Trung Binh:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		label_3.setBounds(23, 94, 99, 22);
		contentPane.add(label_3);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				NapList(choice.getSelectedItem());
			}
		});
		choice.setBounds(134, 10, 187, 20);
		contentPane.add(choice);

		txtmasv.setBounds(134, 38, 187, 22);
		contentPane.add(txtmasv);

		txtht.setBounds(134, 66, 187, 22);
		contentPane.add(txtht);

		txtdtb.setBounds(134, 94, 187, 22);
		contentPane.add(txtdtb);

		Button button = new Button("Nhap");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int ktma = 0;
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					SinhVien sv = (SinhVien) ds.get(i);
					if (sv.masv.equals(txtmasv.getText())) {
						ktma = 1;
						break;
					}
				}
				if (ktma == 0) {
					SinhVien sv = new SinhVien(txtmasv.getText(), txtht.getText(), choice.getSelectedItem(),
							Float.parseFloat(txtdtb.getText()));
					ds.add(sv);
					NapList(choice.getSelectedItem());
				}
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(344, 10, 70, 22);
		contentPane.add(button);

		Button button_1 = new Button("Luu File");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fw = new FileWriter("ds.txt" , true);
					PrintWriter ghi = new PrintWriter(fw);
					int n = ds.size();
					for (int i = 0; i < n; i++) {
						SinhVien sv = (SinhVien) ds.get(i);
						ghi.println(sv.masv);
						ghi.println(sv.ht);
						ghi.println(sv.tenlop);
						ghi.println(sv.dtb);
					}
					ghi.close();
				} catch (Exception tt) {
					tt.getStackTrace();
				}
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setBounds(430, 10, 70, 22);
		contentPane.add(button_1);

		Button button_1_1 = new Button("Sua");
		button_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					SinhVien sv = (SinhVien) ds.get(i);
					if (sv.masv.equals(txtmasv.getText())) {
						sv.DoiTen(txtht.getText());
						sv.DoiLop(choice.getSelectedItem());
						sv.DoiDtb(Float.parseFloat(txtdtb.getText()));
						ds.set(i, sv);
						NapList(choice.getSelectedItem());
					}
				}
			}
		});
		button_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1_1.setBounds(344, 52, 70, 22);
		contentPane.add(button_1_1);

		Button button_1_2 = new Button("Tim Kiem");
		button_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String st = JOptionPane.showInputDialog(this, "Nhap masv can tim");
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					SinhVien sv = (SinhVien) ds.get(i);
					if (sv.masv.toLowerCase().equals(st)) {
						txtmasv.setText(sv.masv);
						txtht.setText(sv.ht);
						txtdtb.setText(String.valueOf(sv.dtb));
					}
				}
			}
		});
		button_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1_2.setBounds(430, 52, 70, 22);
		contentPane.add(button_1_2);

		Label label_4 = new Label("Danh Sach Cac Sinh Vien:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(23, 134, 179, 22);
		contentPane.add(label_4);
		list1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (kt != 0) {
					String st = list1.getSelectedItem();
					for (int i = 0; i < ds.size(); i++) {
						SinhVien sv = (SinhVien) ds.get(i);
						if (sv.masv.equals(st)) {
							txtmasv.setText(sv.masv);
							txtht.setText(sv.ht);
							txtdtb.setText(String.valueOf(sv.dtb));
						}
					}
				}
			}
		});

		list1.setBounds(23, 162, 463, 111);
		contentPane.add(list1);
	}

	void NapList(String tenlop) {
		list1.removeAll();
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			SinhVien sv = (SinhVien) ds.get(i);
			if (sv.tenlop.toLowerCase().equals(tenlop.toLowerCase())) {
				txtmasv.setText(sv.masv);
				txtht.setText(sv.ht);
				txtdtb.setText(String.valueOf(sv.dtb));
				list1.add(sv.masv);
				list1.add(sv.ht);
				list1.add(sv.tenlop);
				list1.add(String.valueOf(sv.dtb));
				list1.add("----------------------------------");
			}
		}
	}
}
