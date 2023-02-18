package views;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controllers.ThongKePanelController;

import java.awt.Font;

public class QuanLyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	 private JFrame parentFrame;
	    private ThongKePanelController controller;
	    /**
	     * Creates new form ThongKePanel
	     */
	    public QuanLyPanel(JFrame parentFrame) {
	        this.parentFrame = parentFrame;
	        initComponents();
	    }
	public void initComponents() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Địt mẹ làm cơ sở dữ liệu bố m còn code");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 5, 562, 415);
		add(lblNewLabel);

	}

}
