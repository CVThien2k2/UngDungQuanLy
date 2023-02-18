package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.HoKhauBean;
import Bean.NhanKhauBean;
import models.ChungMinhThuModel;
import models.CoSoVatChatModel;
import models.CoSoVatChatThue;
import models.HoKhauModel;
import models.HoatDongModel;
import models.NhanKhauModel;
import models.ThanhVienCuaHoModel;

public class CoSoVatChatServices {

	public CoSoVatChatServices() {
		// TODO Auto-generated constructor stub
	}

	public List<CoSoVatChatModel> getList() {

		List<CoSoVatChatModel> list = new ArrayList<>();

		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT * FROM co_so_vat_chat";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CoSoVatChatModel temp = new CoSoVatChatModel();
				temp.setID(rs.getInt("ma_csvc"));
				temp.setMaCoSoVatChat(rs.getString("ma_csvc"));
				temp.setTenCoSoVatChat(rs.getString("ten"));
				temp.setSoluong(rs.getInt("so_luong"));
				temp.setSoluongconlai(rs.getInt("so_luong_con_lai"));
				temp.setSoluongdohong(rs.getInt("so_luong_do_hong"));
				temp.setDongia(rs.getInt("don_gia"));
				list.add(temp);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<CoSoVatChatModel> getListcon() {

		List<CoSoVatChatModel> list = new ArrayList<>();

		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT * FROM co_so_vat_chat where so_luong_con_lai > 0 ";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CoSoVatChatModel temp = new CoSoVatChatModel();
				temp.setID(rs.getInt("ma_csvc"));
				temp.setMaCoSoVatChat(rs.getString("ma_csvc"));
				temp.setTenCoSoVatChat(rs.getString("ten"));
				temp.setSoluong(rs.getInt("so_luong"));
				temp.setSoluongconlai(rs.getInt("so_luong_con_lai"));
				temp.setSoluongdohong(rs.getInt("so_luong_do_hong"));
				temp.setDongia(rs.getInt("don_gia"));
				list.add(temp);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public boolean addCoSoVatChat(String ten,int soluong, int dongia) {
		String sql = "Insert into co_so_vat_chat(ten,so_luong,so_luong_con_lai,so_luong_do_hong,don_gia) values(?,?,?,0,?)";

		try {
			
			Connection connection = MysqlConnection.getMysqlConnection();
			PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1, ten);
            prst.setInt(2, soluong);
            prst.setInt(3, soluong);
            prst.setInt(4, dongia);
            prst.execute();
            prst.close();
//			preparedStatement.executeUpdate();
//			preparedStatement.close();
			connection.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<CoSoVatChatModel> search(String key) {
		List<CoSoVatChatModel> list = new ArrayList<>();
		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT * " + "FROM co_so_vat_chat Where ten like N'%" + key + "%'";

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CoSoVatChatModel temp = new CoSoVatChatModel();
				temp.setID(rs.getInt("ma_csvc"));
				temp.setMaCoSoVatChat(rs.getString("ma_csvc"));
				temp.setTenCoSoVatChat(rs.getString("ten"));
				temp.setSoluong(rs.getInt("so_luong"));
				temp.setSoluongconlai(rs.getInt("so_luong_con_lai"));
				temp.setSoluongdohong(rs.getInt("so_luong_do_hong"));
				temp.setDongia(rs.getInt("don_gia"));
				list.add(temp);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<String> getListName() {
		List<String> list = new ArrayList<>();
		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT hoTen " + "FROM nhan_khau ";

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String temp;

				temp = rs.getString("hoTen");

				list.add(temp);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public String getname(String cmt) {
		String name = null;
		try {
			Connection connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT * "
					+ "FROM nhan_khau,chung_minh_thu Where nhan_khau.ID =  chung_minh_thu.idNhanKhau and chung_minh_thu.soCMT = "
					+ cmt + "";

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				name = rs.getString("hoTen");
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return name;
	}

	public boolean addHoatDong(HoatDongModel hoatdong, List<CoSoVatChatThue> list, String cmt)
			{
		int IDNK;
		Connection connection;
		try {
			connection = MysqlConnection.getMysqlConnection();
			String query = "SELECT * "
					+ "FROM nhan_khau,chung_minh_thu Where nhan_khau.ID =  chung_minh_thu.idNhanKhau and chung_minh_thu.soCMT = "
					+ cmt + "";

			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				IDNK = rs.getInt("ID");
				preparedStatement.close();
				// 1 - 19
				query = "INSERT INTO hoat_dong (ten_hd,thoi_gian_bat_dau,thoi_gian_ket_thuc,IDNK,don_gia,trang_thai)"
						+ " values ( ?, ?, ?, ?,?,?)";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				preparedStatement1.setString(1, hoatdong.getTenhoatdong());

				java.sql.Date tgbatdau = new java.sql.Date(hoatdong.getThoigianbatdau().getTime());
				preparedStatement1.setDate(2, tgbatdau);
				java.sql.Date tgketthuc = new java.sql.Date(hoatdong.getThoigianketthuc().getTime());
				preparedStatement1.setDate(3, tgketthuc);
				preparedStatement1.setInt(4, IDNK);
				preparedStatement1.setInt(5, hoatdong.getDongia());
				preparedStatement1.setString(6, "Chưa Trả");
				preparedStatement1.executeUpdate();
				ResultSet rs1 = preparedStatement1.getGeneratedKeys();
				if (rs1.next()) {
					int hdID = rs1.getInt(1);
					String sql = "INSERT INTO hoat_dong_csvc(ma_csvc,ma_hd, so_luong_thue)"
							+ " values (?, ?,?)";
					PreparedStatement prst = connection.prepareStatement(sql);
					list.forEach(cosovatchatthue -> {
						CoSoVatChatModel md = cosovatchatthue.getCosovatchatmodel();
						int soluong = cosovatchatthue.getSoluong();
						try {
							
							prst.setInt(1, md.getID());
							prst.setInt(2, hdID);
							prst.setInt(3, soluong);
							prst.execute();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					});
					
					prst.close();
					String sql2 = "UPDATE co_so_vat_chat SET so_luong_con_lai = ? Where ma_csvc = ?";
					PreparedStatement prst1 = connection.prepareStatement(sql2);
					list.forEach(cosovatchatthue -> {
						CoSoVatChatModel md = cosovatchatthue.getCosovatchatmodel();
						int soluong =md.getSoluongconlai() - cosovatchatthue.getSoluong();
						try {
							
							prst1.setInt(1,md.getSoluongconlai());
							prst1.setInt(2, md.getID());
							prst1.execute();
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					});
					
					prst1.close();


				}
				preparedStatement1.close();
				connection.close();
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
		
		
		return true;
	}

	public boolean update(int n,int ma) {
		// TODO Auto-generated method stub
		String sql = "Update co_so_vat_chat Set so_luong = ? where ma_csvc = ?";

		try {
			
			Connection connection = MysqlConnection.getMysqlConnection();
			PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, n);
            prst.setInt(2, ma);
            
            prst.execute();
            prst.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
		
	}

}
