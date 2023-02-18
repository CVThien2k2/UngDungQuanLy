package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CoSoVatChatModel;
import models.CoSoVatChatThue;
import models.HoatDongModel;
import models.LichSuModel;
import models.NhanKhauModel;

public class LichSuServices {
	public LichSuServices() {
		// TODO Auto-generated constructor stub
	}

	public List<LichSuModel> getList() {

		List<LichSuModel> list = new ArrayList<>();

		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT * from nhan_khau, hoat_dong where nhan_khau.ID = hoat_dong.IDNK";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LichSuModel ls = new LichSuModel();
				NhanKhauModel nhanKhau = new NhanKhauModel();
				HoatDongModel hd = new HoatDongModel();
				nhanKhau.setID(rs.getInt("ID"));
				nhanKhau.setBietDanh(rs.getString("bietDanh"));
				nhanKhau.setHoTen(rs.getString("hoTen"));
				nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
				
				nhanKhau.setNamSinh(rs.getDate("namSinh"));
				nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
				nhanKhau.setTonGiao(rs.getString("tonGiao"));
				nhanKhau.setDanToc(rs.getString("danToc"));
				nhanKhau.setQuocTich(rs.getString("quocTich"));
				nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
				nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
				nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
				hd.setID(rs.getInt("ma_hd"));
				hd.setTenhoatdong(rs.getString("ten_hd"));
				hd.setIDNK(rs.getInt("IDNK"));
				hd.setThoigianbatdau(rs.getDate("thoi_gian_bat_dau"));
				hd.setThoigianketthuc(rs.getDate("thoi_gian_ket_thuc"));
				hd.setDongia(rs.getInt("don_gia"));
				hd.setTrangthai(rs.getString("trang_thai"));

				ls.setHd(hd);
				ls.setNk(nhanKhau);
				list.add(ls);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<CoSoVatChatThue> getListThue(int id) {
		// TODO Auto-generated method stub
		List<CoSoVatChatThue> list = new ArrayList<>();

		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT * FROM hoat_dong_csvc,co_so_vat_chat where ma_hd ="+id+" and co_so_vat_chat.ma_csvc = hoat_dong_csvc.ma_csvc";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CoSoVatChatThue thue = new CoSoVatChatThue();
				CoSoVatChatModel csvc = new CoSoVatChatModel();
				csvc.setTenCoSoVatChat(rs.getString("ten"));
				csvc.setSoluong(rs.getInt("so_luong"));
				csvc.setSoluongconlai(rs.getInt("so_luong_con_lai"));
				csvc.setSoluongdohong(rs.getInt("so_luong_do_hong"));
				csvc.setDongia(rs.getInt("don_gia"));
				csvc.setID(rs.getInt("ma_csvc"));
				thue.setSoluong(rs.getInt("so_luong_thue"));
				thue.setCosovatchatmodel(csvc);
				thue.setThanhtien(csvc.getDongia()*thue.getSoluong());
				
				list.add(thue);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public List<CoSoVatChatThue> tralistthue(List<CoSoVatChatThue> list,int id) {
		// TODO Auto-generated method stub

		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String sql = "UPDATE hoat_dong SET trang_thai = N'Đã Trả' Where ma_hd ="+id;
			PreparedStatement prst = connection.prepareStatement(sql);
			prst.execute();
			prst.close();
			String sql1 = "UPDATE co_so_vat_chat SET so_luong_con_lai = ? Where ma_csvc = ?";
			PreparedStatement prst1 = connection.prepareStatement(sql1);
			list.forEach(cosovatchatthue -> {
				CoSoVatChatModel md = cosovatchatthue.getCosovatchatmodel();
				int soluong =md.getSoluongconlai() + cosovatchatthue.getSoluong();
				try {
					
					prst1.setInt(1,soluong);
					prst1.setInt(2, md.getID());
					prst1.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			prst1.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
