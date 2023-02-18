package views;

import controllers.NhanKhauManagerPanelController;
import models.CoSoVatChatModel;
import models.CoSoVatChatThue;
import models.HoatDongModel;
import services.CoSoVatChatServices;
import utility.ClassTableModel;

import javax.swing.JFrame;
import views.NhanKhauManagerFrame.AddNewPeopleJFrame;
import views.NhanKhauManagerFrame.DangKyTamTruJFrame;
import views.NhanKhauManagerFrame.DangKyTamVangJFrame;
import views.NhanKhauManagerFrame.KhaiTuJFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.JSlider;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 *
 * @author Hai
 */
public class DangKyPanel extends javax.swing.JPanel {

	/**
	 * Creates new form NhanKhauManagePanel
	 */
	private NhanKhauManagerPanelController controller = null;
	private JFrame parentJFrame;
	private JTextField textField_1;
	private JLabel lblTnHotng;
	private CoSoVatChatServices cosovatchatservices;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private ClassTableModel classTableModel;
	private List<CoSoVatChatModel> listcosovatchat;
	private final String[] COLUMNS = { "Tên sản phẩm", "Số lượng", "Giá Thuê ( 1 cái)" };
	private final String[] COLUMNS1 = { "Tên sản phẩm", "Số lượng", "Thành tiền" };
	private JPanel panel_2;
	private com.toedter.calendar.JDateChooser dateChooser;
	private com.toedter.calendar.JDateChooser dateChooser_1;
	private List<CoSoVatChatThue> listthue;
	private JPanel panel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_3;
	private JButton btnNewButton;

	public DangKyPanel(JFrame parentFrame) {
		this.parentJFrame = parentFrame;
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		cosovatchatservices = new CoSoVatChatServices();
		classTableModel = new ClassTableModel();
		this.listcosovatchat = this.cosovatchatservices.getListcon();
		listthue = new ArrayList<CoSoVatChatThue>();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 883, 87);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Vui lòng nhập số CMT");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(218, 6, 165, 33);
		panel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(380, 10, 123, 26);
		panel.add(textField_1);

		lblTnHotng = new JLabel("Tên hoạt động");
		lblTnHotng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnHotng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnHotng.setBounds(0, 124, 106, 19);
		panel.add(lblTnHotng);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			private Component dateChooser;
			private Component dateChooser_1;

			public void actionPerformed(ActionEvent e) {
				String cmt = textField_1.getText();
				if(CheckCmt()) {
					String name = cosovatchatservices.getname(cmt);
					if (name != null) {
						setText(name);

					} else {
						JOptionPane.showMessageDialog(null, "Số CMT khoong đúng");
					}
				}
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(DangKyPanel.class.getResource("/Icons/checked.png")));
		btnNewButton_1.setBounds(526, 6, 34, 26);
		panel.add(btnNewButton_1);

		lblNewLabel_1 = new JLabel("Họ Tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(287, 49, 60, 28);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(380, 46, 123, 26);
		panel.add(textField);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 97, 883, 412);
		add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_2 = new JLabel("Tên hoạt động");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 18, 109, 27);
		panel_1.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(139, 21, 103, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Thời gian bắt đầu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 55, 119, 19);
		panel_1.add(lblNewLabel_3);

		dateChooser = new com.toedter.calendar.JDateChooser();
		dateChooser.setBounds(139, 55, 103, 20);
		dateChooser.setEnabled(false);
		panel_1.add(dateChooser);

		JLabel lblNewLabel_4 = new JLabel("Thời gian bắt đầu");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_4.setBounds(10, 84, 119, 19);
		panel_1.add(lblNewLabel_4);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(139, 85, 103, 20);
		dateChooser_1.setEnabled(false);
		panel_1.add(dateChooser_1);

		panel_2 = new JPanel();
		panel_2.setBounds(369, 21, 504, 129);
		panel_1.add(panel_2);

		panel_3 = new JPanel();
		panel_3.setBounds(10, 166, 863, 179);
		panel_1.add(panel_3);

		lblNewLabel_5 = new JLabel("Chọn cơ sở vật chất muốn thuê");
		lblNewLabel_5.setBackground(new Color(64, 128, 128));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(428, 0, 373, 26);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 13));

		lblNewLabel_6 = new JLabel("Tổng Tiền");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(639, 355, 80, 20);
		panel_1.add(lblNewLabel_6);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setText("0");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setBounds(714, 355, 139, 22);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CheckEmpty()) {
					HoatDongModel hd = new HoatDongModel();
					hd.setTenhoatdong(textField_2.getText().trim());
					hd.setThoigianbatdau(dateChooser.getDate());
					hd.setThoigianketthuc(dateChooser_1.getDate());
					hd.setDongia(Integer.parseInt(textField_3.getText()));
					
						try {
							if( cosovatchatservices.addHoatDong(hd, listthue, textField_1.getText())){
								JOptionPane.showMessageDialog(null, "them thanh cong");
								removeAll();
								initComponents();
								validate();
							    repaint();
							}
							
						} catch (HeadlessException e1) {
							
						}
					

				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(414, 373, 49, 20);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("đ");
		lblNewLabel_7.setBounds(860, 357, 23, 20);
		panel_1.add(lblNewLabel_7);
	
		setBackground(new java.awt.Color(255, 255, 255));

	}// </editor-fold>//GEN-END:initComponents

	public void setDataTable() {
		List<CoSoVatChatModel> listItem = new ArrayList<>();
		this.listcosovatchat.forEach(cosovatchat -> {
			listItem.add(cosovatchat);
		});
		DefaultTableModel model = classTableModel.setTableCSVC(listItem, COLUMNS);
		JTable table = new JTable(model) {
			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			}

		};

		// thiet ke bang

		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(50, 25));
		table.setRowHeight(25);
		table.validate();
		table.repaint();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setMaxWidth(180);
		table.getColumnModel().getColumn(0).setMinWidth(180);
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.addMouseListener(new MouseAdapter() {
			private int i;
			private long Money;

			@Override
			public void mouseClicked(MouseEvent e) {

//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
				if (e.getClickCount() > 1) {
					CoSoVatChatModel csvc = listcosovatchat.get(table.getSelectedRow());

					String m = JOptionPane.showInputDialog("Nhập số lượng ( nhỏ hơn " + csvc.getSoluongconlai());

					if (m != null) {
						int sl = Integer.parseInt(m);

						if (sl > csvc.getSoluongconlai()) {
							JOptionPane.showMessageDialog(null, "Không đủ số lượng cho thuê");
						} else {
							listcosovatchat.get(table.getSelectedRow()).setSoluongconlai(csvc.getSoluongconlai() - sl);
							CoSoVatChatThue n = new CoSoVatChatThue();
							n.setCosovatchatmodel(csvc);
							n.setSoluong(sl);
							n.setThanhtien(sl * csvc.getDongia());

							listthue.forEach(cosovatchat -> {
								if (cosovatchat.getCosovatchatmodel().getTenCoSoVatChat()
										.equals(csvc.getTenCoSoVatChat())) {
									cosovatchat.setSoluong(cosovatchat.getSoluong() + sl);
									i++;
								}

							});
							if (i == 0) {
								listthue.add(n);
							}

							listthue.forEach(cosovatchat -> {

								Money += cosovatchat.getThanhtien();

							});
							textField_3.setText(Money+"");

							setDataTable();
							setDataTablethue();
						}
					}
				}
			}

		});

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		panel_2.removeAll();
		panel_2.setLayout(new BorderLayout());
		panel_2.add(scroll);
		panel_2.validate();
		panel_2.repaint();
	}

	public void setDataTablethue() {
		List<CoSoVatChatThue> listItem = new ArrayList<>();
		this.listthue.forEach(cosovatchat -> {
			listItem.add(cosovatchat);
		});
		DefaultTableModel model = classTableModel.setTablethue(listItem, COLUMNS1);
		JTable table = new JTable(model) {
			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			}

		};

		// thiet ke bang

		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(25);
		table.validate();
		table.repaint();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setMaxWidth(180);
		table.getColumnModel().getColumn(0).setMinWidth(180);
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.addMouseListener(new MouseAdapter() {
			private long Money;

			@Override
			public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
				if (e.getClickCount() > 1) {
					CoSoVatChatThue temp = listthue.get(table.getSelectedRow());
					CoSoVatChatModel n = temp.getCosovatchatmodel();
					String[] options = { "Xóa lựa chọn", "Giảm" };

					int x = JOptionPane.showOptionDialog(null, "Bạn muốn?", "Click a button",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					if (x == 0) {
						listthue.remove(listthue.get(table.getSelectedRow()));
						listcosovatchat.forEach(cosovatchat -> {
							if (cosovatchat.getTenCoSoVatChat().equals(n.getTenCoSoVatChat())) {
								cosovatchat.setSoluongconlai(cosovatchat.getSoluongconlai() + temp.getSoluong());
							}

						});
					}
					if (x == 1) {
						String m = JOptionPane.showInputDialog("Nhập số lượng muốn mua ( nhỏ hơn " + temp.getSoluong());
						int sl = Integer.parseInt(m);
						if (sl <= 0) {
							listthue.remove(listthue.get(table.getSelectedRow()));
							listcosovatchat.forEach(cosovatchat -> {
								if (cosovatchat.getTenCoSoVatChat().equals(n.getTenCoSoVatChat())) {
									cosovatchat.setSoluongconlai(cosovatchat.getSoluongconlai() + temp.getSoluong());
								}

							});
						} else {
							if (sl > 20) {
								JOptionPane.showMessageDialog(null, "Không được nhập quá số lượng chỉ định");
							} else {
								listcosovatchat.forEach(cosovatchat -> {
									if (cosovatchat.getTenCoSoVatChat().equals(n.getTenCoSoVatChat())) {
										cosovatchat.setSoluongconlai(
												cosovatchat.getSoluongconlai() + temp.getSoluong() - sl);
									}

								});
								temp.setSoluong(sl);
							}
						}
					}
					listthue.forEach(cosovatchat -> {

						Money += cosovatchat.getThanhtien();

					});
					textField_3.setText(Money+"");

					setDataTable();
					setDataTablethue();
				}
			}
		});

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		panel_3.removeAll();
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scroll);
		panel_3.validate();
		panel_3.repaint();
	}

	public void setText(String name) {
		setDataTable();
		setDataTablethue();
		textField.setText(name);
		btnNewButton_1.setIcon(new ImageIcon(DangKyPanel.class.getResource("/Icons/check.png")));
		textField_2.setEnabled(true);
		dateChooser.setEnabled(true);
		dateChooser_1.setEnabled(true);
	}

	private boolean CheckEmpty() {
		if (textField_2.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	public boolean CheckCmt() {
		if(textField_1.getText().trim().isEmpty()) {
			  JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng CMT", "Warning", JOptionPane.WARNING_MESSAGE);
		        return false;
		}
		try {
            long d = Long.parseLong(textField_1.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Số CMT không thể chứa các ký tự", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    // kiem tra do dai cmt
    if (textField_1.getText().length() != 9 && textField_1.getText().length() != 12) {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng CMT", "Warning", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    return true;
	}
	
}
