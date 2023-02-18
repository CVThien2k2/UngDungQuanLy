package view.QuanLyCoSoVatChatFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.QuanLyCoSoVatChatPanelController;
import services.CoSoVatChatServices;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemMoiCoSoVatChatFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private QuanLyCoSoVatChatPanelController controller = null;
	private JFrame parentJFrame;
	private CoSoVatChatServices cosovatchatservices;

	public ThemMoiCoSoVatChatFrame(JFrame parentJFrame, QuanLyCoSoVatChatPanelController controller) {
		this.parentJFrame = parentJFrame;
		this.controller = controller;
		cosovatchatservices = new CoSoVatChatServices();
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		this.parentJFrame.setEnabled(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm mới cơ sở vật chất cho nhà văn hóa");
		lblNewLabel.setBounds(59, 10, 317, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nhập tên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(102, 76, 72, 19);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(179, 76, 102, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Số lượng :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(102, 124, 72, 19);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Giá thuê :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_2.setBounds(102, 167, 72, 19);
		contentPane.add(lblNewLabel_1_2);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(179, 126, 102, 21);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(179, 169, 102, 21);
		contentPane.add(textField_2);

		JLabel lblNewLabel_2 = new JLabel("1 Chiếc");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(291, 170, 45, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckField()) {
					String str1 = textField.getText().trim();
					String str2 = textField_1.getText().trim();
					String str3 = textField_2.getText().trim();
					
				
					if(cosovatchatservices.addCoSoVatChat(str1,Integer.parseInt(str2),Integer.parseInt(str3))) {
						JOptionPane.showMessageDialog(null,"Thêm thành công");
						controller.refreshData();
						close();
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Có lỗi xảy ra");
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(190, 218, 65, 21);
		contentPane.add(btnNewButton);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!",
						JOptionPane.YES_NO_OPTION) == 0) {
					close();
				}
			}

		});
	}

	void close() {
		this.parentJFrame.setEnabled(true);
		dispose();
	}

	public boolean CheckField() {
		// check null
		if (textField.getText().trim().isEmpty()||textField_1.getText().trim().isEmpty()||textField_2.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else return true;
	}
}
