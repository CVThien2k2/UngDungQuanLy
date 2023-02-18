package models;

public class CoSoVatChatModel {
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private String MaCoSoVatChat;
	private String TenCoSoVatChat;
	private int soluong;
	private int soluongconlai;
	private int soluongdohong;
	private int dongia;
	public String getMaCoSoVatChat() {
		return MaCoSoVatChat;
	}
	public void setMaCoSoVatChat(String maCoSoVatChat) {
		MaCoSoVatChat = maCoSoVatChat;
	}
	public String getTenCoSoVatChat() {
		return TenCoSoVatChat;
	}
	public void setTenCoSoVatChat(String tenCoSoVatChat) {
		TenCoSoVatChat = tenCoSoVatChat;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getSoluongconlai() {
		return soluongconlai;
	}
	public void setSoluongconlai(int soluongconlai) {
		this.soluongconlai = soluongconlai;
	}
	public int getSoluongdohong() {
		return soluongdohong;
	}
	public void setSoluongdohong(int soluongdohong) {
		this.soluongdohong = soluongdohong;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public CoSoVatChatModel(String maCoSoVatChat, String tenCoSoVatChat, int soluong, int soluongconlai,
			int soluongdohong, int dongia) {
		MaCoSoVatChat = maCoSoVatChat;
		TenCoSoVatChat = tenCoSoVatChat;
		this.soluong = soluong;
		this.soluongconlai = soluongconlai;
		this.soluongdohong = soluongdohong;
		this.dongia = dongia;
	}
	public CoSoVatChatModel() {
	}
	

}
