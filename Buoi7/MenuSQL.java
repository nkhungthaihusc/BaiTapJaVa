package Buoi7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmanv;
	private JLabel lblHSLngl;
	private JTextField txtten;
	private JTextField txthsl;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	BuoiHoc1SQL bh = new BuoiHoc1SQL();
	private JTextField txtns;
	private JTextField txtgt;
	private JTextField txtgc;
	private JTextField txtmdv;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSQL frame = new MenuSQL();
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
	void ThemListNV() {
		DefaultTableModel mh = new DefaultTableModel();
		DefaultTableModel mh1 = new DefaultTableModel();
		
		try {
			bh.KetNoi();
			mh.addColumn("Mã NV");
			mh.addColumn("Họ tên");
			mh.addColumn("Ngày sinh");
			mh.addColumn("Giới tính");
			mh.addColumn("hsl");
			mh.addColumn("Ghi chú");
			mh.addColumn("Mã DV");
			String sql = "select * from NhanVien";
			PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				String manv = rs.getString(1);
				String hoten = rs.getString(2);
				String d1 = rs.getDate(3).toString();
				boolean gt = rs.getBoolean(4);
				String gtt = gt == true ? "Nam" : "Nu";
				double hsl = rs.getDouble(5);
				String gc = rs.getString(6);
				String mdv = rs.getString(7);
				mh.addRow(new Object[] {manv , hoten , d1 , gtt , hsl , gc , mdv});
			}
			table.setModel(mh);
			String sql1 = "select * from DonVi";
			PreparedStatement cmd1 = BuoiHoc1SQL.cn.prepareStatement(sql1);
			ResultSet rs1 = cmd1.executeQuery();
			mh1.addColumn("Mã dv");
			mh1.addColumn("Tên dv");
			while(rs1.next()) {
				String madv = rs1.getString(1);
				String tendv = rs1.getString(2);
				mh1.addRow(new Object[] {madv , tendv});
			}
			table_1.setModel(mh1);
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public MenuSQL() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ThemListNV();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtmanv = new JTextField();
		txtmanv.setBounds(122, 31, 177, 20);
		contentPane.add(txtmanv);
		txtmanv.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(32, 34, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(32, 69, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		lblHSLngl = new JLabel("Hệ số lương:");
		lblHSLngl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHSLngl.setBounds(32, 105, 98, 14);
		contentPane.add(lblHSLngl);
		
		txtten = new JTextField();
		txtten.setColumns(10);
		txtten.setBounds(122, 62, 177, 20);
		contentPane.add(txtten);
		
		txthsl = new JTextField();
		txthsl.setColumns(10);
		txthsl.setBounds(122, 102, 177, 20);
		contentPane.add(txthsl);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					bh.KetNoi();
					String sql = "insert into NhanVien values(?,?,?,?,?,?,?)";
					PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
					cmd.setString(1, txtmanv.getText());
					cmd.setString(2, txtten.getText());
					String s = txtns.getText();
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date n1 = f.parse(s);
					java.sql.Date n2 = new java.sql.Date(n1.getTime());
					cmd.setDate(3, n2);
					cmd.setBoolean(4, txtgt.getText().equals("Nam") ? true : false);
					cmd.setDouble(5, Double.parseDouble(txthsl.getText()));
					cmd.setString(6, txtgc.getText());
					cmd.setString(7, txtmdv.getText());
					int k = cmd.executeUpdate();
					System.out.println(k);
					BuoiHoc1SQL.cn.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ThemListNV();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(108, 180, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					bh.KetNoi();
					String sql = "delete from NhanVien where manv = ?";
					PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
					cmd.setString(1 ,txtmanv.getText());
					cmd.executeUpdate();
					BuoiHoc1SQL.cn.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ThemListNV();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(251, 180, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					bh.KetNoi();
					String sql = "update NhanVien set hsl = ? where manv = ?";
					PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
					cmd.setDouble(1, Double.parseDouble(txthsl.getText()));
					cmd.setString(2 , txtmanv.getText());
					cmd.executeUpdate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ThemListNV();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(389, 180, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Find");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel mh = new DefaultTableModel();
				mh.addColumn("Mã NV");
				mh.addColumn("Họ tên");
				mh.addColumn("Ngày sinh");
				mh.addColumn("Giới tính");
				mh.addColumn("hsl");
				mh.addColumn("Ghi chú");
				mh.addColumn("Mã DV");
				try {
					bh.KetNoi();
					String s = JOptionPane.showInputDialog("Nhập mã nhân viên của nhân viên cần tìm: ");
					String sql = "select * from NhanVien where manv = ?";
					PreparedStatement cmd = BuoiHoc1SQL.cn.prepareStatement(sql);
					cmd.setString(1, s);
					ResultSet rs = cmd.executeQuery();
					
					while(rs.next()) {
						String manv = rs.getString(1);
						String hoten = rs.getString(2);
						String d1 = rs.getDate(3).toString();
						boolean gt = rs.getBoolean(4);
						String gtt = gt == true ? "Nam" : "Nu";
						double hsl = rs.getDouble(5);
						String gc = rs.getString(6);
						String mdv = rs.getString(7);
						mh.addRow(new Object[] {manv , hoten , d1 , gtt , hsl , gc , mdv});
					}
					table.setModel(mh);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(533, 180, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(108, 237, 571, 290);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sách nhân viên", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Danh sách đơn vị", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblHs = new JLabel("Ngày sinh:");
		lblHs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHs.setBounds(361, 34, 98, 14);
		contentPane.add(lblHs);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGiiTnh.setBounds(361, 69, 98, 14);
		contentPane.add(lblGiiTnh);
		
		JLabel lblNewLabel_4 = new JLabel("Ghi chú:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(361, 105, 98, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mã dịch vụ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(32, 145, 98, 14);
		contentPane.add(lblNewLabel_5);
		
		txtns = new JTextField();
		txtns.setColumns(10);
		txtns.setBounds(446, 31, 177, 20);
		contentPane.add(txtns);
		
		txtgt = new JTextField();
		txtgt.setColumns(10);
		txtgt.setBounds(446, 66, 177, 20);
		contentPane.add(txtgt);
		
		txtgc = new JTextField();
		txtgc.setColumns(10);
		txtgc.setBounds(446, 102, 177, 20);
		contentPane.add(txtgc);
		
		txtmdv = new JTextField();
		txtmdv.setColumns(10);
		txtmdv.setBounds(122, 142, 177, 20);
		contentPane.add(txtmdv);
		
		
	}
	
}
