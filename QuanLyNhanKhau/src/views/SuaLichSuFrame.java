package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.LichSuController;
import models.CoSoVatChatThue;
import models.HoatDongModel;
import models.LichSuModel;
import services.LichSuServices;
import utility.ClassTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.awt.event.ActionEvent;

public class SuaLichSuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private LichSuModel lichsumodel;
	private JLabel lblNewLabel12;
	private JLabel lblNewLabel6;
	private JLabel lblNewLabel5;
	private JLabel lblNewLabel13;
	private JLabel lblNewLabel14;
	private JFrame parentJFrame;
	private List<CoSoVatChatThue> listthue;
	private ClassTableModel classTableModel = null;
	private final String[] COLUMNS = { "Tên sản phẩm", "Số lượng", "Thành tiền" };
	private Container panel_1;
	private LichSuServices lichsuservices;

	public SuaLichSuFrame(JFrame parentJFrame, LichSuModel lichsumodel) {
		this.lichsumodel = lichsumodel;
		this.parentJFrame = parentJFrame;
		this.parentJFrame.setEnabled(false);
		lichsuservices = new LichSuServices();
		classTableModel = new ClassTableModel();
		HoatDongModel hd = lichsumodel.getHd();

		listthue = lichsuservices.getListThue(hd.getID());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 703, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông tin hoạt động");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(233, 10, 221, 26);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 39, 688, 231);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel6 = new JLabel("New label");
		lblNewLabel6.setBounds(126, 56, 129, 13);
		panel.add(lblNewLabel6);
		lblNewLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel6.setFont(new Font("Tahoma", Font.PLAIN, 13));

		lblNewLabel5 = new JLabel("New label");
		lblNewLabel5.setBounds(126, 21, 129, 13);
		panel.add(lblNewLabel5);
		lblNewLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel5.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
		lblNewLabel_1.setBounds(57, 21, 54, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_1_1 = new JLabel("Năm sinh: ");
		lblNewLabel_1_1.setBounds(61, 56, 62, 13);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(395, 10, 177, 50);
		panel.add(scrollPane);

		lblNewLabel12 = new JLabel("New label");
		scrollPane.setViewportView(lblNewLabel12);
		lblNewLabel12.setBackground(new Color(128, 128, 128));
		lblNewLabel12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel12.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1_1_8 = new JLabel("Địa chỉ :");
		lblNewLabel_1_1_8.setBounds(323, 21, 62, 13);
		panel.add(lblNewLabel_1_1_8);
		lblNewLabel_1_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_8.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblNewLabel_2 = new JLabel("Chi tiết");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(239, 70, 209, 26);
		panel.add(lblNewLabel_2);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 106, 668, 115);
		panel.add(panel_1);

		JLabel lblNewLabel_4 = new JLabel("Tên Hoạt động :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 280, 95, 19);
		contentPane.add(lblNewLabel_4);

		lblNewLabel13 = new JLabel("Tên Hoạt động");
		lblNewLabel13.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel13.setBounds(115, 277, 85, 19);
		contentPane.add(lblNewLabel13);

		JLabel lblNewLabel_4_2 = new JLabel("Thời gian : ");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(0, 315, 95, 19);
		contentPane.add(lblNewLabel_4_2);

		lblNewLabel14 = new JLabel("Tên Hoạt động");
		lblNewLabel14.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel14.setBounds(117, 315, 254, 19);
		contentPane.add(lblNewLabel14);

		JLabel lblNewLabel_5 = new JLabel("Thành tiền :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(370, 280, 84, 13);
		contentPane.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(469, 280, 127, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("đ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(606, 275, 33, 23);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Trạng thái");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(381, 321, 73, 34);
		contentPane.add(lblNewLabel_7);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(468, 327, 111, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!",
						JOptionPane.YES_NO_OPTION) == 0) {
					close();
				}
			}

		});

		JButton btnNewButton = new JButton("Trả");
		if (hd.getTrangthai().equals("Đã Trả"))
			btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Khách Hàng đã trả đủ?", "Có đúng không",
						JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					lichsuservices.tralistthue(listthue, hd.getID());
					LichSuController.refreshData();
					close();
				}
				
			}
		});
		btnNewButton.setBounds(589, 326, 72, 26);
		contentPane.add(btnNewButton);
		SetInf();
		setDataTable();
	}

	void close() {
		this.parentJFrame.setEnabled(true);
		dispose();
	}

	public void SetInf() {
		lblNewLabel5.setText(this.lichsumodel.getNk().getHoTen());
		lblNewLabel6.setText(this.lichsumodel.getNk().getNamSinh() + "");
		lblNewLabel12.setText(this.lichsumodel.getNk().getDiaChiHienNay());
		lblNewLabel13.setText(this.lichsumodel.getHd().getTenhoatdong());
		lblNewLabel14.setText(
				this.lichsumodel.getHd().getThoigianbatdau() + "-" + this.lichsumodel.getHd().getThoigianketthuc());
		textField.setText(this.lichsumodel.getHd().getDongia() + "");
		textField_1.setText(this.lichsumodel.getHd().getTrangthai() + "");

	}

	public void setDataTable() {
		List<CoSoVatChatThue> listItem = new ArrayList<>();
		this.listthue.forEach(lichsu -> {
			listItem.add(lichsu);
		});
		DefaultTableModel model = classTableModel.setTablethue(listItem, COLUMNS);
		JTable table = new JTable(model) {
			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			}

		};

		// thiet ke bang

		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 30));
		table.setRowHeight(50);
		table.validate();
		table.repaint();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//	                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
				if (e.getClickCount() > 1) {

				}
			}

		});
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		panel_1.removeAll();
		panel_1.setLayout(new BorderLayout());
		panel_1.add(scroll);
		panel_1.validate();
		panel_1.repaint();
	}
}
