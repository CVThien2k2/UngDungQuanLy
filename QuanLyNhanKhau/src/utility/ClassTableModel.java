package utility;

import Bean.HoKhauBean;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import models.CoSoVatChatModel;
import models.CoSoVatChatThue;
import models.GiaDinhModel;
import models.HoatDongModel;
import models.LichSuModel;
import models.NhanKhauModel;
import models.TieuSuModel;

/**
 *
 * @author Hai
 * class dinh nghia cac dang table co trong phan mem
 */
public class ClassTableModel {
    // bang cho main frame
    public DefaultTableModel setTableNhanKhau(List<NhanKhauModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((NhanKhauModel item) -> {
            obj[0] = item.getID();
            obj[1] = item.getHoTen();
            obj[2] = item.getNamSinh();
            obj[3] = item.getGioiTinh();
            obj[4] = item.getDiaChiHienNay();
            dtm.addRow(obj);
        });
        return dtm;
    }
    public DefaultTableModel setTableLichSu(List<LichSuModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((LichSuModel item) -> {
        	HoatDongModel hd = item.getHd();
        	NhanKhauModel nkm = item.getNk();
            obj[0] = nkm.getHoTen();
            obj[1] = hd.getTenhoatdong();
            obj[2] = hd.getThoigianbatdau();
            obj[3] = hd.getThoigianketthuc();
            obj[4] = hd.getTrangthai();
            obj[5] = hd.getDongia();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableCoSoVatChat(List<CoSoVatChatModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((CoSoVatChatModel item) -> {
            obj[0] = item.getTenCoSoVatChat();
            obj[1] = item.getSoluong();
            obj[2] = item.getSoluongconlai();
            obj[3] = item.getSoluongdohong();
            obj[4] = item.getDongia();
            dtm.addRow(obj);
        });
        return dtm;
    }
    //table cho bang con lai
    public DefaultTableModel setTableCSVC(List<CoSoVatChatModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((CoSoVatChatModel item) -> {
            obj[0] = item.getTenCoSoVatChat();
            obj[1] = item.getSoluongconlai();
            obj[2] = item.getDongia();
            dtm.addRow(obj);
        });
        return dtm;
    }
    //table cho bang thue
    public DefaultTableModel setTablethue(List<CoSoVatChatThue> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((CoSoVatChatThue item) -> {
        	CoSoVatChatModel temp = item.getCosovatchatmodel();
            obj[0] = temp.getTenCoSoVatChat();
            obj[1] = item.getSoluong();
            obj[2] = item.getThanhtien();
            dtm.addRow(obj);
        });
        return dtm;
    }
    // table cho tieusu
    public DefaultTableModel setTableTieuSu(List<TieuSuModel> tieuSu, String[] listColumn) {
        final int column = listColumn.length;
        
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                 return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[column];
        
        tieuSu.forEach((TieuSuModel item) -> {
            obj[0] = item.getTuNgay().toString();
            obj[1] = item.getDenNgay().toString();
            obj[2] = item.getDiaChi();
            obj[3] = item.getNgheNghiep();
            obj[4] = item.getNoiLamViec();
            dtm.addRow(obj);
        });
        
        dtm.addRow(new Object[] {"", "", "", "", ""});
        
//        dtm.addTableModelListener(new TableModelListener() {
//            @Override
//            public void tableChanged(TableModelEvent e) {
//                int a = dtm.getRowCount();
//                if ((e.getLastRow() + 1) == dtm.getRowCount()) {
//                    System.out.println(); 
//                }
//                
//            }
//        });
        return dtm;
    }
    public DefaultTableModel setTableGiaDinh(List<GiaDinhModel> giaDinh, String[] listColumn) {
        final int column = listColumn.length;
        
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                 return columnIndex == 6 ? Boolean.class : String.class;
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[column];
        
        giaDinh.forEach((GiaDinhModel item) -> {
            obj[0] = item.getHoTen();
            obj[1] = item.getNamSinh().toString();
            obj[2] = item.getGioiTinh();
            obj[3] = item.getQuanHeVoiNhanKhau();
            obj[4] = item.getNgheNghiep();
            obj[5] = item.getDiaChiHienTai();
            dtm.addRow(obj);
        });
        
        dtm.addRow(new Object[] {"", "", "", "", "", ""});
        return dtm;
    }
    
    public DefaultTableModel setTableHoKhau(List<HoKhauBean> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((HoKhauBean item) -> {
            obj[0] = item.getHoKhauModel().getID();
            obj[1] = item.getHoKhauModel().getMaHoKhau();
            obj[2] = item.getChuHo().getHoTen();
            obj[3] = item.getHoKhauModel().getDiaChi();
            obj[4] = item.getHoKhauModel().getNgayLap();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
