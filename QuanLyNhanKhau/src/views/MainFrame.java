/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Bean.DanhMucBean;
import controllers.MainController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 *
 * @author Hai
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/Icons/house.png")));
        initComponents();
        setTitle("Nhóm Vozer");
        List<DanhMucBean> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucBean("TrangChu", Home, jblTrangChu));
        listDanhMuc.add(new DanhMucBean("NhanKhau", NhanKhauBtn, jlbNhanKhau));
        listDanhMuc.add(new DanhMucBean("HoKhau", HoKhauBtn, jlbHoKhau));
        listDanhMuc.add(new DanhMucBean("ThongKe", ThongKeBtn, jlbThongKe));
        listDanhMuc.add(new DanhMucBean("QuanLy", QuanLyBtn, lblQunLCsvc));
        listDanhMuc.add(new DanhMucBean("DangKy", DangkyBtn, lblngKHot));
        listDanhMuc.add(new DanhMucBean("LichSu", LichSuBtn, lblLchSHot));
        
        MainController controller = new MainController(jpnBean, this);
        controller.setView(Home, jblTrangChu, "TrangChu");
        controller.setEvent(listDanhMuc);
        
        // confirm de thuc hien dong
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    dispose();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnContainer = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jblTrangChu = new javax.swing.JLabel();
        NhanKhauBtn = new javax.swing.JPanel();
        jlbNhanKhau = new javax.swing.JLabel();
        HoKhauBtn = new javax.swing.JPanel();
        jlbHoKhau = new javax.swing.JLabel();
        ThongKeBtn = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnBean = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnContainer.setBackground(new java.awt.Color(255, 255, 255));

        jpnMenu.setBackground(new java.awt.Color(153, 153, 153));

        Home.setBackground(new java.awt.Color(0, 160, 50));

        jblTrangChu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jblTrangChu.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/Login1.png"))); // NOI18N
        jblTrangChu.setText("Trang chủ");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        HomeLayout.setHorizontalGroup(
        	HomeLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(HomeLayout.createSequentialGroup()
        			.addComponent(jblTrangChu)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
        	HomeLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, HomeLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jblTrangChu, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))
        );
        Home.setLayout(HomeLayout);

        NhanKhauBtn.setBackground(new java.awt.Color(102, 102, 102));
        NhanKhauBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlbNhanKhau.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbNhanKhau.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanKhau.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/ancestors.png"))); // NOI18N
        jlbNhanKhau.setText("     Nhân Khẩu");

        javax.swing.GroupLayout NhanKhauBtnLayout = new javax.swing.GroupLayout(NhanKhauBtn);
        NhanKhauBtnLayout.setHorizontalGroup(
        	NhanKhauBtnLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(NhanKhauBtnLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jlbNhanKhau, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(52, Short.MAX_VALUE))
        );
        NhanKhauBtnLayout.setVerticalGroup(
        	NhanKhauBtnLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(NhanKhauBtnLayout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jlbNhanKhau)
        			.addContainerGap())
        );
        NhanKhauBtn.setLayout(NhanKhauBtnLayout);

        HoKhauBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbHoKhau.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbHoKhau.setForeground(new java.awt.Color(255, 255, 255));
        jlbHoKhau.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/house.png"))); // NOI18N
        jlbHoKhau.setText("     Hộ Khẩu");

        javax.swing.GroupLayout HoKhauBtnLayout = new javax.swing.GroupLayout(HoKhauBtn);
        HoKhauBtnLayout.setHorizontalGroup(
        	HoKhauBtnLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(HoKhauBtnLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jlbHoKhau, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(73, Short.MAX_VALUE))
        );
        HoKhauBtnLayout.setVerticalGroup(
        	HoKhauBtnLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(HoKhauBtnLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jlbHoKhau)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HoKhauBtn.setLayout(HoKhauBtnLayout);

        ThongKeBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbThongKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKe.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/analysis.png"))); // NOI18N
        jlbThongKe.setText("       Thống Kê");

        javax.swing.GroupLayout ThongKeBtnLayout = new javax.swing.GroupLayout(ThongKeBtn);
        ThongKeBtnLayout.setHorizontalGroup(
        	ThongKeBtnLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(ThongKeBtnLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jlbThongKe, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(30, Short.MAX_VALUE))
        );
        ThongKeBtnLayout.setVerticalGroup(
        	ThongKeBtnLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, ThongKeBtnLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jlbThongKe)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThongKeBtn.setLayout(ThongKeBtnLayout);
        
        QuanLyBtn = new JPanel();
        QuanLyBtn.setBackground(new Color(102, 102, 102));
        
        lblQunLCsvc = new JLabel();
        lblQunLCsvc.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/settings.png")));
        lblQunLCsvc.setText("Quản Lý Nhà Văn Hóa");
        lblQunLCsvc.setForeground(Color.WHITE);
        lblQunLCsvc.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_QuanLyBtn = new GroupLayout(QuanLyBtn);
        gl_QuanLyBtn.setHorizontalGroup(
        	gl_QuanLyBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_QuanLyBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblQunLCsvc)
        			.addContainerGap(33, Short.MAX_VALUE))
        );
        gl_QuanLyBtn.setVerticalGroup(
        	gl_QuanLyBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_QuanLyBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblQunLCsvc, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );
        QuanLyBtn.setLayout(gl_QuanLyBtn);
        
        DangkyBtn = new JPanel();
        DangkyBtn.setBackground(new Color(102, 102, 102));
        
        lblngKHot = new JLabel();
        lblngKHot.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/edit (1).png")));
        lblngKHot.setText("Đăng Ký Hoạt Động");
        lblngKHot.setForeground(Color.WHITE);
        lblngKHot.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_DangkyBtn = new GroupLayout(DangkyBtn);
        gl_DangkyBtn.setHorizontalGroup(
        	gl_DangkyBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_DangkyBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblngKHot, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_DangkyBtn.setVerticalGroup(
        	gl_DangkyBtn.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_DangkyBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblngKHot, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        			.addContainerGap())
        );
        DangkyBtn.setLayout(gl_DangkyBtn);
        
        LichSuBtn = new JPanel();
        LichSuBtn.setBackground(new Color(102, 102, 102));
        
        lblLchSHot = new JLabel();
        lblLchSHot.setIcon(new ImageIcon(MainFrame.class.getResource("/Icons/clock.png")));
        lblLchSHot.setText("Lịch Sử Hoạt Động");
        lblLchSHot.setForeground(Color.WHITE);
        lblLchSHot.setFont(new Font("Arial", Font.BOLD, 14));
        GroupLayout gl_LichSuBtn = new GroupLayout(LichSuBtn);
        gl_LichSuBtn.setHorizontalGroup(
        	gl_LichSuBtn.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_LichSuBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblLchSHot, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_LichSuBtn.setVerticalGroup(
        	gl_LichSuBtn.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_LichSuBtn.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblLchSHot, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        			.addContainerGap())
        );
        LichSuBtn.setLayout(gl_LichSuBtn);

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenuLayout.setHorizontalGroup(
        	jpnMenuLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnMenuLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jpnMenuLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(LichSuBtn, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        				.addGroup(jpnMenuLayout.createSequentialGroup()
        					.addGroup(jpnMenuLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(NhanKhauBtn, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        						.addComponent(HoKhauBtn, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        						.addComponent(ThongKeBtn, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        						.addComponent(QuanLyBtn, GroupLayout.PREFERRED_SIZE, 206, Short.MAX_VALUE)
        						.addComponent(Home, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(DangkyBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
        					.addContainerGap())))
        );
        jpnMenuLayout.setVerticalGroup(
        	jpnMenuLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnMenuLayout.createSequentialGroup()
        			.addComponent(Home, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(NhanKhauBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(HoKhauBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(ThongKeBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(QuanLyBtn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(DangkyBtn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(LichSuBtn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(54, Short.MAX_VALUE))
        );
        jpnMenu.setLayout(jpnMenuLayout);

        javax.swing.GroupLayout jpnBeanLayout = new javax.swing.GroupLayout(jpnBean);
        jpnBean.setLayout(jpnBeanLayout);
        jpnBeanLayout.setHorizontalGroup(
            jpnBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jpnBeanLayout.setVerticalGroup(
            jpnBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnContainerLayout = new javax.swing.GroupLayout(jpnContainer);
        jpnContainerLayout.setHorizontalGroup(
        	jpnContainerLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jpnContainerLayout.createSequentialGroup()
        			.addComponent(jpnMenu, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jpnBean, GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jpnContainerLayout.setVerticalGroup(
        	jpnContainerLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jpnMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(jpnContainerLayout.createSequentialGroup()
        			.addGap(10)
        			.addComponent(jpnBean, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        			.addGap(10))
        );
        jpnContainer.setLayout(jpnContainerLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoKhauBtn;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel NhanKhauBtn;
    private javax.swing.JPanel ThongKeBtn;
    private javax.swing.JLabel jblTrangChu;
    private javax.swing.JLabel jlbHoKhau;
    private javax.swing.JLabel jlbNhanKhau;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JPanel jpnBean;
    private javax.swing.JPanel jpnContainer;
    private javax.swing.JPanel jpnMenu;
    private JPanel QuanLyBtn;
    private JLabel lblQunLCsvc;
    private JPanel DangkyBtn;
    private JLabel lblngKHot;
    private JPanel LichSuBtn;
    private JLabel lblLchSHot;
    // End of variables declaration//GEN-END:variables
}
