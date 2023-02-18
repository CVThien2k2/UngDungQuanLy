package models;

import java.util.Date;

public class HoatDongModel {
	private int ID;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private String tenhoatdong;
	private Date thoigianbatdau;
	private Date thoigianketthuc;
	private int dongia;
	private int IDNK;
	private String trangthai;
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public int getIDNK() {
		return IDNK;
	}
	public void setIDNK(int iDNK) {
		IDNK = iDNK;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public String getTenhoatdong() {
		return tenhoatdong;
	}
	public void setTenhoatdong(String tenhoatdong) {
		this.tenhoatdong = tenhoatdong;
	}
	public Date getThoigianbatdau() {
		return thoigianbatdau;
	}
	public void setThoigianbatdau(Date thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}
	public Date getThoigianketthuc() {
		return thoigianketthuc;
	}
	public void setThoigianketthuc(Date thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}
	public HoatDongModel() {
	}

}
