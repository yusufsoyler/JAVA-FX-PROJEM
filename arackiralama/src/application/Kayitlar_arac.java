package application;

public class Kayitlar_arac {
	
	public String getPlaka() {
		return plaka;
	}
	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public int getYıl() {
		return yıl;
	}
	public void setYıl(int yıl) {
		this.yıl = yıl;
	}
	public String getRenk() {
		return renk;
	}
	public void setRenk(String renk) {
		this.renk = renk;
	}
	public String getYakıt() {
		return yakıt;
	}
	public void setYakıt(String yakıt) {
		this.yakıt = yakıt;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getÜcret() {
		return ücret;
	}
	public void setÜcret(int ücret) {
		this.ücret = ücret;
	}
	private String plaka;
	private String marka;
	private int yıl;
	private String renk;
	private String yakıt;
	private int km;
	private int ücret;
	
	Kayitlar_arac(){
	/*his.plaka="31SZ310";
		this.marka="opel";
		this.yıl=2016;
		this.renk="mavi";
		this.yakıt="dizel";
		this.km=117875;
		this.ücret=1230;*/
		
		
		
	}
	Kayitlar_arac(String plaka,String marka,int yıl,String renk,String yakıt,int km,int ücret){
		this.plaka=plaka;
		this.marka=marka;
		this.yıl=yıl;
		this.renk=renk;
		this.yakıt=yakıt;
		this.km=km;
		this.ücret=ücret;
		
		
	}
	
	
	
	
	

}

