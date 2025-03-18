import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmHienThi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Choice choice = new Choice();
	private JScrollPane scrollPane;
	ArrayList ds;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JTextField dtb;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHienThi frame = new FrmHienThi();
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
	public FrmHienThi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				choice.add("Khoa CNTT");
				choice.add("Khoa Toán");
				choice.add("Khoa Lý");
				LopHoc lh = new LopHoc();
				lh.TaoLop("sv.txt");
				ds = lh.ds1;
				try {
					FileWriter fw1 = new FileWriter("f1.txt");
					PrintWriter pw1 = new PrintWriter(fw1);
					FileWriter fw2 = new FileWriter("f2.txt");
					PrintWriter pw2 = new PrintWriter(fw2);
					FileWriter fw3 = new FileWriter("f3.txt");
					PrintWriter pw3 = new PrintWriter(fw3);
					for(Object t : ds) {
						if(t instanceof SvCntt) {
							SvCntt sv = (SvCntt)t;
							pw1.println(sv.getThongTin());
						}
						if(t instanceof SvToan) {
							SvToan sv = (SvToan)t;
							pw2.println(sv.getThongTin());
						}
						if(t instanceof SvLy) {
							SvLy sv = (SvLy)t;
							pw3.println(sv.getThongTin());
						}
					}
					pw1.close();
					pw2.close();
					pw3.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn Lớp:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(149, 37, 61, 25);
		contentPane.add(lblNewLabel);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				table.removeAll();
				dtb.removeAll();
				String t = choice.getSelectedItem();
				DefaultTableModel mh = new DefaultTableModel();
				if(t.equalsIgnoreCase("Khoa CNTT")) {
					mh.addColumn("Họ tên");
					mh.addColumn("Mã Sinh Viên");
					mh.addColumn("Điểm môn 1");
					mh.addColumn("Điểm môn 2");
					int cnt = 0;
					double sum = 0.0;
					for(Object a : ds) {
						if(a instanceof SvCntt) {
							SvCntt sv = (SvCntt)a;
							sum += sv.getDtb();
							cnt++;
							mh.addRow(new Object[] {sv.getMaSv() , sv.getHoTen() , sv.getDm1() , sv.getDm2()});
						}
					}
					dtb.setText(String.format("%.2f", (sum / cnt)));
					table.setModel(mh);
				}
				if(t.equalsIgnoreCase("Khoa Toán")) {
					mh.addColumn("Họ tên");
					mh.addColumn("Mã Sinh Viên");
					mh.addColumn("Điểm môn 1");
					mh.addColumn("Điểm môn 2");
					mh.addColumn("Điểm môn 3");
					double sum = 0.0;
					int cnt = 0;
					for(Object a : ds) {
						if(a instanceof SvToan) {
							SvToan sv = (SvToan)a;
							sum += sv.getDtb();
							cnt++;
							mh.addRow(new Object[] {sv.getMaSv() , sv.getHoTen() , sv.getDm1() , sv.getDm2() , sv.getDm3()});
						}
					}
					dtb.setText(String.format("%.2f", (sum / cnt)));
					table.setModel(mh);
				}
				if(t.equalsIgnoreCase("Khoa Lý")) {
					double sum = 0.0;
					int cnt = 0;
					mh.addColumn("Họ tên");
					mh.addColumn("Mã Sinh Viên");
					mh.addColumn("Điểm môn 1");
					mh.addColumn("Điểm môn 2");
					mh.addColumn("Điểm môn 3");
					mh.addColumn("Điểm môn 4");
					for(Object a : ds) {
						if(a instanceof SvLy) {
							SvLy sv = (SvLy)a;
							sum += sv.getDtb();
							cnt++;
							mh.addRow(new Object[] {sv.getMaSv() , sv.getHoTen() , sv.getDm1() , sv.getDm2() , sv.getDm3() , sv.getDm4()});
						}
					}
					
					dtb.setText(String.format("%.2f", (sum / cnt)));
					table.setModel(mh);
				}
			}
		});
		
		
		choice.setBounds(216, 37, 116, 20);
		contentPane.add(choice);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(54, 119, 467, 328);
		contentPane.add(tabbedPane);
		
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sách sinh viên", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Danh sách sinh viên tìm kiếm", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Điểm trung bình của Khoa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(54, 78, 156, 14);
		contentPane.add(lblNewLabel_1);
		
		dtb = new JTextField();
		dtb.setBounds(216, 73, 116, 20);
		contentPane.add(dtb);
		dtb.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm SV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LopHoc lh = new LopHoc();
				String key = JOptionPane.showInputDialog("Nhap Key");
				ArrayList<Object> kq = lh.TimKey(ds, key);
				DefaultTableModel mh = new DefaultTableModel();
				mh.addColumn("Họ tên");
				mh.addColumn("Mã Sinh Viên");
				mh.addColumn("Khoa");
				for(Object t : kq) {
					if(t instanceof SvCntt) {
						SvCntt sv = (SvCntt)t;
						mh.addRow(new Object[] {sv.getMaSv() , sv.getHoTen() , "CNTT"});
					}
					if(t instanceof SvToan) {
						SvToan sv = (SvToan)t;
						mh.addRow(new Object[] {sv.getMaSv() , sv.getHoTen() , "Toán"});
					}
					if(t instanceof SvLy) {
						SvLy sv = (SvLy)t;
						mh.addRow(new Object[] {sv.getMaSv() , sv.getHoTen() , "Lý"});
					}
				}
				table_1.setModel(mh);
			}
		});
		btnNewButton.setBounds(395, 57, 89, 23);
		contentPane.add(btnNewButton);
	}
}
