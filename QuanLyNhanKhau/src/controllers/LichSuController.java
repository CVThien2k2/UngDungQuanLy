package controllers;

import Bean.NhanKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import models.HoatDongModel;
import models.LichSuModel;
import models.NhanKhauModel;
import services.LichSuServices;
import services.NhanKhauService;
import utility.ClassTableModel;
import views.SuaLichSuFrame;
import views.infoViews.InfoJframe;

/**
 *
 * @author Hai
 */
public class LichSuController {
    
    private static JPanel jpnView;
    private JTextField jtfSearch;
    private static LichSuServices lichsuservices;
    private static List<LichSuModel> lichsumodel;
    private static ClassTableModel classTableModel = null;
    private final static String[] COLUMNS = {"Họ tên","Tên hoạt động","Ngày bắt đầu", "Ngày kết thúc", "Trạng thái","Thành Tiền"};
    private static JFrame parentJFrame;

    public LichSuController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.lichsuservices = new LichSuServices();
        this.lichsumodel = this.lichsuservices.getList();
        initAction();
    }

    public LichSuController() {
    }
    
    
    //
    public void initAction(){
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                lichsumodel = lichsuservices.getList(key.trim());
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                lichsumodel = lichsuservices.getList(key.trim());
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                lichsumodel = lichsuservices.getList(key.trim());
                setDataTable();
            }
        });
    }
    
    public static void setDataTable() {
        List<LichSuModel> listItem = new ArrayList<>();
         lichsumodel.forEach(lichsu -> {
            listItem.add(lichsu);
        });
        DefaultTableModel model = classTableModel.setTableLichSu(lichsumodel, COLUMNS);
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
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    LichSuModel temp = lichsumodel.get(table.getSelectedRow());
                    SuaLichSuFrame lsfr = new SuaLichSuFrame(parentJFrame,temp);
                    lsfr.setVisible(true);
                    lsfr.setLocationRelativeTo(jpnView);
                  
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
    public void enable() {
    	this.parentJFrame.setEnabled(true);
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public static void refreshData() {
        lichsumodel = lichsuservices.getList();
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
