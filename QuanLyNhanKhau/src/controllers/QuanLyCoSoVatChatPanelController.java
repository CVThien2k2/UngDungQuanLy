package controllers;

import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import models.CoSoVatChatModel;
import models.NhanKhauModel;
import services.CoSoVatChatServices;
import services.NhanKhauService;
import utility.ClassTableModel;
import views.infoViews.InfoJframe;

/**
 *
 * @author Hai
 */
public class QuanLyCoSoVatChatPanelController {

	private JPanel jpnView;
	private JTextField jtfSearch;
	private CoSoVatChatServices cosovatchatservices;
	private List<CoSoVatChatModel> listcosovatchat;
	private ClassTableModel classTableModel = null;
	private final String[] COLUMNS = { "Tên đồ dùng", "Số lượng", "Số lượng còn lại", "Số lượng hỏng", "Đơn gía" };
	private JFrame parentJFrame;

	public QuanLyCoSoVatChatPanelController(JPanel jpnView, JTextField jtfSearch) {
		this.jpnView = jpnView;
		this.jtfSearch = jtfSearch;
		classTableModel = new ClassTableModel();
		this.cosovatchatservices = new CoSoVatChatServices();
		this.listcosovatchat = this.cosovatchatservices.getList();
		initAction();
	}

	public QuanLyCoSoVatChatPanelController() {
	}

	//
	public void initAction() {
		this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String key = jtfSearch.getText();
				listcosovatchat = cosovatchatservices.search(key.trim());
				setDataTable();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String key = jtfSearch.getText();
				listcosovatchat = cosovatchatservices.search(key.trim());
				setDataTable();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String key = jtfSearch.getText();
				listcosovatchat = cosovatchatservices.search(key.trim());
				setDataTable();
			}
		});
	}

	public void setDataTable() {
		List<CoSoVatChatModel> listItem = new ArrayList<>();
		this.listcosovatchat.forEach(cosovatchat -> {
			listItem.add(cosovatchat);
		});
		DefaultTableModel model = classTableModel.setTableCoSoVatChat(listItem, COLUMNS);
		JTable table = new JTable(model) {
			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			}

		};

		// thiet ke bang

		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setMaxWidth(180);
		table.getColumnModel().getColumn(0).setMinWidth(180);
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
				if (e.getClickCount() > 1) {
					CoSoVatChatModel csvc = listcosovatchat.get(table.getSelectedRow());
					Object[] options = { "Sửa Tên","Sửa Số Lượng","Sửa Số lượng hỏng", "CANCEL" };
					
					int x = JOptionPane.showOptionDialog(null, "Click OK to continue", "Lựa Chọn",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[3]);
					if(x==0) {
						String m = JOptionPane.showInputDialog("Nhập lại tên của nó");
						if (m != null) {
								if (cosovatchatservices.updateten(csvc.getID(),m)) {
									JOptionPane.showMessageDialog(null, "Cập nhật thành công");
									refreshData();
								} else {
									JOptionPane.showMessageDialog(null, "Thất bại");
								}
							
						}
					}
//					if(x==2) {
//						String m = JOptionPane.showInputDialog("Nhập lại giá của nó");
//						if (m != null) {
//								if (cosovatchatservices.updategia(csvc.getID(),m)) {
//									JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//									refreshData();
//								} else {
//									JOptionPane.showMessageDialog(null, "Thất bại");
//								}
//							
//						}
//					}
					if(x==2) {
						String m = JOptionPane.showInputDialog("Nhập lại số đồ hỏng của nó");
						if (m != null) {
								if (cosovatchatservices.updatedohong(csvc.getSoluongconlai(),csvc.getSoluongdohong(),csvc.getID(),m)) {
									JOptionPane.showMessageDialog(null, "Cập nhật thành công");
									refreshData();
								} else {
									JOptionPane.showMessageDialog(null, "Thất bại");
								}
							
						}
					}
				
					if (x == 1) {

						try {
							String m = JOptionPane.showInputDialog("Nhập lại số lượng của nó");

							if (m != null) {
								int a = Integer.parseInt(m);
								if (csvc.getSoluong() - a > csvc.getSoluongconlai()) {
									JOptionPane.showMessageDialog(null,
											"Không thể cập nhật do có số lượng chưa trả hết!");
								} else {
									a = Integer.parseInt(m);
									if (cosovatchatservices.update(a,csvc.getSoluongconlai()-(csvc.getSoluong() - a), csvc.getID())) {
										JOptionPane.showMessageDialog(null, "Cập nhật thành công");
										refreshData();
									} else {
										JOptionPane.showMessageDialog(null, "Thất bại");
									}
								}
							}

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Nhập lại bằng số");
						}

					}
				}
			}

		});

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(table);
		scroll.setPreferredSize(new Dimension(1350, 400));
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setParentJFrame(JFrame parentJFrame) {
		this.parentJFrame = parentJFrame;
	}

	public void refreshData() {
		this.listcosovatchat = this.cosovatchatservices.getList();
		setDataTable();
	}

	public JPanel getJpnView() {
		return jpnView;
	}

	public void setJpnView(JPanel jpnView) {
		this.jpnView = jpnView;
	}

	public JTextField getJtfSearch() {
		return jtfSearch;
	}

	public void setJtfSearch(JTextField jtfSearch) {
		this.jtfSearch = jtfSearch;
	}

}
